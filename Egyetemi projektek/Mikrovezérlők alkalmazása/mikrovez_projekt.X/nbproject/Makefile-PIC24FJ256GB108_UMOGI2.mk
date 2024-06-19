#
# Generated Makefile - do not edit!
#
# Edit the Makefile in the project folder instead (../Makefile). Each target
# has a -pre and a -post target defined where you can add customized code.
#
# This makefile implements configuration specific macros and targets.


# Include project Makefile
ifeq "${IGNORE_LOCAL}" "TRUE"
# do not include local makefile. User is passing all local related variables already
else
include Makefile
# Include makefile containing local settings
ifeq "$(wildcard nbproject/Makefile-local-PIC24FJ256GB108_UMOGI2.mk)" "nbproject/Makefile-local-PIC24FJ256GB108_UMOGI2.mk"
include nbproject/Makefile-local-PIC24FJ256GB108_UMOGI2.mk
endif
endif

# Environment
MKDIR=gnumkdir -p
RM=rm -f 
MV=mv 
CP=cp 

# Macros
CND_CONF=PIC24FJ256GB108_UMOGI2
ifeq ($(TYPE_IMAGE), DEBUG_RUN)
IMAGE_TYPE=debug
OUTPUT_SUFFIX=elf
DEBUGGABLE_SUFFIX=elf
FINAL_IMAGE=${DISTDIR}/mikrovez_projekt.X.${IMAGE_TYPE}.${OUTPUT_SUFFIX}
else
IMAGE_TYPE=production
OUTPUT_SUFFIX=hex
DEBUGGABLE_SUFFIX=elf
FINAL_IMAGE=${DISTDIR}/mikrovez_projekt.X.${IMAGE_TYPE}.${OUTPUT_SUFFIX}
endif

ifeq ($(COMPARE_BUILD), true)
COMPARISON_BUILD=-mafrlcsj
else
COMPARISON_BUILD=
endif

# Object Directory
OBJECTDIR=build/${CND_CONF}/${IMAGE_TYPE}

# Distribution Directory
DISTDIR=dist/${CND_CONF}/${IMAGE_TYPE}

# Source Files Quoted if spaced
SOURCEFILES_QUOTED_IF_SPACED=usb/src/usb_device.c usb/src/usb_device_cdc.c usb/src/usb_hal_16bit.c usb_descriptors.c usb_events.c system.c LCD.c timer1637.c main.c timermain.c

# Object Files Quoted if spaced
OBJECTFILES_QUOTED_IF_SPACED=${OBJECTDIR}/usb/src/usb_device.o ${OBJECTDIR}/usb/src/usb_device_cdc.o ${OBJECTDIR}/usb/src/usb_hal_16bit.o ${OBJECTDIR}/usb_descriptors.o ${OBJECTDIR}/usb_events.o ${OBJECTDIR}/system.o ${OBJECTDIR}/LCD.o ${OBJECTDIR}/timer1637.o ${OBJECTDIR}/main.o ${OBJECTDIR}/timermain.o
POSSIBLE_DEPFILES=${OBJECTDIR}/usb/src/usb_device.o.d ${OBJECTDIR}/usb/src/usb_device_cdc.o.d ${OBJECTDIR}/usb/src/usb_hal_16bit.o.d ${OBJECTDIR}/usb_descriptors.o.d ${OBJECTDIR}/usb_events.o.d ${OBJECTDIR}/system.o.d ${OBJECTDIR}/LCD.o.d ${OBJECTDIR}/timer1637.o.d ${OBJECTDIR}/main.o.d ${OBJECTDIR}/timermain.o.d

# Object Files
OBJECTFILES=${OBJECTDIR}/usb/src/usb_device.o ${OBJECTDIR}/usb/src/usb_device_cdc.o ${OBJECTDIR}/usb/src/usb_hal_16bit.o ${OBJECTDIR}/usb_descriptors.o ${OBJECTDIR}/usb_events.o ${OBJECTDIR}/system.o ${OBJECTDIR}/LCD.o ${OBJECTDIR}/timer1637.o ${OBJECTDIR}/main.o ${OBJECTDIR}/timermain.o

# Source Files
SOURCEFILES=usb/src/usb_device.c usb/src/usb_device_cdc.c usb/src/usb_hal_16bit.c usb_descriptors.c usb_events.c system.c LCD.c timer1637.c main.c timermain.c



