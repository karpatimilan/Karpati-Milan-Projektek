/*******************************************************************************
Copyright 2016 Microchip Technology Inc. (www.microchip.com)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

To request to license the code under the MLA license (www.microchip.com/mla_license), 
please contact mla_licensing@microchip.com
*******************************************************************************/

/** INCLUDES *******************************************************/
#include <xc.h>
#include "system.h"
#include "io_mapping.h"
#include "usb_config.h"
#include "usb.h"
#include "usb_device.h"
#include "usb_device_cdc.h"
#include "LCD.h"
#include <stdio.h>
#include <stdint.h>
#include <string.h>
#include <stddef.h>
#include <stdbool.h>
#include "timer1637.h"

/*********************************************************************
* Function: void APP_DeviceCDCBasicDemoInitialize(void);
*
* Overview: Initializes the code
*
* PreCondition: None
*
* Input: None
*
* Output: None
*
********************************************************************/


void APP_CDCInitialize(void);

/*********************************************************************
* Function: void APP_DeviceCDCBasicDemoTasks(void);
*
* Overview: Keeps the demo running.
*
* PreCondition: The demo should have been initialized and started via
*   the APP_DeviceCDCBasicDemoInitialize()
*
* Input: None
*
* Output: None
*
********************************************************************/
void APP_CDCTasks(void);

/********************************************************************
 * Function:        void main(void)
 *
 * PreCondition:    None
 *
 * Input:           None
 *
 * Output:          None
 *
 * Side Effects:    None
 *
 * Overview:        Main program entry point.
 *
 * Note:            None
 *******************************************************************/

/** VARIABLES ******************************************************/
int t=0;
int t_kor=0;
t_kor2=0;
digits2[4]={0,0,0,0};
//A függvény a másodpercben megadott idõt számjegyekre bontja így a késõbbiekben
//idõ formátumú stringet tudunk készíteni belõle
void ConvertTimeToWrite(int num){
int min=num/60;
for (int i = 1; i>=0; i--) {

        digits2[i] = (min % 10);
        min *= 0.1;
    }
   num=num%60;
    for (int i = 3; i>=2; i--) {

        digits2[i] = (num % 10);
        num *= 0.1;
    }
}
// A stopperhez szükséges Timer 
void SetTimer()
{
_T1IF = 0; // Interrupt flag törlése
_T1IE = 1; // Interrupt engedélyezése
PR1 = (F_SEC_OSC) - 1; // Idõ beállítása
TMR1 = 0x0000; // Timer1 beállítása
T1CONbits.TCKPS = 0; // T1 elõosztó 1:1
T1CONbits.TCS = 1; // T1 forrása az órakvarc
}
//Timer elindítása
void StartTimer(){
    T1CONbits.TON=1;
}
//Timer megállítása
void StopTimer(){
    T1CONbits.TON=0;
  
}
//Állapotok definiálása
enum States {
    INIT,
    STOP,
    STOPPER, 
    KOR
};
enum States STATE=INIT;

static uint8_t readBuffer[CDC_DATA_OUT_EP_SIZE];
static uint8_t writeBuffer[CDC_DATA_IN_EP_SIZE];
char LCD[80];
int a=1;

MAIN_RETURN main(void)
{
     CLK_SetDigitalOutput();
    DIO_SetDigitalOutput();
    //Orajel forras beallitasa
    // PLL kimenete
    CLKDIVbits.CPDIV = 0;    // 1:1 32MHz
    // megvarjuk amig a PLL modul vegez
    while(!OSCCONbits.LOCK) Nop();
	
    // szoftveres WDT kikapcsolasa
    RCONbits.SWDTEN = 0;
	
	// Orakvarc engedelyezese
	__builtin_write_OSCCONL(OSCCON | 0x02);

	// Periferia - lab osszerendeles PPS (pp.135)
	//__builtin_write_OSCCONL(OSCCON & 0xbf);  //PPSUnLock;
	//
	//__builtin_write_OSCCONL(OSCCON | 0x40); //PPSLock;
    
    SYSTEM_Initialize(SYSTEM_STATE_USB_START);
    USBDeviceInit();
    USBDeviceAttach();

    // Labak iranya	
	_TRISG6 = 0;	// LED1 kimenet
	_TRISG7 = 0;	// LED2 kimenet
	_TRISG8 = 0;	// LED3 kimenet
    _TRISG9 = 0;	// LED4 kimenet
    _TRISD15 = 0;	// LEDR kimenet
    _TRISF4 = 0;	// LEDG kimenet
    _TRISF5 = 0;	// LEDB kimenet
	_TRISC1 = 1;	// SW1 bemenet
	_TRISC3 = 1;	// SW2 bemenet 
	_TRISE8 = 1;	// SW3 bemenet
    _TRISE9 = 1;	// SW4 bemenet
    
    lcdInit();                  //LCD modul inicializálása
    lcdLoadHuChars();                //Magyar karakterek betöltése
    lcdPutStr("uMOGI2 Serial");   //Szöveg kiíratása
    
     SetTimer();

    while(1)
    {
        //Application specific tasks
        APP_CDCTasks();
        
        // Az állapotgép
        switch(STATE){
            //Init állapotban a timer mindenképp áll emellett a stopper
            //nullázódik
            case INIT:
                StopTimer();
                t=0;
                DisplayTime(t);
                
            
              //  if(a==1){
                
                //a=0;
               // t_kor=0;
              //  t_kor2=0;
              //  }
                //SW1 megnyomására elindul a stopper
                if(SW1){
                    DELAY_MS(10);
                    while(SW1)Nop();
                    DELAY_MS(10);
                    STATE=STOPPER;
                    StartTimer();
                   
                }
                
            break;
            //A stopper futái állapota
            case STOPPER:
                
        
            //SW2 megnyomására a stopper megáll
            if(SW2){
             DELAY_MS(10);
             while(SW2)Nop();
             DELAY_MS(10); 
             STATE=STOP;
            }
            //A TM-1637 modulra kiírjuk az eltelt idõt
             DisplayTime(t);
                 break;
             //A Stopper megállítása
            case STOP:
                StopTimer();
                //SW2 megnyomására nullázhatjuk a stoppert
                if(SW2){
                 DELAY_MS(10);
                 while(SW2)Nop();
                 DELAY_MS(10);
                 
                 STATE=INIT;
                }
                //SW1 megnyomására újra elindíthatjuk
                 if(SW1){
                 DELAY_MS(10);
                 while(SW1)Nop();
                 DELAY_MS(10);
                 STATE=STOPPER;
                 StartTimer();
                }
            
            break;
        
        }
     
      
          
          

    }//end while
}//end main

