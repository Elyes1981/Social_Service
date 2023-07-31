import 'dart:convert';

import 'package:demo/core/routes/app_routes.dart';
import 'package:demo/core/services/AuthenticationService.dart';
import 'package:demo/shared/sharedPref.dart';
import 'package:demo/ui/login/AppPreferenceHelper%20.dart';

import 'package:get/get.dart';

import 'package:demo/core/models/Mou3inaModel.dart';
import 'package:demo/core/services/Mou3inaService.dart';
import 'package:demo/shared/controllers/generic.controller.dart';

import 'package:flutter/material.dart';

import 'package:shared_preferences/shared_preferences.dart';
class profilController extends GenericController{
  static profilController instance = Get.find();
 final AppPreferenceHelper _helper = new AppPreferenceHelper();
  final AuthenticationService _service =Get.put(AuthenticationService());
     Mou3inaService mou3inaService=Get.find();
   
   
    
String? name;
  String? emaill;
  String? usernName;
String? fist;
int? id;
  @override
  void onInit() {
   name=_helper.userId.toString();
   
    emaill=_helper.email;
    usernName=_helper.username;
     fist=_helper.firstName;
    super.onInit();
    
  }
   void Out() async {
     final response =  _service.logout();
       Get.offAndToNamed(AppRoutes.login); 
    } 
    void find() async {
   
    final List< dynamic> mou3ina = await  mou3inaService.findMou3ina(name);
     print("helooo");
    print(mou3ina);
     print("helooo");
    }
}