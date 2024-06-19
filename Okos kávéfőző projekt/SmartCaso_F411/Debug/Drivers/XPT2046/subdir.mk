################################################################################
# Automatically-generated file. Do not edit!
# Toolchain: GNU Tools for STM32 (11.3.rel1)
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
C_SRCS += \
../Drivers/XPT2046/xpt2046.c 

C_DEPS += \
./Drivers/XPT2046/xpt2046.d 

OBJS += \
./Drivers/XPT2046/xpt2046.o 


# Each subdirectory must supply rules for building sources it contributes
Drivers/XPT2046/%.o Drivers/XPT2046/%.su Drivers/XPT2046/%.cyclo: ../Drivers/XPT2046/%.c Drivers/XPT2046/subdir.mk
	arm-none-eabi-gcc "$<" -mcpu=cortex-m4 -std=gnu11 -g3 -DDEBUG -DUSE_HAL_DRIVER -DSTM32F411xE -c -I../Core/Inc -I../Drivers/STM32F4xx_HAL_Driver/Inc -I../Drivers/STM32F4xx_HAL_Driver/Inc/Legacy -I../Drivers/CMSIS/Device/ST/STM32F4xx/Include -I../Drivers/CMSIS/Include -I../TouchGFX/App -I../TouchGFX/target/generated -I../TouchGFX/target -I../USB_DEVICE/App -I../USB_DEVICE/Target -I../Middlewares/ST/STM32_USB_Device_Library/Core/Inc -I../Middlewares/ST/STM32_USB_Device_Library/Class/CDC/Inc -I../Middlewares/ST/touchgfx/framework/include -I../TouchGFX/generated/fonts/include -I../TouchGFX/generated/gui_generated/include -I../TouchGFX/generated/images/include -I../TouchGFX/generated/texts/include -I../TouchGFX/generated/videos/include -I../TouchGFX/gui/include -I"C:/Users/peter/STM32CubeIDE/workspace_1.14.1/SmarCaso2.0/SmartCaso_F411/Drivers/MAX6675" -I"C:/Users/peter/STM32CubeIDE/workspace_1.14.1/SmarCaso2.0/SmartCaso_F411/Drivers/ST7796" -I"C:/Users/peter/STM32CubeIDE/workspace_1.14.1/SmarCaso2.0/SmartCaso_F411/Drivers/XPT2046" -I"C:/Users/peter/STM32CubeIDE/workspace_1.14.1/SmarCaso2.0/SmartCaso_F411/Drivers/HX711" -O0 -ffunction-sections -fdata-sections -Wall -fstack-usage -fcyclomatic-complexity -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" --specs=nano.specs -mfpu=fpv4-sp-d16 -mfloat-abi=hard -mthumb -o "$@"

clean: clean-Drivers-2f-XPT2046

clean-Drivers-2f-XPT2046:
	-$(RM) ./Drivers/XPT2046/xpt2046.cyclo ./Drivers/XPT2046/xpt2046.d ./Drivers/XPT2046/xpt2046.o ./Drivers/XPT2046/xpt2046.su

.PHONY: clean-Drivers-2f-XPT2046

