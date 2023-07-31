import 'dart:convert';
import 'package:http/http.dart' as http;
import 'package:get/get.dart';
import 'package:providers_services/core/routes/app_routes.dart';
import 'package:providers_services/core/services/generic.service.dart';
import 'package:providers_services/ui/login/AppPreferenceHelper%20.dart';


class AuthenticationService extends GenericService {
  final AppPreferenceHelper _helper = new AppPreferenceHelper();

  @override
  void onInit() {
    super.onInit();
  }

//login in
  Future<dynamic> login(String username, String password) async {
    Map data = {
      "username": username,
      "password": password,
    };
    //http://172.20.10.3
    //encode Map to JSON
    var body = json.encode(data);
    var x = await http.post(Uri.parse('http://10.0.2.2:8088/api/auth/signin'),
        headers: <String, String>{"Content-Type": "application/json"},
        body: jsonEncode(data));
    Map<String, dynamic> responseJson = json.decode(x.body);
//print(responseJson['id']);
    print(x.body);
    // String jwt = response.headers?[AppPreferences.TOKEN_HEADER];
    await _helper.saveAuthToken(responseJson['accessToken']);
    _helper.saveIsLoggedIn(true);
    _helper.saveUserID(responseJson['id'].toString());
    _helper.saveUserEmail(responseJson['emailAdress'].toString());
    _helper.saveUserName(responseJson['username'].toString());
    _helper.saveUserFirst(responseJson['firstName'].toString());
    Get.offAndToNamed(AppRoutes.categories);

    return x.body;
  }

//log out
  Future<dynamic> logout() async {
    return apiCall('api/auth/logout',
            decoder: (value) => GetUtils.isBool(value.toString()), body: null)
        .then((value) async {
      if (value) {
        await _helper.removeAuthToken();
        await _helper.saveIsLoggedIn(false);
      }
      return value;
    });
  }
}