CFLAGS=
ASFLAGS=
LDLIBSOPTIONS=

############# Tool locations ##########################################
# If you copy a project from one host to another, the path where the  #
# compiler is installed may be different.                             #
# If you open this project with MPLAB X in the new host, this         #
# makefile will be regenerated and the paths will be corrected.       #
#######################################################################
# fixDeps replaces a bunch of sed/cat/printf statements that slow down the build
FIXDEPS=fixDeps

.build-conf:  ${BUILD_SUBPROJECTS}
ifneq ($(INFORMATION_MESSAGE), )
	@echo $(INFORMATION_MESSAGE)
endif
	${MAKE}  -f nbproject/Makefile-PIC24FJ256GB108_UMOGI2.mk ${DISTDIR}/mikrovez_projekt.X.${IMAGE_TYPE}.${OUTPUT_SUFFIX}

MP_PROCESSOR_OPTION=24FJ256GB108
MP_LINKER_FILE_OPTION=,--script=p24FJ256GB108.gld
# ------------------------------------------------------------------------------------
# Rules for buildStep: compile
ifeq ($(TYPE_IMAGE), DEBUG_RUN)
${OBJECTDIR}/usb/src/usb_device.o: usb/src/usb_device.c  .generated_files/flags/PIC24FJ256GB108_UMOGI2/69ec594f908d0e77f9ccfde6fe7fb4a25c1bc98c .generated_files/flags/PIC24FJ256GB108_UMOGI2/da39a3ee5e6b4b0d3255bfef95601890afd80709
	@${MKDIR} "${OBJECTDIR}/usb/src" 
	@${RM} ${OBJECTDIR}/usb/src/usb_device.o.d 
	@${RM} ${OBJECTDIR}/usb/src/usb_device.o 
	${MP_CC} $(MP_EXTRA_CC_PRE)  usb/src/usb_device.c  -o ${OBJECTDIR}/usb/src/usb_device.o  -c -mcpu=$(MP_PROCESSOR_OPTION)  -MP -MMD -MF "${OBJECTDIR}/usb/src/usb_device.o.d"      -g -D__DEBUG     -omf=elf -DXPRJ_PIC24FJ256GB108_UMOGI2=$(CND_CONF)    $(COMPARISON_BUILD)  -fno-short-double -O0 -falign-arrays -I"../demo_src" -I"usb/inc" -I"../../../../../../bsp/exp16/pic24fj256gb110_pim" -I"." -msmart-io=1 -msfr-warn=off    -mdfp="${DFP_DIR}/xc16"
	
${OBJECTDIR}/usb/src/usb_device_cdc.o: usb/src/usb_device_cdc.c  .generated_files/flags/PIC24FJ256GB108_UMOGI2/533982a4bb9ed4c17f5f79208ed0ab2303b95058 .generated_files/flags/PIC24FJ256GB108_UMOGI2/da39a3ee5e6b4b0d3255bfef95601890afd80709
	@${MKDIR} "${OBJECTDIR}/usb/src" 
	@${RM} ${OBJECTDIR}/usb/src/usb_device_cdc.o.d 
	@${RM} ${OBJECTDIR}/usb/src/usb_device_cdc.o 
	${MP_CC} $(MP_EXTRA_CC_PRE)  usb/src/usb_device_cdc.c  -o ${OBJECTDIR}/usb/src/usb_device_cdc.o  -c -mcpu=$(MP_PROCESSOR_OPTION)  -MP -MMD -MF "${OBJECTDIR}/usb/src/usb_device_cdc.o.d"      -g -D__DEBUG     -omf=elf -DXPRJ_PIC24FJ256GB108_UMOGI2=$(CND_CONF)    $(COMPARISON_BUILD)  -fno-short-double -O0 -falign-arrays -I"../demo_src" -I"usb/inc" -I"../../../../../../bsp/exp16/pic24fj256gb110_pim" -I"." -msmart-io=1 -msfr-warn=off    -mdfp="${DFP_DIR}/xc16"
	
