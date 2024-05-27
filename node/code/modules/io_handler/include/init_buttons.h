#pragma once

#ifndef INIT_BUTTONS_T
#define INIT_BUTTONS_T


#ifdef __cplusplus
extern "C" {
#endif


int init_buttons(void);

void button_up_callback (void *arg);
void button_left_callback (void *arg);
void button_down_callback (void *arg);
void button_right_callback (void *arg);
void button_extra_callback (void *arg);


#ifdef __cplusplus
}
#endif

#endif /* INIT_BUTTONS_T */
