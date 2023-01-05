import 'package:demo/core/models/DelegationModel.dart';

import 'package:demo/core/services/generic.service.dart';
class delegationService  extends GenericService {
  @override
  void onInit() {
    super.onInit();
  }
Future<List<DelegationModel>> findDelagation() async {
  List<DelegationModel> response = await apiCall(
    '/Delegations',
    isPost: false,
    decoder: (json) =>
        (json as List<dynamic>).map((e) => DelegationModel.fromJson(e)).toList(),
  );
  
  return Future.value(response);
}



}