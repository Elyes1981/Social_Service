import 'package:demo/core/models/Mou3inaModel.dart';
import 'package:demo/ui/profil/moreDetails.dart';
import 'package:demo/ui/profil/profilController.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';

import 'package:shared_preferences/shared_preferences.dart';

class Profile extends GetView<profilController> {
  Profile({Key? key}) : super(key: key);
  bool isEditMode = false;
  Mou3inaEntity? user;
  String? username;
  String? emailAdress;
 int? id;
 bool isSignin = false;

  getToken() async {
    SharedPreferences sharedPreferences = await SharedPreferences.getInstance();
 
    username = sharedPreferences.getString("username");
    emailAdress = sharedPreferences.getString("emailAdress");
  print(username);
  print(emailAdress);
  print("amal");

    if (username != null) {
    
    }
  }

  @override
 
  TextEditingController _passwordController = TextEditingController();
  bool vis = true;
  @override
  Widget build(BuildContext context) {
    double width = MediaQuery.of(context).size.width;
    double height = MediaQuery.of(context).size.height;
    return Stack(
      fit: StackFit.expand,
      children: [
        Container(
          decoration: BoxDecoration(
            gradient: LinearGradient(
              colors: [
                Color.fromRGBO(4, 9, 35, 1),
                Color.fromRGBO(39, 105, 171, 1),
              ],
              begin: FractionalOffset.bottomCenter,
              end: FractionalOffset.topCenter,
            ),
          ),
        ),
        Scaffold(
          backgroundColor: Colors.transparent,
          body: SingleChildScrollView(
            physics: BouncingScrollPhysics(),
            child: Padding(
              padding: const EdgeInsets.symmetric(horizontal: 16, vertical: 73),
              child: Column(
                children: [
                 
                  
                  Text(
                    "12".tr,
                    textAlign: TextAlign.center,
                    style: TextStyle(
                      color: Colors.white,
                      fontSize: 34,
                      fontFamily: 'Nisebuschgardens',
                    ),
                  ),
                  Container(
                    height: height * 0.50,
                    child: LayoutBuilder(
                      builder: (context, constraints) {
                        double innerHeight = constraints.maxHeight;
                        double innerWidth = constraints.maxWidth;
                        return Stack(
                          fit: StackFit.expand,
                          children: [
                            Positioned(
                              bottom: 0,
                              left: 0,
                              right: 0,
                              child: Container(
                                height: innerHeight * 0.80,
                                width: innerWidth,
                                decoration: BoxDecoration(
                                  borderRadius: BorderRadius.circular(30),
                                  color: Colors.white,
                                ),
                                child: Column(children: [
                                  SizedBox(
                                    height: 150,
                                  ),
                                  Column(
                                      mainAxisAlignment:
                                          MainAxisAlignment.center,
                                      children: [
                                        Column(children: [
                                          controller.name!= null
                                              ? Text("13".tr+":"+
                                                  controller.name!,
                                                  style: TextStyle(
                                                    color: Color.fromARGB(255, 11, 11, 13),
                                                    fontFamily: 'Nunito',
                                                    fontSize: 20,
                                                  ),
                                                )
                                              : Text("Loading"),
                                        ]),
                                        SizedBox(
                                          width: 5,
                                        ),
                                        Column(children: [
                                          controller.emaill!= null
                                              ? Text(
                                                  "46".tr+":"+
                                                  controller.emaill!,
                                                  style: TextStyle(
                                                    color: Color.fromARGB(255, 15, 16, 17),
                                                    fontSize: 20,
                                                  ),
                                                )
                                              : Text("Loading"),
                                        ]),
                                      ]),

                                  
                                  SizedBox(
                                    height: 5,
                                  ),
                                  Column(children: [
                                    controller.usernName != null
                                        ? Text(
                                            "47".tr +":"+
                                                  controller.usernName!,
                                            style: TextStyle(
                                              color: Color.fromARGB(255, 15, 17, 20),
                                              fontFamily: 'Nunito',
                                              fontSize: 20,
                                            ),
                                          )
                                        : Text("Loading"),
                                  ]),
                               
                            
                               
        
                                ]),
                              ),
                            ),
                         
                   Positioned(
                              top: 0,
                              left: 0,
                              right: 0,
                              child: Center(
                                child: Container(
                                  child: Image.asset(
                                    'assets/profile.png',
                                    width: innerWidth * 0.45,
                                    fit: BoxFit.fitWidth,
                                  ),
                                ),
                              ),
                            ),
                            
                          ],
                        );
                      },
                    ),
                  ),
                 RaisedButton(
          child: Text("More details"),
          onPressed: () {
            showDialog(
                context: context,
                builder: (BuildContext context) {
                  return AlertDialog(
                    scrollable: true,
                    title: Text('Profil'),
                    content: Padding(
                      padding: const EdgeInsets.all(8.0),
                      child: Form(
                        child: Column(
                          children: <Widget>[
                           Text(
                                            "FirstName" +":"+
                                                  "Sonia",
                                            style: TextStyle(
                                              color: Color.fromARGB(255, 20, 21, 21),
                                              fontFamily: 'Nunito',
                                              fontSize: 20,
                                            ),
                                          ),
                                       SizedBox(
                                            height: 30,
                                          ),
                                             Text(
                                            "LastName" +":"+
                                                  "lassoued",
                                            style: TextStyle(
                                              color: Color.fromARGB(255, 20, 21, 21),
                                              fontFamily: 'Nunito',
                                              fontSize: 20,
                                            ),
                                          ),
                                       SizedBox(
                                            height: 30,
                                          ),
                                         Text(
                                            "Service" +":"+
                                                  "cook",
                                            style: TextStyle(
                                              color: Color.fromARGB(255, 20, 21, 21),
                                              fontFamily: 'Nunito',
                                              fontSize: 20,
                                            ),
                                          ),
                                       SizedBox(
                                            height: 30,
                                          ),
                         
                                        Text(
                                            "langage Speaking" +":"+
                                                  "frensh",
                                            style: TextStyle(
                                              color: Color.fromARGB(255, 12, 15, 18),
                                              fontFamily: 'Nunito',
                                              fontSize: 20,
                                            ),
                                          )
                                        ,
                            SizedBox(
                                            height: 30,
                                          ),
                                         Text(
                                            "Birthday" +":"+
                                                  "24/11/1998",
                                            style: TextStyle(
                                              color: Color.fromARGB(255, 18, 21, 25),
                                              fontFamily: 'Nunito',
                                              fontSize: 20,
                                            ),
                                          ),
                                            SizedBox(
                                            height: 30,
                                          ),
                                       Text(
                                            "Service" +":"+
                                                  "cook",
                                            style: TextStyle(
                                              color: Color.fromARGB(255, 11, 14, 17),
                                              fontFamily: 'Nunito',
                                              fontSize: 20,
                                            ),
                                          ),
                                            SizedBox(
                                            height: 30,
                                          ),
                                          Text(
                                            "Phone2" +":"+
                                                  "25654334",
                                            style: TextStyle(
                                              color: Color.fromARGB(255, 16, 20, 24),
                                              fontFamily: 'Nunito',
                                              fontSize: 20,
                                            ),
                                          ),
                                          SizedBox(
                                            height: 30,
                                          ),
                                              Text(
                                            "Home-Adress" +":"+
                                                  "sfax",
                                            style: TextStyle(
                                              color: Color.fromARGB(255, 16, 20, 24),
                                              fontFamily: 'Nunito',
                                              fontSize: 20,
                                            ),
                                          )
                                       
                          ],
                        ),
                      ),
                    ),
                     actions: [
                      RaisedButton(
                          child: Text("Back"),
                          onPressed: () {
                            // your code
                          })
                    ],
                  );
                });
          },
        ),
                ],
              ),
            ),
          ),
        )
      ],
    );
  }
}