${OBJECTDIR}/usb/src/usb_hal_16bit.o: usb/src/usb_hal_16bit.c  .generated_files/flags/PIC24FJ256GB108_UMOGI2/37df65e0ea23f831d320f2016869a9e4bae23a1d .generated_files/flags/PIC24FJ256GB108_UMOGI2/da39a3ee5e6b4b0d3255bfef95601890afd80709
	@${MKDIR} "${OBJECTDIR}/usb/src" 
	@${RM} ${OBJECTDIR}/usb/src/usb_hal_16bit.o.d 
	@${RM} ${OBJECTDIR}/usb/src/usb_hal_16bit.o 
	${MP_CC} $(MP_EXTRA_CC_PRE)  usb/src/usb_hal_16bit.c  -o ${OBJECTDIR}/usb/src/usb_hal_16bit.o  -c -mcpu=$(MP_PROCESSOR_OPTION)  -MP -MMD -MF "${OBJECTDIR}/usb/src/usb_hal_16bit.o.d"      -g -D__DEBUG     -omf=elf -DXPRJ_PIC24FJ256GB108_UMOGI2=$(CND_CONF)    $(COMPARISON_BUILD)  -fno-short-double -O0 -falign-arrays -I"../demo_src" -I"usb/inc" -I"../../../../../../bsp/exp16/pic24fj256gb110_pim" -I"." -msmart-io=1 -msfr-warn=off    -mdfp="${DFP_DIR}/xc16"
	
${OBJECTDIR}/usb_descriptors.o: usb_descriptors.c  .generated_files/flags/PIC24FJ256GB108_UMOGI2/407095efb358360c1426aa42f39c2da1937fd735 .generated_files/flags/PIC24FJ256GB108_UMOGI2/da39a3ee5e6b4b0d3255bfef95601890afd80709
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} ${OBJECTDIR}/usb_descriptors.o.d 
	@${RM} ${OBJECTDIR}/usb_descriptors.o 
	${MP_CC} $(MP_EXTRA_CC_PRE)  usb_descriptors.c  -o ${OBJECTDIR}/usb_descriptors.o  -c -mcpu=$(MP_PROCESSOR_OPTION)  -MP -MMD -MF "${OBJECTDIR}/usb_descriptors.o.d"      -g -D__DEBUG     -omf=elf -DXPRJ_PIC24FJ256GB108_UMOGI2=$(CND_CONF)    $(COMPARISON_BUILD)  -fno-short-double -O0 -falign-arrays -I"../demo_src" -I"usb/inc" -I"../../../../../../bsp/exp16/pic24fj256gb110_pim" -I"." -msmart-io=1 -msfr-warn=off    -mdfp="${DFP_DIR}/xc16"
	
${OBJECTDIR}/usb_events.o: usb_events.c  .generated_files/flags/PIC24FJ256GB108_UMOGI2/11cc4585938cf01290fb526565ba8d0db5c5a2e9 .generated_files/flags/PIC24FJ256GB108_UMOGI2/da39a3ee5e6b4b0d3255bfef95601890afd80709
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} ${OBJECTDIR}/usb_events.o.d 
	@${RM} ${OBJECTDIR}/usb_events.o 
	${MP_CC} $(MP_EXTRA_CC_PRE)  usb_events.c  -o ${OBJECTDIR}/usb_events.o  -c -mcpu=$(MP_PROCESSOR_OPTION)  -MP -MMD -MF "${OBJECTDIR}/usb_events.o.d"      -g -D__DEBUG     -omf=elf -DXPRJ_PIC24FJ256GB108_UMOGI2=$(CND_CONF)    $(COMPARISON_BUILD)  -fno-short-double -O0 -falign-arrays -I"../demo_src" -I"usb/inc" -I"../../../../../../bsp/exp16/pic24fj256gb110_pim" -I"." -msmart-io=1 -msfr-warn=off    -mdfp="${DFP_DIR}/xc16"
	
${OBJECTDIR}/system.o: system.c  .generated_files/flags/PIC24FJ256GB108_UMOGI2/ae778726d1558677814900f24499836b21365f41 .generated_files/flags/PIC24FJ256GB108_UMOGI2/da39a3ee5e6b4b0d3255bfef95601890afd80709
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} ${OBJECTDIR}/system.o.d 
	@${RM} ${OBJECTDIR}/system.o 
	${MP_CC} $(MP_EXTRA_CC_PRE)  system.c  -o ${OBJECTDIR}/system.o  -c -mcpu=$(MP_PROCESSOR_OPTION)  -MP -MMD -MF "${OBJECTDIR}/system.o.d"      -g -D__DEBUG     -omf=elf -DXPRJ_PIC24FJ256GB108_UMOGI2=$(CND_CONF)    $(COMPARISON_BUILD)  -fno-short-double -O0 -falign-arrays -I"../demo_src" -I"usb/inc" -I"../../../../../../bsp/exp16/pic24fj256gb110_pim" -I"." -msmart-io=1 -msfr-warn=off    -mdfp="${DFP_DIR}/xc16"
	
