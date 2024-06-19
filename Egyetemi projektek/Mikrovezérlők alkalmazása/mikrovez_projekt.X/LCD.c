#include <xc.h>
#include "LCD.h"

//magyar �kezetes karakterek
const unsigned char hu_char[] = {
0x02,0x04,0x0E,0x01,0x0F,0x11,0x0F,0x00, //�
0x02,0x04,0x0E,0x11,0x1F,0x10,0x0E,0x00, //�
0x02,0x04,0x0C,0x04,0x04,0x04,0x0E,0x00, //�
0x02,0x04,0x0E,0x11,0x11,0x11,0x0E,0x00, //�
0x02,0x04,0x11,0x11,0x11,0x13,0x0D,0x00, //�
0x0A,0x00,0x11,0x11,0x11,0x13,0x0D,0x00, //�
0x05,0x0A,0x11,0x11,0x11,0x13,0x0D,0x00, //�
0x05,0x0A,0x0E,0x11,0x11,0x11,0x0E,0x00, //�
};

/**
 * <b>LCD inicializ�l�sa</b><br>
 * l�bak be�ll�t�sa<br>
 * ind�t�s 8 bites �zemm�dban<br>
 */
void lcdInit(){
    
    // az LCD vez�rl� vonalainak be�ll�t�sa
    TRISE &= 0xff00; // D0-D7 kimenet
    _TRISG0 = 0;     // RS kimenet
    _TRISG1 = 0;     // RW kimenet
    _TRISF1 = 0;     // E kimenet
    LCD_RS = 0;      // RS alacsony
    LCD_RW = 0;      // RW alacsony
    LCD_E = 0;       // E alacsony
    
    DELAY_MS(50);    // v�r az eszk�z be�ll�s�ra
    
    lcdPutCmd(0x38); // 2 soros display, 5x8 karakter
    lcdPutCmd(0x08); // display off
    lcdPutCmd(0x01); // k�perny� t�rl�se, kurzor alaphelyzetbe �ll�t�s
    lcdPutCmd(0x06); // automatikus inkrement�l�s, nem l�pteti a kijelz�t
    lcdPutCmd(0x0C); // a display bekapcsol�sa; kurzor �s villog�s kikapcsolva
    
    DELAY_MS(3);
}


/**
 * adat vagy utas�t�s k�ld�se
 * @param c adat/karakter
 * @param rs 0 - utas�t�s, 1 - adat
 */
void lcdWrite(uint8_t c, uint8_t rs){
    
    uint8_t BF;      // BusyFlag (foglalts�g) figyel�se
    TRISE |= 0x00ff; // l�bak bemenetek
    LCD_RW = 1;      // beolvas�s
    LCD_RS = 0;      // utas�t�s
    LCD_DATA &= 0xff00;
    do {
        LCD_E = 1;   // E magas
        Nop(); Nop(); Nop(); BF = LCD_BF;
        LCD_E = 0;   // E alacsony
    } while (BF);
    
    TRISE &= 0xff00; // l�bak kimenetek
    LCD_RW = 0;      // �r�s
    LCD_RS = rs ? 1 : 0;      // adat vagy parancs
    LCD_DATA = (LCD_DATA & 0xff00) | c;    // 8 bit k�ld�se
    LCD_E = 1;       // E magas
    Nop(); Nop(); Nop();
    LCD_E = 0;       // E alacsony
}


/**
 * ki�r egy karakterf�z�rt az LCD-re
 * @param s Karaktert�mb
 */
void lcdPutStr(char *s){
  while (*s) {
    char c = *s;
    switch(c) {           // magyar karakterek cser�je a felt�lt�ttre
      case '�':  c = 0x00; break;
      case '�':  c = 0x01; break;
      case '�':  c = 0x02; break;
      case '�':  c = 0x03; break;
      case '�':  c = 0x04; break;
      case '�':  c = 0x05; break;
      case '�':  c = 0x06; break;
      case '�':  c = 0x07; break;
      case '�':  c = 0xEF; break;
    }
    if (c == '\n')
      lcdGo2Row();        // kurzor mozgat�sa a m�sodik sor elej�re
    else
      lcdPutChar(c);      // karakter ki�rat�sa
    s++;
  }
}


// magyar �kezetes karakterek felt�lt�se a CGRAM-ba
void lcdLoadHuChars(void) {
    int i;
    lcdPutCmd(0x40);             // kurzor a CGRAM elej�re (0. char)
    for(i=0; i<64; i++) {
      lcdPutChar(hu_char[i]);    // defini�lhat� karakterek felt�lt�se
    }                            // �kezetes karakterekkel
    lcdPutCmd(0x80);             // kurzor vissza, a DDRAM elej�re
}