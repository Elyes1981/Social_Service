
/*import 'package:demo/core/models/customerModel.dart';
import 'package:demo/core/models/customercomplainModel.dart';

import 'package:demo/core/services/generic.service.dart';*/
import '../models/customercomplainModel.dart';
import 'generic.service.dart';

class CusComplainService  extends GenericService {
  @override
  void onInit() {
    super.onInit();
  }
Future<customercomplainModel> createcomplain( customercomplainModel cuscomplain) async {
 return await apiCall(
    '/customercomplains',
    isPost: true,
    body: cuscomplain.toJson(),

  );
  
  
  
}

Future<List<customercomplainModel>>  findcomplains() async {
 List<customercomplainModel> response = await apiCall('/customercomplains',
    isPost: false,
     decoder: (json) =>
        (json as List<dynamic>).map((e) => customercomplainModel.fromJson(e)).toList(),
  );
print('ttested');
  return Future.value(response);
}


}
