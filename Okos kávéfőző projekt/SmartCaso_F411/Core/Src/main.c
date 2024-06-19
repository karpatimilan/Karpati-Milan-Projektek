/* USER CODE BEGIN Header */
/**
  ******************************************************************************
  * @file           : main.c
  * @brief          : Main program body
  ******************************************************************************
  * @attention
  *
  * Copyright (c) 2024 STMicroelectronics.
  * All rights reserved.
  *
  * This software is licensed under terms that can be found in the LICENSE file
  * in the root directory of this software component.
  * If no LICENSE file comes with this software, it is provided AS-IS.
  *
  ******************************************************************************
  */
/* USER CODE END Header */
/* Includes ------------------------------------------------------------------*/
#include "main.h"
#include "crc.h"
#include "dma.h"
#include "spi.h"
#include "tim.h"
#include "usb_device.h"
#include "gpio.h"
#include "app_touchgfx.h"

/* Private includes ----------------------------------------------------------*/
/* USER CODE BEGIN Includes */
#include "ST7796.h"
#include "xpt2046.h"
#include "TemperatureControl.h"
#include "MAX6675.h"
#include "HX711.h"
#include "config.h"
/* USER CODE END Includes */

/* Private typedef -----------------------------------------------------------*/
/* USER CODE BEGIN PTD */

/* USER CODE END PTD */

/* Private define ------------------------------------------------------------*/
/* USER CODE BEGIN PD */
//#define scale
/* USER CODE END PD */

/* Private macro -------------------------------------------------------------*/
/* USER CODE BEGIN PM */

/* USER CODE END PM */

/* Private variables ---------------------------------------------------------*/

/* USER CODE BEGIN PV */
hx711_t loadcell_right;
hx711_t loadcell_left;


PIDController temp_controller;
/* USER CODE END PV */

/* Private function prototypes -----------------------------------------------*/
void SystemClock_Config(void);
/* USER CODE BEGIN PFP */

extern uint8_t CDC_Transmit_FS(uint8_t* Buf, uint16_t Len);
void InitLoadCells(void);
void InitPIDController(void);

/* USER CODE END PFP */

/* Private user code ---------------------------------------------------------*/
/* USER CODE BEGIN 0 */

//USB buffer
uint8_t buffer[15];

//Temperature control variables
float temperature;
float goal_temp=TARGET_TEMP;
uint32_t control;

//Scale variables
long weightLeft = 0;
long weightRight = 0;
long weight=0;
bool ReadSensorData=true;
/* USER CODE END 0 */

/**
  * @brief  The application entry point.
  * @retval int
  */
int main(void)
{
  /* USER CODE BEGIN 1 */
	InitPIDController();
  /* USER CODE END 1 */

  /* MCU Configuration--------------------------------------------------------*/

  /* Reset of all peripherals, Initializes the Flash interface and the Systick. */
  HAL_Init();

  /* USER CODE BEGIN Init */

  /* USER CODE END Init */

  /* Configure the system clock */
  SystemClock_Config();

  /* USER CODE BEGIN SysInit */

  /* USER CODE END SysInit */

  /* Initialize all configured peripherals */
  MX_GPIO_Init();
  MX_DMA_Init();
  MX_SPI1_Init();
  MX_SPI2_Init();
  MX_SPI3_Init();
  MX_TIM2_Init();
  MX_CRC_Init();
  MX_TIM3_Init();
  MX_TIM5_Init();
  MX_USB_DEVICE_Init();
  MX_TouchGFX_Init();
  /* USER CODE BEGIN 2 */

//Start Timers
  HAL_TIM_Base_Start_IT(&htim2);
  HAL_TIM_Base_Start_IT(&htim3);
  HAL_TIM_PWM_Start(&htim5,TIM_CHANNEL_1);

 //Initialize own modules
   Init_LCD();
   XPT2046_Init();

   InitLoadCells();


  /* USER CODE END 2 */

  /* Infinite loop */
  /* USER CODE BEGIN WHILE */
  while (1)
  {
#ifdef scale
	  if(ReadSensorData==true){
		  weightRight = get_weight(&loadcell_right, 1, CHANNEL_A);
		  weightLeft = get_weight(&loadcell_left, 1, CHANNEL_A);
		  weight=weightRight+weightLeft;
		  sprintf((char*)buffer, "%.2f;%ld\n", temperature,weight);
		  CDC_Transmit_FS((uint8_t*)buffer, strlen((const char*)buffer));
		  ReadSensorData=false;
	  }
#endif
    /* USER CODE END WHILE */

  MX_TouchGFX_Process();
    /* USER CODE BEGIN 3 */
  }
  /* USER CODE END 3 */
}

/**
  * @brief System Clock Configuration
  * @retval None
  */
