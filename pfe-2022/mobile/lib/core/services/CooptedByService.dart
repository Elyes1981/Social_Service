
import 'package:demo/core/models/cooptedBy.dart';
import 'package:demo/core/services/generic.service.dart';
class CooptedByService  extends GenericService {
  @override
  void onInit() {
    super.onInit();
  }
Future<List<CooptedByModel>> findCooptedBy() async {
  List<CooptedByModel> response = await apiCall(
    '/CooptedBy',
    isPost: false,
    decoder: (json) =>
        (json as List<dynamic>).map((e) => CooptedByModel.fromJson(e)).toList(),
  );
  
  return Future.value(response);
}



}