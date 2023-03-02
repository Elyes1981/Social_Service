/*import 'package:demo/core/models/customerModel.dart';
import 'package:demo/core/models/genderModel.dart';
import 'package:demo/core/models/statusModel.dart';
import 'package:demo/core/routes/app_routes.dart';
import 'package:demo/core/services/customer.service.dart';
import 'package:demo/core/services/gender.service.dart';
import 'package:demo/core/services/status.service.dart';
import 'package:demo/shared/controllers/generic.controller.dart';*/
import 'package:flutter/cupertino.dart';
import 'package:get/get.dart';

import '../../core/models/customerModel.dart';
import '../../core/models/genderModel.dart';
import '../../core/models/statusModel.dart';
import '../../core/routes/app_routes.dart';
import '../../core/services/customer.service.dart';
import '../../core/services/gender.service.dart';
import '../../core/services/status.service.dart';
import '../../shared/controllers/generic.controller.dart';

class RegisterController extends GenericController {
  static RegisterController instance = Get.find();
  StatusService statusService = Get.find();
  GenderService genderService = Get.find();
  CustomerService customerService = Get.find();
late List<Map<String, dynamic>> GenderList = [];
  late List<Map<String, dynamic>> StatusList = [];
   
   RxList<customerModel> customerList=List<customerModel>.empty().obs;
  RxBool isloading = true.obs;
  RxList<String> selectedValues = List<String>.empty().obs;
  RxBool isSelected = true.obs;
  late TextEditingController firstName;
  late TextEditingController lastName;
  late TextEditingController phone;
  late TextEditingController emailAdress;
  late TextEditingController birthDate;
  late customerModel customer;
  List<genderModel> g = [];
  String? genderSelected;
  List<statusModel> statuss = [];
  String? statusSelected;

  @override
  void onInit() {
    findGender();
    //findCustomer();
    findStatus();
    firstName = new TextEditingController();
    lastName = new TextEditingController();
    phone = new TextEditingController();
    emailAdress = new TextEditingController();
birthDate= new TextEditingController();
    super.onInit();
  }

  void initialization() async {
    firstName = new TextEditingController();
    lastName = new TextEditingController();
    phone = new TextEditingController();
    emailAdress = new TextEditingController();
    birthDate= new TextEditingController();

    super.initialization();
  }

 Future<void> createCustomer() async {
    try {
      final customerModel response =
          await customerService.createcustomer(customer);

      Get.offAndToNamed(AppRoutes.login);

      initialization();
    } catch (e) {
      print(e);
    }
  }

  addcustomer(bool isvalid) async {
    if (isvalid) {
      customer = new customerModel();
      customer.firstName = firstName.text;
      customer.lastName = lastName.text;
      customer.phone = phone.text;
      customer.emailAdress = emailAdress.text;
customer.birthDate=DateTime.parse(birthDate.text);
      genderModel genre =
          g.firstWhere((element) => element.id.toString() == genderSelected);
      statusModel stat =
          statuss.firstWhere((element) => element.id.toString() == statusSelected);

      print(customer.birthDate);
      customer.gender = genre;
      customer.status = stat;
      
      /*await createCustomer();*/
      print("added successfuly");
    } else {
      print("Error");
    }
  }

  findGender() async {
    //isloading(true);
    g = await genderService.findgender();

    GenderList = [
      {
        'value': g[0].id,
        'label': g[0].label,
      },
      {
        'value': g[1].id,
        'label': g[1].label,
      },
    ];

   // isloading(false);
  }

  findStatus() async {
   // isloading(true);
    statuss = await statusService.findstatus();
    StatusList = [
      {
        'value': statuss[0].id,
        'label': statuss[0].label,
      },
      {
        'value': statuss[1].id,
        'label': statuss[1].label,
      },
       {
        'value': statuss[2].id,
        'label': statuss[2].label,
      },
    ];
   // isloading(false);
  }

save(String value){
   print(selectedValues);
  isSelected.value=true;
  selectedValues.add(value);
  print(selectedValues);
  isSelected.value=false;
}
 findCustomer() async {
   // isloading(true);
    print("testtt");

customerList.value= await customerService.findcustomer();

print("ssttt");

    print(customerList.length.toString());
   
   // isloading(false);
  

  }
}