//// Minden interuptnál az eltel másodpercekhez hozzáadunk egyet
void __attribute__((interrupt(auto_psv))) _T1Interrupt(){
     t++;
    _T1IF = 0;  // interrupt flag törlése   
}

/*********************************************************************
* Function: void APP_CDCInitialize(void);
*
* Overview: Initializes the code
*
* PreCondition: None
*
* Input: None
*
* Output: None
*
********************************************************************/
void APP_CDCInitialize()
{   
    line_coding.bCharFormat = 0;
    line_coding.bDataBits = 8;
    line_coding.bParityType = 0;
    line_coding.dwDTERate = 9600;
}

/*********************************************************************
* Function: void APP_CDCTasks(void);
*
* Overview: Keeps the demo running.
*
* PreCondition: The demo should have been initialized and started via
*   the APP_CDCInitialize()
*
* Input: None
*
* Output: None
*
********************************************************************/
void APP_CDCTasks()
{
    
    /* If the USB device isn't configured yet, we can't really do anything
     * else since we don't have a host to talk to.  So jump back to the
     * top of the while loop. */
    if( USBGetDeviceState() < CONFIGURED_STATE )
    {
        return;
    }

    /* If we are currently suspended, then we need to see if we need to
     * issue a remote wakeup.  In either case, we shouldn't process any
     * keyboard commands since we aren't currently communicating to the host
     * thus just continue back to the start of the while loop. */
    if( USBIsDeviceSuspended()== true )
    {
        return;
    }
        

    /* Check to see if there is a transmission in progress, if there isn't, then
     * we can see about performing an echo response to data received.
     */
     if( USBUSARTIsTxTrfReady() == true)
    {
        uint8_t numBytesRead;

        numBytesRead = getsUSBUSART(readBuffer, sizeof(readBuffer));
        if (numBytesRead>0)
        {
            memset(writeBuffer,0,sizeof(writeBuffer));
     
            switch(readBuffer[0])
            {
                case 0x0A:
                case 0x0D:
                    break;
                //Amennyiben a számítógép küld egy kérdõjelet két lehetséges 
                //opció van. Amennyiben SW3, azaz a kör gomb meg van nyomva
                //a mikrovezérlõ visszaküld egy k-t jelezve,hogy a kör funkció
                //meg lett nyomva.Amennyiben SW3 nincs megnyomva az aktuális
                //stopperen mért idõt küldjük el a számítógépnek
                case '?':
                    ConvertTimeToWrite(t);
                   
                   
                    
                    if(SW3){strcpy((char *)writeBuffer,"k\r\n");
                    }
                  
                    else{
                    sprintf(writeBuffer, "%i%i:%i%i\r\n",digits2[0],digits2[1],digits2[2],digits2[3]);
                    }
                    break;
                 
                
               
                default:
                    strcpy((char *)writeBuffer,"?\r\n");
                    break;
                    
                  
                  //A start gomb megnyomására a számítógép egy S betût küld,
                 // elindítja a stoppert
                case 'S':
                    STATE=STOPPER;
                    StartTimer();
                    a=1;
                    break;
                 //A start gomb megnyomására a számítógép egy S betût küld,
                 // megállítja a stoppert
                case 'M':
                    STATE=STOP;
                    break;
                    //A start gomb megnyomására a számítógép egy S betût küld,
                 // nulláza a stoppert
                case 'R':
                    STATE=INIT;
                    break;
                    
             
                
                            
                        
  
            }
            
            putUSBUSART(writeBuffer,strlen((char*)writeBuffer));
        }
    } 

    CDCTxService();
}

/*******************************************************************************
 End of File
*/
