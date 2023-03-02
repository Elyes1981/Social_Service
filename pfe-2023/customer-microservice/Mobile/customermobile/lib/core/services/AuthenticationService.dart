/*
import 'dart:convert';
import 'package:demo/core/helper/AppPreferenceHelper%20.dart';
import 'package:flutter/cupertino.dart';


import 'package:demo/core/models/api_response.model.dart';
import 'package:demo/core/services/generic.service.dart';

import 'package:path_provider/path_provider.dart';
*/
import 'package:get/get.dart';
import 'package:http/http.dart' as http;

import 'dart:convert';

import '../helper/AppPreferenceHelper .dart';
import 'generic.service.dart';

class AuthenticationService extends GenericService {
  final AppPreferenceHelper _helper = new AppPreferenceHelper();

  @override
  void onInit() {
    super.onInit();
  }


  Future<dynamic> login(String username, String password) async {
      Map data = {
   "username": username,
        "password": password,};
  //encode Map to JSON
  var body = json.encode(data);
   var x= await http.post(Uri.parse('http://10.0.2.2:8978/api/auth/signin'), 
       headers: <String, String>{"Content-Type": "application/json"},
    body:jsonEncode(data));
    Map<String, dynamic> responseJson = json.decode(x.body);
//print(responseJson['id']);
print(x.body);  
      // String jwt = response.headers?[AppPreferences.TOKEN_HEADER];
       await _helper.saveAuthToken(responseJson['accessToken']);
       _helper.saveIsLoggedIn(true);
       _helper.saveUserID(responseJson['id'].toString());
 return  x.body ;
      }
    
      

      
  

    


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



