import 'dart:convert';
import 'dart:io';

import 'package:demo/core/models/Mou3inaModel.dart';
import 'package:demo/core/services/generic.service.dart';
import 'package:get/get_connect.dart';


class Mou3inaService extends GenericService {
  @override
  void onInit() {
    super.onInit();
  }

  Future<List<Mou3inaEntity>> findMou3inas() async {
    List<Mou3inaEntity> response = await apiCall(
      '/Mou3inas',
      isPost: false,
      decoder: (json) => (json as List<dynamic>)
          .map((e) => Mou3inaEntity.fromJson(e))
          .toList(),
    );
    return Future.value(response);
  }
  Future<List<Map<String, dynamic>>> findMou3ina(String? id) async {
   List<Map<String, dynamic>>  response = await apiCall(
    '/Mou3inaa/$id',
    isPost: false,
    decoder: (json) =>
        (json as List<dynamic>).map((e) => Mou3inaEntity.fromJson(e)).toList(),
  );
  return response;
  }

Future<Mou3inaEntity> create(Mou3inaEntity mou3ina) async {
  return await apiCall(
    '/api/auth/signup',
    isPost: true,
    body:mou3ina.toJson(),
  );
}
Future signin(String username, String password) async {
  String data = jsonEncode({'username': username, 'password': password});
  return await apiCall(
    '/api/auth/signin',
    isPost: true,
    body:data,
  );
  
}
// ignore: non_constant_identifier_names
/* Future<int> Login(String username, String password) async {
  var res= await apiCall(
    '/api/auth/signin',
    isPost: true,
    body: {
        "username": username,
        "password": password
      }
    );
   return res.body;
   
  }*/
  

}
