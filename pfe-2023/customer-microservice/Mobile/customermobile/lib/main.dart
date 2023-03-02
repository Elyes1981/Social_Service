import 'dart:async';


import 'package:customermobile/ui/home/home.controller.dart';
import 'package:customermobile/ui/login/login.controller.dart';
import 'package:customermobile/ui/my_app.dart';
import 'package:customermobile/ui/register/register.controller.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';

import 'core/services/AuthenticationService.dart';
import 'core/services/cus_complain.service.dart';
import 'core/services/customer.service.dart';
import 'core/services/gender.service.dart';
import 'core/services/generic.service.dart';
import 'core/services/residencetype.dart';
import 'core/services/servicetype.dart';
import 'core/services/sousTypes.service.dart';
import 'core/services/status.service.dart';
import 'core/services/statusRes.service.dart';
import 'core/services/translation.service.dart';

Future<void> main() async{
  WidgetsFlutterBinding.ensureInitialized();
  //await Firebase.initializeApp();

  await initDependencies();
  final TranslationService translationService = TranslationService();
  final AppTranslations translations =
  await translationService.getTranslations();
  return runZonedGuarded(() async {
    runApp(MyApp(translations: translations));
  }, (Object error, StackTrace stack) {});}

Future<void>initDependencies() async {
  Get.put<GenericService>(GenericService() , permanent: true);
  Get.lazyPut<LoginController>(() => LoginController(), fenix: true);
  Get.lazyPut<HomeController>(() => HomeController(), fenix: true);
  //Get.lazyPut<ServicestypeController>(() => ServicestypeController(), fenix: true);
  //Get.lazyPut<ResidenceTypeController>(() => ResidenceTypeController(), fenix: true);
  Get.lazyPut<RegisterController>(() => RegisterController(), fenix: true);

  Get.put<AuthenticationService>(AuthenticationService() , permanent: true);

  Get.put<CusComplainService>(CusComplainService() , permanent: true);
  //Get.put<ComplainTypeService>(ComplainTypeService() , permanent: true);
  Get.put<ServiceType>(ServiceType() , permanent: true);
  //Get.put<PreferenceService>(PreferenceService() , permanent: true);
  Get.put<SousTypesService>(SousTypesService() , permanent: true);
  Get.put<StatusService>(StatusService() , permanent: true);
  Get.put<GenderService>(GenderService() , permanent: true);
  Get.put<ResidenceType>(ResidenceType() , permanent: true);
  Get.put<CustomerService>(CustomerService() , permanent: true);
  //Get.put<ResearchService>(ResearchService() , permanent: true);
  Get.put<StatusResService>(StatusResService() , permanent: true);
  //Get.put<ReservationService>(ReservationService() , permanent: true);








}


