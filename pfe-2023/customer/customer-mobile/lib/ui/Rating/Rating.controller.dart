
import 'package:flutter/cupertino.dart';
import 'package:get/get.dart';

import '../../core/models/customerModel.dart';
import '../../core/models/preferenceModel.dart';
import '../../core/models/reservationModel.dart';
import '../../core/routes/app_routes.dart';
import '../../core/services/preference.service.dart';
import '../../core/services/reservation.service.dart';
import '../../shared/controllers/generic.controller.dart';

class RatingController extends GenericController{
   static RatingController instance = Get.find();
     PreferenceService preferenceService = Get.find();

   RxList<preferencesModel> preferenceList=List<preferencesModel>.empty().obs;
   //RxList<reservationModel> ReservationList=List<reservationModel>.empty().obs;
   RxBool isloading = true.obs;
   double ? rankselected;
    late double rank;
    late customerModel customer;
    late preferencesModel preference;
   RxList<reservationModel> ReservationList=List<reservationModel>.empty().obs;
     ReservationService reservationService = Get.find();

late reservationModel reservation;
  @override
  void onInit() {
    // findResearch();
    // rank = new TextEditingController();
    super.onInit();
  }

 void initialization() async {
  //  rank = new TextEditingController();
    
    super.initialization();
  }

  Future<void> createPreference() async {
    try {
      final preferencesModel response =
          await preferenceService.createpreference(preference);

      Get.offAndToNamed(AppRoutes.reshistory);

      initialization();
    } catch (e) {
      print(e);
    }
  }

  addpreference(bool isvalid) async {
    if (isvalid) {
      preference = new preferencesModel();
      //preference.rank = rank;
     

     preference.rank= rankselected;
    
    
      
      await createPreference();
      print("added successfuly");
    } else {
      print("Error");
    }
  }

 findPreference() async {
    isloading(true);
  
preferenceList.value= await preferenceService.findpreference();
print("ss");
print(preferenceList[0].rank);
  
    isloading(false);
  

  }
  /*void updateContact(bool isValid, reservationModel reservation) async {
   
  

      try {
      final reservationModel response =
          await reservationService.updateReservation(reservation);

      Get.offAndToNamed(AppRoutes.login);

    } catch (e) {
      print(e);
    }
  }*/
}