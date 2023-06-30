import 'package:flutter/material.dart';
import 'package:flutter_rating_bar/flutter_rating_bar.dart';
import 'package:get/get.dart';
import 'package:table_calendar/table_calendar.dart';

import '../ReservationHistory/ReservationHistory.controller.dart';

class Rating extends GetView<ReservationHistoryController> {

   final _formKey = GlobalKey<FormState>();

  @override
  Widget build(BuildContext context) {
    controller.findoneReserv();
  //print(controller.findoneReserv()); 
  // print(Get.arguments.toString());
   //print("lastrate"+controller.reservation.value.rate.toString());
    return Scaffold(
       appBar: AppBar(
        backgroundColor: Colors.white,
          elevation: 0.0,
          leading: Icon(
            Icons.arrow_back,
            color: Colors.black,
          ),
          actions: <Widget>[
            Padding(
              padding: const EdgeInsets.all(8.0),
              child: Icon(
                Icons.favorite_border,
            color: Colors.black,
              ),
            ),
            Padding(
              padding: const EdgeInsets.fromLTRB(0.0, 8.0, 12.0, 8.0),
              child: Icon(
                Icons.more_vert,
            color: Colors.black,
              ),
            ),
          ],
        ),
        
      body: SingleChildScrollView(
         
              child: Padding(
                  padding: EdgeInsets.only(left: 10, right: 10, top: 140),
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.center,
                    children: [
                     /* Text("now"+controller.reservation.value.id.toString())*/
                      Container(
                        height: 400,
                        width: 400,
                        child: InkWell(
                            onTap: () {
                              //Navigator.of(context).pushNamed("homepage");
                            },
                            child: Card(
                              clipBehavior: Clip.antiAlias,
                              shape: RoundedRectangleBorder(
                                borderRadius: BorderRadius.circular(24),
                              ),
                              child: Column(
                                children: [
                                  Stack(
                                      children: [
                                        Image.asset(
                                          "assets/images/C2.jpg",
                                          width: 340,
                                          height: 200,
                                        ),
                                      ],
                                    ),
                                    Center(
                                      child: Container(
                                        child: Text("Your Feedback is so important to ",
                                        style:TextStyle(
                                color: Colors.black,
                                fontWeight: FontWeight.w400,
                                fontSize: 15,
                                
                            )
                                        ),
                                      ),
                                    ),
                                     Center(
                                      child: Container(
                                        child: Text(" help us improve our services",
                                        style:TextStyle(
                                color: Colors.black,
                                fontWeight: FontWeight.w400,
                                fontSize: 15,
                                
                            )))),
                            //Text(controller.reservation.id.toString()),
                            Obx(() {

      return
                            Form(
                  key: _formKey,
                  
                               child:   Column(
                                    children: [
                                      Padding(
                  padding: EdgeInsets.only(left: 10, right: 10, top: 20),
                  
                                        child: FlutterRatingBar(
                                          //initialRating: controller.reservation.value.rate,
                                          fillColor: Color.fromARGB(255, 60, 10, 68),
                                          borderColor: Color.fromARGB(255, 60, 10, 68),
                                          //allowHalfRating: true,
                                          onRatingUpdate: (rating) {
                                          //  print(rating);
                                           controller.rankselected=rating ;
                                            //print("New"+ controller.reservation.value.rate.toString());
                                          
                                          },
                                        ),
                                      ),
                                  
                                  SizedBox(height: 20,
                                  ),
                                  Row(
                                    children: [
                                        Padding(
                                          padding: const EdgeInsets.fromLTRB(25, 0, 0, 0),
                                          child: ElevatedButton(
                    onPressed: () {
                     // Navigator.of(context).pushNamed("reshistory");
                     //  print("test008");
    //print(controller.reservation.value.id);
                    },
                    child: Text( "Cancel"),
                    style: ElevatedButton.styleFrom(
                      primary: Colors.purple
                    ),
                  ),
                                        ),
                  SizedBox(width: 180,),
                                      ElevatedButton(
                                        onPressed: () {
                                           _formKey.currentState!.save();
                                           print("le 11"+Get.arguments.toString());
                                          controller.updateContact(_formKey.currentState!.validate());
                                //Navigator.of(context).pushNamed("login");
                                          if(controller.rankselected!<4){
                                             Navigator.of(context).pushNamed("complain");
                              }
                              else{
                                 
                              Navigator.of(context).pushNamed("reshistory");
                              }
                                        }
                   /* onPressed: () { if(controller.rankselected!<4){

                      controller.createPreference();
                            controller
                                .addpreference(_formKey.currentState!.validate());
                              Navigator.of(context).pushNamed("complain");
                              }
                              else{
                                  controller.createPreference();
                            controller
                                .addpreference(_formKey.currentState!.validate());
                              Navigator.of(context).pushNamed("reshistory");
                              }
                          },*/,
                    child: Text( "Submit"),
                    style: ElevatedButton.styleFrom(
                      primary: Colors.purple
                    ),
                  ),
                  
                                    ],
                                  )   ],
                                  ), ) ;
    })
    ,

                                  
                                  
                                ],
                              ),
                            )),
                      ),
                    ],
                  ))),
        
     bottomNavigationBar: BottomNavigationBar(
          
          //currentIndex: currentIndex,
          selectedItemColor: Colors.black54,
          unselectedItemColor: Colors.black54,
          showSelectedLabels: true,
          showUnselectedLabels: true,
          elevation: 0,
          items: const <BottomNavigationBarItem>[
            BottomNavigationBarItem(
              icon: Icon(Icons.home_rounded,color:Colors.blueAccent),
              label: 'Home',
             
              
              
            ),
            BottomNavigationBarItem(
              
              icon: Icon(Icons.list_alt,color:Colors.blueAccent),
              label: 'Orders',

            ),
            BottomNavigationBarItem(
              icon: Icon(Icons.favorite,color: Colors.redAccent,),
              label: 'Preferences',
            ),
            BottomNavigationBarItem(
              icon: Icon(Icons.heart_broken,color:Colors.black),
              label: 'Blacklist',
            ),
            BottomNavigationBarItem(
              icon: Icon(Icons.menu),
              label: 'Menu',
            ),
          ],
        )
    );
    
  }
  
}
