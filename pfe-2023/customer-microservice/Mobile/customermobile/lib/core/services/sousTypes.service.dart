
/*import 'package:demo/core/models/sousTypesModel.dart';

import 'package:demo/core/services/generic.service.dart';*/
import '../models/sousTypesModel.dart';
import 'generic.service.dart';

class SousTypesService  extends GenericService {
  @override
  void onInit() {
    super.onInit();
  }
Future<List<sousTypesModel>> findsousTypes() async {
  List<sousTypesModel> response = await apiCall(
    '/soustypes',
    isPost: false,
    decoder: (json) =>
        (json as List<dynamic>).map((e) => sousTypesModel.fromJson(e)).toList(),
  );
  
  return Future.value(response);
}



}
