

import 'package:customermobile/core/models/mou3ina.dart';
import 'package:flutter/cupertino.dart';
import 'package:get/get.dart';

import '../../core/models/reservationModel.dart';
import '../../core/models/servicetypeModel.dart';
import '../../core/models/statusResModel.dart';
import '../../core/routes/app_routes.dart';
import '../../core/services/reservation.service.dart';
import '../../core/services/servicetype.dart';
import '../../core/services/mou3ina.dart';
import '../../core/services/statusRes.service.dart';
import '../../shared/controllers/generic.controller.dart';


class ReservationController extends GenericController{
  static ReservationController instance = Get.find();
  ServiceType  servicestype = Get.find();
  Mou3ina  mou3ina = Get.find();
  ReservationService reservationService = Get.find();
  StatusResService statusResService = Get.find();
  late RxList<dynamic> ServiceList=List<dynamic>.empty().obs;
  late List<Map<String, dynamic>> StatusResList = [];
  RxBool isloading = true.obs;
 RxList<String> selectedValues = List<String>.empty().obs;
  RxBool isSelected = true.obs;
    reservationModel ?reservation;
RxBool isPosting = false.obs;
//List<statusResModel> statusres = [];
  late TextEditingController statusres ;
  String? statusSelected;
  bool? morselect;
    bool? eveselect;
   bool? aftselect;
   bool? isRecSelect;
   DateTime? desiredselect;
  List<ServiceTypeModel> S = [];
  String? serviceselct;
  String?numSelect;
    RxBool isUpdated = false.obs;
  late TextEditingController desiredDate;
   late TextEditingController desiredHour;
  late TextEditingController numberOfMou3ina ;
    late TextEditingController paymentStatus;
  int selectedItemIndex = 0;



  @override
  void onInit() {
    
    numberOfMou3ina = new TextEditingController();
   // statusres = new TextEditingController();
    //paymentStatus  = new TextEditingController();
    desiredDate= new TextEditingController();
   //     desiredHour= new TextEditingController();


   findserviceType();
   //findStatusRes();
   
   super.onInit();
    
  }
  
  void initialization() async {

    numberOfMou3ina = new TextEditingController();
    //statusres = new TextEditingController();
    desiredDate = new TextEditingController();
   // desiredHour = new TextEditingController();
    
   //paymentStatus  = new TextEditingController();

    
    super.initialization();
  }

  Future<void> createReservation() async {
    try {
      final reservationModel response =
          await reservationService.createreservation(reservation!);

      Get.offAndToNamed(AppRoutes.login);
      print('sahaa');

      initialization();
    } catch (e) {
      print(e);
    }
  }

  addreservation(bool isvalid) async {
    // if (isvalid) {
      
      reservation = new reservationModel();
       
        //reservation?.numberOfMou3ina = int.parse(numberOfMou3ina.text);

     

     ServiceTypeModel service =S.firstWhere((element) => element.idService.toString() == serviceselct);
    // statusResModel stat =statusres.firstWhere((element) => element.code.toString() == statusSelected);

     print(service);
    // reservation?.serviceTypes = service;
     //reservation?.statuscode = stat;
     //reservation?.isRecurrent=isRecSelect;
    
      reservation?.evening = eveselect ;
      reservation?.morning = morselect;
      reservation?.afternoon = aftselect ;
     //reservation!.desiredHour=DateTime.parse(desiredHour.text);

     reservation!.desiredDate=DateTime.parse(desiredDate.text);
         print(eveselect);
         print(morselect);
         print(aftselect);
         
      await createReservation();
      print("added successfuly");
    /*} else {
      print("Error");
    }*/
  }
  findserviceType() async {
    isloading(true);
    List<ServiceTypeModel> rs = await servicestype.findServiceType();
        ServiceList.value=rs.map((e) => e.label).toList();
       //ServiceList.value=rs;

    print(ServiceList.value);
    //print(ServiceList.value[0]);
    isloading(false);
  
   isloading(false);
   // print(statusres[2].status_en);
  }

  void searchMou3ina(List<dynamic> selectedOptions) async{
    isloading(true);
    print("before searchMou3ina");
    List<String> strs = List<String>.from(selectedOptions);
    List<Mou3Ina> rs = await mou3ina.findMou3inaByServicesTypes(strs);
    print("after searchMou3ina");
    for (var value in rs) {
      print(value.firstName);

    };




    isloading(false);

  }
  
  /*findStatusRes() async {
    print("aywwwwwa");
    //isloading(true);
    statusres = await statusResService.findstatus();
    StatusResList = [
      {
        'value': statusres[0].code,
        'label': statusres[0].status_en,
      },
      {
        'value': statusres[1].code,
        'label': statusres[1].status_en,
      },
       {
        'value': statusres[0].code,
        'label': statusres[0].status_en,
      },
       {
        'value': statusres[0].code,
        'label': statusres[0].status_en,
      },
    ];
   // isloading(false);
   // print(statusres[2].status_en);
  }*/
  
  

  
  
  }