
import 'package:flutter/animation.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:providers_services/ui/home/home.ui.dart';
import 'package:providers_services/ui/login/login.ui.dart';
import 'package:providers_services/ui/signup/signup.dart';


class AppRoutes {


  AppRoutes._();

  static const String login = '/login';
  static const String home = '/home';
    static const String signup = '/signup';
  static const String categories = '/categories';
  static final List<GetPage<Widget>> routes = <GetPage<Widget>>[
    GetPage<LoginView>(
        name: login,
        page: () => LoginView(),
        transition: Transition.upToDown,
        preventDuplicates: true,
        opaque: false,
        curve: Curves.fastLinearToSlowEaseIn),
         /*GetPage<Categories>(
        name: categories,
        page: () => Categories(),
        transition: Transition.upToDown,
        preventDuplicates: true,
        opaque: false,
        curve: Curves.fastLinearToSlowEaseIn),*/
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
  ];
}