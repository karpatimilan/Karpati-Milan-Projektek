





#include "main.h"
#include "ST7796.h"

#define ST7796


extern SPI_HandleTypeDef hspi1;


void writecommand(uint8_t data);
static void writedata(uint8_t data);
static void RESET_L(void);
static void RESET_H(void);
static void CS_L(void);
static void CS_H(void);
static void DC_L(void);
static void DC_H(void);









void Init_LCD() {
#ifdef ST7796
	HAL_Delay(120);
		CS_L();
		writecommand(0x01); //Software reset
		HAL_Delay(120);

		writecommand(0x11); //Sleep exit
		HAL_Delay(120);

		writecommand(0xF0); //Command Set control
		writedata(0xC3);    //Enable extension command 2 partI

		writecommand(0xF0); //Command Set control
		writedata(0x96);    //Enable extension command 2 partII

		writecommand(0x36); //Memory Data Access Control MX, MY, RGB mode
		writedata(0xE8);    //X-Mirror, Top-Left to right-Buttom, RGB

		writecommand(0x3A); //Interface Pixel Format
		writedata(0x55);    //Control interface color format set to 16


		writecommand(0xB4); //Column inversion
		writedata(0x01);    //1-dot inversion

		writecommand(0xB6); //Display Function Control
		writedata(0x80);    //Bypass
		writedata(0x02);    //Source Output Scan from S1 to S960, Gate Output scan from G1 to G480, scan cycle=2
		writedata(0x3B);    //LCD Drive Line=8*(59+1)


		writecommand(0xE8); //Display Output Ctrl Adjust
		writedata(0x40);
		writedata(0x8A);
		writedata(0x00);
		writedata(0x00);
		writedata(0x29);    //Source eqaulizing period time= 22.5 us
		writedata(0x19);    //Timing for "Gate start"=25 (Tclk)
		writedata(0xA5);    //Timing for "Gate End"=37 (Tclk), Gate driver EQ function ON
		writedata(0x33);

		writecommand(0xC1); //Power control2
		writedata(0x06);    //VAP(GVDD)=3.85+( vcom+vcom offset), VAN(GVCL)=-3.85+( vcom+vcom offset)

		writecommand(0xC2); //Power control 3
		writedata(0xA7);    //Source driving current level=low, Gamma driving current level=High

		writecommand(0xC5); //VCOM Control
		writedata(0x18);    //VCOM=0.9

		HAL_Delay(120);

		//ST7796 Gamma Sequence
		writecommand(0xE0); //Gamma"+"
		writedata(0xF0);
		writedata(0x09);
		writedata(0x0b);
		writedata(0x06);
		writedata(0x04);
		writedata(0x15);
		writedata(0x2F);
		writedata(0x54);
		writedata(0x42);
		writedata(0x3C);
		writedata(0x17);
		writedata(0x14);
		writedata(0x18);
		writedata(0x1B);

		writecommand(0xE1); //Gamma"-"
		writedata(0xE0);
		writedata(0x09);
		writedata(0x0B);
		writedata(0x06);
		writedata(0x04);
		writedata(0x03);
		writedata(0x2B);
		writedata(0x43);
		writedata(0x42);
		writedata(0x3B);
		writedata(0x16);
		writedata(0x14);
		writedata(0x17);
		writedata(0x1B);

		HAL_Delay(120);

		writecommand(0xF0); //Command Set control
		writedata(0x3C);    //Disable extension command 2 partI

		writecommand(0xF0); //Command Set control
		writedata(0x69);    //Disable extension command 2 partII

		CS_H();
	  HAL_Delay(120);
	  CS_L();
		writecommand(0x29); //Display on
#endif

#ifdef ILI9488
		writecommand(0x01); //Software reset
		HAL_Delay(120);

		HAL_Delay(120);
			CS_L();
			writecommand(0x01); //Software reset
			HAL_Delay(120);

			writecommand(0x11); //Sleep exit
			HAL_Delay(120);

			writecommand(0xF0); //Command Set control
			writedata(0xC3);    //Enable extension command 2 partI

			writecommand(0xF0); //Command Set control
			writedata(0x96);    //Enable extension command 2 partII

			writecommand(0x36); //Memory Data Access Control MX, MY, RGB mode
			writedata(0xE8);    //X-Mirror, Top-Left to right-Buttom, RGB

			writecommand(0x3A); //Interface Pixel Format
			writedata(0x55);    //Control interface color format set to 16


			writecommand(0xB4); //Column inversion
			writedata(0x01);    //1-dot inversion

			writecommand(0xB6); //Display Function Control
			writedata(0x80);    //Bypass
			writedata(0x02);    //Source Output Scan from S1 to S960, Gate Output scan from G1 to G480, scan cycle=2
			writedata(0x3B);    //LCD Drive Line=8*(59+1)


			writecommand(0xE8); //Display Output Ctrl Adjust
			writedata(0x40);
			writedata(0x8A);
			writedata(0x00);
			writedata(0x00);
			writedata(0x29);    //Source eqaulizing period time= 22.5 us
			writedata(0x19);    //Timing for "Gate start"=25 (Tclk)
			writedata(0xA5);    //Timing for "Gate End"=37 (Tclk), Gate driver EQ function ON
			writedata(0x33);

			writecommand(0xC1); //Power control2
			writedata(0x06);    //VAP(GVDD)=3.85+( vcom+vcom offset), VAN(GVCL)=-3.85+( vcom+vcom offset)

			writecommand(0xC2); //Power control 3
			writedata(0xA7);    //Source driving current level=low, Gamma driving current level=High

			writecommand(0xC5); //VCOM Control
			writedata(0x18);    //VCOM=0.9

			HAL_Delay(120);

    writecommand(0xE0); // Positive Gamma Control
        writedata(0x00);
        writedata(0x03);
        writedata(0x09);
        writedata(0x08);
        writedata(0x16);
        writedata(0x0A);
        writedata(0x3F);
        writedata(0x78);
        writedata(0x4C);
        writedata(0x09);
        writedata(0x0A);
        writedata(0x08);
        writedata(0x16);
        writedata(0x1A);
        writedata(0x0F);

        writecommand(0XE1); // Negative Gamma Control
        writedata(0x00);
        writedata(0x16);
        writedata(0x19);
        writedata(0x03);
        writedata(0x0F);
        writedata(0x05);
        writedata(0x32);
        writedata(0x45);
        writedata(0x46);
        writedata(0x04);
        writedata(0x0E);
        writedata(0x0D);
        writedata(0x35);
        writedata(0x37);
        writedata(0x0F);

        writecommand(0XC0); // Power Control 1
        writedata(0x17);
        writedata(0x15);

        writecommand(0xC1); // Power Control 2
        writedata(0x41);

        writecommand(0xC5); // VCOM Control
        writedata(0x00);
        writedata(0x12);
        writedata(0x80);

        writecommand(0x36); // Memory Access Control
        writedata(0x48);          // MX, BGR

        writecommand(0x3A); // Pixel Interface Format
    #if defined (TFT_PARALLEL_8_BIT) || defined (TFT_PARALLEL_16_BIT) || defined (RPI_DISPLAY_TYPE)
        writedata(0x55);  // 16-bit colour for parallel
    #else
        writedata(0x65);  // 16-bit colour for SPI
    #endif

        writecommand(0xF0); //Command Set control
        		writedata(0x3C);    //Disable extension command 2 partI

        		writecommand(0xF0); //Command Set control
        		writedata(0x69);    //Disable extension command 2 partII

        writecommand(0x11);  //Exit Sleep
    HAL_Delay(120);

        writecommand(0x29);  //Display on
        HAL_Delay(25);
#endif
}


