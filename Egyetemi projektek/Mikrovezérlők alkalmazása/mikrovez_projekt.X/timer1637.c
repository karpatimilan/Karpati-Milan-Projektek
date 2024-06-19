/*
 * File:   timer1637.c
 * Author: peter
 *
 * Created on November 20, 2023, 7:47 PM
 */


//A kommunikáció megvalósítására szolgáló kódrész

#include "xc.h"
#include "timer1637.h"
#include "io_mapping.h"



#define adress 0b11000000
#define brightness 0b10001111


// Az adat és órajel vezetékek fel és lehúzására szolgáló függvények
//(Mivel az I2C lábak alapértelmezetten felhúzó ellenállásokkal rendelkeznek
//amennyiben nem húzzuk le õket a lábak magasan vannak)
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
// A kommunikáció megkezdésére szolgáló függvény az adatvezeték magasról
//alacsony szintre vált miközben az órajel vezeték magas szinten van

void startComm(){
    setCLKhigh();
    setDIOhigh();
    setDIOlow();
}
// A kommunikáció befejezését jelzõ függvény az adatvezeték alacsonyról magasba
//vált miközben az órajel vezeték magas állapotban van
void stopComm(){
setCLKlow();
setDIOlow();
setCLKhigh();
setDIOhigh();
}    

//A TM1637-es modultól érkezõ megerõsítés ellenõrzése. A modul a 8. órajel után
//az adatvezetéket lehúzza nullára majd a 9. órajel után elengedi a vezetéket
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

//Nyolc bit kiküldését megvalósító függvény a függvény bemenete egy char amelyet
//bináris értékre váltunk és megvizsgáljuk,hogy az adott bit 0 vagy 1 majd ennek
//megfelelõen az adatvezetéket magasra vagy alacsonyra állítjuk. Fontos hogy az
//adat vezeték érétkváltozása mindig az órajel vezeték alacsony állapota mellett
//következik be.
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

//A függvény az idõ másodperben megadott értékét konvertálja idõ formátumba és 
// a digit tömbe számjegyekre bontva tárolja el az idõ értéket.
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
//A függvény a másodpercben megadott idõértéket perc:másodperc formátumban 
//megjeleníti a TM-1637 modulon
void DisplayTime(int num){
    ConvertTime(num);
    startComm();
    startComm();
    comm(adress);
    checkACK();
    
    
    //ADAT KÜLDÉS
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
//Számjegyek átváltása a kijelzõ szegmenseinek megfelelõ formátumba
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