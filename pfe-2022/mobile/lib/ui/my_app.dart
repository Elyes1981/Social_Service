import 'package:demo/core/services/translation.service.dart';
import 'package:demo/core/routes/app_routes.dart';
import 'package:demo/ui/LOCAL/local.dart';
import 'package:demo/ui/home/home.ui.dart';
import 'package:demo/ui/login/login.ui.dart';
import 'package:demo/ui/signup/signup.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:flutter_localizations/flutter_localizations.dart';

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
        locale:Get.deviceLocale,
        translations: MyLocale(),
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
      
       
        getPages: AppRoutes.routes,
        localizationsDelegates: const <LocalizationsDelegate<dynamic>>[
          // Built-in localization of basic text for Material widgets
          GlobalMaterialLocalizations.delegate,
          // Built-in localization for text direction LTR/RTL
          GlobalWidgetsLocalizations.delegate,
          // Built-in localization of basic text for Cupertino widgets
          GlobalCupertinoLocalizations.delegate
        ],
        home:HomeView()
        );
  }


}