${OBJECTDIR}/LCD.o: LCD.c  .generated_files/flags/PIC24FJ256GB108_UMOGI2/2110629a605b60de1005d3594ca784665fab4ef7 .generated_files/flags/PIC24FJ256GB108_UMOGI2/da39a3ee5e6b4b0d3255bfef95601890afd80709
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} ${OBJECTDIR}/LCD.o.d 
	@${RM} ${OBJECTDIR}/LCD.o 
	${MP_CC} $(MP_EXTRA_CC_PRE)  LCD.c  -o ${OBJECTDIR}/LCD.o  -c -mcpu=$(MP_PROCESSOR_OPTION)  -MP -MMD -MF "${OBJECTDIR}/LCD.o.d"      -g -D__DEBUG     -omf=elf -DXPRJ_PIC24FJ256GB108_UMOGI2=$(CND_CONF)    $(COMPARISON_BUILD)  -fno-short-double -O0 -falign-arrays -I"../demo_src" -I"usb/inc" -I"../../../../../../bsp/exp16/pic24fj256gb110_pim" -I"." -msmart-io=1 -msfr-warn=off    -mdfp="${DFP_DIR}/xc16"
	
${OBJECTDIR}/timer1637.o: timer1637.c  .generated_files/flags/PIC24FJ256GB108_UMOGI2/1094cce8bd4149ee7fad27acd0487989b6e177eb .generated_files/flags/PIC24FJ256GB108_UMOGI2/da39a3ee5e6b4b0d3255bfef95601890afd80709
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} ${OBJECTDIR}/timer1637.o.d 
	@${RM} ${OBJECTDIR}/timer1637.o 
	${MP_CC} $(MP_EXTRA_CC_PRE)  timer1637.c  -o ${OBJECTDIR}/timer1637.o  -c -mcpu=$(MP_PROCESSOR_OPTION)  -MP -MMD -MF "${OBJECTDIR}/timer1637.o.d"      -g -D__DEBUG     -omf=elf -DXPRJ_PIC24FJ256GB108_UMOGI2=$(CND_CONF)    $(COMPARISON_BUILD)  -fno-short-double -O0 -falign-arrays -I"../demo_src" -I"usb/inc" -I"../../../../../../bsp/exp16/pic24fj256gb110_pim" -I"." -msmart-io=1 -msfr-warn=off    -mdfp="${DFP_DIR}/xc16"
	
${OBJECTDIR}/main.o: main.c  .generated_files/flags/PIC24FJ256GB108_UMOGI2/ed00e9c272064ed473b5e11fbac949db613d8580 .generated_files/flags/PIC24FJ256GB108_UMOGI2/da39a3ee5e6b4b0d3255bfef95601890afd80709
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} ${OBJECTDIR}/main.o.d 
	@${RM} ${OBJECTDIR}/main.o 
	${MP_CC} $(MP_EXTRA_CC_PRE)  main.c  -o ${OBJECTDIR}/main.o  -c -mcpu=$(MP_PROCESSOR_OPTION)  -MP -MMD -MF "${OBJECTDIR}/main.o.d"      -g -D__DEBUG     -omf=elf -DXPRJ_PIC24FJ256GB108_UMOGI2=$(CND_CONF)    $(COMPARISON_BUILD)  -fno-short-double -O0 -falign-arrays -I"../demo_src" -I"usb/inc" -I"../../../../../../bsp/exp16/pic24fj256gb110_pim" -I"." -msmart-io=1 -msfr-warn=off    -mdfp="${DFP_DIR}/xc16"
	
