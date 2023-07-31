//import 'package:demo/ui/home/home.controller.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';

import 'home.controller.dart';
class HomeView extends GetView<HomeController>{
  const HomeView({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Center(
      child: Text('Welcome to flutter app', style: Get.textTheme.bodyText1!.copyWith(color: Get.theme.primaryColorDark)),
    );
  }

}