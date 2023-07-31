import 'package:demo/core/models/LangageModel.dart';
import 'package:demo/core/services/generic.service.dart';
class LangageService  extends GenericService {
  @override
  void onInit() {
    super.onInit();
  }
Future<List<LangageModel>> findLangage() async {
  List<LangageModel> response = await apiCall(
    '/LangageSpeaking',
    isPost: false,
    decoder: (json) =>
        (json as List<dynamic>).map((e) => LangageModel.fromJson(e)).toList(),
  );
  
  return Future.value(response);
}



}