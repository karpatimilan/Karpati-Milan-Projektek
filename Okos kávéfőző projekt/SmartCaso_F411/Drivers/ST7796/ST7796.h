/*
 * ST7796.h
 *
 *  Created on: Mar 7, 2024
 *      Author: peter
 */

#ifndef ST7796_ST7796_H_
#define ST7796_ST7796_H_


#ifdef __cplusplus
 extern "C" {
#endif

#include "main.h" // For STM32F4

#define GUI_WIDTH 480
#define GUI_HEIGHT 320

 void Init_LCD();
void ST7796_SetWindow(uint16_t x0, uint16_t y0, uint16_t x1, uint16_t y1);
void ST7796_DrawBitmap(uint16_t w, uint16_t h, uint8_t *s);
void ST7796_EndOfDrawBitmap(void);

void writecommand(uint8_t data);
void LCD_IO_WriteMultipleData(uint8_t *pData, uint32_t Size);

#ifdef __cplusplus
}
#endif



#endif /* ST7796_ST7796_H_ */
