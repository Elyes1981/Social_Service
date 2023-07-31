

import 'package:providers_services/core/models/StatusModel.dart';
import 'package:providers_services/core/services/generic.service.dart';

class StatusService extends GenericService {
  @override
  void onInit() {
    super.onInit();
  }

//getListStatus
  Future<List<StatusModel>> findStatus() async {
    print("*********start methode find status ***************");
    List<StatusModel> response = await apiCall(
      '/Status',
      isPost: false,
      decoder: (json) =>
          (json as List<dynamic>).map((e) => StatusModel.fromJson(e)).toList(),
    );
    print("*********end methode find status ***************");

    return Future.value(response);
  }
}
