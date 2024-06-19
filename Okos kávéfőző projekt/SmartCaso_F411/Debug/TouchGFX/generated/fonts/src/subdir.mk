################################################################################
# Automatically-generated file. Do not edit!
# Toolchain: GNU Tools for STM32 (11.3.rel1)
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../TouchGFX/generated/fonts/src/ApplicationFontProvider.cpp \
../TouchGFX/generated/fonts/src/CachedFont.cpp \
../TouchGFX/generated/fonts/src/FontCache.cpp \
../TouchGFX/generated/fonts/src/Font_verdana_10_4bpp_0.cpp \
../TouchGFX/generated/fonts/src/Font_verdana_18_4bpp_0.cpp \
../TouchGFX/generated/fonts/src/Font_verdanab_16_4bpp_0.cpp \
../TouchGFX/generated/fonts/src/Font_verdanab_23_4bpp_0.cpp \
../TouchGFX/generated/fonts/src/Font_verdanab_27_4bpp_0.cpp \
../TouchGFX/generated/fonts/src/GeneratedFont.cpp \
../TouchGFX/generated/fonts/src/Kerning_verdana_10_4bpp.cpp \
../TouchGFX/generated/fonts/src/Kerning_verdana_18_4bpp.cpp \
../TouchGFX/generated/fonts/src/Kerning_verdanab_16_4bpp.cpp \
../TouchGFX/generated/fonts/src/Kerning_verdanab_23_4bpp.cpp \
../TouchGFX/generated/fonts/src/Kerning_verdanab_27_4bpp.cpp \
../TouchGFX/generated/fonts/src/Table_verdana_10_4bpp.cpp \
../TouchGFX/generated/fonts/src/Table_verdana_18_4bpp.cpp \
../TouchGFX/generated/fonts/src/Table_verdanab_16_4bpp.cpp \
../TouchGFX/generated/fonts/src/Table_verdanab_23_4bpp.cpp \
../TouchGFX/generated/fonts/src/Table_verdanab_27_4bpp.cpp \
../TouchGFX/generated/fonts/src/UnmappedDataFont.cpp \
../TouchGFX/generated/fonts/src/VectorFontRendererBuffers.cpp 

OBJS += \
./TouchGFX/generated/fonts/src/ApplicationFontProvider.o \
./TouchGFX/generated/fonts/src/CachedFont.o \
./TouchGFX/generated/fonts/src/FontCache.o \
./TouchGFX/generated/fonts/src/Font_verdana_10_4bpp_0.o \
./TouchGFX/generated/fonts/src/Font_verdana_18_4bpp_0.o \
./TouchGFX/generated/fonts/src/Font_verdanab_16_4bpp_0.o \
./TouchGFX/generated/fonts/src/Font_verdanab_23_4bpp_0.o \
./TouchGFX/generated/fonts/src/Font_verdanab_27_4bpp_0.o \
./TouchGFX/generated/fonts/src/GeneratedFont.o \
./TouchGFX/generated/fonts/src/Kerning_verdana_10_4bpp.o \
./TouchGFX/generated/fonts/src/Kerning_verdana_18_4bpp.o \
./TouchGFX/generated/fonts/src/Kerning_verdanab_16_4bpp.o \
./TouchGFX/generated/fonts/src/Kerning_verdanab_23_4bpp.o \
./TouchGFX/generated/fonts/src/Kerning_verdanab_27_4bpp.o \
./TouchGFX/generated/fonts/src/Table_verdana_10_4bpp.o \
./TouchGFX/generated/fonts/src/Table_verdana_18_4bpp.o \
./TouchGFX/generated/fonts/src/Table_verdanab_16_4bpp.o \
./TouchGFX/generated/fonts/src/Table_verdanab_23_4bpp.o \
./TouchGFX/generated/fonts/src/Table_verdanab_27_4bpp.o \
./TouchGFX/generated/fonts/src/UnmappedDataFont.o \
./TouchGFX/generated/fonts/src/VectorFontRendererBuffers.o 

CPP_DEPS += \
./TouchGFX/generated/fonts/src/ApplicationFontProvider.d \
./TouchGFX/generated/fonts/src/CachedFont.d \
./TouchGFX/generated/fonts/src/FontCache.d \
./TouchGFX/generated/fonts/src/Font_verdana_10_4bpp_0.d \
./TouchGFX/generated/fonts/src/Font_verdana_18_4bpp_0.d \
./TouchGFX/generated/fonts/src/Font_verdanab_16_4bpp_0.d \
./TouchGFX/generated/fonts/src/Font_verdanab_23_4bpp_0.d \
./TouchGFX/generated/fonts/src/Font_verdanab_27_4bpp_0.d \
./TouchGFX/generated/fonts/src/GeneratedFont.d \
./TouchGFX/generated/fonts/src/Kerning_verdana_10_4bpp.d \
./TouchGFX/generated/fonts/src/Kerning_verdana_18_4bpp.d \
./TouchGFX/generated/fonts/src/Kerning_verdanab_16_4bpp.d \
./TouchGFX/generated/fonts/src/Kerning_verdanab_23_4bpp.d \
./TouchGFX/generated/fonts/src/Kerning_verdanab_27_4bpp.d \
./TouchGFX/generated/fonts/src/Table_verdana_10_4bpp.d \
./TouchGFX/generated/fonts/src/Table_verdana_18_4bpp.d \
./TouchGFX/generated/fonts/src/Table_verdanab_16_4bpp.d \
./TouchGFX/generated/fonts/src/Table_verdanab_23_4bpp.d \
./TouchGFX/generated/fonts/src/Table_verdanab_27_4bpp.d \
./TouchGFX/generated/fonts/src/UnmappedDataFont.d \
./TouchGFX/generated/fonts/src/VectorFontRendererBuffers.d 


