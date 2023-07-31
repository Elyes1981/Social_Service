import 'dart:convert';

/*import 'package:demo/core/services/AuthenticationService.dart';
import 'package:demo/shared/controllers/generic.controller.dart';*/
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:get/get_connect/http/src/status/http_status.dart';

import '../../core/services/AuthenticationService.dart';
import '../../shared/controllers/generic.controller.dart';

class LoginController extends GenericController{
  TextEditingController usernameController = TextEditingController();
  TextEditingController passwordController = TextEditingController();
  RxBool isVisible = true.obs;
   RxBool isloading = true.obs;
 final AuthenticationService _service =Get.put(AuthenticationService());

  @override
  void onInit() {
    // TODO: implement onInit
    super.onInit();
  }
  
  void onSubmit(bool isFormValid) async {
     final response =  _service.login(usernameController.text,passwordController.text);
     print(response);
    }
}
