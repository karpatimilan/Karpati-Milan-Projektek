#include <gui/screen1_screen/Screen1View.hpp>
#include <gui/containers/CustomContainer1.hpp>




extern float temperature;
extern long weight;

Screen1View::Screen1View()
{

}

void Screen1View::setupScreen()
{
	Unicode::snprintfFloat(flexButton1Buffer,FLEXBUTTON1_SIZE, "%.0f",temperature);

    Screen1ViewBase::setupScreen();
}

void Screen1View::tearDownScreen()
{
    Screen1ViewBase::tearDownScreen();
}
void Screen1View::Update_temperature(){

	Unicode::snprintfFloat(flexButton1Buffer,FLEXBUTTON1_SIZE, "%.0f",temperature);
	Unicode::snprintf(textArea2Buffer,TEXTAREA2_SIZE, "%d",weight);
	lineProgress1.setValue(weight);
	lineProgress1.invalidate();
	flexButton1.invalidate();
	textArea2.invalidate();
}
