import 'dart:convert';



import 'package:demo/core/models/OrdresModel.dart';
import 'package:demo/core/services/generic.service.dart';
class OrdersService extends GenericService {
  @override
  void onInit() {
    super.onInit();
  }

/*Future<List<OrdesModel>> findordres() async {
  List<OrdesModel> response = await apiCall(
    '/CustomerReservations/Reservations',
    isPost: false,
    decoder: (json) =>
        (json as List<dynamic>).map((e) => OrdesModel.fromJson(e)).toList(),
  );
  
  return Future.value(response);
}
*/


}