#include <gui/containers/CustomContainer1.hpp>

#include <gui_generated/screen1_screen/Screen1ViewBase.hpp>
#include <touchgfx/canvas_widget_renderer/CanvasWidgetRenderer.hpp>
#include <touchgfx/Color.hpp>
#include <images/BitmapDatabase.hpp>
#include <texts/TextKeysAndLanguages.hpp>

CustomContainer1::CustomContainer1()
{

}

void CustomContainer1::initialize()
{
	Unicode::snprintf(textArea1Buffer, TEXTAREA1_SIZE, "%u",temp);
    CustomContainer1Base::initialize();
}

void CustomContainer1::Down_clicked(){

	temp--;
	Unicode::snprintf(textArea1Buffer, TEXTAREA1_SIZE, "%u",temp);
	textArea1.invalidate();
}


void CustomContainer1::Up_clicked(){

	temp++;
	Unicode::snprintf(textArea1Buffer, TEXTAREA1_SIZE, "%u",temp);
	textArea1.invalidate();
}

