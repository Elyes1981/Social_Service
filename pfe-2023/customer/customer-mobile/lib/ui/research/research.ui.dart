import 'package:date_format/date_format.dart';
//import 'package:demo/ui/Reservation/Reservation.controller.dart';
import 'package:flutter/material.dart';
import 'package:flutter_datetime_picker/flutter_datetime_picker.dart';
import 'package:get/get.dart';
import 'package:intl/intl.dart';
import 'package:multiselect_formfield/multiselect_formfield.dart';
import 'package:select_form_field/select_form_field.dart';
import 'package:sliding_switch/sliding_switch.dart';
import 'package:toggle_switch/toggle_switch.dart';
import 'package:flutter_time_picker_spinner/flutter_time_picker_spinner.dart';

import '../../ui/Complain/Complain.ui.dart';
import '../../ui/Reservation/Reservation.controller.dart';
import '../resReasearch/resResearch.ui.dart';
import '../resReasearch/view.ui.dart';


class Research extends GetView<ReservationController>  {

  List? _myActivities;
  List<dynamic> _selectedOptions = [];
  DateTime _dateTime = DateTime.now();
  List<dynamic> _Modifier = [];

  final List<Map<String, dynamic>> _items = [
    {
      'value': 1,
      'label': '1',
    },
    {
      'value': 2,
      'label': '2',
    },
    {
      'value': 3,
      'label': ' 3',
    },
  ];
  final _formKey = GlobalKey<FormState>();
  bool _morning = false;
  bool _evening = false;
  bool _afternoon = false;

