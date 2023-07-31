import 'dart:convert';

import 'package:demo/core/models/ServiceModel.dart';

import 'package:demo/core/services/generic.service.dart';
class ServiceType  extends GenericService {
  @override
  void onInit() {
    super.onInit();
  }
Future<List<ServiceModel>> findServiceType() async {
  List<ServiceModel> response = await apiCall(
    '/ServiceTypes',
    isPost: false,
    decoder: (json) =>
        (json as List<dynamic>).map((e) => ServiceModel.fromJson(e)).toList(),
  );
  
  return Future.value(response);
}



}