# Each subdirectory must supply rules for building sources it contributes
TouchGFX/generated/fonts/src/%.o TouchGFX/generated/fonts/src/%.su TouchGFX/generated/fonts/src/%.cyclo: ../TouchGFX/generated/fonts/src/%.cpp TouchGFX/generated/fonts/src/subdir.mk
	arm-none-eabi-g++ "$<" -mcpu=cortex-m4 -std=gnu++14 -g3 -DDEBUG -DUSE_HAL_DRIVER -DSTM32F411xE -c -I../Core/Inc -I../Drivers/STM32F4xx_HAL_Driver/Inc -I../Drivers/STM32F4xx_HAL_Driver/Inc/Legacy -I../Drivers/CMSIS/Device/ST/STM32F4xx/Include -I../Drivers/CMSIS/Include -I../TouchGFX/App -I../TouchGFX/target/generated -I../TouchGFX/target -I../USB_DEVICE/App -I../USB_DEVICE/Target -I../Middlewares/ST/STM32_USB_Device_Library/Core/Inc -I../Middlewares/ST/STM32_USB_Device_Library/Class/CDC/Inc -I../Middlewares/ST/touchgfx/framework/include -I../TouchGFX/generated/fonts/include -I../TouchGFX/generated/gui_generated/include -I../TouchGFX/generated/images/include -I../TouchGFX/generated/texts/include -I../TouchGFX/generated/videos/include -I../TouchGFX/gui/include -I"C:/Users/peter/STM32CubeIDE/workspace_1.14.1/SmarCaso2.0/SmartCaso_F411/Drivers/ST7796" -I"C:/Users/peter/STM32CubeIDE/workspace_1.14.1/SmarCaso2.0/SmartCaso_F411/Drivers/XPT2046" -O0 -ffunction-sections -fdata-sections -fno-exceptions -fno-rtti -fno-use-cxa-atexit -Wall -femit-class-debug-always -fstack-usage -fcyclomatic-complexity -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" --specs=nano.specs -mfpu=fpv4-sp-d16 -mfloat-abi=hard -mthumb -o "$@"

clean: clean-TouchGFX-2f-generated-2f-fonts-2f-src

