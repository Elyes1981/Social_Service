import 'package:date_format/date_format.dart';
//import 'package:demo/ui/Reservation/Reservation.controller.dart';
import 'package:flutter/material.dart';
import 'package:flutter_datetime_picker/flutter_datetime_picker.dart';
import 'package:flutter_slidable/flutter_slidable.dart';
import 'package:get/get.dart';
import 'package:intl/intl.dart';
import 'package:multiselect_formfield/multiselect_formfield.dart';
import 'package:select_form_field/select_form_field.dart';
import 'package:sliding_switch/sliding_switch.dart';
import 'package:toggle_switch/toggle_switch.dart';
import 'package:flutter_time_picker_spinner/flutter_time_picker_spinner.dart';

import '../ReservationHistory/ReservationHistory.ui.dart';
import '../local/local.controller.dart';
import '../notification/MessageScreen.dart';
import '../notificationPresence/MessageScreenPresence.dart';
import '../notificationPresence/notificationPresence.ui.dart';
import '../resReasearch/resResearch.ui.dart';
import 'Reservation.controller.dart';


class Res extends GetView<ReservationController>    {
  List? _myActivities;
  String formattedDate='';
    DateTime _dateTime = DateTime.now();

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

  final itemList = [
    {
      'image': 'assets/images/imaMo.jpg',
      'title': 'Islem ',
      'desc': '45 DT',
    },
    {
      'image': 'assets/images/imaMo.jpg',
      'title': 'Mounira ',
      'desc': '50 DT',
    },
    {
      'image': 'assets/images/imaMo.jpg',
      'title': 'Eya',
      'desc': '55 DT',
    }
  ];

 // int selectedItemIndex = 0;

  final _formKey = GlobalKey<FormState>();
  bool _morning = false;
  bool _evening = false;
  bool _afternoon = false;
  List<dynamic> _selectedOptions = [];


