import 'package:firebase_messaging/firebase_messaging.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:providers_services/ui/Notification/notification.controller.dart';
import 'package:providers_services/ui/home/home.ui.dart';


class NotificationView extends GetView<NotificationController>{
  const NotificationView({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    Future<void> _onSelectNotification(String payload) async {
      // Rediriger l'utilisateur vers une page spécifique lorsqu'il clique sur la notification
      await Navigator.push(
        context,
        MaterialPageRoute(builder: (context) => HomeView()),
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



            this.controller.Notify("notification","hey");
            //this.controller.Notify("notification","hey");


          },

          child: Icon(Icons.circle_notifications),
        ),
      )

       );
  }

}