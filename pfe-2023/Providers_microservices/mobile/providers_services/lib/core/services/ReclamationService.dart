import 'dart:io';


import 'package:get/get_connect.dart';
import 'package:providers_services/core/models/ReclamationModel.dart';
import 'package:providers_services/core/services/generic.service.dart';

class ReclamationService extends GenericService {
  @override
  void onInit() {
    super.onInit();
  }

//getListReclamation
  Future<ReclamationModel> create(ReclamationModel reclamation ,String? id) async {
    return await apiCall(
      '/Reclamation/newReclamation/$id',
      isPost: true,
      body: reclamation.toJson(),
    );
  }
}
