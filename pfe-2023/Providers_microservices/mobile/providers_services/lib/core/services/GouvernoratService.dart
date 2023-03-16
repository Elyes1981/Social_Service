

import 'package:providers_services/core/models/GouvernoratModel.dart';
import 'package:providers_services/core/services/generic.service.dart';

class GouvernoratService extends GenericService {
  @override
  void onInit() {
    super.onInit();
  }

//getListGouvernorat
  Future<List<GouvernoratModel>> find() async {
    List<GouvernoratModel> response = await apiCall(
      '/Gouvernorats',
      isPost: false,
      decoder: (json) => (json as List<dynamic>)
          .map((e) => GouvernoratModel.fromJson(e))
          .toList(),
    );

    return Future.value(response);
  }
}
