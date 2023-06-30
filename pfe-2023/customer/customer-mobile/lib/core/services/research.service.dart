import '../models/ResearchResult.dart';
import 'generic.service.dart';
class ResearchService  extends GenericService {
  @override
  void onInit() {
    super.onInit();
  }
Future<List<researchModel>>  findResearch() async {
 List<researchModel> response = await apiCall('/researchResults',
    isPost: false,
     decoder: (json) =>
        (json as List<dynamic>).map((e) => researchModel.fromJson(e)).toList(),
  );
print('tt');
  return Future.value(response);

}

  
}