${OBJECTDIR}/timermain.o: timermain.c  .generated_files/flags/PIC24FJ256GB108_UMOGI2/80a7ffd4db5feccdcd375f4947f6f12dbcadf315 .generated_files/flags/PIC24FJ256GB108_UMOGI2/da39a3ee5e6b4b0d3255bfef95601890afd80709
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} ${OBJECTDIR}/timermain.o.d 
	@${RM} ${OBJECTDIR}/timermain.o 
	${MP_CC} $(MP_EXTRA_CC_PRE)  timermain.c  -o ${OBJECTDIR}/timermain.o  -c -mcpu=$(MP_PROCESSOR_OPTION)  -MP -MMD -MF "${OBJECTDIR}/timermain.o.d"      -g -D__DEBUG     -omf=elf -DXPRJ_PIC24FJ256GB108_UMOGI2=$(CND_CONF)    $(COMPARISON_BUILD)  -fno-short-double -O0 -falign-arrays -I"../demo_src" -I"usb/inc" -I"../../../../../../bsp/exp16/pic24fj256gb110_pim" -I"." -msmart-io=1 -msfr-warn=off    -mdfp="${DFP_DIR}/xc16"
	
else
${OBJECTDIR}/usb/src/usb_device.o: usb/src/usb_device.c  .generated_files/flags/PIC24FJ256GB108_UMOGI2/23df213303298ed676def7cc72ef98ad21fa8fcd .generated_files/flags/PIC24FJ256GB108_UMOGI2/da39a3ee5e6b4b0d3255bfef95601890afd80709
	@${MKDIR} "${OBJECTDIR}/usb/src" 
	@${RM} ${OBJECTDIR}/usb/src/usb_device.o.d 
	@${RM} ${OBJECTDIR}/usb/src/usb_device.o 
	${MP_CC} $(MP_EXTRA_CC_PRE)  usb/src/usb_device.c  -o ${OBJECTDIR}/usb/src/usb_device.o  -c -mcpu=$(MP_PROCESSOR_OPTION)  -MP -MMD -MF "${OBJECTDIR}/usb/src/usb_device.o.d"        -omf=elf -DXPRJ_PIC24FJ256GB108_UMOGI2=$(CND_CONF)    $(COMPARISON_BUILD)  -fno-short-double -O0 -falign-arrays -I"../demo_src" -I"usb/inc" -I"../../../../../../bsp/exp16/pic24fj256gb110_pim" -I"." -msmart-io=1 -msfr-warn=off    -mdfp="${DFP_DIR}/xc16"
	
${OBJECTDIR}/usb/src/usb_device_cdc.o: usb/src/usb_device_cdc.c  .generated_files/flags/PIC24FJ256GB108_UMOGI2/584ed95c9003d5c56fe0975bb7c289b932b1d11f .generated_files/flags/PIC24FJ256GB108_UMOGI2/da39a3ee5e6b4b0d3255bfef95601890afd80709
	@${MKDIR} "${OBJECTDIR}/usb/src" 
	@${RM} ${OBJECTDIR}/usb/src/usb_device_cdc.o.d 
	@${RM} ${OBJECTDIR}/usb/src/usb_device_cdc.o 
	${MP_CC} $(MP_EXTRA_CC_PRE)  usb/src/usb_device_cdc.c  -o ${OBJECTDIR}/usb/src/usb_device_cdc.o  -c -mcpu=$(MP_PROCESSOR_OPTION)  -MP -MMD -MF "${OBJECTDIR}/usb/src/usb_device_cdc.o.d"        -omf=elf -DXPRJ_PIC24FJ256GB108_UMOGI2=$(CND_CONF)    $(COMPARISON_BUILD)  -fno-short-double -O0 -falign-arrays -I"../demo_src" -I"usb/inc" -I"../../../../../../bsp/exp16/pic24fj256gb110_pim" -I"." -msmart-io=1 -msfr-warn=off    -mdfp="${DFP_DIR}/xc16"
	
${OBJECTDIR}/usb/src/usb_hal_16bit.o: usb/src/usb_hal_16bit.c  .generated_files/flags/PIC24FJ256GB108_UMOGI2/aa521f69373bbf255d0fccd0bbde072a58085b41 .generated_files/flags/PIC24FJ256GB108_UMOGI2/da39a3ee5e6b4b0d3255bfef95601890afd80709
	@${MKDIR} "${OBJECTDIR}/usb/src" 
	@${RM} ${OBJECTDIR}/usb/src/usb_hal_16bit.o.d 
	@${RM} ${OBJECTDIR}/usb/src/usb_hal_16bit.o 
	${MP_CC} $(MP_EXTRA_CC_PRE)  usb/src/usb_hal_16bit.c  -o ${OBJECTDIR}/usb/src/usb_hal_16bit.o  -c -mcpu=$(MP_PROCESSOR_OPTION)  -MP -MMD -MF "${OBJECTDIR}/usb/src/usb_hal_16bit.o.d"        -omf=elf -DXPRJ_PIC24FJ256GB108_UMOGI2=$(CND_CONF)    $(COMPARISON_BUILD)  -fno-short-double -O0 -falign-arrays -I"../demo_src" -I"usb/inc" -I"../../../../../../bsp/exp16/pic24fj256gb110_pim" -I"." -msmart-io=1 -msfr-warn=off    -mdfp="${DFP_DIR}/xc16"
	
