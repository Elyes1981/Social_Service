
import 'package:flutter/material.dart';
import 'package:flutter_date_picker/flutter_date_picker.dart';
import 'package:get/get.dart';
import 'package:flutter_local_notifications/flutter_local_notifications.dart';
import 'package:providers_services/core/models/ReclamationModel.dart';
import 'package:providers_services/core/routes/app_routes.dart';
import 'package:providers_services/core/services/AuthenticationService.dart';
import 'package:providers_services/core/services/Mou3inaService.dart';
import 'package:providers_services/core/services/ReclamationService.dart';
import 'package:providers_services/shared/controllers/generic.controller.dart';
import 'package:providers_services/ui/login/AppPreferenceHelper%20.dart';
import 'package:providers_services/ui/profil/profilController.dart';

class ReclamationController extends GenericController{


    static ReclamationController instance = Get.find();
   
         Mou3inaService mou3inaService=Get.find();
         ReclamationService reclamationService=Get.find();

    final AppPreferenceHelper _helper = new AppPreferenceHelper();
    final AuthenticationService _service =Get.put(AuthenticationService());

    String? name;

    //
         //late FlutterLocalNotificationsPlugin flutterLocalNotificationsPlugin ;

  final List<Map<String, dynamic>> ListStatusReclamation = [
    {
      'value': 'urgent',
      'label': "52".tr,
     
    },
    {
      'value': 'non',
      'label': "53".tr,
      
    },
 
  ];

    



 late   TextEditingController message ;
 
String? statusReclamation;
 late ReclamationModel reclamation;



  @override
  void onInit() {
    /*flutterLocalNotificationsPlugin = new FlutterLocalNotificationsPlugin();
    //var android = new AndroidInitializationSettings('@mipmap/ic_launcher');
    final InitializationSettings initializationSettings = InitializationSettings(
        android: initializationSettingsAndroid,
        iOS: initializationSettingsDarwin)*/
    /*FlutterLocalNotificationsPlugin flutterLocalNotificationsPlugin = FlutterLocalNotificationsPlugin();
// initialise the plugin. app_icon needs to be a added as a drawable resource to the Android head project
    const AndroidInitializationSettings initializationSettingsAndroid =
    AndroidInitializationSettings('app_icon');
    final DarwinInitializationSettings initializationSettingsDarwin =
    DarwinInitializationSettings(
        onDidReceiveLocalNotification: onDidReceiveLocalNotification);
    final LinuxInitializationSettings initializationSettingsLinux =
    LinuxInitializationSettings(
        defaultActionName: 'Open notification');
    final InitializationSettings initializationSettings = InitializationSettings(
        android: initializationSettingsAndroid,
        iOS: initializationSettingsDarwin,
        macOS: initializationSettingsDarwin,
        linux: initializationSettingsLinux);
    await flutterLocalNotificationsPlugin.initialize(initializationSettings,
        onDidReceiveNotificationResponse: onDidReceiveNotificationResponse);*/
    //var ios = new IOSInitializationSettings() ;
    //var initSettigs = new InitializationSettings(android , iOS)

   message  = new  TextEditingController()  ;
    super.onInit();
   name=_helper.userId.toString();

  }


    @override
  void initialization() async {
    message = new TextEditingController();
    super.initialization();
  }


  Future<void> createReclamation() async {
    try {
     
      final ReclamationModel response = await reclamationService.create(reclamation, name);
    
      Get.offAndToNamed(AppRoutes.profil);
         
      initialization();
    } catch (e) {
      print(e);
    
    }
  }
  addReclamation(bool isValid) async {
    if (isValid) {
      reclamation = new ReclamationModel();
      reclamation.message = message.text;
      reclamation.status =statusReclamation;
       reclamation.idMou3ina =profilController.instance.name;
     

        

      await createReclamation();
       print("success");
    
      }else{ print("failed");}
      
    }
  


@override 
void onClose(){
  super.onClose();
}
}
  
 