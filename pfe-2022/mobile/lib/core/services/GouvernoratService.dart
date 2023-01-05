
import 'package:demo/core/models/GenderModel.dart';
import 'package:demo/core/models/GouvernoratModel.dart';
import 'package:demo/core/models/StatusModel.dart';
import 'package:demo/core/models/cooptedBy.dart';
import 'package:demo/core/services/generic.service.dart';
class GouvernoratService  extends GenericService {
  @override
  void onInit() {
    super.onInit();
  }
Future<List<GouvernoratModel>> find() async {
  List<GouvernoratModel> response = await apiCall(
    '/Gouvernorats',
    isPost: false,
    decoder: (json) =>
        (json as List<dynamic>).map((e) => GouvernoratModel.fromJson(e)).toList(),
  );
  
  return Future.value(response);
}



}