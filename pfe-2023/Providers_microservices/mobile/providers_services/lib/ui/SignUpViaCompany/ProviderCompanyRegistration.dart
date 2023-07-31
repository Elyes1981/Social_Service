
import 'package:flutter/material.dart';
import 'package:gender_selection/gender_selection.dart';
import 'package:get/get.dart';
import 'package:get/get_connect/http/src/utils/utils.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:intl/intl.dart';

import 'package:intl_phone_field/intl_phone_field.dart';
import 'package:multiselect_formfield/multiselect_formfield.dart';
import 'package:grouped_buttons/grouped_buttons.dart';
import 'package:providers_services/ui/login/login.ui.dart';
import 'package:providers_services/ui/signup/map.dart';
import 'package:providers_services/ui/signup/signupController.dart';
import 'package:select_form_field/select_form_field.dart';

class ProviderCompanyRegistration extends GetView<ServiceTypeController> {
  ProviderCompanyRegistration({Key? key}) : super(key: key);

  final GlobalKey<FormState> _formKeyy = GlobalKey<FormState>();

  final GlobalKey<FormState> formKey = GlobalKey<FormState>();


  String _password = '';
  @override
  Widget build(BuildContext context) {
    print('test');
    return Scaffold(
      appBar: AppBar(
        toolbarHeight: 100,
        title: Text(
          "19".tr,
          style: GoogleFonts.pacifico(
              fontWeight: FontWeight.bold, fontSize: 50, color: Colors.white),
        ),
        centerTitle: true,
      ),
      body: SingleChildScrollView(
        child: Column(
          children: [
            Container(
              alignment: Alignment.center,
              child: Column(
                mainAxisAlignment: MainAxisAlignment.start,
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [
                  Obx(() {
                    return controller.isLoading.isFalse
                        ? Form(
                      key: _formKeyy,
                      child: Column(
                        mainAxisAlignment: MainAxisAlignment.start,
                        children: <Widget>[
                          Container(
                            padding: EdgeInsets.all(16),
                            child: MultiSelectFormField(
                              autovalidate: AutovalidateMode.disabled,
                              chipBackGroundColor: Colors.blue,
                              chipLabelStyle: TextStyle(
                                  fontWeight: FontWeight.bold,
                                  color: Colors.white),
                              dialogTextStyle:
                              TextStyle(fontWeight: FontWeight.bold),
                              checkBoxActiveColor: Colors.blue,
                              checkBoxCheckColor: Colors.white,
                              dialogShapeBorder: RoundedRectangleBorder(
                                  borderRadius: BorderRadius.all(
                                      Radius.circular(12.0))),
                              title: Text(
                                "55".tr,
                                style: TextStyle(fontSize: 16),
                              ),
                              validator: (value) {
                                if (value == null || value.length == 0) {
                                  return 'Please select one or more options';
                                }
                                return null;
                              },
                              dataSource: [
                                {
                                  'value': controller.rs[0],
                                  'display': Get.locale!.languageCode == 'ar' ? controller.rs[0].label_ar : Get.locale!.languageCode == 'fr' ? controller.rs[0].label_fr : Get.locale!.languageCode == 'en' ? controller.rs[0].label : 'en',
                                  'textStyle':
                                  TextStyle(color: Colors.black),
                                },
                                {
                                  'value': controller.rs[1],
                                  'display': Get.locale!.languageCode == 'ar' ? controller.rs[1].label_ar : Get.locale!.languageCode == 'fr' ? controller.rs[1].label_fr : Get.locale!.languageCode == 'en' ? controller.rs[1].label : 'en',
                                },
                                {
                                  'value': controller.rs[2],
                                  'display': Get.locale!.languageCode == 'ar' ? controller.rs[2].label_ar : Get.locale!.languageCode == 'fr' ? controller.rs[2].label_fr : Get.locale!.languageCode == 'en' ? controller.rs[2].label : 'en',
                                },
                                {
                                  'value': controller.rs[3],
                                  'display': Get.locale!.languageCode == 'ar' ? controller.rs[3].label_ar : Get.locale!.languageCode == 'fr' ? controller.rs[3].label_fr : Get.locale!.languageCode == 'en' ? controller.rs[3].label : 'en',
                                }
                              ],
                              textField: 'display',
                              valueField: 'value',
                              okButtonLabel: "56".tr,
                              cancelButtonLabel: "57".tr,
                              initialValue: controller.selectedValues,
                              hintWidget: Text('Please choose one or more'),
                              onSaved: (value) {
                                print(value);

                                for (dynamic v in value) {
                                  controller.selectedValues.add(v);
                                }

                                print('serviceTypes');
                              },
                            ),
                          ),

                          Container(
                            padding: EdgeInsets.all(16),
                            child: MultiSelectFormField(
                              autovalidate: AutovalidateMode.disabled,
                              chipBackGroundColor: Colors.blue,
                              chipLabelStyle: TextStyle(
                                  fontWeight: FontWeight.bold,
                                  color: Colors.white),
                              dialogTextStyle:
                              TextStyle(fontWeight: FontWeight.bold),
                              checkBoxActiveColor: Colors.blue,
                              checkBoxCheckColor: Colors.white,
                              dialogShapeBorder: RoundedRectangleBorder(
                                  borderRadius: BorderRadius.all(
                                      Radius.circular(12.0))),
                              title: Text(
                                "75".tr,
                                style: TextStyle(fontSize: 16),
                              ),
                              validator: (value) {
                                if (value == null || value.length == 0) {
                                  return 'Please select one or more options';
                                }
                                return null;
                              },
                              dataSource: [
                                {
                                  "display": Get.locale!.languageCode == 'ar' ? controller.ls[0].label_ar : Get.locale!.languageCode == 'fr' ? controller.ls[0].label_fr : Get.locale!.languageCode == 'en' ? controller.ls[0].label : 'en',
                                  "value": controller.ls[0],
                                },
                                {
                                  "display": Get.locale!.languageCode == 'ar' ? controller.ls[1].label_ar : Get.locale!.languageCode == 'fr' ? controller.ls[1].label_fr : Get.locale!.languageCode == 'en' ? controller.ls[1].label : 'en',
                                  "value": controller.ls[1],
                                },
                                {
                                  "display": Get.locale!.languageCode == 'ar' ? controller.ls[2].label_ar : Get.locale!.languageCode == 'fr' ? controller.ls[2].label_fr : Get.locale!.languageCode == 'en' ? controller.ls[2].label : 'en',
                                  "value": controller.ls[2],
                                },
                              ],
                              textField: 'display',
                              valueField: 'value',
                              okButtonLabel: "56".tr,
                              cancelButtonLabel: "57".tr,
                              initialValue: controller.selectedValuess,
                              hintWidget: Text(''),
                              onSaved: (value) {
                                print(value);

                                for (dynamic v in value) {
                                  controller.selectedValuess.add(v);
                                }

                                print('LangageSpeaking');
                              },
                            ),
                          ),
                          SizedBox(
                            height: 25,
                          ),
                          TextFormField(
                            controller: controller.firstName,
                            validator: (value) {},
                            decoration: InputDecoration(
                                hintText: "58".tr,
                                hintStyle:
                                TextStyle(color: Colors.black87)),
                          ),
                          SizedBox(
                            height: 25,
                          ),
                          TextFormField(
                            controller: controller.username,
                            validator: (value) {},
                            decoration: InputDecoration(
                                hintText: "47".tr,
                                hintStyle:
                                TextStyle(color: Colors.black87)),
                          ),
                          SizedBox(
                            height: 25,
                          ),
                          TextFormField(
                            controller: controller.password,
                            decoration:
                            InputDecoration(hintText: "16".tr),
                            obscureText: true,
                            validator: (value) {
                              if (value == null || value.trim().isEmpty) {
                                return 'This field is required';
                              }
                              if (value.trim().length < 8) {
                                return 'Password must be at least 8 characters in length';
                              }
                              // Return null if the entered password is valid
                              return null;
                            },
                            onChanged: (value) => _password = value,
                          ),
                          SizedBox(
                            height: 25,
                          ),
                          TextFormField(
                            controller: controller.lastName,
                            validator: (value) {},
                            decoration: InputDecoration(
                                hintText: "59".tr,
                                hintStyle:
                                TextStyle(color: Colors.black87)),
                          ),
                          SizedBox(
                            height: 25,
                          ),
                          TextFormField(
                            controller: controller.emailAdress,
                            decoration: InputDecoration(
                              labelText: "46".tr,
                            ),
                            validator: (value) {
                              if (value!.isEmpty ||
                                  !RegExp(r'^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$')
                                      .hasMatch(value)) {
                                return "Enter Correct Email Address";
                              } else {
                                return null;
                              }
                            },
                          ),
                          SizedBox(
                            height: 25,
                          ),
                          TextFormField(
                            controller: controller.home_Adress,
                            validator: (value) {},
                            decoration: InputDecoration(
                                hintText: "60".tr,
                                hintStyle:
                                TextStyle(color: Colors.black87)),
                          ),
                          SizedBox(
                            height: 25,
                          ),
                          TextFormField(
                            keyboardType: TextInputType.number,
                            controller: controller.rib,
                            validator: (value) {},
                            decoration: InputDecoration(
                                hintText: "61".tr,
                                hintStyle:
                                TextStyle(color: Colors.black87)),
                          ),
                          SizedBox(
                            height: 25,
                          ),
                          TextFormField(
                            keyboardType: TextInputType.number,
                            controller: controller.documentIdType,
                            validator: (value) {},
                            decoration: InputDecoration(
                                hintText: "62".tr,
                                hintStyle:
                                TextStyle(color: Colors.black87)),
                          ),
                          SizedBox(
                            height: 25,
                          ),
                          IntlPhoneField(
                            controller: controller.phone,
                            decoration: InputDecoration(
                                labelText: "63".tr,
                                hintStyle:
                                TextStyle(color: Colors.black87)),
                            initialCountryCode: 'TN',
                            onChanged: (phone) {
                              print(phone.completeNumber);
                            },
                          ),
                          SizedBox(
                            height: 25,
                          ),
                          IntlPhoneField(
                            controller: controller.phone2,
                            decoration: InputDecoration(
                                labelText: "64".tr,
                                hintStyle:
                                TextStyle(color: Colors.black87)),
                            initialCountryCode: 'TN',
                            onChanged: (phone) {
                              print(phone.completeNumber);
                            },
                          ),
                          SizedBox(
                            height: 25,
                          ),
                          SizedBox(
                            height: 25,
                          ),
                          SelectFormField(
                            type: SelectFormFieldType
                                .dropdown, // or can be dialog
                            initialValue: '',

                            labelText: "65".tr,
                            style: TextStyle(color: Colors.black87),
                            items: controller.Listsmartphone,
                            onChanged: (val) =>
                            {controller.smartPhone = val},
                            onSaved: (val) => {},
                          ),
                          SizedBox(
                            height: 25,
                          ),
                          TextFormField(
                            controller: controller.video,
                            validator: (value) {},
                            decoration: InputDecoration(
                                hintText: "66".tr,
                                hintStyle:
                                TextStyle(color: Colors.black87)),
                          ),
                          SizedBox(
                            height: 25,
                          ),
                          SelectFormField(
                            type: SelectFormFieldType
                                .dropdown, // or can be dialog
                            initialValue: 'man',

                            labelText: "67".tr,

                            items: controller.genderList,
                            onChanged: (String val) =>
                            {controller.genderSelected = val},
                            onSaved: (val) => {},
                          ),
                          SizedBox(
                            height: 25,
                          ),
                          SelectFormField(
                              type: SelectFormFieldType
                                  .dropdown, // or can be dialog
                              initialValue: 'Single',
                              style: TextStyle(color: Colors.black87),
                              labelText: '68'.tr,
                              items: controller.StatusList,
                              onChanged: (val) =>
                              {controller.statusSelected = val},
                              onSaved: (val) => {}),
                          SizedBox(
                            height: 25,
                          ),
                          SelectFormField(
                            type: SelectFormFieldType
                                .dropdown, // or can be dialog
                            initialValue: ' 6month->1years',
                            style: TextStyle(color: Colors.black87),
                            labelText: '69'.tr,

                            items: controller.seniorityList,
                            onChanged: (val) =>
                            {controller.senioritySelected = val},
                            onSaved: (val) => {},
                          ),
                          SizedBox(
                            height: 25,
                          ),
                          SelectFormField(
                            type: SelectFormFieldType
                                .dropdown, // or can be dialog
                            initialValue: 'circle',
                            style: TextStyle(color: Colors.black87),
                            labelText: '70'.tr,

                            items: controller.cooptedList,
                            onChanged: (val) =>
                            {controller.cooptedSelected = val},
                            onSaved: (val) => print(val),
                          ),
                          SizedBox(
                            height: 25,
                          ),
                          TextFormField(
                            controller: controller?.comment,
                            validator: (value) {},
                            decoration: InputDecoration(
                                hintText: '71'.tr,
                                hintStyle:
                                TextStyle(color: Colors.black87)),
                          ),
                          TextField(
                            controller: controller.dateinput, //editing controller of this TextField
                            decoration: InputDecoration(
                                icon: Icon(Icons
                                    .calendar_today), //icon of text field
                                labelText: "72".tr //label text of field
                            ),
                            readOnly:
                            true, //set it true, so that user will not able to edit text
                            onTap: () async {
                              DateTime? pickedDate = await showDatePicker(
                                  context: context,
                                  initialDate: DateTime.now(),
                                  firstDate: DateTime(
                                      2000), //DateTime.now() - not to allow to choose before today.
                                  lastDate: DateTime(2101));

                              if (pickedDate != null) {
                                print(
                                    pickedDate); //pickedDate output format => 2021-03-10 00:00:00.000
                                String formattedDate =
                                DateFormat('yyyy-MM-dd')
                                    .format(pickedDate);
                                print(
                                    formattedDate); //formatted date output using intl package =>  2021-03-16
                                //you can implement different kind of Date Format here according to your requirement

                                controller.dateinput?.text =
                                    formattedDate; //set output date to TextField value.
                              } else {
                                print("Date is not selected");
                              }
                            },
                          ),

                    /*DropdownButtonFormField<String>(

                      decoration: InputDecoration(
                        labelText: 'Payment frequency',
                      ),
                      value: controller.selectedPaymentFrequency,
                      items: [

                      DropdownMenuItem<String>(

                        value: 'daily',
                        child: Text('Daily'),
                      ),
                      DropdownMenuItem<String>(
                        value: 'weekly',
                        child: Text('Weekly'),
                      ),
                      DropdownMenuItem<String>(
                        value: 'both',
                        child: Text('Both'),
                      ),
                     ],
                      validator: (value) {

                        if (value == null || value.isEmpty) {
                          return 'This field is required';
                        }

                        print(value);
                      },

                      onChanged: (value) {
                        controller.selectedPaymentFrequency = value ;
                      },

                      onSaved: (value) {
                        controller.savePaymentFrequency(value!);
                        print(value);
                      },

                    ),

                          if (controller.selectedPaymentFrequency == 'daily' || controller.selectedPaymentFrequency == 'both')*/
                            /*TextField(
                              controller: controller.morningCost, // Contrôleur d'édition de ce TextField
                              keyboardType: TextInputType.number, // Type de clavier pour la saisie numérique
                              decoration: InputDecoration(
                                icon: Icon(Icons.monetization_on), // Icône du champ texte
                                labelText: "Morning Cost".tr, // Texte de l'étiquette du champ
                              ),
                            ),
                          //if (controller.paymentFrequency == 'daily' || controller.paymentFrequency == 'both')
                            TextField(
                              controller: controller.afternoonCost, // Contrôleur d'édition de ce TextField
                              keyboardType: TextInputType.number, // Type de clavier pour la saisie numérique
                              decoration: InputDecoration(
                                icon: Icon(Icons.monetization_on), // Icône du champ texte
                                labelText: "Afternoon Cost".tr, // Texte de l'étiquette du champ
                              ),
                            ),
                         // if (controller.paymentFrequency == 'daily' || controller.paymentFrequency == 'both')
                            TextField(
                              controller: controller.eveningCost, // Contrôleur d'édition de ce TextField
                              keyboardType: TextInputType.number, // Type de clavier pour la saisie numérique
                              decoration: InputDecoration(
                                icon: Icon(Icons.monetization_on), // Icône du champ texte
                                labelText: "Evening Cost".tr, // Texte de l'étiquette du champ
                              ),
                            ),*/

                          TextField(
                            controller: controller.CompanyID, // Contrôleur d'édition de ce TextField
                            keyboardType: TextInputType.text, // Type de clavier pour la saisie numérique
                            decoration: InputDecoration(
                              icon: Icon(Icons.business), // Icône du champ texte
                              labelText: "Company ID".tr, // Texte de l'étiquette du champ
                            ),
                          ),

                          //if (controller.selectedPaymentFrequency == 'weekly' || controller.selectedPaymentFrequency == 'both')
                               /* TextField(
                                  controller: controller?.morningCost,
                              // Contrôleur d'édition de ce TextField
                                  keyboardType: TextInputType.number,
                              // Type de clavier pour la saisie numérique
                                  decoration: InputDecoration(
                                  icon: Icon(Icons.monetization_on),
                                // Icône du champ texte
                                  labelText: "Morning Cost".tr, // Texte de l'étiquette du champ
                                  ),
                                ),*/
                   /* ElevatedButton(
                    onPressed: () {
                      // Calculate the total cost per day
                     *//* double morningCost = controller.morningCost ?? 0.0;
                      double afternoonCost = controller.afternoonCost ?? 0.0;
                      double eveningCost = controller.eveningCost ?? 0.0;*//*
                      double totalCostPerDay = 60 ;//morningCost + afternoonCost + eveningCost;
                    // Display the total cost per day
                    showDialog(
                    context: context,
                    builder: (context) {
                    return AlertDialog(
                    title: Text('Total Cost per Day'),
                    content: Text('The total cost per day is $totalCostPerDay'),
                    actions: [
                    TextButton(
                    onPressed: () {
                    Navigator.pop(context);
                    },
                    child: Text('OK'),
                    ),
                    ],
                    );
                    },
                    );
                    },
                    child: Text('Confirm'),
                    ),
                          if (controller.showTotalCostMessage)
                            Text('Total cost per day: $controller.totalCostPerDay TND'),
                          Row(
                            mainAxisAlignment: MainAxisAlignment.spaceBetween,
                            children: [
                              ElevatedButton(
                                onPressed: () {
                                  // Logique pour revenir en arrière
                                },
                                child: Text('Back'),
                              ),
                              ElevatedButton(
                                onPressed: () {
                                  if (formKey.currentState!.validate()) {
                                    formKey.currentState!.save();
                                    // Logique pour soumettre le formulaire
                                  }
                                },
                                child: Text('Submit'),
                              ),
                            ],
                          )*/
                          /*TextField(
                            controller: controller?.morningCost, // Contrôleur d'édition de ce TextField
                            keyboardType: TextInputType.number, // Type de clavier pour la saisie numérique
                            decoration: InputDecoration(
                              icon: Icon(Icons.monetization_on), // Icône du champ texte
                              labelText: "Morning Cost".tr, // Texte de l'étiquette du champ
                            ),
                          )*/
                        ],
                      ),
                    )
                        : Container(
                      child: Center(
                        child: CircularProgressIndicator(),
                      ),
                    );
                  }),
                  SizedBox(
                    height: 20,
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    children: [
                      TextButton(
                          style: TextButton.styleFrom(
                              foregroundColor: Colors.blue,
                              shape: RoundedRectangleBorder(
                                  borderRadius: BorderRadius.circular(16.0))),
                          onPressed: () {
                            // String companyID = controller.CompanyID.text;
                            //print(companyID);// Obtenir la valeur du champ 'CompanyID'
                            controller.createMou3ina();
                            controller.addMou3ina(_formKeyy.currentState!.validate());
                            Navigator.push(
                              context,
                              MaterialPageRoute(
                                builder: (context) => LoginView(),
                              ),
                            );
                          },
                          child: Text(
                            "73".tr,
                            style: TextStyle(color: Colors.blue, fontSize: 20),
                          )),
                      SizedBox(
                        width: 140,
                      ),
                      TextButton(
                          style: TextButton.styleFrom(
                              foregroundColor: Colors.grey,
                              shape: RoundedRectangleBorder(
                                  borderRadius: BorderRadius.circular(16.0))),
                          onPressed: () {
                            Navigator.push(
                              context,
                              MaterialPageRoute(
                                builder: (context) => localisatioMap(),
                              ),
                            );
                          },
                          child: Text(
                            "57".tr,
                            style: TextStyle(color: Colors.black, fontSize: 20),
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

class MyAppBar extends StatelessWidget implements PreferredSizeWidget {
  Size get preferredSize => new Size.fromHeight(60);
  @override
  Widget build(BuildContext context) {
    return AppBar(
      elevation: 0,
      actions: [
        HeaderSection(),
      ],
      backgroundColor: Colors.white.withOpacity(0),
    );
  }
}

class HeaderSection extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      height: 200,
      decoration: BoxDecoration(
        color: Colors.blueGrey,
        image: DecorationImage(
          image: AssetImage('assets/ttt.jpg'),
          fit: BoxFit.cover,
        ),
        borderRadius: BorderRadius.only(
          bottomLeft: Radius.circular(50),
        ),
      ),
      child: Stack(
        children: [
          Positioned(
            right: 0,
            bottom: 20,
            child: MaterialButton(
              onPressed: () {},
              color: Colors.blue,
              shape: CircleBorder(),
              child: Padding(
                padding: EdgeInsets.all(17),
                child: Icon(
                  Icons.play_arrow_rounded,
                  color: Colors.white,
                  size: 30,
                ),
              ),
            ),
          ),
        ],
      ),
    );
  }
}