void SystemClock_Config(void)
{
  RCC_OscInitTypeDef RCC_OscInitStruct = {0};
  RCC_ClkInitTypeDef RCC_ClkInitStruct = {0};

  /** Configure the main internal regulator output voltage
  */
  __HAL_RCC_PWR_CLK_ENABLE();
  __HAL_PWR_VOLTAGESCALING_CONFIG(PWR_REGULATOR_VOLTAGE_SCALE1);

  /** Initializes the RCC Oscillators according to the specified parameters
  * in the RCC_OscInitTypeDef structure.
  */
  RCC_OscInitStruct.OscillatorType = RCC_OSCILLATORTYPE_HSE;
  RCC_OscInitStruct.HSEState = RCC_HSE_ON;
  RCC_OscInitStruct.PLL.PLLState = RCC_PLL_ON;
  RCC_OscInitStruct.PLL.PLLSource = RCC_PLLSOURCE_HSE;
  RCC_OscInitStruct.PLL.PLLM = 25;
  RCC_OscInitStruct.PLL.PLLN = 192;
  RCC_OscInitStruct.PLL.PLLP = RCC_PLLP_DIV2;
  RCC_OscInitStruct.PLL.PLLQ = 4;
  if (HAL_RCC_OscConfig(&RCC_OscInitStruct) != HAL_OK)
  {
    Error_Handler();
  }

  /** Initializes the CPU, AHB and APB buses clocks
  */
  RCC_ClkInitStruct.ClockType = RCC_CLOCKTYPE_HCLK|RCC_CLOCKTYPE_SYSCLK
                              |RCC_CLOCKTYPE_PCLK1|RCC_CLOCKTYPE_PCLK2;
  RCC_ClkInitStruct.SYSCLKSource = RCC_SYSCLKSOURCE_PLLCLK;
  RCC_ClkInitStruct.AHBCLKDivider = RCC_SYSCLK_DIV1;
  RCC_ClkInitStruct.APB1CLKDivider = RCC_HCLK_DIV2;
  RCC_ClkInitStruct.APB2CLKDivider = RCC_HCLK_DIV1;

  if (HAL_RCC_ClockConfig(&RCC_ClkInitStruct, FLASH_LATENCY_3) != HAL_OK)
  {
    Error_Handler();
  }
}

/* USER CODE BEGIN 4 */


/**
  * @brief  Initialization the left and right loadcells
  * @param None
  * @retval None
  */

void InitLoadCells(void){
#ifdef scale
	hx711_init(&loadcell_right,SCALE_RIGHT_CLK_GPIO_Port,SCALE_RIGHT_CLK_Pin, SCALE_RIGHT_DIN_GPIO_Port,SCALE_RIGHT_DIN_Pin);
	set_scale(&loadcell_right,RIGHT_SCALING,1);
	set_gain(&loadcell_right, 128, 32);
	tare_all(&loadcell_right,10);

	hx711_init(&loadcell_left,SCALE_LEFT_CLK_GPIO_Port,SCALE_LEFT_CLK_Pin, SCALE_LEFT_DIN_GPIO_Port,SCALE_LEFT_DIN_Pin);
	set_scale(&loadcell_left,LEFT_SCALING,1);
	set_gain(&loadcell_left, 128, 32);
	tare_all(&loadcell_left,10);
#endif
}

void InitPIDController(void){

	temp_controller.Kd=2500;
	  temp_controller.Ki=150;
	  temp_controller.Kp=800;
	  temp_controller.T=0.25;
	  temp_controller.tau=0.1;
	  temp_controller.limMax=4999;
	  temp_controller.limMin=0;
	  temp_controller.limMaxInt=300;
	  temp_controller.limMinInt=-4999;
	  PIDController_Init(&temp_controller);

}

extern void touchgfxSignalVSync(void);



void HAL_TIM_PeriodElapsedCallback(TIM_HandleTypeDef *htim)
{
	if (htim->Instance == TIM2) {
		touchgfxSignalVSync();
	}
	if (htim->Instance == TIM1) {

	}
	//making a timer interrupt every 0.25 seconds
	if (htim->Instance == TIM3) {
		 temperature=Max6675_Read_Temp();
		 control=PIDController_Update(&temp_controller,goal_temp,temperature);
		 __HAL_TIM_SET_COMPARE(&htim5, TIM_CHANNEL_1, control);
		 ReadSensorData=true;


	}
}
/* USER CODE END 4 */

/**
  * @brief  This function is executed in case of error occurrence.
  * @retval None
  */
void Error_Handler(void)
{
  /* USER CODE BEGIN Error_Handler_Debug */
  /* User can add his own implementation to report the HAL error return state */
  __disable_irq();
  while (1)
  {
  }
  /* USER CODE END Error_Handler_Debug */
}

#ifdef  USE_FULL_ASSERT
/**
  * @brief  Reports the name of the source file and the source line number
  *         where the assert_param error has occurred.
  * @param  file: pointer to the source file name
  * @param  line: assert_param error line source number
  * @retval None
  */
void assert_failed(uint8_t *file, uint32_t line)
{
  /* USER CODE BEGIN 6 */
  /* User can add his own implementation to report the file name and line number,
     ex: printf("Wrong parameters value: file %s on line %d\r\n", file, line) */
  /* USER CODE END 6 */
}
#endif /* USE_FULL_ASSERT */
