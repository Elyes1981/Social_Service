import 'dart:async';
import 'package:demo/core/services/CooptedByService.dart';
import 'package:demo/core/services/DelegationService.dart';
import 'package:demo/core/services/GenderService.dart';
import 'package:demo/core/services/GouvernoratService.dart';
import 'package:demo/core/services/Mou3inaService.dart';
import 'package:demo/core/services/OrdresService.dart';
import 'package:demo/core/services/ReclamationService.dart';
import 'package:demo/core/services/ServiceType.dart';
import 'package:demo/core/services/StatusService.dart';
import 'package:demo/core/services/TaskService.dart';
import 'package:demo/core/services/generic.service.dart';
import 'package:demo/core/services/langageService.dart';
import 'package:demo/core/services/seniorityService.dart';
import 'package:demo/ui/Calendar/task_controller.dart';
import 'package:demo/ui/DB/DBHelper.dart';
import 'package:demo/ui/LOCAL/local.controller.dart';
import 'package:demo/ui/Reclamation/ReclamationController.dart';
import 'package:demo/ui/home/home.controller.dart';
import 'package:demo/ui/login/login.controller.dart';
import 'package:demo/ui/my_app.dart';
import 'package:demo/ui/ordres/ordresController.dart';
import 'package:demo/ui/profil/profilController.dart';
import 'package:demo/ui/signup/signupController.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'core/services/translation.service.dart';

Future<void> main() async{
  
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp();
  await initDependencies();
  
  await DBHelper.initDb();
  
  return runZonedGuarded(() async {
    runApp(MyApp());
  }, (Object error, StackTrace stack) {});}

Future<void>initDependencies() async {
  
  Get.put<GenericService>( GenericService(), permanent: true);
   Get.lazyPut<ReclamationController>(() => ReclamationController(), fenix: true);
    Get.lazyPut<MyLocaleController>(() => MyLocaleController(), fenix: true);
   
  Get.lazyPut<ServiceTypeController>(() => ServiceTypeController(), fenix: true);
  Get.lazyPut<LoginController>(() => LoginController(), fenix: true);
  Get.lazyPut<profilController>(() => profilController(), fenix: true);
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
  Get.put<OrdersService>( OrdersService(), permanent: true);
   

}


