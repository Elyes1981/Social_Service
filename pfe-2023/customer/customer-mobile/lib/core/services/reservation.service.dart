import 'dart:convert';
import 'dart:ffi';
import '../models/ordermou3inalist.dart';
import '../models/reservationModel.dart';
import 'generic.service.dart';
class ReservationService  extends GenericService {
  @override
  void onInit() {
    super.onInit();
  }
Future<reservationModel> createreservation( reservationModel reservation) async {
 return await apiCall(
    '/CustomerReservations',
    isPost: true,
    body: reservation.toJson(),

  );

}

Future<List<reservationModel>>  findReservation() async {
 List<reservationModel> response = await apiCall('/CustomerReservations',
    isPost: false,
     decoder: (json) =>
        (json as List<dynamic>).map((e) => reservationModel.fromJson(e)).toList(),
  );

  return Future.value(response);
}
Future<reservationModel>  findoneReservation(Long id) async {
 reservationModel response = await apiCall('/CustomerReservations/1',
    isPost: false,
     decoder: (json) => reservationModel.fromJson(json));
  print("nnnn");

  return Future.value(response);
}
Future<List<CustomerOrderMou3InaList>> findmou3inasInRes(String id) async {
  List<CustomerOrderMou3InaList> response = await apiCall('/CustomerReservations/customerReservations/mou3ina/'+id,
    isPost: false,
     decoder: (json) =>
        (json as List<dynamic>).map((e) => CustomerOrderMou3InaList.fromJson(e)).toList(),);
        return Future.value(response);

  //return Future.value(response);
}

 /* Future<reservationModel> updateReservation(reservationModel reservation,String id) async {
    return await apiCall('/CustomerReservations/'+id,
        body: reservation.toJson(), isPost: false, isPut: true);
  }*/

Future<dynamic> updateReservation(reservationModel reservation,String id) async {
    return await apiCall(
        '/CustomerReservations/'+id,
        isPost: false,
        isPut: true,
        body: reservation.toJson());
        print("hola");
  }
}
