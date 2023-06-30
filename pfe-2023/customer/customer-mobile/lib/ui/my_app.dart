/*import 'package:demo/core/services/servicetype.dart';
import 'package:demo/core/services/translation.service.dart';
import 'package:demo/core/routes/app_routes.dart';
import 'package:demo/ui/Complain/Complain.ui.dart';
import 'package:demo/ui/Complain/complainlist.ui.dart';
import 'package:demo/ui/Rating/Rating.ui.dart';
import 'package:demo/ui/Rating/preferences.ui.dart';
import 'package:demo/ui/Reservation/Reservation.ui.dart';
import 'package:demo/ui/Reservation/Reservation.ui.dart';
import 'package:demo/ui/ReservationHistory/ReservationHistory.ui.dart';
import 'package:demo/ui/ReservationHistory/ReservationHistory.ui.dart';
import 'package:demo/ui/home_address/home_address.ui.dart';

import 'package:demo/ui/login/Loginfacb.dart';
import 'package:demo/ui/login/login.ui.dart';
import 'package:demo/ui/onboarding_page/onboarding_page.controller.dart';
import 'package:demo/ui/register/profile.dart';
import 'package:demo/ui/onboarding_page/onboarding_page.ui.dart';
import 'package:demo/ui/register/register.ui.dart';
import 'package:demo/ui/residenceType/residenceType.ui.dart';
import 'package:demo/ui/servicesType/servicestype.ui.dart';
import 'package:demo/ui/sms/MyHomePage.dart';
import 'package:demo/ui/sms/sms.ui.dart';*/

import 'package:customermobile/ui/register/register.ui.dart';
import 'package:customermobile/ui/resReasearch/resResearch.ui.dart';
import 'package:customermobile/ui/resReasearch/test.dart';
import 'package:customermobile/ui/resReasearch/view.ui.dart';
import 'package:customermobile/ui/research/research.ui.dart';
import 'package:flutter/material.dart';
import 'package:flutter_localizations/flutter_localizations.dart';
import 'package:get/get.dart';
import '../core/routes/app_routes.dart';
import '../core/services/translation.service.dart';
import 'Complain/Complain.ui.dart';
import 'Rating/Rating.ui.dart';
import 'Reservation/Reservation.ui.dart';
import 'ReservationHistory/ReservationHistory.ui.dart';
import 'home/home.ui.dart';
import 'local/LOCAL.dart';
import 'login/login.ui.dart';
import 'notification/MessageScreen.dart';
import 'notification/notification.ui.dart';
//import 'onboarding_page/onboarding_page.ui.dart';
//import 'package:flutter_localizations/flutter_localizations.dart';

class MyApp extends StatelessWidget {
  MyApp({Key? key}) : super(key: key);



  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return GetMaterialApp(
        theme: ThemeData(
          // This changes font for the entire app using the Google Fonts package
          // from pub.dev : https://pub.dev/packages/google_fonts
          // You can change theme colors to directly change colors for the whole
          // app.
          primaryIconTheme: const IconThemeData(
            color: Colors.black,
          ),
          primaryColor: Color(0xff5B428F),
          primaryColorDark: Color(0xff262833),
          primaryColorLight: Color(0xffFFFFFF),
          colorScheme:
          ColorScheme.fromSwatch().copyWith(secondary: Color(0xffF56D58)),
        ),
        darkTheme: ThemeData(
          // This changes font for the entire app using the Google Fonts package
          // from pub.dev : https://pub.dev/packages/google_fonts
          primaryIconTheme: const IconThemeData(
            color: Colors.white,
          ),

          // You can change theme colors to directly change colors for the whole
          // app.
          primaryColor: Color(0xff5B428F),
          primaryColorDark: Color(0xffFFFFFF),
          primaryColorLight: Color(0xff000000),
          colorScheme:
          ColorScheme.fromSwatch().copyWith(secondary: Color(0xffF56D58)),
        ),
        debugShowCheckedModeBanner: false,
        title: 'RealTime Chat',
        translations: MyLocale(),
        locale: Get.deviceLocale,
        getPages: AppRoutes.routes,
        localizationsDelegates: const <LocalizationsDelegate<dynamic>>[
          // Built-in localization of basic text for Material widgets

          GlobalMaterialLocalizations.delegate,
          // Built-in localization for text direction LTR/RTL
          GlobalWidgetsLocalizations.delegate,
          //Built-in localization of basic text for Cupertino widgets
          GlobalCupertinoLocalizations.delegate
        ],
        home:  HomeView());
  }


}