import 'dart:convert';
import 'dart:ffi';

import 'package:demo/core/models/OrdresModel.dart';
import 'package:demo/core/services/Mou3inaService.dart';
import 'package:demo/ui/login/AppPreferenceHelper%20.dart';
import 'package:demo/ui/profil/profilController.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:http/http.dart' as http;

import 'dart:convert';



class moreDetails extends StatefulWidget {

  @override
  State<StatefulWidget>createState() {
    return moreDetailsState();
  }
}

 class moreDetailsState extends State<moreDetails> {
final AppPreferenceHelper _helper = new AppPreferenceHelper();
 Mou3inaService mou3inaService=Get.find();
getprofil() async{
 print("hhhhh");
  List<dynamic> responsebody = await mou3inaService.findMou3ina(profilController.instance.name);
 print("hhhhh");
return responsebody;

}

 @override
void initState(){
  getprofil();
  super.initState();
}


  @override
  Widget build(BuildContext context) {
    return Container(
      child: Scaffold(
        appBar: AppBar(
          title: Text("8".tr),
            centerTitle: true,
        ),
        body: ListView(
          children: <Widget>[
           FutureBuilder(
             future: getprofil(),
             builder: (BuildContext context , AsyncSnapshot  snapshot) {
                if(snapshot.hasData){
                   return Column(children :<Widget>[
                 for(int i=0 ; i<snapshot.data.length ; i++)
                 TestList(
                 

                    id: snapshot.data[i]['id'].toString(),
        
                   desiredDate: snapshot.data[i]['firstName'].toString(),
                   numberOfMou3ina: snapshot.data[i]['lastName'].toString(),
                   
                 )
                 
               ],);

                }
                return CircularProgressIndicator();
             },
           ),
          ]),
      ),
    );
  }
}

class $idMou3ina {
}

class TestList extends StatelessWidget {
  final numberOfMou3ina;
   final id;
  final desiredDate;
  final desiredHour;
  final operationDate;
   final morning;
   final afternoon;
  final evening;
  TestList({this.numberOfMou3ina, this.desiredDate,this.desiredHour
   ,this.operationDate,this.id,this.morning,this.afternoon,this.evening});

  get shrinkWrap => null;

  @override
  Widget build(BuildContext context) {
    return
     Card(
        child: Column(
      children: <Widget>[
          
            
        ListTile(
            leading: CircleAvatar(
            child: Icon(Icons.article),
          ),
        
          title: Container(
            margin: EdgeInsets.only(top: 10),
            child: Text( id,
         
              
              style: TextStyle(
                  fontSize: 18,
                  fontWeight: FontWeight.w600,
                  color: Colors.black),
            ),
          ),
         
          isThreeLine: true,
          subtitle: Text(
            desiredDate,
              
            style: TextStyle(fontSize: 18 , fontWeight: FontWeight.w600,
                  color: Colors.black),
          ),
          trailing: Text( numberOfMou3ina),
          selectedColor: Color.fromARGB(255, 35, 140, 220),
          selectedTileColor: Colors.black12,
        
        ),
         
        Divider(color: Colors.grey.withOpacity(0.5)),
      
      ],
      
    ),
    
    );
  }
}