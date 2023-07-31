import 'dart:convert';
import 'dart:ffi';


import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:http/http.dart' as http;

import 'dart:convert';

import 'package:intl/intl.dart';
import 'package:providers_services/ui/login/AppPreferenceHelper%20.dart';
import 'package:providers_services/ui/profil/profilController.dart';



class ordres extends StatefulWidget {

  @override
  State<StatefulWidget>createState() {
    return ordressState();
  }
}

 class ordressState extends State<ordres> {
  final AppPreferenceHelper _helper = new AppPreferenceHelper();



   getCommandes(int? idMou3ina) async{

    var url ='http://10.0.2.2:8978/CustomerReservations/ProviderOrder/$idMou3ina';
    var response = await http.get(Uri.parse(url));
    List<dynamic> responsebody = jsonDecode(response.body);
    print(responsebody);
    return responsebody ;


}

 @override
void initState(){
  getCommandes(profilController.instance.id);
  super.initState();
}


  @override
  Widget build(BuildContext context) {
  
    return Container(
      child: Scaffold(
     
        body: ListView(
          children: <Widget>[
           FutureBuilder(
             future: getCommandes(profilController.instance.id),
             builder: (BuildContext context , AsyncSnapshot  snapshot) {
                if(snapshot.hasData){
                   return Column(children :<Widget>[
                 for(int i=0 ; i<snapshot.data.length ; i++)
                 TestList(
                 

                    //id: snapshot.data[i]['id'].toString(),

                   OrderDay: snapshot.data[i]['OrderDay'],
                   /*numberOfMou3ina: snapshot.data[i]['numberOfMou3ina'].toString(),
                    desiredHour: snapshot.data[i]['desiredHour'].toString(),
                    operationDate : snapshot.data[i]['operationDate'].toString(),*/
                    //nomClient :snapshot.data[i]['nomClient'].toString(),
                    //telephone :snapshot.data[i]['phone'].toString(),
                    //adress :snapshot.data[i]['adress'].toString(),
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
  //final numberOfMou3ina;
  // final id;
  final OrderDay;
  //final desiredHour;
  //final operationDate;
   //final adress;
   //final nomClient;
  //final telephone;
  TestList({/*this.numberOfMou3ina,*/ this.OrderDay/*,this.desiredHour
   ,this.operationDate,this.id,*//*this.adress,this.nomClient,this.telephone*/});

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
        
/*          title: Container(
            margin: EdgeInsets.only(top: 10),
            child:
             Text( "48".tr +":"+"12/08/2022"
             
           ,
         
              
              style: TextStyle(
                  fontSize: 18,
                  fontWeight: FontWeight.w600,
                  color: Colors.black),
            ),
          ),*/
         
          isThreeLine: true,
          subtitle: Text(
            "49".tr +":+ ${OrderDay}",
              
            style: TextStyle(fontSize: 18 , fontWeight: FontWeight.w600,
                  color: Colors.black),
          ),
          //trailing: Text( "50".tr +":"+id),
          selectedColor: Color.fromARGB(255, 35, 140, 220),
          selectedTileColor: Colors.black12,
        
        ),
        /*ListTile(
        
        
*//*          title: Container(
            margin: EdgeInsets.only(top: 10),
            child:
             Text( "76".tr+" :"+nomClient,
         
              
              style: TextStyle(
                  fontSize: 18,
                  fontWeight: FontWeight.w600,
                  color: Colors.black),
            ),
            
          ),*//*
           isThreeLine: true,
         *//* subtitle: Text(
            
              "77".tr+" :"+telephone, 
            style: TextStyle(fontSize: 18 , fontWeight: FontWeight.w600,
                  color: Colors.black),
          ),*//*
       
          selectedColor: Color.fromARGB(255, 35, 140, 220),
          selectedTileColor: Colors.black12,
        ),*/
         /*Text(
             "78".tr+" :"+adress,style: TextStyle(
                  fontSize: 18,
                  fontWeight: FontWeight.w600,
                  color: Colors.black)
             ),*/
        Divider(color: Colors.grey.withOpacity(0.5)),
      
      ],
      
    ),
    
    );
  }
}