
/*import 'package:demo/core/models/statusResModel.dart';
import 'package:demo/core/services/generic.service.dart';*/
import '../models/statusResModel.dart';
import 'generic.service.dart';

class StatusResService  extends GenericService {
  @override
  void onInit() {
    super.onInit();
  }
Future<List<statusResModel>> findstatus() async {
  List<statusResModel> response = await apiCall(
    '/statusReservation',
    isPost: false,
    decoder: (json) =>
        (json as List<dynamic>).map((e) => statusResModel.fromJson(e)).toList(),
  );
  
  return Future.value(response);
}



}