void ST7796_SetWindow(uint16_t x0, uint16_t y0, uint16_t x1, uint16_t y1)
{
	writecommand(0x2A); // Column addr set
	writedata(x0 >> 8);
	writedata(x0 & 0xFF);     // XSTART
	writedata(x1 >> 8);
	writedata(x1 & 0xFF);     // XEND
	writecommand(0x2B); // Row addr set
	writedata(y0 >> 8);
	writedata(y0 & 0xff);     // YSTART
	writedata(y1 >> 8);
	writedata(y1 & 0xff);     // YEND
	writecommand(0x2C); // write to RAM
	CS_L();
	HAL_GPIO_WritePin(GPIOA,GPIO_PIN_6,GPIO_PIN_SET);
}




static void ConvHL(uint8_t *s, int32_t l)
{
	uint8_t v;
	while (l > 0) {
		v = *(s+1);
		*(s+1) = *s;
		*s = v;
		s += 2;
		l -= 2;
	}
}



void ST7796_DrawBitmap(uint16_t w, uint16_t h, uint8_t *s)
{
	// Enable to access GRAM
	writecommand(0x2C);

	DC_H();
#if 0
	__HAL_SPI_DISABLE(&hspi1);
	hspi1.Instance->CR2 |= SPI_DATASIZE_16BIT; // Set 16 bit mode
	__HAL_SPI_ENABLE(&hspi1);
#endif
	ConvHL(s, (int32_t)w*h*2);
	HAL_SPI_Transmit_DMA(&hspi1, (uint8_t*)s, w * h *2);
#if 0
	__HAL_SPI_DISABLE(&hspi1);
	hspi1.Instance->CR2 &= ~(SPI_DATASIZE_16BIT); // Set 8 bit mode
	__HAL_SPI_ENABLE(&hspi1);
#endif
}


void ST7796_EndOfDrawBitmap(void)
{
#if 0
	__HAL_SPI_DISABLE(&hspi1);
	hspi1.Instance->CR2 &= ~(SPI_DATASIZE_16BIT); // Set 8 bit mode
	__HAL_SPI_ENABLE(&hspi1);
#endif
}

void writecommand(uint8_t data)
{
	DC_L();
	CS_L();
	if (HAL_SPI_Transmit(&hspi1, &data, 1, 1000) != HAL_OK) {
		Error_Handler();
	}
	CS_H();
	DC_H();
}

static void writedata(uint8_t data)
{
	DC_H();
	CS_L();
	if (HAL_SPI_Transmit(&hspi1, &data, 1, 1000) != HAL_OK) {
		Error_Handler();
	}
	CS_H();
	DC_L();
}

static void RESET_L(void)
{
	HAL_GPIO_WritePin(GPIOA, GPIO_PIN_3, GPIO_PIN_RESET);
}

static void RESET_H(void)
{
	HAL_GPIO_WritePin(GPIOA, GPIO_PIN_3, GPIO_PIN_SET);
}

static void CS_L(void)
{
	HAL_GPIO_WritePin(GPIOA, GPIO_PIN_4, GPIO_PIN_RESET);
}
static void CS_H(void)
{
	HAL_GPIO_WritePin(GPIOA, GPIO_PIN_4, GPIO_PIN_SET);
}

static void DC_L(void)
{
	HAL_GPIO_WritePin(GPIOA, GPIO_PIN_6, GPIO_PIN_RESET);
}

static void DC_H(void)
{
	HAL_GPIO_WritePin(GPIOA, GPIO_PIN_6, GPIO_PIN_SET);
}
