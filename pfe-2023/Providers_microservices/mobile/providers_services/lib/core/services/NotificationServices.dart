import 'dart:convert';
import 'dart:ffi';

import 'package:http/http.dart' as http;
import 'package:providers_services/core/models/NotificationHistoryModel.dart';
import 'package:providers_services/ui/login/AppPreferenceHelper%20.dart';

import 'generic.service.dart';

class NotificationServices extends GenericService {
  final AppPreferenceHelper _helper = new AppPreferenceHelper();

  @override
  void onInit() {
    super.onInit();
  }

  Future<dynamic> confirmationPresence(int reservationId, String confirmation) async {
    Map data = {
      "confirmationPresence": confirmation,
      "reservationId": reservationId,
    };
    //encode Map to JSON
    var body = json.encode(data);
    var x = await http.post(Uri.parse('http://10.0.2.2:8978/confirmation-presence'),
        headers: <String, String>{"Content-Type": "application/json"},
        body: jsonEncode(data));
  }

  Future<List<notificationModel>>  findNotifications(String? id) async {
    httpClient.baseUrl = "http://10.0.2.2:8088";
    List<notificationModel> response = await apiCall('/notification/Provider/Notifications/$id',
      isPost: false,
      decoder: (json) =>
          (json as List<dynamic>).map((e) => notificationModel.fromJson(e)).toList(),
    );

    return Future.value(response);
  }

}
