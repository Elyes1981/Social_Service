import 'package:providers_services/core/models/ProviderOrdersModel.dart';
import 'package:providers_services/core/models/reservationModel.dart';
import 'package:providers_services/core/services/generic.service.dart';
import 'package:providers_services/ui/login/AppPreferenceHelper%20.dart';
import 'package:http/http.dart' as http;


class ReservationService  extends GenericService {

  final AppPreferenceHelper _helper = new AppPreferenceHelper();

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

  Future<List<ProviderOrdersModel>>  findReservation(String? id ) async {
    httpClient.baseUrl = "http://10.0.2.2:8978";
    List<ProviderOrdersModel> response = await apiCall('/CustomerReservations/ProviderOrder/$id',
      isPost: false,
      decoder: (json) =>
          (json as List<dynamic>).map((e) => ProviderOrdersModel.fromJson(e)).toList(),
    );

    return Future.value(response);
  }


  Future<reservationModel>  findoneReservation(String id) async {
    reservationModel response = await apiCall('/CustomerReservations/'+id,
        isPost: false,
        decoder: (json) => reservationModel.fromJson(json));
    print("nnnn");

    return Future.value(response);
  }

  Future<dynamic> confirmReservation(int? id) async {
    httpClient.baseUrl = "http://10.0.2.2:8978";
    return await apiCall('/CustomerReservations/$id/ConfirmReservation',
        isPost: false,
        isPut: true);

    }

  Future<dynamic> CancelReservation(int? id) async {
    httpClient.baseUrl = "http://10.0.2.2:8978";
    return await apiCall('/CustomerReservations/$id/CancelReservation',
        isPost: false,
        isPut: true);

  }


  /*Future<List<CustomerOrderMou3InaList>> findmou3inasInRes(String id) async {
    List<CustomerOrderMou3InaList> response = await apiCall('/CustomerReservations/customerReservations/mou3ina/'+id,
      isPost: false,
      decoder: (json) =>
          (json as List<dynamic>).map((e) => CustomerOrderMou3InaList.fromJson(e)).toList(),);
    return Future.value(response);

    //return Future.value(response);
  }*/



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
