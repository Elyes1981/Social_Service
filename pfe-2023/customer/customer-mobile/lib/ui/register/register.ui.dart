/*import 'package:demo/shared/constants/Background.dart';
import 'package:demo/ui/register/register.controller.dart';*/
import 'package:customermobile/ui/register/register.controller.dart';
import 'package:email_validator/email_validator.dart';
import 'package:flutter/material.dart';
import 'package:gender_picker/source/enums.dart';
import 'package:gender_picker/source/gender_picker.dart';
import 'package:gender_selection/gender_selection.dart';
import 'package:get/get.dart';
import 'package:intl_phone_field/intl_phone_field.dart';
import 'package:intl/intl.dart';
import 'package:select_form_field/select_form_field.dart';
import 'package:sliding_switch/sliding_switch.dart';

import '../../shared/constants/Background.dart';

class Register extends GetView<RegisterController> {
  int _currentStep = 0;
  StepperType stepperType = StepperType.vertical;
  TextEditingController dateinput = TextEditingController();
  TextEditingController confirmpassword = TextEditingController();
  final TextEditingController emailController = TextEditingController();
  TextEditingController password = TextEditingController();
  bool _isPasswordEightCharacters = false;
  bool _hasPasswordOneNumber = false;
  bool _hasPwdOneCharacter = false;
  bool _hasPwdOneUpCharacter = false;
  bool _isVisible = false;
  bool _isObscure = false;

  onPasswordChanged(String password) {
    final numericRegex = RegExp(r'[0-9]');
    final charRegex = RegExp(r'[!@#$&*]');
     
    _isPasswordEightCharacters = false;
    if (password.length >= 8) _isPasswordEightCharacters = true;

    _hasPasswordOneNumber = false;
    if (numericRegex.hasMatch(password)) _hasPasswordOneNumber = true;
    _hasPwdOneCharacter = false;
    if (charRegex.hasMatch(password)) _hasPwdOneCharacter = true;
  }

  Color bulbColor = Colors.black;
  final _formKey = GlobalKey<FormState>();