clean-TouchGFX-2f-generated-2f-fonts-2f-src:
	-$(RM) ./TouchGFX/generated/fonts/src/ApplicationFontProvider.cyclo ./TouchGFX/generated/fonts/src/ApplicationFontProvider.d ./TouchGFX/generated/fonts/src/ApplicationFontProvider.o ./TouchGFX/generated/fonts/src/ApplicationFontProvider.su ./TouchGFX/generated/fonts/src/CachedFont.cyclo ./TouchGFX/generated/fonts/src/CachedFont.d ./TouchGFX/generated/fonts/src/CachedFont.o ./TouchGFX/generated/fonts/src/CachedFont.su ./TouchGFX/generated/fonts/src/FontCache.cyclo ./TouchGFX/generated/fonts/src/FontCache.d ./TouchGFX/generated/fonts/src/FontCache.o ./TouchGFX/generated/fonts/src/FontCache.su ./TouchGFX/generated/fonts/src/Font_verdana_10_4bpp_0.cyclo ./TouchGFX/generated/fonts/src/Font_verdana_10_4bpp_0.d ./TouchGFX/generated/fonts/src/Font_verdana_10_4bpp_0.o ./TouchGFX/generated/fonts/src/Font_verdana_10_4bpp_0.su ./TouchGFX/generated/fonts/src/Font_verdana_18_4bpp_0.cyclo ./TouchGFX/generated/fonts/src/Font_verdana_18_4bpp_0.d ./TouchGFX/generated/fonts/src/Font_verdana_18_4bpp_0.o ./TouchGFX/generated/fonts/src/Font_verdana_18_4bpp_0.su ./TouchGFX/generated/fonts/src/Font_verdanab_16_4bpp_0.cyclo ./TouchGFX/generated/fonts/src/Font_verdanab_16_4bpp_0.d ./TouchGFX/generated/fonts/src/Font_verdanab_16_4bpp_0.o ./TouchGFX/generated/fonts/src/Font_verdanab_16_4bpp_0.su ./TouchGFX/generated/fonts/src/Font_verdanab_23_4bpp_0.cyclo ./TouchGFX/generated/fonts/src/Font_verdanab_23_4bpp_0.d ./TouchGFX/generated/fonts/src/Font_verdanab_23_4bpp_0.o ./TouchGFX/generated/fonts/src/Font_verdanab_23_4bpp_0.su ./TouchGFX/generated/fonts/src/Font_verdanab_27_4bpp_0.cyclo ./TouchGFX/generated/fonts/src/Font_verdanab_27_4bpp_0.d ./TouchGFX/generated/fonts/src/Font_verdanab_27_4bpp_0.o ./TouchGFX/generated/fonts/src/Font_verdanab_27_4bpp_0.su ./TouchGFX/generated/fonts/src/GeneratedFont.cyclo ./TouchGFX/generated/fonts/src/GeneratedFont.d ./TouchGFX/generated/fonts/src/GeneratedFont.o ./TouchGFX/generated/fonts/src/GeneratedFont.su ./TouchGFX/generated/fonts/src/Kerning_verdana_10_4bpp.cyclo ./TouchGFX/generated/fonts/src/Kerning_verdana_10_4bpp.d ./TouchGFX/generated/fonts/src/Kerning_verdana_10_4bpp.o ./TouchGFX/generated/fonts/src/Kerning_verdana_10_4bpp.su ./TouchGFX/generated/fonts/src/Kerning_verdana_18_4bpp.cyclo ./TouchGFX/generated/fonts/src/Kerning_verdana_18_4bpp.d ./TouchGFX/generated/fonts/src/Kerning_verdana_18_4bpp.o ./TouchGFX/generated/fonts/src/Kerning_verdana_18_4bpp.su ./TouchGFX/generated/fonts/src/Kerning_verdanab_16_4bpp.cyclo ./TouchGFX/generated/fonts/src/Kerning_verdanab_16_4bpp.d ./TouchGFX/generated/fonts/src/Kerning_verdanab_16_4bpp.o ./TouchGFX/generated/fonts/src/Kerning_verdanab_16_4bpp.su ./TouchGFX/generated/fonts/src/Kerning_verdanab_23_4bpp.cyclo ./TouchGFX/generated/fonts/src/Kerning_verdanab_23_4bpp.d ./TouchGFX/generated/fonts/src/Kerning_verdanab_23_4bpp.o ./TouchGFX/generated/fonts/src/Kerning_verdanab_23_4bpp.su ./TouchGFX/generated/fonts/src/Kerning_verdanab_27_4bpp.cyclo ./TouchGFX/generated/fonts/src/Kerning_verdanab_27_4bpp.d ./TouchGFX/generated/fonts/src/Kerning_verdanab_27_4bpp.o ./TouchGFX/generated/fonts/src/Kerning_verdanab_27_4bpp.su ./TouchGFX/generated/fonts/src/Table_verdana_10_4bpp.cyclo ./TouchGFX/generated/fonts/src/Table_verdana_10_4bpp.d ./TouchGFX/generated/fonts/src/Table_verdana_10_4bpp.o ./TouchGFX/generated/fonts/src/Table_verdana_10_4bpp.su ./TouchGFX/generated/fonts/src/Table_verdana_18_4bpp.cyclo ./TouchGFX/generated/fonts/src/Table_verdana_18_4bpp.d ./TouchGFX/generated/fonts/src/Table_verdana_18_4bpp.o ./TouchGFX/generated/fonts/src/Table_verdana_18_4bpp.su ./TouchGFX/generated/fonts/src/Table_verdanab_16_4bpp.cyclo ./TouchGFX/generated/fonts/src/Table_verdanab_16_4bpp.d ./TouchGFX/generated/fonts/src/Table_verdanab_16_4bpp.o ./TouchGFX/generated/fonts/src/Table_verdanab_16_4bpp.su ./TouchGFX/generated/fonts/src/Table_verdanab_23_4bpp.cyclo ./TouchGFX/generated/fonts/src/Table_verdanab_23_4bpp.d ./TouchGFX/generated/fonts/src/Table_verdanab_23_4bpp.o ./TouchGFX/generated/fonts/src/Table_verdanab_23_4bpp.su ./TouchGFX/generated/fonts/src/Table_verdanab_27_4bpp.cyclo ./TouchGFX/generated/fonts/src/Table_verdanab_27_4bpp.d ./TouchGFX/generated/fonts/src/Table_verdanab_27_4bpp.o ./TouchGFX/generated/fonts/src/Table_verdanab_27_4bpp.su ./TouchGFX/generated/fonts/src/UnmappedDataFont.cyclo ./TouchGFX/generated/fonts/src/UnmappedDataFont.d ./TouchGFX/generated/fonts/src/UnmappedDataFont.o ./TouchGFX/generated/fonts/src/UnmappedDataFont.su ./TouchGFX/generated/fonts/src/VectorFontRendererBuffers.cyclo ./TouchGFX/generated/fonts/src/VectorFontRendererBuffers.d ./TouchGFX/generated/fonts/src/VectorFontRendererBuffers.o ./TouchGFX/generated/fonts/src/VectorFontRendererBuffers.su

.PHONY: clean-TouchGFX-2f-generated-2f-fonts-2f-src

