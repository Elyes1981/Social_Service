
import 'dart:convert';

import 'package:get/get.dart';

import '../../core/models/ResearchResult.dart';
import '../../core/models/customerModel.dart';
import '../../core/models/mou3ina.dart';
import '../../core/models/ordermou3inalist.dart';
import '../../core/models/reservationModel.dart';
import '../../core/services/customer.service.dart';
import '../../core/services/ordermou3inalist.service.dart';
import '../../core/services/research.service.dart';
import '../../core/services/reservation.service.dart';
import '../../shared/controllers/generic.controller.dart';
import 'dart:convert';

class ReservationHistoryController extends GenericController{
   static ReservationHistoryController instance = Get.find();
   ResearchService researchService = Get.find();
   OrderMou3inaService orderMou3inaService = Get.find();
   ReservationService reservationService = Get.find();
   RxList<researchModel> ResearchList=List<researchModel>.empty().obs;
      RxList<CustomerOrderMou3InaList> mou3ina_orderlist=List<CustomerOrderMou3InaList>.empty().obs;
CustomerService customerService = Get.find();
late List<Map<String, dynamic>> GenderList = [];
  late List<Map<String, dynamic>> StatusList = [];
   int id=Get.arguments;
   // late reservationModel reservation;
   RxList<CustomerOrderMou3InaList> mou3ina_list=List<CustomerOrderMou3InaList>.empty().obs;
 //late Mou3Ina mou3inaSelected ;
   late  Mou3Ina mou3inaSelected ;
    Rx<customerModel> customer = customerModel().obs;

    Rx<reservationModel> reservation = reservationModel().obs;
   RxList<customerModel> customerList=List<customerModel>.empty().obs;
   RxList<reservationModel> ReservationList=List<reservationModel>.empty().obs;
  // RxBool isloading = false.obs;
   double ? rankselected;
  var test="eyaa";
  
  @override
  void onInit() {
    // findResearch();
    //findMou3inas();
    print('marwen');
    findReserv();

   // findoneReserv();
    super.onInit();
  }

  findResearch() async {
   // isloading(true);
  
ResearchList.value= await researchService.findResearch();
print("ss");
print(ResearchList[0].firstname_Mou3ina);
  
  //  isloading(false);
  

  }
 updateContact(bool isValid) async {
   
  
print("NOWWW");
       reservation.value = await reservationService.findoneReservation( Get.arguments);

      reservation.value.rate=rankselected ;
       // print(reservation.rate.toStri)+"eeeee");
       //reservation.value.rate=4.0;
        dynamic response =await reservationService.updateReservation(reservation.value,Get.arguments.toString());
print(response);
      //Get.offAndToNamed(AppRoutes.login);

   
  }
 /* updateCustomerpref(bool isValid) async {
   
  
print("NOWWW");
       //cust.value = await reservationService.findoneReservation( Get.arguments.toString());

      customerList[0].mou3inas_preferences!.add(mou3inaSelected);
      print(customerList[0].mou3inas_preferences![1].id);
       // print(reservation.rate.toStri)+"eeeee");
       //reservation.value.rate=4.0;
        dynamic response =await customerService.updateCustomer(customer.value,"2");
print("helllllooo"+response);
      //Get.offAndToNamed(AppRoutes.login);

   
  }*/
   findReserv() async {


     //isloading(true);
  ReservationList.value= await reservationService.findReservation();
print(ReservationList[1].desiredDate);
print(ReservationList[0].id);
  
   // isloading(false);
  

  }
  findoneReserv() async {

   // isloading(true);
  
 reservation.value = await reservationService.findoneReservation( Get.arguments);
//print("taw"+reservation.value.id.toString());
//print("helooo"+reservation.value.rate.toString()); 
 // isloading(false);
  

  }

   findMou3inas() async {

  //  isloading(true);
  
 mou3ina_list.value = await reservationService.findmou3inasInRes( Get.arguments.toString());
//print("taw"+mou3ina_list[0].mou3Ina!.firstName.toString());
//print("helooo"+reservation.value.rate.toString()); 
 // isloading(false);
  

  }

  findCustomer() async {
  //  isloading(true);
    print("testtt");

customerList.value= await customerService.findcustomer();

print("ssttt");

    print(customerList.length.toString());
   
   // isloading(false);
  

  /* findMou3inas() async {

     isloading(true);
  
mou3ina_orderlist.value= await orderMou3inaService.findmou3inalist();
print("test");
print(mou3ina_orderlist[0].mou3Ina!.firstName.toString());
  
    isloading(false);
  

  }*/

}}