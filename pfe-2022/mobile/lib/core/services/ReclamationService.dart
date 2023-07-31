import 'dart:io';

import 'package:demo/core/models/Mou3inaModel.dart';
import 'package:demo/core/models/ReclamationModel.dart';
import 'package:demo/core/services/generic.service.dart';
import 'package:get/get_connect.dart';


class ReclamationService extends GenericService {
  @override
  void onInit() {
    super.onInit();
  }



Future<ReclamationModel> create(ReclamationModel reclamation) async {
  return await apiCall(
    '/Reclamation/newReclamation',
    isPost: true,
    body:reclamation.toJson(),
  );
}

}