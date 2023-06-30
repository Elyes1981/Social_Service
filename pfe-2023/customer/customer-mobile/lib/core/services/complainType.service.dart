
/*import 'package:demo/core/models/complainTypeModel.dart';
import 'package:demo/core/models/genderModel.dart';
import 'package:demo/core/models/sousTypesModel.dart';

import 'package:demo/core/services/generic.service.dart';*/

import '../models/complainTypeModel.dart';
import 'generic.service.dart';
class ComplainTypeService  extends GenericService {
  @override
  void onInit() {
    super.onInit();
  }
Future<List<complainTypeModel>> findcomplainType() async {
  List<complainTypeModel> response = await apiCall(
    '/complains',
    isPost: false,
    decoder: (json) =>
        (json as List<dynamic>).map((e) => complainTypeModel.fromJson(e)).toList(),
  );
  
  return Future.value(response);
}



}
