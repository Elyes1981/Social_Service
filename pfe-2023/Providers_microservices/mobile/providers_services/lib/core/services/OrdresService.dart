import 'dart:convert';

import 'package:providers_services/core/models/CustomerOrderMou3inaList.dart';
import 'package:providers_services/core/services/generic.service.dart';
import 'package:http/http.dart' as http;



class OrdersService extends GenericService {
  @override
  void onInit() {
    super.onInit();
  }

  Future<List<CustomerOrderMou3inaList>> getReservationsByProviderId(int id) async {
    final url = 'http://10.0.2.2:8978/CustomerReservations/ProviderOrder/$id';

    final response = await http.get(Uri.parse(url));

    if (response.statusCode == 200) {
      final data = jsonDecode(response.body) as List<dynamic>;
      final reservations = data.map((item) {
        return CustomerOrderMou3inaList(
          id: item['id'],
          //orderDay: DateTime.parse(item['OrderDay']),
          serviceCost: item['serviceCost'].toDouble(),
          rank: item['Rank'],
        );
      }).toList();

      return reservations;
    } else {
      throw Exception('Failed to fetch reservations');
    }
  }

  /*Future<List<CustomerOrderMou3inaList>> getReservationsByProviderId(int? id) async {
    List<Map<String, dynamic>> response = await apiCall(
      'http://10.0.2.2:8978/CustomerReservations/ProviderOrder/$id',
      isPost: false,
      decoder: (json) =>
          (json as List<dynamic>).map((e) => CustomerOrderMou3inaList.fromJson(e)).toList(),
    );

    List<CustomerOrderMou3inaList> orders = response.map((e) => CustomerOrderMou3inaList.fromJson(e)).toList();
    return orders;
  }*/

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