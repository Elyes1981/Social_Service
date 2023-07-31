import 'package:get/get.dart';
import 'package:flutter/material.dart';
import 'package:providers_services/core/models/Mou3inaModel.dart';
import 'package:providers_services/core/routes/app_routes.dart';
import 'package:providers_services/core/services/AuthenticationService.dart';
import 'package:providers_services/core/services/Mou3inaService.dart';
import 'package:providers_services/shared/controllers/generic.controller.dart';
import 'package:providers_services/ui/login/AppPreferenceHelper%20.dart';
import 'package:shared_preferences/shared_preferences.dart';

class profilController extends GenericController {
  static profilController instance = Get.find();
  final AppPreferenceHelper _helper = new AppPreferenceHelper();
  final AuthenticationService _service = Get.put(AuthenticationService());
  Mou3inaService mou3inaService = Get.find();
  Rx<Mou3inaEntity> provider = Mou3inaEntity().obs;
  String? name;
  String? emaill;
  String? usernName;
  String? fist;
  String? lastName;
  int? id;

  @override
  void onInit() {
    name = _helper.userId.toString();

    emaill = _helper.email;
    usernName = _helper.username;
    fist = _helper.firstName;
    super.onInit();
    find();
  }

  void Out() async {
    final response = _service.logout();
    Get.offAndToNamed(AppRoutes.login);
  }

  void find() async {
    provider.value = (await mou3inaService.findMou3ina(name)) as Mou3inaEntity;
    print(provider.value.firstName!);
    print("helooo");
  }
}
