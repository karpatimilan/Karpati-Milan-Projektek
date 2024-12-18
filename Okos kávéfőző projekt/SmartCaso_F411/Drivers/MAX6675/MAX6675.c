/*
 * MAX6675.c
 *
 *  Created on: Feb 25, 2024
 *      Author: peter
 */


#include"MAX6675.h"
extern SPI_HandleTypeDef hspi3;

// ------------------- Variables ----------------
_Bool TCF=0;                                          // Thermocouple Connection acknowledge Flag
uint8_t DATARX[2];                                    // Raw Data from MAX6675

// ------------------- Functions ----------------
float Max6675_Read_Temp(void){
float Temp=0;                                         // Temperature Variable
HAL_GPIO_WritePin(SSPORT,SSPIN,GPIO_PIN_RESET);       // Low State for SPI Communication
HAL_SPI_Receive(&hspi3, DATARX, 1, 50);       // DATA Transfer
HAL_GPIO_WritePin(SSPORT,SSPIN,GPIO_PIN_SET);         // High State for SPI Communication
TCF=(((DATARX[0]|(DATARX[1]<<8))>>2)& 0x0001);        // State of Connecting
Temp=((((DATARX[0]|DATARX[1]<<8)))>>3);               // Temperature Data Extraction
Temp*=0.25;                                           // Data to Centigrade Conversation
return Temp;
}
