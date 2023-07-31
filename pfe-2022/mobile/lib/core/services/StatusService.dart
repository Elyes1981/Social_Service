
import 'package:demo/core/models/GenderModel.dart';
import 'package:demo/core/models/StatusModel.dart';
import 'package:demo/core/models/cooptedBy.dart';
import 'package:demo/core/services/generic.service.dart';
class StatusService  extends GenericService {
  @override
  void onInit() {
    super.onInit();
  }
Future<List<StatusModel>> findStatus() async {
  List<StatusModel> response = await apiCall(
    '/Status',
    isPost: false,
    decoder: (json) =>
        (json as List<dynamic>).map((e) => StatusModel.fromJson(e)).toList(),
  );
  
  return Future.value(response);
}



}