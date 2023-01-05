
import 'package:demo/core/models/seniorityModel.dart';
import 'package:demo/core/services/generic.service.dart';
class SeniorityService  extends GenericService {
  @override
  void onInit() {
    super.onInit();
  }
Future<List<SeniorityModel>> findseniority() async {
  List<SeniorityModel> response = await apiCall(
    '/Senioritys',
    isPost: false,
    decoder: (json) =>
        (json as List<dynamic>).map((e) => SeniorityModel.fromJson(e)).toList(),
  );
  
  return Future.value(response);
}



}