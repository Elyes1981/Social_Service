import 'dart:convert';
import 'package:http/http.dart' as http;
import 'package:flutter/material.dart';
import 'package:flutter_date_picker/flutter_date_picker.dart';
import 'package:get/get.dart';
import 'package:providers_services/core/models/CustomerOrderMou3inaList.dart';
import 'package:providers_services/core/models/OrdresModel.dart';
import 'package:providers_services/core/services/Mou3inaService.dart';
import 'package:providers_services/core/services/OrdresService.dart';
import 'package:providers_services/shared/controllers/generic.controller.dart';

class ordresController extends GenericController {

  static ordresController instance = Get.find();
  Mou3inaService mou3inaService = Get.find();
  OrdersService ordersService = Get.find();
  RxBool isLoading = true.obs;
  RxList reservations = List<CustomerOrderMou3inaList>.empty().obs;
  List<CustomerOrderMou3inaList> ProviderReservations = [];
  RxList<CustomerOrderMou3inaList> mou3ina_orderlist = List<CustomerOrderMou3inaList>.empty().obs;

  /*Future<List<CustomerOrderMou3inaList>>  findReservation() async {
 List<reservationModel> response = await apiCall('http://10.0.2.2:8978/CustomerReservations/ProviderOrder/97',
    isPost: false,
     decoder: (json) =>
        (json as List<dynamic>).map((e) => CustomerOrderMou3inaList.fromJson(e)).toList(),
  );

  return Future.value(response);
}
*/

  Future <List<CustomerOrderMou3inaList>> fetchCustomerOrders() async {
    final response = await http.get(
      Uri.parse('http://10.0.2.2:8978/CustomerReservations/ProviderOrder/97'),
    );
    if (response.statusCode == 200) {
      var jsonResponse = json.decode(response.body);
      //RxList<CustomerOrderMou3inaList> orders = [];
      for (var u in jsonResponse) {
        CustomerOrderMou3inaList order =
        CustomerOrderMou3inaList(id: u['id'],
            //orderDay: u['OrderDay'],
            rank: u['Rank'],
            serviceCost: u['serviceCost']);
        mou3ina_orderlist.add(order);
      }
      return mou3ina_orderlist;
    } else {
      throw Exception('Failed to load post');
    }
  }

  findResearch() async {

    isLoading(true);
    mou3ina_orderlist.value= await fetchCustomerOrders();
    isLoading(false);


    //print(mou3ina_orderlist[1].OrderDay);
    print("ss");

  }


  @override
  void onInit() {
    findResearch();
    super.onInit();
  }

  @override
  void onClose() {
    super.onClose();
  }
}
