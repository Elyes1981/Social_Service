import 'package:get/get.dart';
import 'package:providers_services/core/models/NotificationHistoryModel.dart';
import 'package:providers_services/core/models/ProviderOrdersModel.dart';
import 'package:providers_services/core/models/reservationModel.dart';
import 'package:providers_services/core/services/AuthenticationService.dart';
import 'package:providers_services/core/services/NotificationServices.dart';
import 'package:providers_services/core/services/reservation.service.dart';
import 'package:providers_services/shared/controllers/generic.controller.dart';
import 'package:providers_services/ui/login/AppPreferenceHelper%20.dart';

class NotificationHistoryController extends GenericController{

  static NotificationHistoryController instance = Get.find();

  NotificationServices notificationService = Get.find();

  final AppPreferenceHelper _helper = new AppPreferenceHelper();
  final AuthenticationService _service =Get.put(AuthenticationService());

  //int id=Get.arguments;

  int? id;
  String? name;

  Rx<notificationModel> notification = notificationModel().obs;
  RxList<notificationModel> NotificationList=List<notificationModel>.empty().obs;

  var test="eyaa";

  @override
  void onInit() {
    super.onInit();

    name=_helper.userId.toString();
    // findResearch();
    //findMou3inas();
    findNotif();
    // findoneReserv();
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
    //notification.value = await notificationService.findoneReservation( Get.arguments.toString());

    //notification.value.rate=rankselected ;
    // print(reservation.rate.toStri)+"eeeee");
    //reservation.value.rate=4.0;
    //dynamic response =await reservationService.updateReservation(notification.value,Get.arguments.toString());
    //print(response);
    //Get.offAndToNamed(AppRoutes.login);


  }
  updateCustomerpref(bool isValid) async {


    print("NOWWW");
    //cust.value = await reservationService.findoneReservation( Get.arguments.toString());

    //customerList[0].mou3inas_preferences!.add(mou3inaSelected);
    //print(customerList[0].mou3inas_preferences![1].id);
    // print(reservation.rate.toStri)+"eeeee");
    //reservation.value.rate=4.0;
    //dynamic response =await customerService.updateCustomer(customer.value,"2");
    //print("helllllooo"+response);
    //Get.offAndToNamed(AppRoutes.login);


  }

  findNotif() async {

    //isloading(true);

    NotificationList.value= await notificationService.findNotifications(name);
    print("test notifications");
    //print(ReservationList[1].OrderDay);

    //isloading(false);


  }

  String getStatusImage(String title) {
    if (title == "Approval") {
      return "assets/done.png";
    } else if (title == "Rappel") {
      return "assets/reminder.png";
    } else if (title == "Disapproval") {
      return "assets/cancelled.png";
    }
    return "assets/reminder.png";
  }


}
