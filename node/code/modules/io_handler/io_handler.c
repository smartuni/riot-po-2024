/*
 * Copyright (C) 2024 HAW Hamburg
 *
 * This file is subject to the terms and conditions of the GNU Lesser
 * General Public License v2.1. See the file LICENSE in the top level
 * directory for more details.
 */

/**
 * @{
 *
 * @file
 * @brief    IO Handler: Vibration module and buttons initialization   
 *
 * @author   Eduard Lomtadze <eduard.lomtadze@haw-hamburg.de>   
 * @}
 */

#define ENABLE_DEBUG  1
#include "debug.h"

#include "init_buttons.h"
#include "io_handler.h"

//Define the vibration time (milliseconds) here:
#define VIBRATE_FOR_MSEC 500

void io_init(void){
    init_buttons();
}

handler_result_t ioHandler_handleEvent(EVENT_T event){
    DEBUG("[IoHandler:handleEvent]\n");
    switch(event){
        case VIBRATE:
            DEBUG("[IoHandler:handleEvent]: vibrate\n");
            vibrate(VIBRATE_FOR_MSEC);
        break;
        default:
        break;
    }
    return HANDLED;
}
