################################################################################
# Automatically-generated file. Do not edit!
# Toolchain: GNU Tools for STM32 (11.3.rel1)
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../TouchGFX/generated/images/src/__generated/image_alternate_theme_images_widgets_circleprogress_backgrounds_small.cpp \
../TouchGFX/generated/images/src/__generated/image_alternate_theme_images_widgets_lineprogress_backgrounds_image_plain_normal_tiny_90.cpp \
../TouchGFX/generated/images/src/__generated/image_icon_theme_images_hardware_keyboard_arrow_down_35_35_000000.svg.cpp \
../TouchGFX/generated/images/src/__generated/image_icon_theme_images_hardware_keyboard_arrow_down_35_35_FF0000.svg.cpp \
../TouchGFX/generated/images/src/__generated/image_icon_theme_images_hardware_keyboard_arrow_up_35_35_000000.svg.cpp \
../TouchGFX/generated/images/src/__generated/image_icon_theme_images_hardware_keyboard_arrow_up_35_35_FF0000.svg.cpp 

OBJS += \
./TouchGFX/generated/images/src/__generated/image_alternate_theme_images_widgets_circleprogress_backgrounds_small.o \
./TouchGFX/generated/images/src/__generated/image_alternate_theme_images_widgets_lineprogress_backgrounds_image_plain_normal_tiny_90.o \
./TouchGFX/generated/images/src/__generated/image_icon_theme_images_hardware_keyboard_arrow_down_35_35_000000.svg.o \
./TouchGFX/generated/images/src/__generated/image_icon_theme_images_hardware_keyboard_arrow_down_35_35_FF0000.svg.o \
./TouchGFX/generated/images/src/__generated/image_icon_theme_images_hardware_keyboard_arrow_up_35_35_000000.svg.o \
./TouchGFX/generated/images/src/__generated/image_icon_theme_images_hardware_keyboard_arrow_up_35_35_FF0000.svg.o 

CPP_DEPS += \
./TouchGFX/generated/images/src/__generated/image_alternate_theme_images_widgets_circleprogress_backgrounds_small.d \
./TouchGFX/generated/images/src/__generated/image_alternate_theme_images_widgets_lineprogress_backgrounds_image_plain_normal_tiny_90.d \
./TouchGFX/generated/images/src/__generated/image_icon_theme_images_hardware_keyboard_arrow_down_35_35_000000.svg.d \
./TouchGFX/generated/images/src/__generated/image_icon_theme_images_hardware_keyboard_arrow_down_35_35_FF0000.svg.d \
./TouchGFX/generated/images/src/__generated/image_icon_theme_images_hardware_keyboard_arrow_up_35_35_000000.svg.d \
./TouchGFX/generated/images/src/__generated/image_icon_theme_images_hardware_keyboard_arrow_up_35_35_FF0000.svg.d 


# Each subdirectory must supply rules for building sources it contributes
TouchGFX/generated/images/src/__generated/%.o TouchGFX/generated/images/src/__generated/%.su TouchGFX/generated/images/src/__generated/%.cyclo: ../TouchGFX/generated/images/src/__generated/%.cpp TouchGFX/generated/images/src/__generated/subdir.mk
	arm-none-eabi-g++ "$<" -mcpu=cortex-m4 -std=gnu++14 -g3 -DDEBUG -DUSE_HAL_DRIVER -DSTM32F411xE -c -I../Core/Inc -I../Drivers/STM32F4xx_HAL_Driver/Inc -I../Drivers/STM32F4xx_HAL_Driver/Inc/Legacy -I../Drivers/CMSIS/Device/ST/STM32F4xx/Include -I../Drivers/CMSIS/Include -I../TouchGFX/App -I../TouchGFX/target/generated -I../TouchGFX/target -I../USB_DEVICE/App -I../USB_DEVICE/Target -I../Middlewares/ST/STM32_USB_Device_Library/Core/Inc -I../Middlewares/ST/STM32_USB_Device_Library/Class/CDC/Inc -I../Middlewares/ST/touchgfx/framework/include -I../TouchGFX/generated/fonts/include -I../TouchGFX/generated/gui_generated/include -I../TouchGFX/generated/images/include -I../TouchGFX/generated/texts/include -I../TouchGFX/generated/videos/include -I../TouchGFX/gui/include -I"C:/Users/peter/STM32CubeIDE/workspace_1.14.1/SmarCaso2.0/SmartCaso_F411/Drivers/ST7796" -I"C:/Users/peter/STM32CubeIDE/workspace_1.14.1/SmarCaso2.0/SmartCaso_F411/Drivers/XPT2046" -O0 -ffunction-sections -fdata-sections -fno-exceptions -fno-rtti -fno-use-cxa-atexit -Wall -femit-class-debug-always -fstack-usage -fcyclomatic-complexity -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" --specs=nano.specs -mfpu=fpv4-sp-d16 -mfloat-abi=hard -mthumb -o "$@"

