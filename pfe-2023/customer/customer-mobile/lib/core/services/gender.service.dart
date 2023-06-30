
/*import 'package:demo/core/models/genderModel.dart';

import 'package:demo/core/services/generic.service.dart';*/
import '../models/genderModel.dart';
import 'generic.service.dart';

class GenderService  extends GenericService {
  @override
  void onInit() {
    super.onInit();
  }
Future<List<genderModel>> findgender() async {
  List<genderModel> response = await apiCall(
    '/genders',
    isPost: false,
    decoder: (json) =>
        (json as List<dynamic>).map((e) => genderModel.fromJson(e)).toList(),
  );
  
  return Future.value(response);
}



}
