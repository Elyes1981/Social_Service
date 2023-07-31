import 'dart:io';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:http/http.dart' as http;
import 'package:image_picker/image_picker.dart';
import 'package:providers_services/ui/UploadFiles/UploadFilesController.dart';
import 'package:providers_services/ui/profil/profilController.dart';
import 'package:file_picker/file_picker.dart';


class UploadFilesPage extends StatefulWidget {

  const UploadFilesPage({Key? key}) : super(key: key);

  @override
  State<UploadFilesPage> createState() => _UploadFilesPageState();
}

class _UploadFilesPageState extends State<UploadFilesPage> {



  @override
  void initState() {
    super.initState();
  }


  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
        title: const Text('Upload files'),
        centerTitle: true,
        ),
        body: GetBuilder<UploadFilesController>(builder:(uploadFilescontroller){
          return SafeArea(
            child: Padding(
                padding: const EdgeInsets.all(24.0),
                child:Column(children: [
                  Center(
                    child: GestureDetector(
                      child: const Text("choose your identity card"),
                      onTap: ()=>uploadFilescontroller.pickImage(),
                    ),
                  ),
                  const SizedBox(height: 35),
                  Container(  //once we picked the imge => interface va afficher l'image
                    alignment: Alignment.center,
                    width: double.infinity,
                    height : 100,
                    color:Colors.grey[300],
                    child: uploadFilescontroller.pickedFile != null
                        ? Image.file(
                      File(uploadFilescontroller.pickedFile! // get the file path and converted to an image by calling the constructor of file
                          .path),width: 100,height: 100, fit:BoxFit.cover,

                    ) : const Text('Please select an image'),
                  ),
                  const SizedBox(height: 35),
                  Center(
                    child: GestureDetector(
                      child: const Text("upload"),
                      onTap: ()=>uploadFilescontroller.uploadCIN(),
                    ),
                  ),
                  const SizedBox(height: 35),
                  Center(
                    child: GestureDetector(
                      child: const Text("choose your photo identity"),
                      onTap: ()=>uploadFilescontroller.pickImage2(),
                    ),
                  ),
                  const SizedBox(height: 35),
                  Container(  //once we picked the imge => interface va afficher l'image
                    alignment: Alignment.center,
                    width: double.infinity,
                    height : 100,
                    color:Colors.grey[300],
                    child: uploadFilescontroller.pickedFile2 != null
                        ? Image.file(
                      File(uploadFilescontroller.pickedFile2! // get the file path and converted to an image by calling the constructor of file
                          .path),width: 100,height: 100, fit:BoxFit.cover,

                    ) : const Text('Please select an image'),
                  ),
                  const SizedBox(height: 35),
                  Center(
                    child: GestureDetector(
                      child: const Text("upload"),
                      onTap: ()=>uploadFilescontroller.uploadPhoto(),
                    ),
                  ),
                  const SizedBox(height: 35),
                  /*Container(
                    alignment: Alignment.center,
                    width: double.infinity,
                    height: 180,
                    color: Colors.grey[300],
                    child: uploadFilescontroller.imagePath !=null ? Image.network("http://mvs.bslmeiyu.com"+Get
                        .find<UploadFilesController>().imagePath!,
                    width: 100 , height: 100,fit : BoxFit.cover,)
                      : const Text("No image from server ")
                  )*/
                ])

              /*ElevatedButton(
                  onPressed: _openFileExplorer,
                  child: Text('Select Files'),
                ),
                SizedBox(height: 16),
                Expanded(
                  child: ListView.builder(

                    itemCount: _selectedFiles.length,
                    itemBuilder: (context, index) {

                      return ListTile(
                        title: Text(basename(_selectedFiles[index].path)),
                      );
                    },
                  ),
                ),*/

              /*   Image.file(file),
      ElevatedButton(
        onPressed: ()  {
          pickFile();
         *//* XFile? image = await ImagePicker().pickImage(source: ImageSource.gallery);
          if (image != null) {
            File file = File(image.path);
            uploadFile(file);
          }*//*
        },
        *//*onPressed: () async {
          final pickedFile =
          await ImagePicker().getImage(source: ImageSource.gallery);
          setState(() {
            _imageFile = pickedFile;
          });
        },*//*
        child: Text('Choose Photo'),
      ),*/
              /* ElevatedButton(
    onPressed: ()  {
    await service.showNotification(
    id: 0,
    title: 'Notification Title',
    body: 'Some body');
    },
    child: const Text('Show Local Notification'),
    ),
    ElevatedButton(
                    onPressed: () async {
                      await service.showScheduledNotification(
                        id: 0,
                        title: 'Notification Title',
                        body: 'Some body',
                        seconds: 4,
                      );
                    },
                    child: const Text('Show Scheduled Notification'),
                  ),
    ElevatedButton(
                    onPressed: () async {
                      await service.showNotificationWithPayload(
                          id: 0,
                          title: 'Notification Title',
                          body: 'Some body',
                          payload: 'payload navigation');
                    },
                    child: const Text('Show Notification With Payload'),
                  ),*/

            ),
          );
    }));
  }

    /*void listenToNotification() =>
      service.onNotificationClick.stream.listen(onNoticationListener);*/

   /* void onNoticationListener(String? payload) {
    if (payload != null && payload.isNotEmpty) {
      print('payload $payload');

      Navigator.push(
          context,
          MaterialPageRoute(
              builder: ((context) => SecondScreen(payload: payload))));
    }
  }*/

/*void pickFile() async{
  FilePickerResult? result = await FilePicker.platform.pickFiles(
    type : FileType.any
  );

}*/

 /* void handleUpload(List<File> files) async {
    int? id = profilController.instance.id ;
    var request = http.MultipartRequest("POST" , Uri.parse("http:///localhost:8088/filee/uploadd/$id"));
    //request.fields["id"]=id ;
    request.headers['Authorization'] = "" ;
    var picture = http.MultipartFile.fromBytes()
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

/*  void _openFileExplorer() async {
    final result = await FilePicker.platform.pickFiles(allowMultiple: true);
    if (result != null) {
      setState(() {
        _selectedFiles = result.paths.map((path) => File(path!)).toList();
      });
    }
  }

  Future<void> _uploadFiles() async {
    try {
      await uploadFiles(_selectedFiles);
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('Files uploaded successfully')),
      );
    } catch (e) {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('Error uploading files: $e')),
      );
    }
  }*/

  }


