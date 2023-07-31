
import 'package:demo/core/models/GenderModel.dart';
import 'package:demo/core/models/cooptedBy.dart';
import 'package:demo/core/services/generic.service.dart';
class GenderService  extends GenericService {
  @override
  void onInit() {
    super.onInit();
  }
Future<List<GenderModel>> findGender() async {
  List<GenderModel> response = await apiCall(
    '/Gender',
    isPost: false,
    decoder: (json) =>
        (json as List<dynamic>).map((e) => GenderModel.fromJson(e)).toList(),
  );
  
  return Future.value(response);
}



}