${OBJECTDIR}/usb_descriptors.o: usb_descriptors.c  .generated_files/flags/PIC24FJ256GB108_UMOGI2/eea83de22c525d5ba916304ebad0a2c601fedf6d .generated_files/flags/PIC24FJ256GB108_UMOGI2/da39a3ee5e6b4b0d3255bfef95601890afd80709
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} ${OBJECTDIR}/usb_descriptors.o.d 
	@${RM} ${OBJECTDIR}/usb_descriptors.o 
	${MP_CC} $(MP_EXTRA_CC_PRE)  usb_descriptors.c  -o ${OBJECTDIR}/usb_descriptors.o  -c -mcpu=$(MP_PROCESSOR_OPTION)  -MP -MMD -MF "${OBJECTDIR}/usb_descriptors.o.d"        -omf=elf -DXPRJ_PIC24FJ256GB108_UMOGI2=$(CND_CONF)    $(COMPARISON_BUILD)  -fno-short-double -O0 -falign-arrays -I"../demo_src" -I"usb/inc" -I"../../../../../../bsp/exp16/pic24fj256gb110_pim" -I"." -msmart-io=1 -msfr-warn=off    -mdfp="${DFP_DIR}/xc16"
	
${OBJECTDIR}/usb_events.o: usb_events.c  .generated_files/flags/PIC24FJ256GB108_UMOGI2/f2793aa72b3bd81d6fc773958ab6b0fe41f4136c .generated_files/flags/PIC24FJ256GB108_UMOGI2/da39a3ee5e6b4b0d3255bfef95601890afd80709
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} ${OBJECTDIR}/usb_events.o.d 
	@${RM} ${OBJECTDIR}/usb_events.o 
	${MP_CC} $(MP_EXTRA_CC_PRE)  usb_events.c  -o ${OBJECTDIR}/usb_events.o  -c -mcpu=$(MP_PROCESSOR_OPTION)  -MP -MMD -MF "${OBJECTDIR}/usb_events.o.d"        -omf=elf -DXPRJ_PIC24FJ256GB108_UMOGI2=$(CND_CONF)    $(COMPARISON_BUILD)  -fno-short-double -O0 -falign-arrays -I"../demo_src" -I"usb/inc" -I"../../../../../../bsp/exp16/pic24fj256gb110_pim" -I"." -msmart-io=1 -msfr-warn=off    -mdfp="${DFP_DIR}/xc16"
	
${OBJECTDIR}/system.o: system.c  .generated_files/flags/PIC24FJ256GB108_UMOGI2/6ee2250912dd3f94ec4e477ac5446e4d568faa4f .generated_files/flags/PIC24FJ256GB108_UMOGI2/da39a3ee5e6b4b0d3255bfef95601890afd80709
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} ${OBJECTDIR}/system.o.d 
	@${RM} ${OBJECTDIR}/system.o 
	${MP_CC} $(MP_EXTRA_CC_PRE)  system.c  -o ${OBJECTDIR}/system.o  -c -mcpu=$(MP_PROCESSOR_OPTION)  -MP -MMD -MF "${OBJECTDIR}/system.o.d"        -omf=elf -DXPRJ_PIC24FJ256GB108_UMOGI2=$(CND_CONF)    $(COMPARISON_BUILD)  -fno-short-double -O0 -falign-arrays -I"../demo_src" -I"usb/inc" -I"../../../../../../bsp/exp16/pic24fj256gb110_pim" -I"." -msmart-io=1 -msfr-warn=off    -mdfp="${DFP_DIR}/xc16"
	
