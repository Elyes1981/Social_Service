

import 'package:providers_services/core/models/seniorityModel.dart';
import 'package:providers_services/core/services/generic.service.dart';

class SeniorityService extends GenericService {
  @override
  void onInit() {
    super.onInit();
  }

  //getListSeniority
  Future<List<SeniorityModel>> findseniority() async {
    print('start methode seno');
    List<SeniorityModel> response = await apiCall(
      '/Senioritys',
      isPost: false,
      decoder: (json) => (json as List<dynamic>)
          .map((e) => SeniorityModel.fromJson(e))
          .toList(),
    );
    print('end methode seno');


    return Future.value(response);
  }
}
