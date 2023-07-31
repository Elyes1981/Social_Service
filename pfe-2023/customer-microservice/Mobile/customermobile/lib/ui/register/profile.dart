/*import 'package:demo/shared/constants/Background.dart';
import 'package:demo/shared/constants/Background1.dart';
import 'package:demo/ui/login/login.controller.dart';
import 'package:demo/ui/login/login.ui.dart';
import 'package:demo/ui/register/register.controller.dart';*/
import 'package:customermobile/ui/register/register.controller.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';

import '../login/login.ui.dart';

class Profile extends GetView<RegisterController> {
  var theme1 = Colors.white;
  var theme2 = Color(0xff2E324F);
  var white = Colors.white;
  var black = Colors.black;
  bool switchColor = false;
  int currentIndex = 0;
  void onTap(int index) {
    currentIndex = index;
    if(currentIndex==0){
     
    MaterialPageRoute(builder: (context) =>  LoginView(),
  );
    }
    
    
  }

  @override
  Widget build(BuildContext context) {
    controller.findCustomer();
     //print(controller.customerList.value[0].birthDate.toString());
    print(controller.customerList.length.toString());
    return Scaffold(
        backgroundColor: theme1,
        appBar: AppBar(
          backgroundColor: theme1,
          elevation: 0.0,
          leading: Icon(
            Icons.arrow_back,
            color: black,
          ),
          actions: <Widget>[
            Padding(
              padding: const EdgeInsets.all(8.0),
              child: Icon(
                Icons.favorite_border,
                color: black,
              ),
            ),
            Padding(
              padding: const EdgeInsets.fromLTRB(0.0, 8.0, 12.0, 8.0),
              child: Icon(
                Icons.more_vert,
                color: black,
              ),
            ),
          ],
        ),
        body: Obx(() {
      return controller.isloading.isFalse
          ? Column(
              children: <Widget>[
                Text(
                      "Profile",
                      style: TextStyle(
                          fontWeight: FontWeight.bold,
                          color: Color(0xFF2661FA),
                          fontSize: 20),
                    ),
                _profilePic(),
                SizedBox(
                  height: 12,
                ),
                Text( controller.customerList.value[1].firstName.toString()+' '+ controller.customerList.value[1].lastName.toString(),
                                    style: TextStyle(
                          fontWeight: FontWeight.bold,
                          color: Color(0xFF2661FA),
                          fontSize: 20),
                    ),
                                  SizedBox(
                  height: 12,
                ),
                Text( controller.customerList.value[1].phone.toString(),
                                    style: TextStyle(
                                        fontWeight: FontWeight.bold,
                                        color: Color.fromARGB(255, 7, 16, 38),
                                        fontSize: 16),
                                          

                                  ),
                                     SizedBox(
                  height: 15,
                ),
                Column(
                  children: [
                    
                    
                    Container(
                      height: 60,
                      width: 340,
                      child: Card(
                        clipBehavior: Clip.antiAlias,
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(24),
                        ),
                        child: Column(
                          children: [
                            /* Padding(
                              padding: EdgeInsets.all(16).copyWith(bottom: 0),
                            ),*/
                            Stack(
                              children: [
                                Padding(
                                  padding:
                                      const EdgeInsets.fromLTRB(0, 0, 260, 0),
                                  child: Image.asset(
                                    "assets/images/contact.png",
                                    width: 30,
                                    height: 30,
                                  ),
                                ),
                                    Padding(
                                      padding: const EdgeInsets.fromLTRB(260, 10, 0, 0),

                                      child: Icon(Icons.edit,color: Colors.blueAccent,),
                                    ) ,
                                Positioned(
                                  bottom: 10,
                                  right: 16,
                                  left: 50,
                                  child: Text(
                                    controller.customerList.value[1].emailAdress
                                        .toString(),
                                    style: TextStyle(
                                        fontWeight: FontWeight.bold,
                                        color: Color.fromARGB(255, 7, 16, 38),
                                        fontSize: 16),
                                          

                                  ),

                                ),
                                
                              ],
                            ),
                          ],
                        ),
                      ),
                    ),
                    SizedBox(
                      height: 40,
                    ),
                    Container(
                      height: 60,
                      width: 340,
                      child: Card(
                        clipBehavior: Clip.antiAlias,
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(24),
                        ),
                        child: Column(
                          children: [
                            /* Padding(
                              padding: EdgeInsets.all(16).copyWith(bottom: 0),
                            ),*/
                             Stack(
                              children: [
                                Padding(
                                  padding:
                                      const EdgeInsets.fromLTRB(0, 0, 260, 0),
                                  child: Image.asset(
                                    "assets/images/contact.png",
                                    width: 30,
                                    height: 30,
                                  ),
                                ),
                                Padding(
                                      padding: const EdgeInsets.fromLTRB(260, 10, 0, 0),

                                      child: Icon(Icons.edit,color: Colors.blueAccent,),
                                    ) ,
                                Positioned(
                                  bottom: 10,
                                  right: 16,
                                  left: 50,
                                  child: Text(
                                  controller.customerList.value[1].birthDate!.day.toString()+"-"+controller.customerList.value[1].birthDate!.month.toString()+'-'+controller.customerList.value[1].birthDate!.year.toString(),

                                      
                                    style: TextStyle(
                                        fontWeight: FontWeight.bold,
                                        color: Color.fromARGB(255, 7, 16, 38),
                                        fontSize: 16),
                                  ),
                                ),
                              ],
                            ),
                          ],
                        ),
                      ),
                    ),
                    SizedBox(
                      height: 40,
                    ),
                    Container(
                      height: 60,
                      width: 340,
                      child: Card(
                        clipBehavior: Clip.antiAlias,
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(20),
                        ),
                        child: Column(
                          children: [
                            /* Padding(
                              padding: EdgeInsets.all(16).copyWith(bottom: 0),
                            ),*/
                            Stack(
                              children: [
                                Padding(
                                  padding:
                                      const EdgeInsets.fromLTRB(0, 0, 260, 0),
                                  child: Image.asset(
                                    "assets/images/mail.png",
                                    width: 30,
                                    height: 30,
                                  ),
                                ),
                                Padding(
                                      padding: const EdgeInsets.fromLTRB(260, 10, 0, 0),

                                      child: Icon(Icons.edit,color: Colors.blueAccent,),
                                    ) ,
                                Positioned(
                                  bottom: 10,
                                  right: 16,
                                  left: 50,
                                  child: Text(
                                                                      controller.customerList.value[1].gender!.label.toString(),

                                    style: TextStyle(
                                        fontWeight: FontWeight.bold,
                                        color: Color.fromARGB(255, 7, 16, 38),
                                        fontSize: 16),
                                  ),
                                ),
                              ],
                            ),
                          ],
                        ),
                      ),
                    ),
                    SizedBox(
                      height: 40,
                    ),
                    Container(
                      height: 60,
                      width: 340,
                      child: Card(
                        clipBehavior: Clip.antiAlias,
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(24),
                        ),
                        child: Column(
                          children: [
                            Stack(
                              children: [
                                Padding(
                                  padding:
                                      const EdgeInsets.fromLTRB(0, 0, 260, 0),
                                  child: Image.asset(
                                    "assets/images/phone.png",
                                    width: 30,
                                    height: 30,
                                  ),
                                ),
                                Padding(
                                      padding: const EdgeInsets.fromLTRB(260, 10, 0, 0),

                                      child: Icon(Icons.edit,color: Colors.blueAccent,),
                                    ) ,
                                Positioned(
                                  bottom: 10,
                                  right: 16,
                                  left: 50,
                                  child: Text(
                                    controller.customerList.value[1].status!.label
                                        .toString(),
                                    style: TextStyle(
                                        fontWeight: FontWeight.bold,
                                        color: Color.fromARGB(255, 7, 16, 38),
                                        fontSize: 16),
                                  ),
                                ),
                              ],
                            ),
                            /* Padding(
                              padding: EdgeInsets.all(16).copyWith(bottom: 0),
                            ),*/
                          ],
                        ),
                      ),
                    ),
                  ],
                ),
              ],
            ): Container(
              child: Center(child: CircularProgressIndicator()),
            );
          
        }),
        bottomNavigationBar: BottomNavigationBar(
          
          currentIndex: currentIndex,
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
              icon: Icon(Icons.heart_broken,color: Colors.redAccent,),
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
        ));
  }
  
                                

                                

  Container _profilePic() => Container(
        child: Padding(
          padding: const EdgeInsets.fromLTRB(120.0, 30.0, 120.0, 15.0),
          child: Stack(
            //alignment: const Alignment(0.9, 0.9),
            children: <Widget>[
              CircleAvatar(
                backgroundImage: AssetImage("assets/images/main.png"),
                radius: 80.0,
              ),
            ],
          ),
        ),
      );
      
      
}
