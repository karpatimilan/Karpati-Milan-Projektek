/*
 * MAX6675.h
 *
 *  Created on: Feb 25, 2024
 *      Author: peter
 */

#ifndef INC_MAX6675_H_
#define INC_MAX6675_H_
#include "main.h"

// ------------------------- Defines -------------------------
#define SSPORT GPIOB       // GPIO Port of Chip Select(Slave Select)
#define SSPIN  GPIO_PIN_5  // GPIO PIN of Chip Select(Slave Select)
// ------------------------- Functions  ----------------------
float Max6675_Read_Temp(void);
#endif
