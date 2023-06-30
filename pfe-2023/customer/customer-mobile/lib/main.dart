import 'dart:async';

import 'package:customermobile/core/services/mou3ina.dart';
import 'package:customermobile/ui/Complain/complain.controller.dart';
import 'package:customermobile/ui/Reservation/Reservation.controller.dart';
import 'package:customermobile/ui/ReservationHistory/ReservationHistory.controller.dart';
import 'package:customermobile/ui/home/home.controller.dart';
import 'package:customermobile/ui/local/local.controller.dart';
import 'package:customermobile/ui/login/login.controller.dart';
import 'package:customermobile/ui/my_app.dart';
import 'package:customermobile/ui/register/register.controller.dart';
import 'package:customermobile/ui/notification/notification.controller.dart';
import 'package:customermobile/ui/servicesType/servicestype.controller.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:firebase_messaging/firebase_messaging.dart';
//import 'package:firebase_messaging/firebase_messaging.dart
import 'package:flutter/material.dart';
import 'package:flutter_local_notifications/flutter_local_notifications.dart';
import 'package:get/get.dart';
import 'package:awesome_notifications/awesome_notifications.dart';
import 'core/services/AuthenticationService.dart';
import 'core/services/complainType.service.dart';
import 'core/services/cus_complain.service.dart';
import 'core/services/customer.service.dart';
import 'core/services/gender.service.dart';
import 'core/services/generic.service.dart';
import 'core/services/ordermou3inalist.service.dart';
import 'core/services/preference.service.dart';
import 'core/services/research.service.dart';
import 'core/services/reservation.service.dart';
import 'core/services/residencetype.dart';
import 'core/services/servicetype.dart';
import 'core/services/sousTypes.service.dart';
import 'core/services/status.service.dart';
import 'core/services/statusRes.service.dart';
import 'core/services/translation.service.dart';
//import 'package:cloud_firestore/cloud_firestore.dart';

Future<void> backgroundHandler(RemoteMessage message) async {
  print(message.data.toString());
  print(message.notification!.title);
}


Future<void> main() async{
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp();
  FirebaseMessaging.onBackgroundMessage(backgroundHandler);
  AwesomeNotifications().initialize(
      null,
      [
        NotificationChannel(
            channelKey: 'Key1',
            channelName: 'channelName',
            channelDescription: 'Notification ',
            defaultColor: Color(0XFF9050DD),
            ledColor: Colors.white,
          playSound: true,
          enableLights: true,
          enableVibration: true

        )
      ],
  );

  FirebaseMessaging.onMessage.listen(
        (message) {
      print("FirebaseMessaging.onMessage.listen");
      if (message.notification != null) {
        print(message.notification!.title);
        print(message.notification!.body);
        print("message.data11 ${message.data}");
        // LocalNotificationService.display(message);
        NotificationController _notificationController = new NotificationController();
        _notificationController.Notify(message.notification!.title,message.notification!.body);

      }
    },
  );
  FirebaseMessaging messaging = FirebaseMessaging.instance ;
  final FlutterLocalNotificationsPlugin _flutterLocalNotificationsPlugin  = FlutterLocalNotificationsPlugin();
 /* void requestNotificationPermission()async {
    NotificationSettings settings = await messaging.requestPermission(
        alert: true ,
        announcement: true ,
        badge: true ,
        carPlay:  true ,
        criticalAlert: true ,
        provisional: true ,
        sound: true
    );
  }*/

  await initDependencies();
  final TranslationService translationService = TranslationService();
  final AppTranslations translations =
  await translationService.getTranslations();
  return runZonedGuarded(() async {
    runApp(MyApp());
  }, (Object error, StackTrace stack) {});}

Future<void>initDependencies() async {
  Get.put<GenericService>(GenericService() , permanent: true);
  Get.lazyPut<LoginController>(() => LoginController(), fenix: true);
  Get.lazyPut<HomeController>(() => HomeController(), fenix: true);
  Get.lazyPut<NotificationController>(() => NotificationController(), fenix: true);
  Get.lazyPut<ServicestypeController>(() => ServicestypeController(), fenix: true);
  //Get.lazyPut<ResidenceTypeController>(() => ResidenceTypeController(), fenix: true);
  Get.lazyPut<RegisterController>(() => RegisterController(), fenix: true);
  Get.lazyPut<ReservationController>(() => ReservationController(), fenix: true);
  //Get.lazyPut<ResearchController>(() => ResearchController(), fenix: true);
  Get.lazyPut<ReservationHistoryController>(() => ReservationHistoryController(), fenix: true);
  Get.put<AuthenticationService>(AuthenticationService() , permanent: true);
  Get.lazyPut<ComplainController>(() => ComplainController(), fenix: true);
  //Get.put<ReservationHistoryController>(ReservationHistoryController() , permanent: true);
  Get.put<OrderMou3inaService>(OrderMou3inaService() , permanent: true);
  Get.put<CusComplainService>(CusComplainService() , permanent: true);
  Get.put<ComplainTypeService>(ComplainTypeService() , permanent: true);
  Get.put<ServiceType>(ServiceType() , permanent: true);
  Get.put<Mou3ina>(Mou3ina() , permanent: true);
  Get.put<PreferenceService>(PreferenceService() , permanent: true);
  Get.put<SousTypesService>(SousTypesService() , permanent: true);
  Get.put<StatusService>(StatusService() , permanent: true);
  Get.put<GenderService>(GenderService() , permanent: true);
  Get.put<ResidenceType>(ResidenceType() , permanent: true);
  Get.put<CustomerService>(CustomerService() , permanent: true);
  Get.put<ResearchService>(ResearchService() , permanent: true);
  Get.put<StatusResService>(StatusResService() , permanent: true);
  Get.put<ReservationService>(ReservationService() , permanent: true);

  Get.lazyPut<MyLocaleController>(() => MyLocaleController(), fenix: true);






}


