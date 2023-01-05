import 'package:demo/core/models/DelegationModel.dart';
import 'package:demo/core/models/GenderModel.dart';
import 'package:demo/core/models/GouvernoratModel.dart';
import 'package:demo/core/models/LangageModel.dart';
import 'package:demo/core/models/Mou3inaModel.dart';
import 'package:demo/core/models/OrdresModel.dart';
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
import 'package:demo/core/services/OrdresService.dart';
import 'package:demo/core/services/ReclamationService.dart';
import 'package:demo/core/services/ServiceType.dart';
import 'package:demo/core/services/StatusService.dart';
import 'package:demo/core/services/langageService.dart';
import 'package:demo/core/services/seniorityService.dart';
import 'package:demo/shared/controllers/generic.controller.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_date_picker/flutter_date_picker.dart';
import 'package:get/get.dart';

class ordresController extends GenericController{

    static ordresController instance = Get.find();
   
         Mou3inaService mou3inaService=Get.find();
         OrdersService ordersService=Get.find();
       RxBool isLoading = true.obs;  
   RxList ordresList = List<OrdesModel>.empty().obs;
   List<OrdesModel> rs=[];
   late List<Map<String, dynamic>>   cooptedList =[];
   
/*find() async {
   isLoading(true);
     print("amalnnnnn");
      print(isLoading);
   rs = await ordersService.findordres();
    isLoading(false);
   print(isLoading);
    print(rs);
    print("EEEEE");
     cooptedList = [
  {
    'value': rs[0].id,
    'label': rs[0].evening,
  
   
  },
  
];
   
  }
*/

  @override
  void onInit() {
 
 super.onInit();
  }

  
@override 
void onClose(){
  super.onClose();
}
}
  
 