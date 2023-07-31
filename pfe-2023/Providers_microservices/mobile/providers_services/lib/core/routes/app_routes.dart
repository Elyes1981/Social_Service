
import 'package:flutter/animation.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:providers_services/ui/home/home.ui.dart';
import 'package:providers_services/ui/login/MENU.dart';
import 'package:providers_services/ui/login/login.ui.dart';
import 'package:providers_services/ui/profil/CustomerProfil.ui.dart';
import 'package:providers_services/ui/signup/signup.dart';

import '../../ui/Notification/notification.ui.dart';
import '../../ui/UploadFiles/uploadfiles.dart';
import '../../ui/profil/profil.dart';


class AppRoutes {


  AppRoutes._();

  static const String login = '/login';
  static const String home = '/home';
  static const String signup = '/signup';
  static const String categories = '/categories';
  static const String customer = '/customer';
  static const String profil = '/profil';


  static final List<GetPage<Widget>> routes = <GetPage<Widget>>[
    GetPage<LoginView>(
        name: login,
        page: () => LoginView(),
        transition: Transition.upToDown,
        preventDuplicates: true,
        opaque: false,
        curve: Curves.fastLinearToSlowEaseIn),
    GetPage<Categories>(
        name: categories,
        page: () => Categories(),
        transition: Transition.upToDown,
        preventDuplicates: true,
        opaque: false,
        curve: Curves.fastLinearToSlowEaseIn),
    GetPage<SignUp>(
        name: signup,
        page: () =>  SignUp(),
        transition: Transition.upToDown,
        preventDuplicates: true,
        opaque: false,
        curve: Curves.fastLinearToSlowEaseIn),
    GetPage<HomeView>(
        name: home,
        page: () => const HomeView(),
        transition: Transition.upToDown,
        preventDuplicates: true,
        opaque: false,
        curve: Curves.fastLinearToSlowEaseIn),
    GetPage<UploadFilesPage>(
        name: home,
        page: () =>  UploadFilesPage(),
        transition: Transition.upToDown,
        preventDuplicates: true,
        opaque: false,
        curve: Curves.fastLinearToSlowEaseIn),
    GetPage<NotificationView>(
        name: home,
        page: () =>  NotificationView(),
        transition: Transition.upToDown,
        preventDuplicates: true,
        opaque: false,
        curve: Curves.fastLinearToSlowEaseIn),
    GetPage<NotificationView>(
        name: profil,
        page: () =>  Profile(),
        transition: Transition.upToDown,
        preventDuplicates: true,
        opaque: false,
        curve: Curves.fastLinearToSlowEaseIn),

    /*GetPage<CustomerProfil>(
        name: customer,
        page: () =>  CustomerProfil(),
        transition: Transition.upToDown,
        preventDuplicates: true,
        opaque: false,
        curve: Curves.fastLinearToSlowEaseIn)*/
  ];
}