  void showAlert(BuildContext context) {
    showDialog(
      context: context,
      builder: (BuildContext context) {
        return AlertDialog(
          title: Text('80'.tr),
          content: Text('81'.tr+_myActivities!.join(',')+'\n'+'82'.tr+formattedDate+ '\n'+'83'.tr +':             Islem ' +'\n'+'84'.tr +':                     45DT '),

          actions: [
            TextButton(
              child: Text("56".tr),
              onPressed: () {
                //Navigator.of(context).pop();
                 Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => ReservationHistory()),
                );


              },
            ),
            TextButton(
              child: Text("45".tr),
              onPressed: () {
                Navigator.of(context).pop();



              },
            ),
          ],
        );
      },
    );
  }

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


                       /* Padding(
                         *//* padding: const EdgeInsets.fromLTRB(20, 10, 20, 0),
                          child: Text(
                            "Save More Than What you spend",
                            style: TextStyle(
                              color: Color.fromARGB(255, 72, 6, 81),
                              fontSize: 20.0,
                              fontWeight: FontWeight.w300,
                            ),
                          ),*//*
                        ),*/
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
                                      text: "85".tr,
                                    ),
                                    Tab(
                                      text: "23".tr,
                                    ),
                                    Tab(
                                      text: "86".tr,
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
                                                                  title: Text("2".tr,//appTranslations.keys['en']!['general.title']
                                                                    //"Service Type",
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
                                                                      return "87".tr;
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
                                                                      "87".tr),
                                                                  initialValue:
                                                                      _myActivities,

                                                                  onSaved:
                                                                      (value) {
                                                                    if (value ==
                                                                        null)
                                                                      return;

                                                                    _myActivities =
                                                                        value;
                                                                    print(_myActivities);
                                                                  },
                                                                ),
                                                              ],
                                                            ),
                                                            SizedBox(
                                                              height: 15,
                                                            ),


                                                            SizedBox(
                                                              height: 15,
                                                            ),
                                                           
                                                            SelectFormField(
                                                            //  controller:controller.numberOfMou3ina,

                                                              hintText:
                                                              "88".tr,
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
                       
        


        
                                                           TextField(
                        controller:controller.desiredDate,
                            //editing controller of this TextField
                        decoration: InputDecoration(
                          labelText: "89".tr,
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
                             formattedDate =
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
                                      Container(
                                        padding: EdgeInsets.all(16.0),
                                        child: (itemList.isEmpty)
                                            ? SizedBox(
                                          height: double.infinity,
                                          width: double.infinity,
                                          child: Column(
                                            mainAxisAlignment: MainAxisAlignment.center,
                                            crossAxisAlignment: CrossAxisAlignment.center,
                                            children: const [
                                              Icon(
                                                Icons.hourglass_empty_rounded,
                                                color: Colors.grey,
                                                size: 50.0,
                                              ),
                                              SizedBox(height: 10.0),
                                              Text(
                                                'No item...',
                                                style: TextStyle(fontSize: 24.0, color: Colors.grey),
                                              )
                                            ],
                                          ),
                                        )
                                            : ListView.builder(
                                          itemCount: itemList.length,
                                          itemBuilder: (context, index) {
                                            final item = itemList[index];

                                            return Padding(
                                              padding: (index == 0)
                                                  ? const EdgeInsets.symmetric(vertical: 10.0)
                                                  : const EdgeInsets.only(bottom: 10.0),
                                              child: Slidable(
                                                key: Key('$item'),
                                                startActionPane: ActionPane(
                                                  motion: const ScrollMotion(),
                                                  children: [
                                                    SlidableAction(
                                                      onPressed: (context) {},
                                                      backgroundColor: Colors.green[300]!,
                                                      icon: Icons.share,
                                                    ),
                                                  ],
                                                ),
                                                endActionPane: ActionPane(
                                                  motion: const ScrollMotion(),
                                                  children: [
                                                    SlidableAction(
                                                      onPressed: (context) {

                                                      },
                                                      backgroundColor: Colors.red,
                                                      icon: Icons.delete,
                                                    ),
                                                  ],
                                                ),
                                                child: GestureDetector(
                                                  onTap: () {


                                                  },
                                                  child: Container(
                                                    margin: const EdgeInsets.symmetric(horizontal: 10.0),
                                                    padding: const EdgeInsets.all(10.0),
                                                    decoration: BoxDecoration(
                                                      borderRadius: BorderRadius.circular(10.0),
                                                      color: (index == controller.selectedItemIndex)
                                                          ? Colors.green[100]
                                                          : Colors.white,
                                                      boxShadow: [
                                                        BoxShadow(
                                                          blurRadius: 1.0,
                                                          spreadRadius: 1.0,
                                                          color: Colors.green[400]!,
                                                        ),
                                                      ],
                                                    ),
                                                    child: Row(
                                                      mainAxisAlignment: MainAxisAlignment.start,
                                                      crossAxisAlignment: CrossAxisAlignment.center,
                                                      children: [
                                                        ClipRRect(
                                                          borderRadius: BorderRadius.circular(10.0),
                                                          child: Image.asset(
                                                            item['image']!,
                                                            width: 100.0,
                                                            height: 100.0,
                                                            fit: BoxFit.cover,
                                                          ),
                                                        ),
                                                        const SizedBox(width: 10.0),
                                                        Column(
                                                          mainAxisAlignment: MainAxisAlignment.center,
                                                          crossAxisAlignment: CrossAxisAlignment.start,
                                                          children: [
                                                            Text(
                                                              item['title']!,
                                                              style: const TextStyle(
                                                                fontSize: 18.0,
                                                                fontWeight: FontWeight.bold,
                                                                color: Colors.deepPurple,
                                                              ),
                                                            ),
                                                            const SizedBox(height: 10.0),
                                                            Text(
                                                              item['desc']!,
                                                              style: const TextStyle(
                                                                fontSize: 14.0,
                                                                color: Colors.grey,
                                                              ),
                                                            ),
                                                          ],
                                                        ),
                                                      ],
                                                    ),
                                                  ),
                                                ),
                                              ),
                                            );
                                          },
                                        ),
                                      ),

                                      //herree
                                    ],
                                  ),
                                ),

                                SizedBox(
                                  height: 20.0,
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
                                        MaterialPageRoute(builder: (context) => MessageScreen()),
                                      );
                                    },*/
                                    onPressed: () async {
                                      controller.createReservation();
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
                                        Color.fromARGB(255, 76, 172, 175),
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
                                        '86'.tr,
                                        style: TextStyle(fontSize: 16),
                                      ),
                                    ),
                                  ),
                                ),
                                SizedBox(
                                  height: 20.0,
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
                                        MaterialPageRoute(builder: (context) => MessageScreen()),
                                      );
                                    },*/
                                    onPressed: () async {
                                      controller.createReservation();
                                      bool isValide;
                                      print("valide1");
                                      /*if (isValide=_formKey.currentState!.validate()) {
                                        // Valider le formulaire avant d'ajouter la réservation
                                        controller.addreservation(isValide);
                                        print("valide2");

                                        // Naviguer vers l'écran suivant
                                        await Navigator.push(
                                          context,
                                          MaterialPageRoute(builder: (context) => ReservationHistory()),
                                        );
                                      }*/

                                      showAlert(context);
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
                                        'Order',
                                        style: TextStyle(fontSize: 16),
                                      ),
                                    ),
                                  ),
                                ),
                                
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
class MyAppBar extends StatelessWidget implements PreferredSizeWidget {
  Size get preferredSize => new Size.fromHeight(60);

  @override
  Widget build(BuildContext context) {
    MyLocaleController controllerLang =Get.find();
    return AppBar(


      backgroundColor: Colors.white.withOpacity(0),
      title: Text(""),
      actions: [
        PopupMenuButton(
            icon:Icon( Icons.language, ),
            color: Colors.white,
            elevation: 20,
            enabled: true,
            onSelected: (value){}    ,
            itemBuilder:(context) => [
              PopupMenuItem(
                child: Text("30".tr),
                onTap:(){controllerLang.changeLang('fr');},
                value: '',
              ),
              PopupMenuItem(
                child: Text("31".tr),
                onTap:(){controllerLang.changeLang('en');},

                value:'',
              ),
              PopupMenuItem(
                child: Text("32".tr),
                onTap:(){controllerLang.changeLang('ar');},
                value:'',
              ),
            ]
        )
      ],

    );
  }
}
