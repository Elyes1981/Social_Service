


import 'package:favorite_button/favorite_button.dart';
import 'package:flutter/material.dart';
import 'package:flutter_rating_bar/flutter_rating_bar.dart';
import 'package:get/get.dart';

import '../ReservationHistory/ReservationHistory.controller.dart';

class Preferences extends GetView<ReservationHistoryController> {
   final _formKey = GlobalKey<FormState>();
  @override
  Widget build(BuildContext context) {
    controller.findMou3inas();
   controller.findCustomer();
   print("cust-id"+controller.customerList[0].id.toString());

    //print("it's meee"+controller.mou3ina_list[0].mou3Ina!.firstName.toString());
    return Scaffold(
      body:Obx(() { 
      return      Form(
                  key: _formKey,
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
                            Text("Yoshimasa Sushi", style: TextStyle(
                                color: Colors.white,
                                fontWeight: FontWeight.w700,
                                fontSize: 20
                            ),),
                            SizedBox(height: 10,),
                            Row(
                              crossAxisAlignment: CrossAxisAlignment.end,
                              children: [
                                Icon(Icons.star, color: Colors.white,),
                                Icon(Icons.star, color: Colors.white,),
                                Icon(Icons.star, color: Colors.white,),
                                Icon(Icons.star, color: Colors.white,),
                                Icon(Icons.star, color: Colors.white,),
                                Text(" 250 Reviews", style: TextStyle(
                                    color: Colors.white,
                                    fontSize: 13
                                ),)
                              ],
                            )
                          ],
                        ),
                        Container(
                          height: 70,
                          width: 70,
                          decoration: BoxDecoration(
                              shape: BoxShape.circle,
                              color: Colors.white
                          ),
                          child: Center(
                            child: Icon(Icons.favorite,color: Colors.redAccent, size: 35,),
                          ),
                        )
                      ],
                    ),
                    SizedBox(height: 15,),
                    Text("Lorem ipsum dolar sits amet is used in print industry", style: TextStyle(
                        color: Colors.white,
                        fontSize: 12
                    ),)
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
                        Text("Your List Of Reservations", style: TextStyle(
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
  itemCount:controller.mou3ina_list.length,
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
  title: Text(controller.mou3ina_list[index].mou3Ina!.firstName.toString()+" "+controller.mou3ina_list[index].mou3Ina!.lastName.toString()
    +" "+controller.mou3ina_list[index].customerReservation!.rate.toString()
    , style: TextStyle(
                  fontSize: 16,
                  fontWeight: FontWeight.w600
              ),),
     /* title: Text("Imene Chaoua"
        /*controller.ReservationList[index].id.toString()+" "+controller.ReservationList[index].numberOfMou3ina.toString()*/)*/
      subtitle:  ButtonTheme( // make buttons use the appropriate styles for cards
                // ignore: unnecessary_new
                child: 
                 ButtonBar(
                  
                  children: [
                  Text(" favorite", style: TextStyle(
                  fontSize: 14,
                  fontWeight: FontWeight.w600
              ),),
                 FavoriteButton(
           isFavorite: false,
           
        
    valueChanged: (_isFavourite) {
      print('Is Favourite $_isFavourite)');
      if(_isFavourite==true){
       // controller.customerList[0].mou3inas_preferences!.add(Mou3Ina());
      controller.mou3inaSelected=controller.mou3ina_list[index].mou3Ina!;
      print(controller.mou3ina_list[index].mou3Ina!.lastName.toString());
      _formKey.currentState!.save();
                                        
   //controller.updateCustomerpref(_formKey.currentState!.validate());
      }
      },
     ),
       //SizedBox(width:120,),

     Text(" Blacklist", style: TextStyle(
                  fontSize: 14,
                  fontWeight: FontWeight.w600
              ),),
                     FavoriteButton(
           isFavorite: false,
        iconColor: Colors.black,
        
    valueChanged: (_isFavourite) {
      print('Is Favourite $_isFavourite)');
      },
     ),
                    ]
                    )
                    ),

       /*trailing: ButtonTheme( // make buttons use the appropriate styles for cards
                // ignore: unnecessary_new
                child: 
                 ButtonBar(
                  
                  children: [
                  Text(" favorite", style: TextStyle(
                  fontSize: 14,
                  fontWeight: FontWeight.w600
              ),),
                 FavoriteButton(
           isFavorite: false,
        
    valueChanged: (_isFavourite) {
      print('Is Favourite $_isFavourite)');
      if(_isFavourite=true){
        
      }
      },
     ),
       SizedBox(width: 80,),

     Text(" Blacklist", style: TextStyle(
                  fontSize: 14,
                  fontWeight: FontWeight.w600
              ),),
                     FavoriteButton(
           isFavorite: false,
        iconColor: Colors.black,
        
    valueChanged: (_isFavourite) {
      print('Is Favourite $_isFavourite)');
      },
     ),
                    ]
                    )
                    ) */
   
            
        //child: Text(    controller.CustomerList[index].firstName.toString().substring(0, 1).toUpperCase()+controller.CustomerList[index].lastName.toString().substring(0, 1).toUpperCase()
// style: TextStyle(color: Colors.black)),
      
    )]));
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
      ); }),
      
      
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


