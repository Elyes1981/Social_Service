import 'dart:async';

import 'package:awesome_notifications/awesome_notifications.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:firebase_messaging/firebase_messaging.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_local_notifications/flutter_local_notifications.dart';
import 'package:get/get.dart';
import 'package:providers_services/core/services/CooptedByService.dart';
import 'package:providers_services/core/services/DelegationService.dart';
import 'package:providers_services/core/services/GenderService.dart';
import 'package:providers_services/core/services/GouvernoratService.dart';
import 'package:providers_services/core/services/Mou3inaService.dart';
import 'package:providers_services/core/services/NotificationServices.dart';
import 'package:providers_services/core/services/OrdresService.dart';
import 'package:providers_services/core/services/ReclamationService.dart';
import 'package:providers_services/core/services/ServiceType.dart';
import 'package:providers_services/core/services/StatusService.dart';
import 'package:providers_services/core/services/TaskService.dart';
import 'package:providers_services/core/services/generic.service.dart';
import 'package:providers_services/core/services/langageService.dart';
import 'package:providers_services/core/services/reservation.service.dart';
import 'package:providers_services/core/services/seniorityService.dart';
import 'package:providers_services/ui/Calendar/task_controller.dart';
import 'package:providers_services/ui/LOCAL/local.controller.dart';
import 'package:providers_services/ui/Notification/NotificationHistory.controller.dart';
import 'package:providers_services/ui/Notification/notification.controller.dart';
import 'package:providers_services/ui/Reclamation/ReclamationController.dart';
import 'package:providers_services/ui/UploadFiles/UploadFilesController.dart';
import 'package:providers_services/ui/home/home.controller.dart';
import 'package:providers_services/ui/login/login.controller.dart';
import 'package:providers_services/ui/my_app.dart';
import 'package:providers_services/ui/ordres/ordresController.dart';
import 'package:providers_services/ui/profil/profilController.dart';
import 'package:providers_services/ui/reservationHistory/ReservationHistory.controller.dart';
import 'package:providers_services/ui/signup/signupController.dart';


Future<void> main() async{

  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp();
  FirebaseMessaging.onBackgroundMessage(_firebasePushHandler);
  AwesomeNotifications().initialize(
    // set the icon to null if you want to use the default app icon
      null,
      [
        NotificationChannel(
            channelGroupKey: 'basic_channel_group',
            channelKey: 'basic_channel',
            channelName: 'Basic notifications',
            channelDescription: 'Notification channel for basic tests',
            defaultColor: Color(0xFF9D50DD),
            ledColor: Colors.white,
            enableLights: true,
            enableVibration: true
        )
      ]
      // Channel groups are only visual and are not required
      /*channelGroups: [
        NotificationChannelGroup(
            channelGroupKey: 'basic_channel_group',
            channelGroupName: 'Basic group')
      ],
      debug: true*/
  );

  FirebaseMessaging messaging = FirebaseMessaging.instance ;
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


  await initDependencies();



  //final FlutterLocalNotificationsPlugin _flutterLocalNotificationsPlugin = FlutterLocalNotificationsPlugin();

  //await DBHelper.initDb();






  return runZonedGuarded(() async {
    runApp(MyApp());
  }, (Object error, StackTrace stack) {});}


  Future<void> _firebasePushHandler(RemoteMessage message) async{
    print("Message from push notif is ${message.data}");
    AwesomeNotifications().createNotificationFromJsonData(message.data);
  }

Future<void>initDependencies() async {

  Get.put<GenericService>( GenericService(), permanent: true);
  Get.lazyPut<ReclamationController>(() => ReclamationController(), fenix: true);
  Get.lazyPut<MyLocaleController>(() => MyLocaleController(), fenix: true);

  Get.lazyPut<ServiceTypeController>(() => ServiceTypeController(), fenix: true);
  Get.lazyPut<LoginController>(() => LoginController(), fenix: true);
  Get.lazyPut<HomeController>(() => HomeController(), fenix: true);
  Get.lazyPut<TaskController>(() => TaskController(), fenix: true);
  Get.lazyPut<ordresController>(() => ordresController(), fenix: true);
  Get.put<TaskService>( TaskService(), permanent: true);
  Get.put<ServiceType>( ServiceType(), permanent: true);
  Get.put<GenderService>( GenderService(), permanent: true);
  Get.put<StatusService>( StatusService(), permanent: true);
  Get.put<LangageService>( LangageService(), permanent: true);
  Get.put<CooptedByService>( CooptedByService(), permanent: true);
  Get.put<SeniorityService>( SeniorityService(), permanent: true);
  Get.put<delegationService>( delegationService(), permanent: true);
  Get.lazyPut<TaskController>(() => TaskController(), fenix: true);
  Get.put<TaskService>( TaskService(), permanent: true);
  Get.put<Mou3inaService>( Mou3inaService(), permanent: true);
  Get.put<GouvernoratService>( GouvernoratService(), permanent: true);
  Get.put<ReclamationService>( ReclamationService(), permanent: true);
  Get.put<ReservationService>(ReservationService() , permanent: true);
  Get.put<NotificationServices>(NotificationServices() , permanent: true);
  Get.put<OrdersService>( OrdersService(), permanent: true);
  Get.lazyPut(() => UploadFilesController()/*,fenix: true*/); //instance controller  nécessaire pour la première fois, puis réutilisé tout au long de la durée de vie de l'application. Cela peut être utile pour réduire l'utilisation de la mémoire et améliorer les performances
  // Get.lazyPut()méthode, il ne sera créé que lors de sa première demande, puis réutilisé pour les demandes suivantes
  Get.lazyPut<NotificationController>(() => NotificationController(), fenix: true);
  Get.lazyPut<NotificationHistoryController>(() => NotificationHistoryController(), fenix: true);
  Get.lazyPut<ReservationHistoryController>(() => ReservationHistoryController(), fenix: true);
  Get.lazyPut<profilController>(() => profilController(), fenix: true);













}