clean: clean-TouchGFX-2f-generated-2f-images-2f-src-2f-__generated

clean-TouchGFX-2f-generated-2f-images-2f-src-2f-__generated:
	-$(RM) ./TouchGFX/generated/images/src/__generated/image_alternate_theme_images_widgets_circleprogress_backgrounds_small.cyclo ./TouchGFX/generated/images/src/__generated/image_alternate_theme_images_widgets_circleprogress_backgrounds_small.d ./TouchGFX/generated/images/src/__generated/image_alternate_theme_images_widgets_circleprogress_backgrounds_small.o ./TouchGFX/generated/images/src/__generated/image_alternate_theme_images_widgets_circleprogress_backgrounds_small.su ./TouchGFX/generated/images/src/__generated/image_alternate_theme_images_widgets_lineprogress_backgrounds_image_plain_normal_tiny_90.cyclo ./TouchGFX/generated/images/src/__generated/image_alternate_theme_images_widgets_lineprogress_backgrounds_image_plain_normal_tiny_90.d ./TouchGFX/generated/images/src/__generated/image_alternate_theme_images_widgets_lineprogress_backgrounds_image_plain_normal_tiny_90.o ./TouchGFX/generated/images/src/__generated/image_alternate_theme_images_widgets_lineprogress_backgrounds_image_plain_normal_tiny_90.su ./TouchGFX/generated/images/src/__generated/image_icon_theme_images_hardware_keyboard_arrow_down_35_35_000000.svg.cyclo ./TouchGFX/generated/images/src/__generated/image_icon_theme_images_hardware_keyboard_arrow_down_35_35_000000.svg.d ./TouchGFX/generated/images/src/__generated/image_icon_theme_images_hardware_keyboard_arrow_down_35_35_000000.svg.o ./TouchGFX/generated/images/src/__generated/image_icon_theme_images_hardware_keyboard_arrow_down_35_35_000000.svg.su ./TouchGFX/generated/images/src/__generated/image_icon_theme_images_hardware_keyboard_arrow_down_35_35_FF0000.svg.cyclo ./TouchGFX/generated/images/src/__generated/image_icon_theme_images_hardware_keyboard_arrow_down_35_35_FF0000.svg.d ./TouchGFX/generated/images/src/__generated/image_icon_theme_images_hardware_keyboard_arrow_down_35_35_FF0000.svg.o ./TouchGFX/generated/images/src/__generated/image_icon_theme_images_hardware_keyboard_arrow_down_35_35_FF0000.svg.su ./TouchGFX/generated/images/src/__generated/image_icon_theme_images_hardware_keyboard_arrow_up_35_35_000000.svg.cyclo ./TouchGFX/generated/images/src/__generated/image_icon_theme_images_hardware_keyboard_arrow_up_35_35_000000.svg.d ./TouchGFX/generated/images/src/__generated/image_icon_theme_images_hardware_keyboard_arrow_up_35_35_000000.svg.o ./TouchGFX/generated/images/src/__generated/image_icon_theme_images_hardware_keyboard_arrow_up_35_35_000000.svg.su ./TouchGFX/generated/images/src/__generated/image_icon_theme_images_hardware_keyboard_arrow_up_35_35_FF0000.svg.cyclo ./TouchGFX/generated/images/src/__generated/image_icon_theme_images_hardware_keyboard_arrow_up_35_35_FF0000.svg.d ./TouchGFX/generated/images/src/__generated/image_icon_theme_images_hardware_keyboard_arrow_up_35_35_FF0000.svg.o ./TouchGFX/generated/images/src/__generated/image_icon_theme_images_hardware_keyboard_arrow_up_35_35_FF0000.svg.su

.PHONY: clean-TouchGFX-2f-generated-2f-images-2f-src-2f-__generated

