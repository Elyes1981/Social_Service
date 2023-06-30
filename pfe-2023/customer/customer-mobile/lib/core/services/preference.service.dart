import '../models/preferenceModel.dart';
import 'generic.service.dart';
class PreferenceService  extends GenericService {
  @override
  void onInit() {
    super.onInit();
  }
Future<preferencesModel> createpreference( preferencesModel preference) async {
 return await apiCall(
    '/customer_preferences',
    isPost: true,
    body: preference.toJson(),

  );
  
  
  
}

Future<List<preferencesModel>>  findpreference() async {
 List<preferencesModel> response = await apiCall('/customer_preferences',
    isPost: false,
     decoder: (json) =>
        (json as List<dynamic>).map((e) => preferencesModel.fromJson(e)).toList(),
  );
print('ttested');
  return Future.value(response);
}


}