${OBJECTDIR}/LCD.o: LCD.c  .generated_files/flags/PIC24FJ256GB108_UMOGI2/b7be13fdadd3560c3fa34f74090a874b49564957 .generated_files/flags/PIC24FJ256GB108_UMOGI2/da39a3ee5e6b4b0d3255bfef95601890afd80709
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} ${OBJECTDIR}/LCD.o.d 
	@${RM} ${OBJECTDIR}/LCD.o 
	${MP_CC} $(MP_EXTRA_CC_PRE)  LCD.c  -o ${OBJECTDIR}/LCD.o  -c -mcpu=$(MP_PROCESSOR_OPTION)  -MP -MMD -MF "${OBJECTDIR}/LCD.o.d"        -omf=elf -DXPRJ_PIC24FJ256GB108_UMOGI2=$(CND_CONF)    $(COMPARISON_BUILD)  -fno-short-double -O0 -falign-arrays -I"../demo_src" -I"usb/inc" -I"../../../../../../bsp/exp16/pic24fj256gb110_pim" -I"." -msmart-io=1 -msfr-warn=off    -mdfp="${DFP_DIR}/xc16"
	
${OBJECTDIR}/timer1637.o: timer1637.c  .generated_files/flags/PIC24FJ256GB108_UMOGI2/a71b2f747b4485aa5c3dfc91970e9a070d8570b4 .generated_files/flags/PIC24FJ256GB108_UMOGI2/da39a3ee5e6b4b0d3255bfef95601890afd80709
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} ${OBJECTDIR}/timer1637.o.d 
	@${RM} ${OBJECTDIR}/timer1637.o 
	${MP_CC} $(MP_EXTRA_CC_PRE)  timer1637.c  -o ${OBJECTDIR}/timer1637.o  -c -mcpu=$(MP_PROCESSOR_OPTION)  -MP -MMD -MF "${OBJECTDIR}/timer1637.o.d"        -omf=elf -DXPRJ_PIC24FJ256GB108_UMOGI2=$(CND_CONF)    $(COMPARISON_BUILD)  -fno-short-double -O0 -falign-arrays -I"../demo_src" -I"usb/inc" -I"../../../../../../bsp/exp16/pic24fj256gb110_pim" -I"." -msmart-io=1 -msfr-warn=off    -mdfp="${DFP_DIR}/xc16"
	
${OBJECTDIR}/main.o: main.c  .generated_files/flags/PIC24FJ256GB108_UMOGI2/519244560502e9ddddbbdfc2c55a22f7614bfbb0 .generated_files/flags/PIC24FJ256GB108_UMOGI2/da39a3ee5e6b4b0d3255bfef95601890afd80709
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} ${OBJECTDIR}/main.o.d 
	@${RM} ${OBJECTDIR}/main.o 
	${MP_CC} $(MP_EXTRA_CC_PRE)  main.c  -o ${OBJECTDIR}/main.o  -c -mcpu=$(MP_PROCESSOR_OPTION)  -MP -MMD -MF "${OBJECTDIR}/main.o.d"        -omf=elf -DXPRJ_PIC24FJ256GB108_UMOGI2=$(CND_CONF)    $(COMPARISON_BUILD)  -fno-short-double -O0 -falign-arrays -I"../demo_src" -I"usb/inc" -I"../../../../../../bsp/exp16/pic24fj256gb110_pim" -I"." -msmart-io=1 -msfr-warn=off    -mdfp="${DFP_DIR}/xc16"
	
${OBJECTDIR}/timermain.o: timermain.c  .generated_files/flags/PIC24FJ256GB108_UMOGI2/c1d01259e7245db21d3cc3b16ecbf86c94d36bfa .generated_files/flags/PIC24FJ256GB108_UMOGI2/da39a3ee5e6b4b0d3255bfef95601890afd80709
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} ${OBJECTDIR}/timermain.o.d 
	@${RM} ${OBJECTDIR}/timermain.o 
	${MP_CC} $(MP_EXTRA_CC_PRE)  timermain.c  -o ${OBJECTDIR}/timermain.o  -c -mcpu=$(MP_PROCESSOR_OPTION)  -MP -MMD -MF "${OBJECTDIR}/timermain.o.d"        -omf=elf -DXPRJ_PIC24FJ256GB108_UMOGI2=$(CND_CONF)    $(COMPARISON_BUILD)  -fno-short-double -O0 -falign-arrays -I"../demo_src" -I"usb/inc" -I"../../../../../../bsp/exp16/pic24fj256gb110_pim" -I"." -msmart-io=1 -msfr-warn=off    -mdfp="${DFP_DIR}/xc16"
	
