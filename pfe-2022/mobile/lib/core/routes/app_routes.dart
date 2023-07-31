import 'package:demo/ui/home/home.ui.dart';
import 'package:demo/ui/login/MENU.dart';
import 'package:demo/ui/login/login.ui.dart';
import 'package:demo/ui/signup/signup.dart';
import 'package:flutter/animation.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';

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
  ];
}