  @override
  Widget build(BuildContext context) {
    controller.findGender();
    controller.findStatus();
    return Scaffold(
        /* appBar: AppBar(
          automaticallyImplyLeading: false,
            title: Text('Flutter Stepper Demo'),
          centerTitle: true,
        ),
        */

        body: Background(child: Obx(() {
      return controller.isloading.isTrue
          ? SingleChildScrollView(
              scrollDirection: Axis.vertical,
              child: Form(
                  key: _formKey,
                  child: Padding(
                    padding: EdgeInsets.fromLTRB(10, 100, 10, 0),
                    child: Column(children: [
                      SingleChildScrollView(),
                      Container(
                        alignment: Alignment.centerLeft,
                        padding: EdgeInsets.symmetric(horizontal: 40),
                        child: Text(
                          "Sign Up",
                          style: TextStyle(
                              fontWeight: FontWeight.bold,
                              color: Color(0xFF2661FA),
                              fontSize: 36),
                          textAlign: TextAlign.left,
                        ),
                      ),
                      SingleChildScrollView(
                        scrollDirection: Axis.vertical,

                      ),
                     // default bottomRight
                               
                      Padding(
                        padding: const EdgeInsets.fromLTRB(60, 0, 220, 0),
                        child: SelectFormField(
                          type:
                              SelectFormFieldType.dropdown, // or can be dialog
                          initialValue: "Male",


                          items: controller.GenderList,
                          onChanged: (String val) =>
                              {controller.genderSelected = val},
                          onSaved: (val) => {},
                        ),
                      ),
                      Padding(
                        padding: const EdgeInsets.fromLTRB(60, 0, 220, 0),
                        child: SelectFormField(
                          type:
                              SelectFormFieldType.dropdown, // or can be dialog
                          initialValue: "Single",

                          items: controller.StatusList,
                          onChanged: (String val) =>
                              {controller.statusSelected = val},
                          onSaved: (val) => {},
                        ),
                      ),
                      Padding(
                        padding: const EdgeInsets.fromLTRB(10, 30, 160, 0),
                        child: Container(

                            /*child: SlidingSwitch(
                                  
              
              
              value: false,
              width: 250,
              onChanged: (bool value) {
                print(value);
              },
              height: 55,
              animationDuration: const Duration(milliseconds: 400),
              onTap:(){ },
              onDoubleTap: () {},
              onSwipe: () {},
              textOff: controller.GenderList.value[0],
              textOn: controller.GenderList.value[1],
              colorOn: Color.fromARGB(255, 10, 4, 52),
              colorOff: const Color(0xff6682c0),
              background: const Color(0xffe4e5eb),
              buttonColor: const Color(0xfff7f5f7),
              inactiveColor: const Color(0xff636f7b),
            ),*/
                            ),
                      ),



                      Container(
                        child: TextFormField(
                          controller: controller.firstName,
                          validator: (value) {
                            if (value == null || value.isEmpty) {
                              return 'Please enter your First Name';
                            }
                            return null;
                          },
                          decoration: InputDecoration(
                            labelText: 'First Name',
                            border: OutlineInputBorder(
                              borderSide: BorderSide(),
                            ),
                          ),
                        ),
                      ),
                      SizedBox(
                        height: 15,
                      ),
                      Container(
                        child: TextFormField(
                          controller: controller.lastName,
                          validator: (value) {
                            if (value == null || value.isEmpty) {
                              return 'Please enter some text';
                            }
                            return null;
                          },
                          decoration: InputDecoration(
                            labelText: 'Last Name',
                            border: OutlineInputBorder(
                              borderSide: BorderSide(),
                            ),
                          ),
                        ),
                      ),
                     
                      SizedBox(
                        height: 15,
                      ),
                      TextField(
                        controller:controller.birthDate,
                            //editing controller of this TextField
                        decoration: InputDecoration(
                          labelText: "Birth Date",
                          border: OutlineInputBorder(
                            borderSide: BorderSide(),
                          ),
                          //icon of text field
                          //icon: Icon(Icons.calendar_today),
                          //label text of field
                        ),
                        readOnly:
                            true, //set it true, so that user will not able to edit text
                        onTap: () async {
                          DateTime? pickedDate = await showDatePicker(
                            context: context,
                            initialDate: DateTime.now(),

                            firstDate: DateTime(
                                2000), //DateTime.now() - not to allow to choose before today.
                            lastDate: DateTime(2030),
                          );
controller.birthDate.text=pickedDate.toString().substring(0,10);
                          if (pickedDate != null) {
                            print(
                                pickedDate); //pickedDate output format => 2021-03-10 00:00:00.000
                            String formattedDate =
                                DateFormat('dd-MM-yyyy').format(pickedDate);
                            print(
                                formattedDate); //formatted date output using intl package =>  2021-03-16
                            //you can implement different kind of Date Format here according to your requirement

                            dateinput.text =
                                formattedDate; //set output date to TextField value.

                          } else {
                            print("Date is not selected");
                          }
                        },
                      ),
                      SizedBox(
                        height: 15,
                      ),
                      Container(
                        child: IntlPhoneField(
                          controller: controller.phone,
                          decoration: InputDecoration(
                            labelText: 'Phone Number',
                            border: OutlineInputBorder(
                              borderSide: BorderSide(),
                            ),
                          ),
                          initialCountryCode: 'TN',
                          onChanged: (phone) {
                            print(phone.completeNumber);
                          },
                        ),
                      ),
                      SizedBox(
                        height: 15,
                      ),
                      TextField(
                        controller: controller.emailAdress,
                        decoration: InputDecoration(
                          border: OutlineInputBorder(),
                          hintText: 'Enter a valid Email Adress',
                          prefixIcon: Icon(Icons.mail),
                        ),
                        autofillHints: [AutofillHints.email],
                        keyboardType: TextInputType.emailAddress,
                      ),
                      TextField(
                        onChanged: (password) => onPasswordChanged(password),
                        obscureText: !_isVisible,
                        decoration: InputDecoration(
                          suffixIcon: IconButton(
                            onPressed: () {
                              _isVisible = !_isVisible;
                            },
                            icon: _isVisible
                                ? Icon(
                                    Icons.visibility,
                                    color: Colors.black,
                                  )
                                : Icon(
                                    Icons.visibility_off,
                                    color: Colors.grey,
                                  ),
                          ),
                          border: OutlineInputBorder(
                              borderRadius: BorderRadius.circular(10),
                              borderSide: BorderSide(color: Colors.black)),
                          focusedBorder: OutlineInputBorder(
                              borderRadius: BorderRadius.circular(10),
                              borderSide: BorderSide(color: Colors.black)),
                          hintText: "Password",
                          contentPadding: EdgeInsets.symmetric(
                              horizontal: 20, vertical: 20),
                        ),
                      ),
                      SizedBox(
                        height: 30,
                      ),
                      
                      
                      Row(
                        children: [
                          AnimatedContainer(
                            duration: Duration(milliseconds: 100),
                            width: 20,
                            height: 20,
                            decoration: BoxDecoration(
                                color: _hasPwdOneCharacter
                                    ? Colors.green
                                    : Colors.transparent,
                                border: _hasPwdOneCharacter
                                    ? Border.all(color: Colors.transparent)
                                    : Border.all(color: Colors.grey.shade400),
                                borderRadius: BorderRadius.circular(50)),
                            child: Center(
                              child: Icon(
                                Icons.check,
                                color: Colors.white,
                                size: 15,
                              ),
                            ),
                          ),
                          SizedBox(
                            width: 10,
                          ),
                          Text("Contains at least 1 Special")
                        ],
                      ),
                     
                      SizedBox(
                        height: 17,
                      ),
                      SizedBox(
                        width: double.infinity,
                        child: ElevatedButton(
                          onPressed: () {
                         //   controller.createCustomer();
                            controller
                                .addcustomer(_formKey.currentState!.validate());
                            Navigator.of(context).pushNamed("login");
                          },
                          style: ButtonStyle(
                            foregroundColor:
                                MaterialStateProperty.all<Color>(Colors.white),
                            backgroundColor: MaterialStateProperty.all<Color>(
                                Color.fromARGB(255, 59, 119, 189)),
                            shape: MaterialStateProperty.all<
                                RoundedRectangleBorder>(
                              RoundedRectangleBorder(
                                borderRadius: BorderRadius.circular(24.0),
                              ),
                            ),
                          ),
                          child: Padding(
                            padding: EdgeInsets.all(14.0),
                            child: Text(
                              'Sign Up',
                              style: TextStyle(fontSize: 16),
                            ),
                          ),
                        ),
                      ),
                    ]),
                  )
                  )
                  )
          : Container(
              child: Center(child: CircularProgressIndicator()),
            );
    }
    )
    ));
  }
}
