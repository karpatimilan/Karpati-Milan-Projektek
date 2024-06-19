/*
 * File:   timer1637.c
 * Author: peter
 *
 * Created on November 20, 2023, 7:47 PM
 */


//A kommunik�ci� megval�s�t�s�ra szolg�l� k�dr�sz

#include "xc.h"
#include "timer1637.h"
#include "io_mapping.h"



#define adress 0b11000000
#define brightness 0b10001111


// Az adat �s �rajel vezet�kek fel �s leh�z�s�ra szolg�l� f�ggv�nyek
//(Mivel az I2C l�bak alap�rtelmezetten felh�z� ellen�ll�sokkal rendelkeznek
//amennyiben nem h�zzuk le �ket a l�bak magasan vannak)
void setCLKhigh(){
    CLK_SetHigh();
    DELAY_US(defdelay);
}
void setCLKlow(){
    CLK_SetLow();
    DELAY_US(defdelay);
}
void setDIOhigh(){
    DIO_SetHigh();
    DELAY_US(defdelay);
}
void setDIOlow(){
    DIO_SetLow();
    DELAY_US(defdelay);
}
// A kommunik�ci� megkezd�s�re szolg�l� f�ggv�ny az adatvezet�k magasr�l
//alacsony szintre v�lt mik�zben az �rajel vezet�k magas szinten van

void startComm(){
    setCLKhigh();
    setDIOhigh();
    setDIOlow();
}
// A kommunik�ci� befejez�s�t jelz� f�ggv�ny az adatvezet�k alacsonyr�l magasba
//v�lt mik�zben az �rajel vezet�k magas �llapotban van
void stopComm(){
setCLKlow();
setDIOlow();
setCLKhigh();
setDIOhigh();
}    

//A TM1637-es modult�l �rkez� meger�s�t�s ellen�rz�se. A modul a 8. �rajel ut�n
//az adatvezet�ket leh�zza null�ra majd a 9. �rajel ut�n elengedi a vezet�ket
void checkACK(){
   setCLKlow();
    DELAY_US(defdelay);
    DIO_SetDigitalInput();
    
    while(DIO_GetValue()==1);
    setCLKhigh();
    DELAY_US(defdelay);
    setCLKlow();
    DIO_SetDigitalOutput();
    setDIOlow();
}

//Nyolc bit kik�ld�s�t megval�s�t� f�ggv�ny a f�ggv�ny bemenete egy char amelyet
//bin�ris �rt�kre v�ltunk �s megvizsg�ljuk,hogy az adott bit 0 vagy 1 majd ennek
//megfelel�en az adatvezet�ket magasra vagy alacsonyra �ll�tjuk. Fontos hogy az
//adat vezet�k �r�tkv�ltoz�sa mindig az �rajel vezet�k alacsony �llapota mellett
//k�vetkezik be.
void comm(unsigned char c){
    for(int i=0;i<=7;i++){
        setCLKlow();
        if((c>>i)&0x01){
            setDIOhigh();
        }
        else{
       setDIOlow();}
        setCLKhigh();
    }
}
int digits[4] = { 0,0,0,0 };

//A f�ggv�ny az id� m�sodperben megadott �rt�k�t konvert�lja id� form�tumba �s 
// a digit t�mbe sz�mjegyekre bontva t�rolja el az id� �rt�ket.
void ConvertTime(int num){

int min=num/60;

for (int i = 1; i>=0; i--) {

        digits[i] = (min % 10);
        digits[i]=char2segments(digits[i]);
        min *= 0.1;
    }
   num=num%60;
    for (int i = 3; i>=2; i--) {

        digits[i] = (num % 10);
        digits[i]=char2segments(digits[i]);
        num *= 0.1;
    }

}
//A f�ggv�ny a m�sodpercben megadott id��rt�ket perc:m�sodperc form�tumban 
//megjelen�ti a TM-1637 modulon
void DisplayTime(int num){
    ConvertTime(num);
    startComm();
    startComm();
    comm(adress);
    checkACK();
    
    
    //ADAT K�LD�S
    comm(digits[0]);
    checkACK();
    comm(digits[1]+128);
    checkACK();
    comm(digits[2]);
    checkACK();
    comm(digits[3]);
    checkACK();
   

    //DISPLAY SETTING
    startComm();
    comm(brightness);
    checkACK();
    stopComm();
    
}
//Sz�mjegyek �tv�lt�sa a kijelz� szegmenseinek megfelel� form�tumba
int char2segments(int szam) {
        switch (szam) {
			case 0 : return 0x3f;
			case 1 : return 0x06;
			case 2 : return 0x5b;
			case 3 : return 0x4f;
			case 4 : return 0x66;
			case 5 : return 0x6d;
			case 6 : return 0x7d;
			case 7 : return 0x07;
			case 8 : return 0x7f;
			case 9 : return 0x6f;
           
        }
}