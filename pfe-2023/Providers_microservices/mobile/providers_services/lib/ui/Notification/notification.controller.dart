import 'dart:ffi';
import 'dart:ui';
import 'package:awesome_notifications/awesome_notifications.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:get/get_core/src/get_main.dart';
import 'package:providers_services/core/services/NotificationServices.dart';
import '../../shared/controllers/generic.controller.dart';


class NotificationController extends GenericController{
  final NotificationServices _service =Get.put(NotificationServices());
  @pragma("vm:entry-point")
  static Future<void> onActionReceivedMethod(ReceivedAction receivedAction) async {
    // Your code goes here

    /// Handles regular notification taps.
    if(receivedAction.actionType == ActionType.Default){
      print(receivedAction.id);
      if(receivedAction.id == 17897583){
        // do something...
      }
    }
  }
    @override
  void onInit() {
    // TODO: implement onInit
    super.onInit();
  }

  void Notify(String? title,String? body) async{
    //void Notify(String? title,String? body) async{
    //String timezom = await AwesomeNotifications().getLocalTimeZoneIdentifier();


    await AwesomeNotifications().createNotification(

        content: NotificationContent(
            id: 10,
            channelKey: 'basic_channel',
            title: title,
            body: body
            //bigPicture: "assets/notifici.png",
          /*id: 10,
            channelKey: 'basic_channel',
            title: title,
            body: body,
            bigPicture: "assets/notifici.png",*/


        )

       /*actionButtons:[
         NotificationActionButton(
           key: 'OPEN_DETAILS',
           label: 'Open details'
         )
       ]*/
    );


  }


  void onSubmit(String confirmation) async {
    final response =  _service.confirmationPresence(46 , confirmation);
    print(response);
  }
}