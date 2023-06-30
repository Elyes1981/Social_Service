

import 'package:awesome_notifications/awesome_notifications.dart';
import 'package:firebase_messaging/firebase_messaging.dart';
import 'package:flutter/material.dart';

import 'notification.controller.dart';

class homeNotiff extends StatefulWidget {
  const homeNotiff({Key? key }) : super(key: key);

  @override
  _homeNotiffState createState() => _homeNotiffState();

}

class _homeNotiffState extends State<homeNotiff> {
   @override
  void initState() {
    super.initState();

    // 1. This method call when app in terminated state and you get a notification
   /* FirebaseMessaging.instance.getInitialMessage().then(
          (message) {
        print("FirebaseMessaging.instance.getInitialMessage");

      },
    );

*/
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    throw UnimplementedError();
  }

}

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    throw UnimplementedError();
  }
}

