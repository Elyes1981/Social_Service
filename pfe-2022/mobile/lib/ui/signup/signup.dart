
import 'package:demo/ui/login/login.ui.dart';
import 'package:demo/ui/signup/SignUp3.dart';

import 'package:demo/ui/signup/signupController.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';

import 'package:multiselect_formfield/multiselect_formfield.dart';
import 'package:select_form_field/select_form_field.dart';


class SignUp extends GetView<ServiceTypeController> {
  SignUp({ Key? key }) : super(key: key);
  final formKey = new GlobalKey<FormState>();
  
  @override
  Widget build(BuildContext context) {

    return Scaffold(
       
       
      
      body:   SingleChildScrollView(
        child: Column(
          children: [
      Column(children: [
        Positioned(
            top: 0,
            child: Image.asset(
              'assets/2.jpg',
              width: 400,
              height: 150,
            )),
        Container(
          alignment: Alignment.center,
          child: Form(
           
            child: Column(
              mainAxisAlignment: MainAxisAlignment.start,
              crossAxisAlignment: CrossAxisAlignment.center,
              children: [
                SizedBox(
                  height: 2,
                ),
                Text(
                  "SignUp",
                 
                ),

                           
                  SizedBox(
                  height: 25,
                ),
               
         
              ],
            ),
          ),
        ),
         

        
        
        Row(
           mainAxisAlignment: MainAxisAlignment.spaceEvenly,
          children: [
            
             FlatButton(

                        color: Colors.blue,
                        shape: RoundedRectangleBorder(
                            borderRadius: BorderRadius.circular(16.0)),
                        onPressed: () {
                 Navigator.push(
                 context,
                 MaterialPageRoute(
                   builder: (context) => LoginView(),
                 ),
                );
                        },
                        child: Text(
                          "Continue",
                          style: TextStyle(color: Colors.white, fontSize: 20),
                        )),
                        SizedBox(
                          width: 140,

                        ),
                         FlatButton(
                        color: Colors.blue,
                        shape: RoundedRectangleBorder(
                            borderRadius: BorderRadius.circular(16.0)),
                        onPressed: () {
                 Navigator.push(
                 context,
                 MaterialPageRoute(
                   builder: (context) => SignUp3(),
                 ),
                );
                        },
                        child: Text(
                          "cancel",
                          style: TextStyle(color: Colors.white, fontSize: 20),
                        )),
          ],
        )
          
                        
        
       
           ],
                  ),
                
       ], ),
      ),
                );
                
          
              
            
       
        
    
        
    
  
  
  }
}

