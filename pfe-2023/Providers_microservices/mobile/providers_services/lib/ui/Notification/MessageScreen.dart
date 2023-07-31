

import 'package:awesome_notifications/awesome_notifications.dart';
import 'package:firebase_messaging/firebase_messaging.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:get/get_core/src/get_main.dart';
import 'package:providers_services/ui/home/home.ui.dart';

import '../../core/services/NotificationServices.dart';

import 'notification.controller.dart';
import 'notification.controller.dart';
class MessageScreen extends StatefulWidget {
  const MessageScreen({Key? key }) : super(key: key);


  @override
  _MessageScreenState createState() => _MessageScreenState();

}

class _MessageScreenState extends State<MessageScreen> {
  NotificationController _notificationController = new NotificationController();
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
          //_notificationController.Notify(message.notification!.title,message.notification!.body);

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
    image: AssetImage('assets/images/illustration-3.png'),
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
                    _notificationController.onSubmit("OK");

                    Navigator.push(
                      context,
                      MaterialPageRoute(
                        builder: (context) => HomeView(),
                      ),
                    );
                  },
                  child: Text('Validate'),
                ),

                SizedBox(width: 20.0),
                OutlinedButton(
                  onPressed: () {
                    _notificationController.onSubmit("KO");
                  },
                  child: Text('Cancel'),
                ),
               /* OutlinedButton(
                  onPressed: () {
                    Notify("notification","");
                  },
                  child: Icon(Icons.circle_notifications),
                ),*/
              ],
            ),
          ],
        ),
       ),
      ),
    );
  }
}