  bool isResultVisible = false; // Add this variable to control visibility

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        backgroundColor: Color(0xFFF6F7FF),
        appBar: AppBar(
          elevation: 0.0,
          backgroundColor: Color(0xFFF6F7FF),
        ),
        body: Obx(() {
          return controller.isloading.isFalse
              ? Form(
            key: _formKey,
            child: Padding(
              padding: const EdgeInsets.symmetric(
                  vertical: 8.0, horizontal: 24.0),
              child: Column(
                mainAxisAlignment: MainAxisAlignment.start,
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  //Let's start by adding the text



                  SizedBox(
                    height: 8.0,
                  ),

                  Material(
                    elevation: 10.0,
                    borderRadius: BorderRadius.circular(30.0),
                    shadowColor: Color(0x55434343),
                  ),
                  const SizedBox(height: 30.0),
                  //Now let's Add a Tabulation bar
                  DefaultTabController(
                    length: 3,
                    child: Expanded(
                      child: Column(
                        children: [
                          TabBar(
                            indicatorColor:
                            Color.fromARGB(255, 56, 5, 85),
                            unselectedLabelColor: Color(0xFF555555),
                            labelColor: Color.fromARGB(255, 56, 5, 85),
                            labelPadding:
                            EdgeInsets.symmetric(horizontal: 8.0),
                            tabs: [
                              Tab(
                                text: "Prefered Services",
                              ),
                              Tab(
                                text: "Date & Time",
                              ),
                              Tab(
                                text: "research ",
                              ),
                            ],
                          ),
                          SizedBox(
                            height: 20.0,
                          ),
                          Container(
                            height: 400.0,
                            //width: double.infinity ,
                            child: TabBarView(
                              children: [
                                //Now let's create our first tab page
                                Container(
                                  //width: double.infinity,
                                  child: ListView(
                                    scrollDirection: Axis.horizontal,
                                    children: [
                                      //Now let's add and test our first card
                                      Card(
                                        margin:
                                        EdgeInsets.only(right: 22.0),
                                        clipBehavior: Clip.antiAlias,
                                        shape: RoundedRectangleBorder(
                                          borderRadius:
                                          BorderRadius.circular(30.0),
                                        ),
                                        elevation: 0.0,
                                        child: InkWell(
                                          onTap: () {},
                                          child: Container(
                                            decoration: BoxDecoration(),
                                            width: 200.0,
                                            child: Padding(
                                              padding:
                                              EdgeInsets.all(12.0),
                                              child: Column(
                                                mainAxisAlignment:
                                                MainAxisAlignment
                                                    .start,
                                                crossAxisAlignment:
                                                CrossAxisAlignment
                                                    .start,
                                                children: [
                                                  Column(
                                                    children: [
                                                      Stack(
                                                        children: [

                                                          MultiSelectFormField(
                                                            autovalidate:
                                                            AutovalidateMode
                                                                .disabled,
                                                            chipBackGroundColor:
                                                            Colors
                                                                .blue,
                                                            chipLabelStyle: TextStyle(
                                                                fontWeight:
                                                                FontWeight
                                                                    .bold,
                                                                color: Colors
                                                                    .white),
                                                            dialogTextStyle:
                                                            TextStyle(
                                                                fontWeight:
                                                                FontWeight.bold),
                                                            checkBoxActiveColor:
                                                            Colors
                                                                .blue,
                                                            checkBoxCheckColor:
                                                            Colors
                                                                .white,
                                                            dialogShapeBorder:
                                                            RoundedRectangleBorder(
                                                                borderRadius:
                                                                BorderRadius.all(Radius.circular(12.0))),
                                                            title: Text(
                                                              "Service Type",
                                                              style: TextStyle(
                                                                  fontSize:
                                                                  16),
                                                            ),
                                                            validator:
                                                                (value) {
                                                              if (value ==
                                                                  null ||
                                                                  value.length ==
                                                                      0) {
                                                                return 'Please select one or more options';
                                                              }
                                                              return null;
                                                            },
                                                            dataSource: [
                                                              {
                                                                "display":
                                                                controller
                                                                    .ServiceList[0],
                                                                "value":
                                                                controller
                                                                    .ServiceList[0],
                                                              },
                                                              {
                                                                "display":
                                                                controller
                                                                    .ServiceList[1],
                                                                "value":
                                                                controller
                                                                    .ServiceList[1],
                                                              },
                                                              {
                                                                "display":
                                                                controller
                                                                    .ServiceList[2],
                                                                "value":
                                                                controller
                                                                    .ServiceList[2],
                                                              },
                                                              {
                                                                "display":
                                                                controller
                                                                    .ServiceList[3],
                                                                "value":
                                                                controller
                                                                    .ServiceList[3],
                                                              },
                                                              {
                                                                "display":
                                                                controller
                                                                    .ServiceList[4],
                                                                "value":
                                                                controller
                                                                    .ServiceList[4],
                                                              },
                                                            ],
                                                            textField:
                                                            'display',
                                                            valueField:
                                                            'value',
                                                            okButtonLabel:
                                                            'OK',
                                                            cancelButtonLabel:
                                                            'CANCEL',
                                                            hintWidget: Text(
                                                                'Please choose one or more'),
                                                            initialValue:
                                                            _myActivities,

                                                            onSaved: (newValue) {

                                                              _selectedOptions = newValue;
                                                              _Modifier = _selectedOptions.map((value) => value.toString().replaceAll('[', '')).toList();
                                                              print(_Modifier);


                                                            },
                                                          ),
                                                        ],
                                                      ),


                                                      SizedBox(
                                                        height: 15,
                                                      ),

                                                      SelectFormField(
                                                        //  controller:controller.numberOfMou3ina,

                                                        hintText:
                                                        "Nbr of Mou3ina ",
                                                        type: SelectFormFieldType
                                                            .dropdown, // or can be dialog
                                                        // initialValue: 1,

                                                        items: _items,
                                                        onChanged: (String
                                                        val) =>
                                                        {
                                                          //   controller.numberOfMou3ina.text=val.toString()

                                                        },
                                                        onSaved: (val) =>
                                                        {},
                                                      ),
                                                    ],
                                                  ),
                                                  Expanded(
                                                    child: Column(
                                                      mainAxisAlignment:
                                                      MainAxisAlignment
                                                          .end,
                                                      crossAxisAlignment:
                                                      CrossAxisAlignment
                                                          .start,
                                                      children: [
                                                        SizedBox(
                                                          height: 3.0,
                                                        ),
                                                      ],
                                                    ),
                                                  ),
                                                ],
                                              ),
                                            ),
                                          ),
                                        ),
                                      ),
                                      Card(
                                        margin:
                                        EdgeInsets.only(right: 22.0),
                                        clipBehavior: Clip.antiAlias,
                                        shape: RoundedRectangleBorder(
                                          borderRadius:
                                          BorderRadius.circular(30.0),
                                        ),
                                        elevation: 0.0,
                                        child: InkWell(
                                          onTap: () {},
                                          child: Container(
                                            decoration: BoxDecoration(),
                                            width: 140.0,
                                            height: 200,
                                            child: Padding(
                                              padding:
                                              EdgeInsets.all(12.0),
                                              child: Column(
                                                mainAxisAlignment:
                                                MainAxisAlignment
                                                    .start,
                                                crossAxisAlignment:
                                                CrossAxisAlignment
                                                    .start,
                                                children: [
                                                  Expanded(
                                                    child: Column(
                                                      mainAxisAlignment:
                                                      MainAxisAlignment
                                                          .end,
                                                      crossAxisAlignment:
                                                      CrossAxisAlignment
                                                          .start,
                                                      children: [
                                                        Image.asset(
                                                          "assets/images/c5.jpg",
                                                          width: 340,
                                                          height: 120,
                                                        ),
                                                        Image.asset(
                                                          "assets/images/c6.jpg",
                                                          width: 340,
                                                          height: 120,
                                                        ),
                                                        Image.asset(
                                                          "assets/images/c8.jpg",
                                                          width: 340,
                                                          height: 120,
                                                        ),
                                                        SizedBox(
                                                          height: 3.0,
                                                        ),
                                                      ],
                                                    ),
                                                  ),
                                                ],
                                              ),
                                            ),
                                          ),
                                        ),
                                      )
                                    ],
                                  ),
                                ),
                                Container(
                                  child: ListView(
                                    scrollDirection: Axis.horizontal,
                                    children: [
                                      //Here you can add what ever you want
                                      Card(
                                        // margin: EdgeInsets.only(right: 22.0),
                                        clipBehavior: Clip.antiAlias,
                                        shape: RoundedRectangleBorder(
                                          borderRadius:
                                          BorderRadius.circular(30.0),
                                        ),
                                        elevation: 0.0,
                                        child: InkWell(
                                          onTap: () {},
                                          child: Container(
                                            width: 360.0,
                                            child: Padding(
                                              padding:
                                              EdgeInsets.fromLTRB(
                                                  40, 0, 0, 0),
                                              child: Column(
                                                mainAxisAlignment:
                                                MainAxisAlignment
                                                    .start,
                                                crossAxisAlignment:
                                                CrossAxisAlignment
                                                    .start,
                                                children: [
                                                  Column(
                                                    children: [



                                                      /*TextField(
                                                        controller: controller.desiredHour, //editing controller of this TextField
                                                        decoration: InputDecoration(
                                                            icon: Icon(Icons.timer), //icon of text field
                                                            labelText: "Enter Time" //label text of field
                                                        ),
                                                        readOnly: true,  //set it true, so that user will not able to edit text
                                                        onTap: () async {
                                                          TimeOfDay? pickedTime =  await showTimePicker(
                                                            initialTime: TimeOfDay.now(),
                                                            context: context,
                                                          );
                                                          print("hhhhh");

                                                          if(pickedTime != null ){
                                                            print(pickedTime.format(context));   //output 10:51 PM
                                                            DateTime parsedTime = DateFormat.jm().parse(pickedTime.format(context).toString());
                                                            //converting to DateTime so that we can further format on different pattern.
                                                            print(parsedTime); //output 1970-01-01 22:53:00.000
                                                            String formattedTime = DateFormat('HH:mm:ss').format(parsedTime);
                                                            print(formattedTime); //output 14:59:00
                                                            //DateFormat() is from intl package, you can format the time on any pattern you need.
                                                            controller.desiredHour.text=formattedTime.toString().substring(0,8);



                                                          }else{
                                                            print("Time is not selected");
                                                          }
                                                        },
                                                      ),*/

                                                      TextField(
                                                        controller:controller.desiredDate,
                                                        //editing controller of this TextField
                                                        decoration: InputDecoration(
                                                          labelText: "desired date",
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
                                                            lastDate: DateTime(2029),
                                                          );
                                                          controller.desiredDate.text=pickedDate.toString().substring(0,10);
                                                          if (pickedDate != null) {
                                                            print(
                                                                pickedDate); //pickedDate output format => 2021-03-10 00:00:00.000
                                                            String formattedDate =
                                                            DateFormat('dd-MM-yyyy').format(pickedDate);
                                                            print(
                                                                formattedDate); //formatted date output using intl package =>  2021-03-16
                                                            //you can implement different kind of Date Format here according to your requirement

                                                            //dateinput.text =formattedDate; //set output date to TextField value.

                                                          } else {
                                                            print("Date is not selected");
                                                          }
                                                        },
                                                      ),
                                                      SizedBox(
                                                        height: 12.0,
                                                      ),
                                                      ToggleSwitch(
                                                        minWidth: 90.0,
                                                        initialLabelIndex:
                                                        0,

                                                        activeBgColor:
                                                        Color
                                                            .fromARGB(
                                                            255,
                                                            67,
                                                            13,
                                                            121),
                                                        //Col: Colors.white,
                                                        inactiveBgColor:
                                                        Color
                                                            .fromARGB(
                                                            255,
                                                            228,
                                                            228,
                                                            228),
                                                        //inactiveTextColor: Colors.grey[900],
                                                        labels: [
                                                          'Morning',
                                                          'Evening',
                                                          'Afternoon'
                                                        ],
                                                        onToggle:
                                                            (index) {
                                                          print(
                                                              'switched to: $index');
                                                          if (index ==
                                                              0) {
                                                            _morning =
                                                            true;
                                                            _evening =
                                                            false;
                                                            _afternoon =
                                                            false;
                                                            controller.morselect = _morning;
                                                            controller.eveselect = _evening;
                                                            controller.aftselect = _afternoon;
                                                            print( controller.morselect ) ;
                                                            print("hhhh");

                                                          } else if (index ==
                                                              1) {
                                                            _evening =
                                                            true;
                                                            _morning =
                                                            false;
                                                            _afternoon =
                                                            false;
                                                            controller.morselect = _morning;
                                                            controller.eveselect = _evening;
                                                            controller.aftselect = _afternoon;
                                                          } else if (index ==
                                                              2) {
                                                            _evening =
                                                            false;
                                                            _morning =
                                                            false;
                                                            _afternoon =
                                                            true;
                                                            controller.morselect = _morning;
                                                            controller.eveselect = _evening;
                                                            controller.aftselect = _afternoon;
                                                          }
                                                          print(_morning);
                                                          print(_evening);


                                                          print(
                                                              _afternoon);
                                                          print(controller
                                                              .morselect);
                                                          print(controller
                                                              .eveselect);
                                                          print(controller
                                                              .aftselect);


                                                        },
                                                      ),
                                                      SizedBox(
                                                        height: 20.0,
                                                      ),
                                                      SlidingSwitch(
                                                        value: false,
                                                        width: 250,
                                                        onChanged:
                                                            (bool value) {
                                                          print(value);
                                                        },
                                                        height: 50,
                                                        animationDuration:
                                                        const Duration(
                                                            milliseconds:
                                                            100),
                                                        onTap: () {},
                                                        onDoubleTap:
                                                            () {},
                                                        onSwipe: ( bool value) {
                                                          value:true;
                                                          controller.isRecSelect = value;

                                                        },
                                                        textOff:
                                                        "Ponctuel",
                                                        textOn:
                                                        "Recurrent",
                                                        colorOn: Color
                                                            .fromARGB(
                                                            255,
                                                            10,
                                                            4,
                                                            52),
                                                        colorOff:
                                                        const Color(
                                                            0xff6682c0),
                                                        background:
                                                        const Color(
                                                            0xffe4e5eb),
                                                        buttonColor:
                                                        const Color(
                                                            0xfff7f5f7),
                                                        inactiveColor:
                                                        const Color(
                                                            0xff636f7b),
                                                      ),
                                                    ],
                                                  ),
                                                ],
                                              ),
                                            ),
                                          ),
                                        ),
                                      )
                                    ],
                                  ),
                                ),

                                //herree
                              ],
                            ),
                          ),
                          SizedBox(
                            height: 20.0,
                          ),
                          if (isResultVisible) // Show the result container if isResultVisible is true
                            Container(
                              child: Column(
                                children: [
                                  Text('Your search results'),
                                ],
                              ),

                            ),
                          SizedBox(
                            width: double.infinity,
                            child: ElevatedButton(
                              /*  onPressed: () async {
                                      controller.createReservation();
                                      controller.addreservation(
                                          _formKey.currentState!.validate());
                                      await Navigator.push(
                                        context,
                                        MaterialPageRoute(builder: (context) => TablePage()),
                                      );
                                    },*/
                              onPressed: () async {
                                controller.searchMou3ina(_selectedOptions);
                                bool isValide;
                                print("valide1");
                                if (isValide=_formKey.currentState!.validate()) {
                                  // Valider le formulaire avant d'ajouter la réservation
                                  controller.addreservation(isValide);
                                  print("valide2");

                                  // Naviguer vers l'écran suivant
                                  await Navigator.push(
                                    context,
                                    MaterialPageRoute(builder: (context) => SlidableScreen()),
                                  );
                                }
                              },

                              style: ButtonStyle(
                                foregroundColor:
                                MaterialStateProperty.all<Color>(
                                    Colors.white),
                                backgroundColor:
                                MaterialStateProperty.all<Color>(
                                  Color.fromARGB(255, 56, 5, 85),
                                ),
                                shape: MaterialStateProperty.all<
                                    RoundedRectangleBorder>(
                                  RoundedRectangleBorder(
                                    borderRadius:
                                    BorderRadius.circular(24.0),
                                  ),
                                ),
                              ),
                              child: Padding(
                                padding: EdgeInsets.all(14.0),
                                child: Text(
                                  'Research',
                                  style: TextStyle(fontSize: 16),
                                ),
                              ),
                            ),
                          )
                        ],
                      ),
                    ),
                  )
                ],
              ),
            ),
          )
              : Container(
            child: Center(child: CircularProgressIndicator()),
          );
        }
        )
    );
  }
}
