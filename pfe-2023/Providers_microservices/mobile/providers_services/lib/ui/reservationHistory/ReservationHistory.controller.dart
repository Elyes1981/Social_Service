import 'package:get/get.dart';
import 'package:providers_services/core/models/ProviderOrdersModel.dart';
import 'package:providers_services/core/models/reservationModel.dart';
import 'package:providers_services/core/services/AuthenticationService.dart';
import 'package:providers_services/core/services/reservation.service.dart';
import 'package:providers_services/shared/controllers/generic.controller.dart';
import 'package:providers_services/ui/login/AppPreferenceHelper%20.dart';

class ReservationHistoryController extends GenericController{

  static ReservationHistoryController instance = Get.find();
  ReservationService reservationService = Get.find();

  final AppPreferenceHelper _helper = new AppPreferenceHelper();
  final AuthenticationService _service =Get.put(AuthenticationService());
  //ResearchService researchService = Get.find();
  //OrderMou3inaService orderMou3inaService = Get.find();
  //RxList<researchModel> ResearchList=List<researchModel>.empty().obs;
  //RxList<CustomerOrderMou3InaList> mou3ina_orderlist=List<CustomerOrderMou3InaList>.empty().obs;
  //CustomerService customerService = Get.find();
  //late List<Map<String, dynamic>> GenderList = [];
  //late List<Map<String, dynamic>> StatusList = [];
  int? id;
  String? name;
  // late reservationModel reservation;
  //RxList<CustomerOrderMou3InaList> mou3ina_list=List<CustomerOrderMou3InaList>.empty().obs;
  //late Mou3Ina mou3inaSelected ;
  //late  Mou3Ina mou3inaSelected ;
  //Rx<customerModel> customer = customerModel().obs;

  Rx<reservationModel> reservation = reservationModel().obs;
  //RxList<customerModel> customerList=List<customerModel>.empty().obs;
  RxList<ProviderOrdersModel> ReservationList=List<ProviderOrdersModel>.empty().obs;
  //RxBool isloading = true.obs;
  double ? rankselected;
  var test="eyaa";


  @override
  void onInit() {
    super.onInit();

    name=_helper.userId.toString();
    findReserv();

  }

  /*findResearch() async {
    isloading(true);

    ResearchList.value= await researchService.findResearch();
    print("ss");
    print(ResearchList[0].firstname_Mou3ina);

    isloading(false);


  }*/
  updateContact(bool isValid) async {


    print("NOWWW");
    /*reservation.value = await reservationService.findoneReservation( Get.arguments.toString());

    reservation.value.rate=rankselected ;
    // print(reservation.rate.toStri)+"eeeee");
    //reservation.value.rate=4.0;
    dynamic response =await reservationService.updateReservation(reservation.value,Get.arguments.toString());
    print(response);*/
    //Get.offAndToNamed(AppRoutes.login);


  }
  /*updateCustomerpref(bool isValid) async {


    print("NOWWW");
    //cust.value = await reservationService.findoneReservation( Get.arguments.toString());

    //customerList[0].mou3inas_preferences!.add(mou3inaSelected);
    //print(customerList[0].mou3inas_preferences![1].id);
    // print(reservation.rate.toStri)+"eeeee");
    //reservation.value.rate=4.0;
    //dynamic response =await customerService.updateCustomer(customer.value,"2");
    //print("helllllooo"+response);
    //Get.offAndToNamed(AppRoutes.login);


  }*/

  findReserv() async {

    ReservationList.value = await reservationService.findReservation(name);

    print("test service");



  }

  Future<dynamic> confirmReservation(int? id) async {
    try {
      return await reservationService.confirmReservation(id);
    } catch (e) {
      print('Failed to confirm reservation: $e');
      return null;
    }
  }

  Future<dynamic> CancelReservation(int? id) async {
    try {
      return await reservationService.CancelReservation(id);
    } catch (e) {
      print('Failed to confirm reservation: $e');
      return null;
    }
  }



  String getStatusImage(String status) {
    if (status == "CONFIRMED") {
      return "assets/confirmed.png";
    } else if (status == "CANCELLED") {
      return "assets/cancelled.png";
    } else if (status == "COMPLETED") {
      return "assets/done.png";
    } else if (status == "PENDING") {
      return "assets/pending.png";
    }
    return "assets/PENDING.png";
  }


}
