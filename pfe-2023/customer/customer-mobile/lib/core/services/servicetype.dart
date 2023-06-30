
/*import 'package:demo/core/models/servicetypeModel.dart';
import 'package:demo/core/services/generic.service.dart';*/
import '../models/servicetypeModel.dart';
import 'generic.service.dart';

class ServiceType  extends GenericService {
  @override
  void onInit() {
    super.onInit();
  }
Future<List<ServiceTypeModel>> findServiceType() async {
  List<ServiceTypeModel> response = await apiCall(
    '/ServiceTypes',
    isPost: false,
    decoder: (json) =>
        (json as List<dynamic>).map((e) => ServiceTypeModel.fromJson(e)).toList(),
  );
  
  return Future.value(response);
}



}
