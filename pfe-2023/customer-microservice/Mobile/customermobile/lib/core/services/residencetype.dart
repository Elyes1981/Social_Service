
/*import 'package:demo/core/models/residencetypeModel.dart';
import 'package:demo/core/services/generic.service.dart';*/
import '../models/residencetypeModel.dart';
import 'generic.service.dart';

class ResidenceType  extends GenericService {
  @override
  void onInit() {
    super.onInit();
  }
Future<List<ResidenceTypeModel>> findResidenceType() async {
  List<ResidenceTypeModel> response = await apiCall(
    '/residenceTypes',
    isPost: false,
    decoder: (json) =>
        (json as List<dynamic>).map((e) => ResidenceTypeModel.fromJson(e)).toList(),
  );
  
  return Future.value(response);
}



}
