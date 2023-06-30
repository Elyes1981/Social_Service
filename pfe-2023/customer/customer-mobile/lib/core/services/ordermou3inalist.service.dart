


import '../models/ordermou3inalist.dart';
import 'generic.service.dart';
class OrderMou3inaService  extends GenericService {
  @override
  void onInit() {
    super.onInit();
  }
Future<List<CustomerOrderMou3InaList>> findmou3inalist() async {
  List<CustomerOrderMou3InaList> response = await apiCall(
    '/CustomerReservations/orders',
    isPost: false,
    decoder: (json) =>
        (json as List<dynamic>).map((e) => CustomerOrderMou3InaList.fromJson(e)).toList(),
  );
  
  return Future.value(response);
}



}
