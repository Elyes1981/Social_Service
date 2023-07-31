
import 'package:demo/ui/Reclamation/ReclamationController.dart';
import 'package:demo/ui/login/MENU.dart';
import 'package:demo/ui/login/login.ui.dart';
import 'package:demo/ui/signup/signup.dart';

import 'package:demo/ui/signup/signupController.dart';
import 'package:flutter/material.dart';
import 'package:gender_selection/gender_selection.dart';
import 'package:get/get.dart';

import 'package:intl_phone_field/intl_phone_field.dart';
import 'package:multiselect_formfield/multiselect_formfield.dart';
import 'package:grouped_buttons/grouped_buttons.dart';
import 'package:select_form_field/select_form_field.dart';

class Reclamation extends GetView<ReclamationController> {
  Reclamation({Key? key}) : super(key: key);

  
   final GlobalKey<FormState> _formKeyy = GlobalKey<FormState>();
   
 


  @override
  Widget build(BuildContext context) {
    return Scaffold(
       
      body: SingleChildScrollView(
        child: Column(
          children: [
             Positioned.fill(  //
            child: Image(
              image: AssetImage('assets/reclamation.jpg'),
              fit : BoxFit.fill,
           ),
          ), 
            //Positioned(
           //     top: 0,
             //   child: Image.asset(
              //    'assets/reclamation.jpg',
               //   width: 400,
               //   height: 150,
             //   )),
            Container(
              alignment: Alignment.center,
        
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.start,
                  crossAxisAlignment: CrossAxisAlignment.center,
                  children: [
              
                 
                    SizedBox(
                      height: 25,
                    ),
             
          
       


        Form(
            
            key: _formKeyy,
            child: Column(
              mainAxisAlignment: MainAxisAlignment.start,
              children: <Widget>[
                
  
                
             
            
              TextFormField(
                controller: controller.message,
                validator: (value) {},
                decoration: InputDecoration(
                    hintText: "42".tr,
                    enabledBorder: OutlineInputBorder(
                        borderRadius: BorderRadius.circular(16),
                        borderSide: BorderSide(color: Colors.blue)),
                    focusedBorder: OutlineInputBorder(
                        borderRadius: BorderRadius.circular(16),
                        borderSide: BorderSide(color: Colors.blue)),
                    errorBorder: OutlineInputBorder(
                        borderRadius: BorderRadius.circular(16),
                        borderSide: BorderSide(color: Colors.red)),
                    focusedErrorBorder: OutlineInputBorder(
                        borderRadius: BorderRadius.circular(16),
                        borderSide: BorderSide(color: Colors.red))),
              ),
               SizedBox(
                          height: 20,

                        ),
                                                    SelectFormField(
  type: SelectFormFieldType.dropdown, // or can be dialog
  initialValue: '',
 
  labelText: "43".tr,
  items: controller.ListStatusReclamation,
  onChanged: (val) =>{controller.statusReclamation= val},
  onSaved: (val) => {},
)
                                                
             
              ],
            
          ),),       
     
  
       
               SizedBox(
                          height: 10,

                        ),
              Row(
           mainAxisAlignment: MainAxisAlignment.spaceEvenly,
          children: [
            
             FlatButton(

                        color: Colors.blue,
                        shape: RoundedRectangleBorder(
                            borderRadius: BorderRadius.circular(16.0)),
                        onPressed: () {
                         
                  controller.createReclamation();
                   controller.addReclamation(_formKeyy.currentState!.validate());
                 Navigator.push(


                 context,
                 MaterialPageRoute(
                   builder: (context) => LoginView(),
                 ),
                );
                        },
                        child: Text(
                          "44".tr,
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
                   builder: (context) => Categories(),
                 ),
                );
                        },
                        child: Text(
                          "45".tr,
                          style: TextStyle(color: Colors.white, fontSize: 20),
                        )),
          ],
        )
          
                  ],
                ),
                  
              ),
            
          ],
        ),
      ),
    );
  }
}
