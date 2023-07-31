import 'dart:convert';
import 'dart:io';

import 'package:providers_services/core/models/Mou3inaModel.dart';
import 'package:providers_services/core/services/generic.service.dart';
import 'package:providers_services/ui/profil/profilController.dart';
import 'package:http/http.dart' as http;



class Mou3inaService extends GenericService {
  @override
  void onInit() {
    super.onInit();
  }

//getListMou3ina
  Future<List<Mou3inaEntity>> findMou3inas() async {  //async retourne tjr un objet de type Future
    List<Mou3inaEntity> response = await apiCall(   //await attendre la fin de l'exécution de la tâche asynchrone et récupérer la valeur de retour de cette tâche, tout en continuant à exécuter le reste de son code de manière asynchrone.
      '/Mou3inas',  //apiCall() est une fonction asynchrone qui effectue une requête HTTP et renvoie une Future qui se termine avec les données JSON récupérées.
      isPost: false,
      decoder: (json) => (json as List<dynamic>)  //"dynamic" signifie que le type peut être déterminé à l'exécution. n'est pas conny à l'avance , le compilateur Dart ne vérifie pas le type de la variable et ne signale pas d'erreur de type
          .map((e) => Mou3inaEntity.fromJson(e))
          .toList(),
    );
    return Future.value(response);
  }

  //getMou3na By id
  Future<List<Map<String, dynamic>>> findMou3ina(String? id) async {
    List<Map<String, dynamic>> response = await apiCall(
      '/Mou3inaa/$id',
      isPost: false,
      decoder: (json) => (json as List<dynamic>)  // decoderfonction prend un objet JSON sous la forme d'un Mapavec Stringdes clés et dynamicdes valeurs et renvoie un Listde ces mappages.
          .map((e) => Mou3inaEntity.fromJson(e))
          .toList(),
    );
    return response;
  }

//addMou3ina
  Future<Mou3inaEntity> create(Mou3inaEntity mou3ina , String companyID) async {
    return await apiCall(
      '/api/auth/signup',
      isPost: true,
      body: mou3ina.toJson(),
    );
  }

//sign in
  Future signin(String username, String password) async {
    String data = jsonEncode({'username': username, 'password': password});
    return await apiCall(
      '/api/auth/signin',
      isPost: true,
      body: data,
    );
  }


// ignore: non_constant_identifier_names
/* Future<int> Login(String username, String password) async {
  var res= await apiCall(
    '/api/auth/signin',
    isPost: true,
    body: {
        "username": username,
        "password": password
      }
    );
   return res.body;
   
  }*/

/*  Future<void> uploadFiles(String? id , File multipartFiles) async {
    var request = http.MultipartRequest(
      'POST',
      Uri.parse('/filee/uploadd/$id'),
    );
    //request.fields['id'] = id!; // replace with the desired ID
    List<File> files = [File('path/to/your/file.pdf')]; // replace with the paths of the desired files
    for (var file in files) {
      var stream = file.openRead().cast<List<int>>();
      var length = await file.length();
      request.files.add(http.MultipartFile(
          'files', stream, length, filename: file.path.split('/').last));
    }
    var response = await request.send();
    if (response.statusCode == 200) {
      print('Files uploaded successfully');
    } else {
      print('Error uploading files: ${response.statusCode}');
    }
  }*/

  Future<http.Response> uploadFiles(List<File> files) async {
    int? id = profilController.instance.id ;

    var request = http.MultipartRequest('POST', Uri.parse('http:///localhost:8088/filee/uploadd/$id'));
    request.fields['id'] = id.toString();

    for(File file in files) {
      var stream  = new http.ByteStream(file.openRead());
      var length = await file.length();
      var multipartFile = new http.MultipartFile('files', stream, length, filename: file.path);
      request.files.add(multipartFile);
    }

    var response = await request.send();
    return http.Response.fromStream(response);
  }
}
