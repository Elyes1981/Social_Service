
import 'package:get/get.dart';

import '../../core/models/servicetypeModel.dart';
import '../../core/services/servicetype.dart';
import '../../shared/controllers/generic.controller.dart';

class ServicestypeController extends GenericController{
  static ServicestypeController instance = Get.find();
  ServiceType servicestype = Get.find();
  late RxList<dynamic> ServiceList=List<dynamic>.empty().obs;
  RxBool isloading = true.obs;
  RxList<String> selectedValues = List<String>.empty().obs;
  RxBool isSelected = true.obs;



  @override
  void onInit() {
   findserviceType();
    super.onInit();
  }
  findserviceType() async {
    isloading(true);
    List<ServiceTypeModel> rs = await servicestype.findServiceType();
    ServiceList.value=rs.map((e) => e.label).toList();
    print(ServiceList.value);
    print(ServiceList.value[0]);
    isloading(false);
  

  }
  
  
  


/*save(String value){
   print(selectedValues);
  isSelected.value=true;
  selectedValues.add(value);
  print(selectedValues);
  isSelected.value=false;
}*/
  
}