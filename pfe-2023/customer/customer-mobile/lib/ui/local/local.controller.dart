import 'package:flutter/cupertino.dart';
import 'package:get/get.dart';

class MyLocaleController extends GetxController{
  Future changeLang(String codeLang){
    Locale locale = Locale(codeLang);
    return Get.updateLocale(locale);
  }
}