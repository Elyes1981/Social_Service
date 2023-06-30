import 'package:awesome_notifications/awesome_notifications.dart';
import 'package:firebase_messaging/firebase_messaging.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';

import '../dispo/dispo.ui.dart';
//import 'notification.controller.dart';
import 'notificationPresence.controller.dart';
class NotificationPresenceView extends GetView<NotificationPresenceController>{
  const NotificationPresenceView({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    Future<void> _onSelectNotification(String payload) async {
      // Rediriger l'utilisateur vers une page spécifique lorsqu'il clique sur la notification
      await Navigator.push(
        context,
        MaterialPageRoute(builder: (context) => DispoView()),
      );
    }


    FirebaseMessaging.instance.getToken().then((value) {
      print("value");
      print(value);
    });

    // TODO: implement build
    return Scaffold(
      body: Center(
        child: ElevatedButton(

          onPressed: (){



            this.controller.Notify("notification","");

            /*Navigator.push(
              context,
              MaterialPageRoute(
                builder: (context) => DispoView(),
              ),
            );*/



           /* AwesomeNotifications().actionStream.listen((
            reactivedNotifiction){
              Navigator.of(context).pushNamed(
                '/DispoView',
              );
            }
            );*/
          },

          child: Icon(Icons.circle_notifications),
        ),
      )

       );
  }

}