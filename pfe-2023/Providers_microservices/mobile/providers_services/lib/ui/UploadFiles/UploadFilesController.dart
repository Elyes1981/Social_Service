import 'dart:convert';
import 'dart:io';
import 'package:get/get.dart';
import 'package:get/get_core/src/get_main.dart';
import 'package:image_picker/image_picker.dart';
import 'package:providers_services/core/services/Mou3inaService.dart';
import 'package:providers_services/shared/controllers/generic.controller.dart';
import 'package:http/http.dart' as http;
import 'package:providers_services/ui/profil/profilController.dart';


class UploadFilesController extends GetxController{

  static UploadFilesController instance = Get.find();
  Mou3inaService mou3inaService=Get.find();

  //File? _image; // put the selected  image in "_image"
  PickedFile? _pickedFile ; // grabbing object from our gallery of our phone
  PickedFile? get pickedFile=>_pickedFile; //getter
  PickedFile? _pickedFile2 ;
  PickedFile? get pickedFile2=>_pickedFile2;
  String? _imagePath ;
  String? get imagePath=> _imagePath ;
  String? _imagePath2 ;
  String? get imagePath2=> _imagePath2 ;
  final _picker = ImagePicker();
  final _picker2 = ImagePicker();// initialiser image picker


  //////implementing image picker ( for accessing the gallery to get the image )
  Future<void> pickImage() async {
    _pickedFile= await _picker.getImage(source: ImageSource.gallery);
    update();
    /*if(_pickedFile!=null){
      setState(() {
        _image =File(_pickedFile!.path); // once the file has been loaded , we redraw our UI
      });
    }*/
  }

  Future<void> pickImage2() async {
    _pickedFile2= await _picker2.getImage(source: ImageSource.gallery);
    update();
    /*if(_pickedFile!=null){
      setState(() {
        _image =File(_pickedFile!.path); // once the file has been loaded , we redraw our UI
      });
    }*/
  }

  //////
  Future<void> uploadCIN() async {
    //upload();
    //bool success=false;
    //print("*********test0***************");
    http.StreamedResponse response = await updateCIN(_pickedFile);
    if (response.statusCode == 200) {
      Map map = jsonDecode(await response.stream.bytesToString());
      String message = map["message"];
      //success=true;
      //_imagePath=message;
      // _pickedFile = null;
      //await getUserInfo();
      print(message);
      _imagePath=message;
      print(_imagePath);
    } else {
      print("error posting the image");
    }
    update();
    //return success;
  }

  Future<void> uploadPhoto() async {
    //upload();
    //bool success=false;
    //print("*********test0***************");
    http.StreamedResponse response = await updatePhoto(_pickedFile2);
    if (response.statusCode == 200) {
      Map map = jsonDecode(await response.stream.bytesToString());
      String message = map["message"];
      //success=true;
      //_imagePath=message;
      // _pickedFile = null;
      //await getUserInfo();
      print(message);
      _imagePath2=message;
      print(_imagePath2);
    } else {
      print("error posting the image");
    }
    update();
    //return success;
  }

  /*Future<void> upload2() async {
    //upload();
    //bool success=false;
    //print("*********test0***************");
    http.StreamedResponse response = await updateImage(_pickedFile ,_pickedFile2 );
    if (response.statusCode == 200) {
      Map map = jsonDecode(await response.stream.bytesToString());
      String message = map["message"];
      //success=true;
      //_imagePath=message;
      // _pickedFile = null;
      //await getUserInfo();
      print(message);
      _imagePath=message;
      print(_imagePath);
    } else {
      print("error posting the image");
    }
    update();
    //return success;
  }*/


  ///////////////////////////////////////
  Future<http.StreamedResponse> updateCIN(PickedFile? data) async {
    /*int? id = profilController.instance.id ;
    print(id);*/
    int? id = 104 ;
    http.MultipartRequest request = http.MultipartRequest('POST', Uri.parse('http://10.0.2.2:8088/filee/uploadd/$id'));
    print("test1");
    //request.fields['id'] = id.toString();
    //print("*********test ***************");
    if(/*GetPlatform.isMobile &&*/ data != null){
      File _file = File(data.path);
      request.files.add(http.MultipartFile('files',_file.readAsBytes().asStream(), _file.lengthSync(), filename: _file.path.split('/').last));
      //print("*********test2***************");
    }
      http.StreamedResponse response = await request.send();
    return response;
  }


  Future<http.StreamedResponse> updatePhoto(PickedFile? data2) async {
    /*int? idcon = profilController.instance.id ;
    print(idcon);*/
    int? id = 104  ;
    http.MultipartRequest request = http.MultipartRequest('POST', Uri.parse('http://10.0.2.2:8088/filee/uploaddd/$id'));
    print("test1");
    //request.fields['id'] = id.toString();
    //print("*********test ***************");
    if(/*GetPlatform.isMobile &&*/ data2 != null ){
      File _file2 = File(data2.path);
      request.files.add(http.MultipartFile('photo',_file2.readAsBytes().asStream(), _file2.lengthSync(), filename: _file2.path.split('/').last));
      //print("*********test2***************");
    }
    http.StreamedResponse response = await request.send();
    return response;
  }
}