endif

# ------------------------------------------------------------------------------------
# Rules for buildStep: assemble
ifeq ($(TYPE_IMAGE), DEBUG_RUN)
else
endif

# ------------------------------------------------------------------------------------
# Rules for buildStep: assemblePreproc
ifeq ($(TYPE_IMAGE), DEBUG_RUN)
else
endif

# ------------------------------------------------------------------------------------
# Rules for buildStep: link
ifeq ($(TYPE_IMAGE), DEBUG_RUN)
${DISTDIR}/mikrovez_projekt.X.${IMAGE_TYPE}.${OUTPUT_SUFFIX}: ${OBJECTFILES}  nbproject/Makefile-${CND_CONF}.mk    
	@${MKDIR} ${DISTDIR} 
	${MP_CC} $(MP_EXTRA_LD_PRE)  -o ${DISTDIR}/mikrovez_projekt.X.${IMAGE_TYPE}.${OUTPUT_SUFFIX}  ${OBJECTFILES_QUOTED_IF_SPACED}      -mcpu=$(MP_PROCESSOR_OPTION)        -D__DEBUG=__DEBUG   -omf=elf -DXPRJ_PIC24FJ256GB108_UMOGI2=$(CND_CONF)    $(COMPARISON_BUILD)   -mreserve=data@0x800:0x81F -mreserve=data@0x820:0x821 -mreserve=data@0x822:0x823 -mreserve=data@0x824:0x825 -mreserve=data@0x826:0x84F   -Wl,,,--defsym=__MPLAB_BUILD=1,--defsym=__MPLAB_DEBUG=1,--defsym=__DEBUG=1,-D__DEBUG=__DEBUG,,$(MP_LINKER_FILE_OPTION),--stack=16,--check-sections,--data-init,--pack-data,--handles,--isr,--no-gc-sections,--fill-upper=0,--stackguard=16,--no-force-link,--smart-io,-Map="${DISTDIR}/${PROJECTNAME}.${IMAGE_TYPE}.map",--report-mem,--memorysummary,${DISTDIR}/memoryfile.xml$(MP_EXTRA_LD_POST)  -mdfp="${DFP_DIR}/xc16" 
	
else
${DISTDIR}/mikrovez_projekt.X.${IMAGE_TYPE}.${OUTPUT_SUFFIX}: ${OBJECTFILES}  nbproject/Makefile-${CND_CONF}.mk   
	@${MKDIR} ${DISTDIR} 
	${MP_CC} $(MP_EXTRA_LD_PRE)  -o ${DISTDIR}/mikrovez_projekt.X.${IMAGE_TYPE}.${DEBUGGABLE_SUFFIX}  ${OBJECTFILES_QUOTED_IF_SPACED}      -mcpu=$(MP_PROCESSOR_OPTION)        -omf=elf -DXPRJ_PIC24FJ256GB108_UMOGI2=$(CND_CONF)    $(COMPARISON_BUILD)  -Wl,,,--defsym=__MPLAB_BUILD=1,$(MP_LINKER_FILE_OPTION),--stack=16,--check-sections,--data-init,--pack-data,--handles,--isr,--no-gc-sections,--fill-upper=0,--stackguard=16,--no-force-link,--smart-io,-Map="${DISTDIR}/${PROJECTNAME}.${IMAGE_TYPE}.map",--report-mem,--memorysummary,${DISTDIR}/memoryfile.xml$(MP_EXTRA_LD_POST)  -mdfp="${DFP_DIR}/xc16" 
	${MP_CC_DIR}\\xc16-bin2hex ${DISTDIR}/mikrovez_projekt.X.${IMAGE_TYPE}.${DEBUGGABLE_SUFFIX} -a  -omf=elf   -mdfp="${DFP_DIR}/xc16" 
	
endif


# Subprojects
.build-subprojects:


# Subprojects
.clean-subprojects:

# Clean Targets
.clean-conf: ${CLEAN_SUBPROJECTS}
	${RM} -r ${OBJECTDIR}
	${RM} -r ${DISTDIR}

# Enable dependency checking
.dep.inc: .depcheck-impl

DEPFILES=$(wildcard ${POSSIBLE_DEPFILES})
ifneq (${DEPFILES},)
include ${DEPFILES}
endif
