import 'dart:convert';

import 'package:providers_services/core/models/ServiceModel.dart';
import 'package:providers_services/core/services/generic.service.dart';


class ServiceType extends GenericService {
  @override
  void onInit() {
    super.onInit();
  }

  //getListService
  Future<List<ServiceModel>> findServiceTypes() async {
    print("*********start methode find serviceType ***************");
    List<ServiceModel> response = await apiCall(

      '/ServiceTypes',
      isPost: false,
      decoder: (json) =>
          (json as List<dynamic>).map((e) => ServiceModel.fromJson(e)).toList(),
    );
    print("*********end methode find serviceType ***************");
    print('SENT ${response}');



    return Future.value(response);
  }
}
