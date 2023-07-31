import 'package:demo/core/models/DelegationModel.dart';
import 'package:demo/core/models/GenderModel.dart';
import 'package:demo/core/models/GouvernoratModel.dart';
import 'package:demo/core/models/LangageModel.dart';
import 'package:demo/core/models/Mou3inaModel.dart';
import 'package:demo/core/models/ReclamationModel.dart';
import 'package:demo/core/models/ServiceModel.dart';
import 'package:demo/core/models/StatusModel.dart';
import 'package:demo/core/models/cooptedBy.dart';
import 'package:demo/core/models/seniorityModel.dart';
import 'package:demo/core/routes/app_routes.dart';
import 'package:demo/core/services/CooptedByService.dart';
import 'package:demo/core/services/DelegationService.dart';
import 'package:demo/core/services/GenderService.dart';
import 'package:demo/core/services/GouvernoratService.dart';
import 'package:demo/core/services/Mou3inaService.dart';
import 'package:demo/core/services/ReclamationService.dart';
import 'package:demo/core/services/ServiceType.dart';
import 'package:demo/core/services/StatusService.dart';
import 'package:demo/core/services/langageService.dart';
import 'package:demo/core/services/seniorityService.dart';
import 'package:demo/shared/controllers/generic.controller.dart';
import 'package:demo/ui/profil/profilController.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_date_picker/flutter_date_picker.dart';
import 'package:get/get.dart';

class ReclamationController extends GenericController{

    static ReclamationController instance = Get.find();
   
         Mou3inaService mou3inaService=Get.find();
         ReclamationService reclamationService=Get.find();
         
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
  
  
  
   message  = new  TextEditingController()  ;

   
     
   
    super.onInit();
  }

    @override
  void initialization() async {
  
    message = new TextEditingController();
  

 
  
  
  
    super.initialization();
  }


  Future<void> createReclamation() async {
    try {
     
      final ReclamationModel response = await reclamationService.create(reclamation);
    
      Get.offAndToNamed(AppRoutes.login);
         
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
  
 