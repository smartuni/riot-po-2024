/**
 * @brief Main file for the C++ code.
 * @author Tom <git@annsann.eu>
 */

#include <cstdio>
#include <vector>

#include "architecture.h"
#include "dispatch_handler.hpp"
#include "dispatcher.hpp"
//#include "init_display.h"
#include "init_lvgl.h"
#include "ping.hpp"
#include "pong.hpp"
#include "riot/thread.hpp"
#include "lvgl/lvgl.h"

using namespace std;
using namespace riot;

kernel_pid_t DISPATCHER_PID;

/* main */
int main() {
  printf("\n************ We are in C++ 😎 ***********\n");
  printf("\n");



  puts("{\"result\": \"PASS\"}");


  // Create the dispatcher
  Dispatcher *dispatcher = new Dispatcher();
  dispatcher->startInternalThread();

  DISPATCHER_PID = dispatcher->getPID();

  // Create the ping class
  Ping *ping = new Ping();
  ping->startInternalThread();

  // Create the pong class
  Pong *pong = new Pong();
  pong->startInternalThread();

  // Subscribe the ping and pong classes to each other
  dispatcher->subscribe({EVENTS::PING}, ping->getPID());
  dispatcher->subscribe({EVENTS::PONG}, pong->getPID());

  cout << "Sending initial ping event" << endl;
  msg_t message;
  message.type = EVENTS::PING;

  msg_try_send(&message, dispatcher->getPID());
printf("printf success\n");

printf("initing\n");
  init_lvgl();
  printf("init success\n");

    

  while (true) {;
  }

  return 0;
}
