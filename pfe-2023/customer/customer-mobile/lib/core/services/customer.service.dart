
import 'dart:convert';

import '../models/customerModel.dart';
import 'generic.service.dart';

/*import 'package:demo/core/models/customerModel.dart';

import 'package:demo/core/services/generic.service.dart';*/
class CustomerService  extends GenericService {
  @override
  void onInit() {
    super.onInit();
  }
Future<customerModel> createcustomer( customerModel customer) async {
 return await apiCall(
    '/customers',
    isPost: true,
    body: customer.toJson(),
    
  );
  
  
  
}

Future<List<customerModel>>  findcustomer() async {
 List<customerModel> response = await apiCall('/customers',
    isPost: false,
     decoder: (json) =>
        (json as List<dynamic>).map((e) => customerModel.fromJson(e)).toList(),
  );
print('ttested');
  return Future.value(response);
}

 Future<customerModel> updateCases(String id, customerModel customer) async {
    Map data = {
      'name': customer.firstName,
      //'gender': customer.gender,
      'Gendre': customer.Gendre,
      
      //'mou3inas_preferences': customer.mou3inas_preferences
    };

   return await apiCall(
    '/customers/id',
    isPut: true,
    body: customer.toJson(),
    
  );
  }
  Future<dynamic> updateCustomer(customerModel customer,String id) async {
    return await apiCall(
        '/customers/'+id,
        isPost: false,
        isPut: true,
        body: customer.toJson());
        //print("hola");
  }
}
