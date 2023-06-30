

import 'package:awesome_notifications/awesome_notifications.dart';
import 'package:firebase_messaging/firebase_messaging.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:get/get_core/src/get_main.dart';

import '../../core/services/NotificationServices.dart';

import 'notificationPresence.controller.dart';

class MessageScreenPresence extends StatefulWidget {
  const MessageScreenPresence({Key? key }) : super(key: key);


  @override
  _MessageScreenPresenceState createState() => _MessageScreenPresenceState();

}

class _MessageScreenPresenceState extends State<MessageScreenPresence> {
  NotificationPresenceController _notificationPresenceControllerController = new NotificationPresenceController();
  @override
  void initState() {
    super.initState();

    // 1. This method call when app in terminated state and you get a notification
    FirebaseMessaging.instance.getInitialMessage().then(
          (message) {
        print("FirebaseMessaging.instance.getInitialMessage");
        if (message != null) {
          print("New Notification");
          // if (message.data['_id'] != null) {
          //   Navigator.of(context).push(
          //     MaterialPageRoute(
          //       builder: (context) => DemoScreen(
          //         id: message.data['_id'],
          //       ),
          //     ),
          //   );
          // }
        }
      },
    );

    // 2. This method only call when App in forground it mean app must be opened
    FirebaseMessaging.onMessage.listen(
          (message) {
        print("FirebaseMessaging.onMessage.listen");
        if (message.notification != null) {
          print(message.notification!.title);
          print(message.notification!.body);
          print("message.data11 ${message.data}");
          // LocalNotificationService.display(message);
          _notificationPresenceControllerController.Notify(message.notification!.title,message.notification!.body);

        }
      },
    );

    // 3. This method only call when App in background and not terminated(not closed)
    FirebaseMessaging.onMessageOpenedApp.listen(
          (message) {
        print("FirebaseMessaging.onMessageOpenedApp.listen");
        if (message.notification != null) {
          print(message.notification!.title);
          print(message.notification!.body);
          print("message.data22 ${message.data['_id']}");
        }
      },
    );
  }



  @override
  Widget build(BuildContext context) {
    return  Scaffold(
      appBar: AppBar(
        centerTitle: true,
        title: const Text('Notification ')  ,
      ),
      body: Container(
    decoration: BoxDecoration(
    image: DecorationImage(
    image: AssetImage('assets/images/illustration-2.png'),
    fit: BoxFit.cover,
    ),
    ),
    child: Center(
    child: Column(

          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            /*Text(
              'Centered Text',
              style: TextStyle(
                fontSize: 24.0,
                fontWeight: FontWeight.bold,
              ),
            ),*/
            SizedBox(height: 20.0),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                ElevatedButton(
                  onPressed: () {
                    _notificationPresenceControllerController.onSubmit("OK");
                  },
                  child: Text('Validate'),
                ),
                SizedBox(width: 20.0),
                OutlinedButton(
                  onPressed: () {
                    _notificationPresenceControllerController.onSubmit("KO");
                  },
                  child: Text('Cancel'),
                ),
              ],
            ),
          ],
        ),
       ),
      ),
    );
  }
}

