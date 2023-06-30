import 'dart:convert';

import '../models/statusModel.dart';
import 'generic.service.dart';

/*import 'package:demo/core/models/statusModel.dart';
import 'package:demo/core/services/generic.service.dart';*/
class StatusService  extends GenericService {
  @override
  void onInit() {
    super.onInit();
  }
Future<List<statusModel>> findstatus() async {
  List<statusModel> response = await apiCall(
    '/statuss',
    isPost: false,
    decoder: (json) =>
        (json as List<dynamic>).map((e) => statusModel.fromJson(e)).toList(),
  );
  
  return Future.value(response);
}



}
