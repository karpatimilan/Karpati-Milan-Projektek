#ifndef LCD_H
#define	LCD_H

#include <xc.h>
#include "system.h"

// LCD l�bak
#define LCD_DATA    LATE // bit 0..7
#define LCD_RS      _LATG0
#define LCD_RW      _LATG1
#define LCD_E       _LATF1
#define LCD_BF      _RE7

// LCD makr�k
#define lcdPutChar(c) lcdWrite(c, 1)    // karakter k�ld�se
#define lcdPutCmd(d)  lcdWrite(d, 0)    // utas�t�s k�ld�se
#define lcdClear()    lcdWrite(0x01,0)  // LCD t�rl�se
#define lcdGoHome()   lcdWrite(0x02,0)  // LCD k�ld�se az 1. sorba
#define lcdGo2Row()   lcdWrite(0xC0,0)  // LCD k�ld�se a 2. sorba

void lcdInit();
void lcdWrite(uint8_t c, uint8_t rs);
void lcdPutStr(char *s);
void lcdLoadHuChars(void);


#endif	/* LCD_H */

