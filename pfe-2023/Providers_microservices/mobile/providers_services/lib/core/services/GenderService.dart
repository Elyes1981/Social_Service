
import 'package:providers_services/core/models/GenderModel.dart';
import 'package:providers_services/core/services/generic.service.dart';

class GenderService extends GenericService {
  @override
  void onInit() {
    super.onInit();
  }

//getListGender
  Future<List<GenderModel>> findGender() async {
    List<GenderModel> response = await apiCall(
      '/Gender',
      isPost: false,
      decoder: (json) =>
          (json as List<dynamic>).map((e) => GenderModel.fromJson(e)).toList(),
    );

    return Future.value(response);
  }
}
