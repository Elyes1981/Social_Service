import 'package:flutter/material.dart';
import 'package:flutter_rating_bar/flutter_rating_bar.dart';
import 'package:favorite_button/favorite_button.dart';

import 'package:get/get.dart';

import '../../core/routes/app_routes.dart';
import 'ReservationHistory.controller.dart';

class ReservationHistory extends GetView<ReservationHistoryController> {
final navigatorKey = GlobalKey<NavigatorState>();
  @override
  Widget build(BuildContext context) {
    controller.findReserv();
    print("ahmed"+controller.ReservationList.length.toString());
   // controller.findMou3inas();
   // print(controller.ReservationList[0].desiredDate.toString());

    controller.findoneReserv();
    
    print( controller.mou3ina_orderlist.length.toString());
    return Scaffold(
      body:Obx(() {
      return   SingleChildScrollView(
        scrollDirection: Axis.vertical,
        child: Container(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Container(
                padding: EdgeInsets.all(20),
                decoration: BoxDecoration(
                   color:Colors. blue,
                    
                    borderRadius: BorderRadius.only(bottomLeft: Radius.circular(40), bottomRight: Radius.circular(40))
                ),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                   
                    SizedBox(height: 50,),
                    Row(
                      mainAxisAlignment: MainAxisAlignment.spaceBetween,
                      children: [
                        Column(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: [
                            SizedBox(
                              height: 20,
                            ),
                            /*Text("Yoshimasa Sushi", style: TextStyle(
                                color: Colors.white,
                                fontWeight: FontWeight.w700,
                                fontSize: 20
                            ),),*/
                            SizedBox(height: 10,),
                            Row(
                              crossAxisAlignment: CrossAxisAlignment.end,
                              children: [
                                Icon(Icons.star, color: Colors.white,),
                                Icon(Icons.star, color: Colors.white,),
                                Icon(Icons.star, color: Colors.white,),
                                Icon(Icons.star, color: Colors.white,),
                                Icon(Icons.star, color: Colors.white,),
                                
                              ],
                            )
                          ],
                        ),
                       
                      ],
                    ),
                    SizedBox(height: 15,),
                    /*Text("Lorem ipsum dolar sits amet is used in print industry", style: TextStyle(
                        color: Colors.white,
                        fontSize: 12
                    ),)*/
                  ],
                ),
              ),
              SizedBox(height: 30,),
               
              Container(
                padding: EdgeInsets.symmetric(horizontal: 10),
                child: Column(
                  children: [
                    Row(
                      crossAxisAlignment: CrossAxisAlignment.end,
                      children: [
                        Text("Your List Of Orders", style: TextStyle(
                            fontSize: 22,
                            fontWeight: FontWeight.w700
                        ),),
                        SizedBox(width: 10,),
                        
                      ],
                    ),
                    Padding(
                        padding: EdgeInsets.only(left: 10, right: 10, top: 10),
                        child: Column(
                          
                          crossAxisAlignment: CrossAxisAlignment.center,
                          children: [
                          
              ListView.builder(shrinkWrap: true,
  itemCount: controller.ReservationList.length,
  itemBuilder: (context, index) {
   
                         
    return  Card(
                                        child: Column(
                                            mainAxisSize: MainAxisSize.min,
                                            children: <Widget>[
                                          ListTile(
        leading: GestureDetector(
    behavior: HitTestBehavior.translucent,
 
    child:Container(
      
     
          height: 100,
          width: 60,
          decoration: BoxDecoration(
              image: DecorationImage(
                  image: AssetImage("assets/images/c88.jpg")
              )
          ),
        ),
       
  ),
  title:Text(controller.ReservationList[index].serviceTypes![0].label.toString()+"   "+controller.ReservationList[index].desiredDate!.year.toString()+'-'+controller.ReservationList[index].desiredDate!.month.toString()+'-'+controller.ReservationList[index].desiredDate!.day.toString(), style: TextStyle(
                  fontSize: 16,
                  fontWeight: FontWeight.w400
              ),),
           /*   title:
              Text(" ", 
              style: TextStyle(
                
                  fontSize: 16,
                  fontWeight: FontWeight.w600

              ),),*/
              
     /* title: Text("Imene Chaoua"
        /*controller.ReservationList[index].id.toString()+" "+controller.ReservationList[index].numberOfMou3ina.toString()*/)*/
      subtitle:  
      /*Text( controller.ReservationList[index].desiredDate!.year.toString()+'-'+controller.ReservationList[index].desiredDate!.month.toString()+'-'+controller.ReservationList[index].desiredDate!.day.toString())*/
      FlutterRatingBar(
        
        itemSize:18,
        //if(controller.ReservationList[index].rate==null){}
                                          initialRating: controller.ReservationList[index].rate!=null?controller.ReservationList[index].rate:0,
                                          fillColor: Color.fromARGB(255, 60, 10, 68),
                                          borderColor: Color.fromARGB(255, 60, 10, 68),
                                          //allowHalfRating: true,
                                         
                                        ),

       trailing: PopupMenuButton(
              itemBuilder: (context) {
                return [
                  
                  PopupMenuItem(
                   
                    value: 'rate',
                    child: Text('Rating',),
                    
                     onTap:() {
                     // print("hhh");
                      // Navigator.of(context).pushNamed("rating");
                    //arguments: controller.CustomerList[index].id);
                  
        //Get.toNamed<dynamic>(AppRoutes.rating);
                    },
                    //icon:Icons.ice_skating
                  ),
                  
                  PopupMenuItem(
                    value: 'favorite',
                    child: const Text('Favorite'),
                     onTap:(){}
                      //showMyDialog,
                       
                   
                  ),
                   PopupMenuItem(
                    onTap: (){
                       
                    },
                    value: 'complain',
                    
                    child: Text('Complain'),
                  )
                ];
              },
              onSelected: (String value){
                if(value=='rate'){
                  //print(controller.CustomerList[index].id);
                 // CustomerItemView(id: controller.CustomerList[index].id);
         // Get.toNamed<dynamic>(AppRoutes.rating);
          
                 // CustomerItemView(id: controller.CustomerList[index].id);
          Get.toNamed<dynamic>(AppRoutes.rating,arguments: controller.ReservationList[index].id);
          print("hii theree");
          print(controller.ReservationList[index].id);
                }
                 if(value=='complain'){
                  //print(controller.CustomerList[index].id);
                 // CustomerItemView(id: controller.CustomerList[index].id);
         // Get.toNamed<dynamic>(AppRoutes.rating);
          Navigator.of(context).pushNamed("complain");
                }
                if(value=='favorite'){
                Get.toNamed<dynamic>(AppRoutes.preferences,arguments: controller.ReservationList[index].id);
              }},
            ),
            
        //child: Text(    controller.CustomerList[index].firstName.toString().substring(0, 1).toUpperCase()+controller.CustomerList[index].lastName.toString().substring(0, 1).toUpperCase()
// style: TextStyle(color: Colors.black)),
      
    ),
    
                    ]
                    )
                    );
  },
)
      
  
            
                          
                          ],
                          
                        )
                        )
                   
                    
                            
                  ],
                ),
              ),
        

        
            ],
            
          ),
        ),
      );


            }
            ),
      
      
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


