/* USER CODE BEGIN Header */
/**
  ******************************************************************************
  * @file           : main.h
  * @brief          : Header for main.c file.
  *                   This file contains the common defines of the application.
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

/* Define to prevent recursive inclusion -------------------------------------*/
#ifndef __MAIN_H
#define __MAIN_H

#ifdef __cplusplus
extern "C" {
#endif

/* Includes ------------------------------------------------------------------*/
#include "stm32f4xx_hal.h"

/* Private includes ----------------------------------------------------------*/
/* USER CODE BEGIN Includes */

/* USER CODE END Includes */

/* Exported types ------------------------------------------------------------*/
/* USER CODE BEGIN ET */

/* USER CODE END ET */

/* Exported constants --------------------------------------------------------*/
/* USER CODE BEGIN EC */

/* USER CODE END EC */

/* Exported macro ------------------------------------------------------------*/
/* USER CODE BEGIN EM */

/* USER CODE END EM */

/* Exported functions prototypes ---------------------------------------------*/
void Error_Handler(void);

/* USER CODE BEGIN EFP */

/* USER CODE END EFP */

/* Private defines -----------------------------------------------------------*/
#define HEATER_PWM_Pin GPIO_PIN_0
#define HEATER_PWM_GPIO_Port GPIOA
#define DISP_RESET_Pin GPIO_PIN_3
#define DISP_RESET_GPIO_Port GPIOA
#define DISP__CS_Pin GPIO_PIN_4
#define DISP__CS_GPIO_Port GPIOA
#define DISP_SCK_Pin GPIO_PIN_5
#define DISP_SCK_GPIO_Port GPIOA
#define DISP_DC_RS_Pin GPIO_PIN_6
#define DISP_DC_RS_GPIO_Port GPIOA
#define DISP_MOSI_Pin GPIO_PIN_7
#define DISP_MOSI_GPIO_Port GPIOA
#define T_CS_Pin GPIO_PIN_12
#define T_CS_GPIO_Port GPIOB
#define T_CLK_Pin GPIO_PIN_13
#define T_CLK_GPIO_Port GPIOB
#define T_DIN_Pin GPIO_PIN_14
#define T_DIN_GPIO_Port GPIOB
#define T_DO_Pin GPIO_PIN_15
#define T_DO_GPIO_Port GPIOB
#define T_IRQ_Pin GPIO_PIN_8
#define T_IRQ_GPIO_Port GPIOA
#define T_IRQ_EXTI_IRQn EXTI9_5_IRQn
#define TEMP_SCK_Pin GPIO_PIN_3
#define TEMP_SCK_GPIO_Port GPIOB
#define TEMP_MISO_Pin GPIO_PIN_4
#define TEMP_MISO_GPIO_Port GPIOB
#define TEMP_CS_Pin GPIO_PIN_5
#define TEMP_CS_GPIO_Port GPIOB
#define SCALE_RIGHT_DIN_Pin GPIO_PIN_6
#define SCALE_RIGHT_DIN_GPIO_Port GPIOB
#define SCALE_RIGHT_CLK_Pin GPIO_PIN_7
#define SCALE_RIGHT_CLK_GPIO_Port GPIOB
#define SCALE_LEFT_DIN_Pin GPIO_PIN_8
#define SCALE_LEFT_DIN_GPIO_Port GPIOB
#define SCALE_LEFT_CLK_Pin GPIO_PIN_9
#define SCALE_LEFT_CLK_GPIO_Port GPIOB

/* USER CODE BEGIN Private defines */

/* USER CODE END Private defines */

#ifdef __cplusplus
}
#endif

#endif /* __MAIN_H */
