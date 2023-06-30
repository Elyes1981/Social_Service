
/*import 'package:demo/core/models/servicetypeModel.dart';
import 'package:demo/core/services/generic.service.dart';*/
import 'package:customermobile/core/models/mou3ina.dart';

import 'generic.service.dart';

class Mou3ina  extends GenericService {
  @override
  void onInit() {
    super.onInit();
  }
Future<List<Mou3Ina>> findMou3inaByServicesTypes(List<String> ids) async {
    print("###findMou3inaByServicesTypes");
  List<Mou3Ina> response = await apiCall(
    '/Mou3inas/search?ids='+ids.toString(),
    isPost: false,
    decoder: (json) =>
        (json as List<dynamic>).map((e) => Mou3Ina.fromJson(e)).toList(),
  );

  return Future.value(response);
}



}
