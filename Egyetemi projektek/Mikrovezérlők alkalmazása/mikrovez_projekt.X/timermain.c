

//#include <xc.h>         // �ltal�nos header a PIC24 csal�dhoz
//#include <stdio.h>      // sprintf miatt
//#include <stdlib.h>     // malloc
//#include <string.h>     // memset
//#include "timer1637.h"
//#include "pin_manage.h"
//#include "io_mapping.h"
//
//// Hardver tulajdons�gok:
//
//// PLL ut�ni �rajel
//
//
//// Delay f�ggv�nyek
//
//
//// LED-ek
//#define LED1        _LATG6
//#define LED2        _LATG7
//#define LED3        _LATG8
//#define LED4        _LATG9
//#define LEDR        _LATD15
//#define LEDG        _LATF4
//#define LEDB        _LATF5
//
//// Nyom�gombok
//#define SW1         !_RC1
//#define SW2         !_RC3
//#define SW3         !_RE8
//#define SW4         !_RE9
//
//// <editor-fold defaultstate="collapsed" desc="LCD Settings">
//
//// LCD l�bak
//#define LCD_DATA    LATE // bit 0..7
//#define LCD_RS      _LATG0
//#define LCD_RW      _LATG1
//#define LCD_E       _LATF1
//#define LCD_BF      _RE7
//
//// LCD makr�k
//#define lcdPutChar(c) lcdWrite(c, 1)    // karakter k�ld�se
//#define lcdPutCmd(d)  lcdWrite(d, 0)    // utas�t�s k�ld�se
//#define lcdClear()    lcdWrite(0x01,0)  // LCD t�rl�se
//#define lcdGoHome()   lcdWrite(0x02,0)  // LCD k�ld�se az 1. sorba
//#define lcdGo2Row()   lcdWrite(0xC0,0)  // LCD k�ld�se a 2. sorba
//
//// magyar �kezetes karakterek
//const unsigned char hu_char[] = {
//0x02,0x04,0x0E,0x01,0x0F,0x11,0x0F,0x00, // �
//0x02,0x04,0x0E,0x11,0x1F,0x10,0x0E,0x00, // �
//0x02,0x04,0x0C,0x04,0x04,0x04,0x0E,0x00, // �
//0x02,0x04,0x0E,0x11,0x11,0x11,0x0E,0x00, // �
//0x02,0x04,0x11,0x11,0x11,0x13,0x0D,0x00, // �
//0x0A,0x00,0x11,0x11,0x11,0x13,0x0D,0x00, // �
//0x05,0x0A,0x11,0x11,0x11,0x13,0x0D,0x00, // �
//0x05,0x0A,0x0E,0x11,0x11,0x11,0x0E,0x00, // �
//};
//
//void lcdInit();
//void lcdWrite(uint8_t c, uint8_t rs);
//void lcdPutStr(char *s);
//void lcdLoadHuChars(void);
//
//// </editor-fold>
//
//char LCD[80];
//
//int main()
//{
//    CLK_SetDigitalOutput();
//    DIO_SetDigitalOutput();
// //Inicializ�l�s - setup
//    
//    // �rajel forr�s be�ll�t�sa
//    // PLL kimenete
//    CLKDIVbits.CPDIV = 0;    // 1:1 32MHz
//    // megv�rjuk am�g a PLL modul v�gez
//    while(!OSCCONbits.LOCK) Nop();
//    
//    // szoftveres WDT kikapcsol�sa
//    RCONbits.SWDTEN = 0;
//    
//    // �rakvarc enged�lyez�se
//    __builtin_write_OSCCONL(OSCCON | 0x02);
//    
//    // Perif�ria - l�b �sszerendel�s PPS (pp.135)
//    //__builtin_write_OSCCONL(OSCCON & 0xbf);  //PPSUnLock;
//    //
//    //__builtin_write_OSCCONL(OSCCON | 0x40); //PPSLock;
//    
//    
//    // L�bak ir�nya 
//    _TRISG6 = 0;    // LED1 kimenet
//    _TRISG7 = 0;    // LED2 kimenet
//    _TRISG8 = 0;    // LED3 kimenet
//    _TRISG9 = 0;    // LED4 kimenet
//    _TRISD15 = 0;   // LEDR kimenet
//    _TRISF4 = 0;    // LEDG kimenet
//    _TRISF5 = 0;    // LEDB kimenet
//    _TRISC1 = 1;    // SW1 bemenet
//    _TRISC3 = 1;    // SW2 bemenet 
//    _TRISE8 = 1;    // SW3 bemenet
//    _TRISE9 = 1;    // SW4 bemenet
//    
//    
//    lcdInit();                        // LCD modul inicializ�l�sa
//    lcdLoadHuChars();                 // magyar karakterek bet�lt�se 
//    lcdPutStr("Hell� uMOGI2  :)");    // sz�veg ki�rat�sa
//    DELAY_MS(2000);
//    
//    SetTimer();
//    StartTimer();
//  
//    
//        
//    
//    
//    while(1)
//    {
//        DisplayTime(t);
//    }
//    
// return (0);
//}
//
//
//// ISR
//void __attribute__((interrupt(auto_psv))) _T1Interrupt(){
//     t++;
//    _T1IF = 0;  // interrupt flag t�rl�se   
//}
//
//
//// <editor-fold defaultstate="collapsed" desc="LCD modul">
//
///**
// * <b>LCD inicializ�l�sa</b><br>
// * l�bak be�ll�t�sa<br>
// * ind�t�s 8 bites �zemm�dban<br>
// */
