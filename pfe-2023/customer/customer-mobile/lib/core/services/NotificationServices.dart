import 'dart:convert';
import 'dart:ffi';

import 'package:http/http.dart' as http;

import '../helper/AppPreferenceHelper .dart';
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
}
