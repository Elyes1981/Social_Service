import 'package:providers_services/core/models/cooptedBy.dart';
import 'package:providers_services/core/services/generic.service.dart';

class CooptedByService extends GenericService {
  @override
  void onInit() {
    super.onInit();
  }

//getListCooptedBy
  Future<List<CooptedByModel>> findCooptedBy() async {
    List<CooptedByModel> response = await apiCall(
      '/CooptedBy',
      isPost: false,
      decoder: (json) => (json as List<dynamic>)
          .map((e) => CooptedByModel.fromJson(e))
          .toList(),
    );

    return Future.value(response);
  }
}
