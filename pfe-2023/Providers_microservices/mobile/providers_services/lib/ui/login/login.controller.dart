import 'dart:convert';

import 'package:get/get.dart';

import 'package:flutter/material.dart';
import 'package:providers_services/core/models/Mou3inaModel.dart';
import 'package:providers_services/core/services/AuthenticationService.dart';
import 'package:providers_services/core/services/Mou3inaService.dart';
import 'package:providers_services/shared/controllers/generic.controller.dart';
import 'package:providers_services/ui/login/AppPreferenceHelper%20.dart';
import 'package:shared_preferences/shared_preferences.dart';

final AuthenticationService _service = Get.put(AuthenticationService());

class LoginController extends GenericController {
  static LoginController instance = Get.find();
  Mou3inaService mou3inaService = Get.find();
  final AppPreferenceHelper _helper = new AppPreferenceHelper();
  TextEditingController usernameController = TextEditingController();
  TextEditingController passwordController = TextEditingController();
  RxBool isVisible = true.obs;
  bool isLoading = false;
  final users = const {
    'dribbble@gmail.com': '12345',
    'hunter@gmail.com': 'hunter',
  };

  ValueNotifier<String> selectedAccountType = ValueNotifier<String>("");
  /*late*/ Mou3inaEntity? mou3ina;
  String? passwordd;
  String? usernamee;
  String? token;
  Duration get loginTime => Duration(milliseconds: 2250);
  Future<String?> authUser(Mou3inaEntity data, email) {
    debugPrint('Name: ${data.emailAdress}');
    return Future.delayed(loginTime).then((_) {
      if (!users.containsKey(data.name)) {
        return 'User not exists';
      }

      return null;
    });
  }

  /* signIn(String username, String password) async {
    
    SharedPreferences sharedPreferences = await SharedPreferences.getInstance();

 var  response= await mou3inaService.signin(username,password);
 print(username);
    print(password);
    print(response);
    print("mosbah");
     
     var   jsonResponse =  json.decode(response.body);
      print(jsonResponse);
       print("ggggg");
      if (jsonResponse != null) {
       var user = Mou3inaEntity.fromJson(jsonResponse);
          isLoading = false;
         sharedPreferences.setString("accessToken", jsonResponse['accessToken']);
      
        sharedPreferences.setString("username", jsonResponse['username']);
        sharedPreferences.setString("emailAdress", jsonResponse['emailAdress']); SharedPref.saveToken( jsonResponse['username'],
            jsonResponse['emailAdress'],);
          print(user.accessToken);
        Get.offAndToNamed(AppRoutes.categories);  
       
      }
    
    }
  */

  void onSubmit(bool isFormValid) async {
    final response =
        _service.login(usernameController.text, passwordController.text);
    print(usernameController.text);
    print("testlogin");
  }

/*  void _updateSelectedAccountType(String value) {
    controller.selectedAccountType.value = value;
  }*/

  void updateSelectedAccountType(String value) {
    selectedAccountType.value = value;
  }

  void confirmAction() {
    print('Type de compte sélectionné : ${selectedAccountType.value}');
  }

  @override
  void onInit() {
    super.onInit();
  }
}
