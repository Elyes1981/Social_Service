import 'dart:ffi';

import 'package:awesome_notifications/awesome_notifications.dart';
import 'package:get/get.dart';
import 'package:get/get_core/src/get_main.dart';

import '../../core/services/NotificationServices.dart';
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
    String timezom = await AwesomeNotifications().getLocalTimeZoneIdentifier();


    await AwesomeNotifications().createNotification(

        content: NotificationContent(
            id: 1,
            channelKey: 'Key1',
            title: title,
            body: body,
            bigPicture: "assets/images/icons/notif.png",


        ),









       actionButtons:[
         NotificationActionButton(
           key: 'OPEN_DETAILS',
           label: 'Open details'
         )
       ]
    );


  }


  void onSubmit(String confirmation) async {
    final response =  _service.confirmationPresence(46 , confirmation);
    print(response);
  }
}