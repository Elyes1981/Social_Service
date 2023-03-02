/*import 'package:demo/ui/Complain/Complain.ui.dart';
import 'package:demo/ui/Complain/complainlist.ui.dart';
import 'package:demo/ui/Rating/Rating.ui.dart';
import 'package:demo/ui/Rating/preferences.ui.dart';
import 'package:demo/ui/ReservationHistory/ReservationHistory.ui.dart';
import 'package:demo/ui/ServicesType/servicestype.ui.dart';
import 'package:demo/ui/calendar/calendar.ui.dart';
import 'package:demo/ui/date_details2/date_details2.dart';
import 'package:demo/ui/date_order/date_order.ui.dart';
import 'package:demo/ui/home/home.ui.dart';
import 'package:demo/ui/home_address/home_address.ui.dart';
import 'package:demo/ui/homeaddress_map/maps.ui.dart';
import 'package:demo/ui/login/login.ui.dart';
import 'package:demo/ui/register/register.ui.dart';
import 'package:demo/ui/sms/MyHomePage.dart';
import 'package:demo/ui/sms/registerphone.ui.dart';
import 'package:demo/ui/sms/sms.ui.dart';*/
import 'package:customermobile/ui/sms/MyHomePage.dart';
import 'package:flutter/animation.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';

import '../../main.dart';
/*import '../../ui/Complain/Complain.ui.dart';
import '../../ui/Complain/complainlist.ui.dart';
import '../../ui/date_details2/date_details2.dart';
import '../../ui/date_order/date_order.ui.dart';*/
import '../../ui/home/home.ui.dart';
import '../../ui/home_address/home_address.ui.dart';
//import '../../ui/homeaddress_map/maps.ui.dart';
import '../../ui/login/login.ui.dart';
import '../../ui/register/register.ui.dart';
//import '../../ui/servicesType/servicestype.ui.dart';
import '../../ui/sms/registerphone.ui.dart';
import '../../ui/sms/sms.ui.dart';

class AppRoutes {
  AppRoutes._();

  static const String login = '/login';
  static const String home = '/home';
  static const String servicestype = '/servicestype';
  static const String home_address = '/home_address';
  static const String register = '/register';
  static const String reshistory = '/reshistory';
  static const String rating = '/rating';

  static const String maps = '/maps';

  static const String sms = '/sms';
  static const String registerphone = '/registerphone';
  static const String date_order = '/date_order';
  static const String homepage = '/homepage';
  static const String complain = '/complain';
  static const String complainlist = '/complainlist';
  static const String preferences = '/preferences';
  static const String calendar = '/calendar';
  static const String date_details = '/date_details';
  static final List<GetPage<Widget>> routes = <GetPage<Widget>>[
    GetPage<LoginView>(
        name: login,
        page: () => LoginView(),
        transition: Transition.upToDown,
        preventDuplicates: true,
        opaque: false,
        curve: Curves.fastLinearToSlowEaseIn),
    /*GetPage<Calendar>(
        name: calendar,
        page: () => Calendar(),
        transition: Transition.upToDown,
        preventDuplicates: true,
        opaque: false,
        curve: Curves.fastLinearToSlowEaseIn),*/
   /* GetPage<Complain>(
        name: complain,
        page: () => Complain(),
        transition: Transition.upToDown,
        preventDuplicates: true,
        opaque: false,
        curve: Curves.fastLinearToSlowEaseIn),*/
    /*GetPage<Rating>(
        name: rating,
        page: () => Rating(),
        transition: Transition.upToDown,
        preventDuplicates: true,
        opaque: false,
        curve: Curves.fastLinearToSlowEaseIn),*/
    /*GetPage<Complainlist>(
        name: complainlist,
        page: () => Complainlist(),
        transition: Transition.upToDown,
        preventDuplicates: true,
        opaque: false,
        curve: Curves.fastLinearToSlowEaseIn),*/
   /* GetPage<Preferences>(
        name: preferences,
        page: () => Preferences(),
        transition: Transition.upToDown,
        preventDuplicates: true,
        opaque: false,
        curve: Curves.fastLinearToSlowEaseIn),*/
   /* GetPage<Date_order>(
        name: date_order,
        page: () => Date_order(),
        transition: Transition.upToDown,
        preventDuplicates: true,
        opaque: false,
        curve: Curves.fastLinearToSlowEaseIn),*/
    GetPage<Sms>(
        name: sms,
        page: () => Sms(),
        transition: Transition.upToDown,
        preventDuplicates: true,
        opaque: false,
        curve: Curves.fastLinearToSlowEaseIn),
    GetPage<Registerphone>(
        name: registerphone,
        page: () => Registerphone(),
        transition: Transition.upToDown,
        preventDuplicates: true,
        opaque: false,
        curve: Curves.fastLinearToSlowEaseIn),
    GetPage<Home_address>(
        name: home_address,
        page: () => Home_address(),
        transition: Transition.upToDown,
        preventDuplicates: true,
        opaque: false,
        curve: Curves.fastLinearToSlowEaseIn),
    GetPage<MyHomePage>(
        name: homepage,
        page: () => MyHomePage(),
        transition: Transition.upToDown,
        preventDuplicates: true,
        opaque: false,
        curve: Curves.fastLinearToSlowEaseIn),
   /* GetPage<date_details2>(
        name: date_details,
        page: () => date_details2(),
        transition: Transition.upToDown,
        preventDuplicates: true,
        opaque: false,
        curve: Curves.fastLinearToSlowEaseIn),*/
    GetPage<Register>(
        name: register,
        page: () => Register(),
        transition: Transition.upToDown,
        preventDuplicates: true,
        opaque: false,
        curve: Curves.fastLinearToSlowEaseIn),
    /*GetPage<Servicestype>(
        name: servicestype,
        page: () => Servicestype(),
        transition: Transition.upToDown,
        preventDuplicates: true,
        opaque: false,
        curve: Curves.fastLinearToSlowEaseIn),*/
   /* GetPage<ReservationHistory>(
        name: reshistory,
        page: () => ReservationHistory(),
        transition: Transition.upToDown,
        preventDuplicates: true,
        opaque: false,
        curve: Curves.fastLinearToSlowEaseIn),*/
    GetPage<HomeView>(
        name: home,
        page: () => const HomeView(),
        transition: Transition.upToDown,
        preventDuplicates: true,
        opaque: false,
        curve: Curves.fastLinearToSlowEaseIn),
    /*GetPage<Maps>(
        name: maps,
        page: () => Maps(),
        transition: Transition.upToDown,
        preventDuplicates: true,
        opaque: false,
        curve: Curves.fastLinearToSlowEaseIn),*/
  ];
}
