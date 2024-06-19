

//#include <xc.h>         // általános header a PIC24 családhoz
//#include <stdio.h>      // sprintf miatt
//#include <stdlib.h>     // malloc
//#include <string.h>     // memset
//#include "timer1637.h"
//#include "pin_manage.h"
//#include "io_mapping.h"
//
//// Hardver tulajdonságok:
//
//// PLL utáni órajel
//
//
//// Delay függvények
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
//// Nyomógombok
//#define SW1         !_RC1
//#define SW2         !_RC3
//#define SW3         !_RE8
//#define SW4         !_RE9
//
//// <editor-fold defaultstate="collapsed" desc="LCD Settings">
//
//// LCD lábak
//#define LCD_DATA    LATE // bit 0..7
//#define LCD_RS      _LATG0
//#define LCD_RW      _LATG1
//#define LCD_E       _LATF1
//#define LCD_BF      _RE7
//
//// LCD makrók
//#define lcdPutChar(c) lcdWrite(c, 1)    // karakter küldése
//#define lcdPutCmd(d)  lcdWrite(d, 0)    // utasítás küldése
//#define lcdClear()    lcdWrite(0x01,0)  // LCD törlése
//#define lcdGoHome()   lcdWrite(0x02,0)  // LCD küldése az 1. sorba
//#define lcdGo2Row()   lcdWrite(0xC0,0)  // LCD küldése a 2. sorba
//
//// magyar ékezetes karakterek
//const unsigned char hu_char[] = {
//0x02,0x04,0x0E,0x01,0x0F,0x11,0x0F,0x00, // á
//0x02,0x04,0x0E,0x11,0x1F,0x10,0x0E,0x00, // é
//0x02,0x04,0x0C,0x04,0x04,0x04,0x0E,0x00, // í
//0x02,0x04,0x0E,0x11,0x11,0x11,0x0E,0x00, // ó
//0x02,0x04,0x11,0x11,0x11,0x13,0x0D,0x00, // ú
//0x0A,0x00,0x11,0x11,0x11,0x13,0x0D,0x00, // ü
//0x05,0x0A,0x11,0x11,0x11,0x13,0x0D,0x00, // û
//0x05,0x0A,0x0E,0x11,0x11,0x11,0x0E,0x00, // õ
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
// //Inicializálás - setup
//    
//    // Órajel forrás beállítása
//    // PLL kimenete
//    CLKDIVbits.CPDIV = 0;    // 1:1 32MHz
//    // megvárjuk amíg a PLL modul végez
//    while(!OSCCONbits.LOCK) Nop();
//    
//    // szoftveres WDT kikapcsolása
//    RCONbits.SWDTEN = 0;
//    
//    // Órakvarc engedélyezése
//    __builtin_write_OSCCONL(OSCCON | 0x02);
//    
//    // Periféria - láb összerendelés PPS (pp.135)
//    //__builtin_write_OSCCONL(OSCCON & 0xbf);  //PPSUnLock;
//    //
//    //__builtin_write_OSCCONL(OSCCON | 0x40); //PPSLock;
//    
//    
//    // Lábak iránya 
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
//    lcdInit();                        // LCD modul inicializálása
//    lcdLoadHuChars();                 // magyar karakterek betöltése 
//    lcdPutStr("Helló uMOGI2  :)");    // szöveg kiíratása
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
//    _T1IF = 0;  // interrupt flag törlése   
//}
//
//
//// <editor-fold defaultstate="collapsed" desc="LCD modul">
//
///**
// * <b>LCD inicializálása</b><br>
// * lábak beállítása<br>
// * indítás 8 bites üzemmódban<br>
// */
