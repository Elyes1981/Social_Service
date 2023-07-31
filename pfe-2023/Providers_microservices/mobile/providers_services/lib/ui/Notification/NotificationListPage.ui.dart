
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:providers_services/ui/Notification/NotificationHistory.controller.dart';

class NotificationListPage extends GetView<NotificationHistoryController> {


  final navigatorKey = GlobalKey<NavigatorState>();
  @override
  Widget build(BuildContext context) {
    controller.findNotif();
    print(controller.NotificationList.value);
    print("hiii" + controller.NotificationList.length.toString());
    // controller.findMou3inas();
    // print(controller.ReservationList[0].desiredDate.toString());

    //controller.findoneReserv();

    //print( controller.mou3ina_orderlist.length.toString());
    return Scaffold(
      body: Obx(() {
        return //controller.isloading.isFalse
          SingleChildScrollView(
            scrollDirection: Axis.vertical,
            child: Container(
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Container(
                    padding: EdgeInsets.all(20),
                    decoration: BoxDecoration(
                        color: Colors.blue,
                        borderRadius: BorderRadius.only(
                            bottomLeft: Radius.circular(40),
                            bottomRight: Radius.circular(40))),
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        SizedBox(
                          height: 50,
                        ),
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
                                SizedBox(
                                  height: 10,
                                ),
                                Row(
                                  crossAxisAlignment: CrossAxisAlignment.end,
                                  children: [
                                    Icon(
                                      Icons.star,
                                      color: Colors.white,
                                    ),
                                    Icon(
                                      Icons.star,
                                      color: Colors.white,
                                    ),
                                    Icon(
                                      Icons.star,
                                      color: Colors.white,
                                    ),
                                    Icon(
                                      Icons.star,
                                      color: Colors.white,
                                    ),
                                    Icon(
                                      Icons.star,
                                      color: Colors.white,
                                    ),
                                  ],
                                )
                              ],
                            ),
                          ],
                        ),
                        SizedBox(
                          height: 15,
                        ),
                        /*Text("Lorem ipsum dolar sits amet is used in print industry", style: TextStyle(
                        color: Colors.white,
                        fontSize: 12
                    ),)*/
                      ],
                    ),
                  ),
                  SizedBox(
                    height: 30,
                  ),
                  Container(
                    padding: EdgeInsets.symmetric(horizontal: 10),
                    child: Column(
                      children: [
                        Row(
                          crossAxisAlignment: CrossAxisAlignment.end,
                          children: [
                            Text(
                              "Notifications",
                              style: TextStyle(
                                  fontSize: 22, fontWeight: FontWeight.w700),
                            ),
                            SizedBox(
                              width: 10,
                            ),
                          ],
                        ),
                        Padding(
                            padding:
                            EdgeInsets.only(left: 10, right: 10, top: 10),
                            child: Column(
                              crossAxisAlignment: CrossAxisAlignment.center,
                              children: [
                                ListView.builder(
                                  shrinkWrap: true,
                                  itemCount: controller.NotificationList.length,
                                  itemBuilder: (context, index) {
                                    return Card(
                                        child: Column(
                                            mainAxisSize: MainAxisSize.min,
                                            children: <Widget>[
                                              ListTile(
                                                leading: GestureDetector(
                                                  behavior:
                                                  HitTestBehavior.translucent,
                                                   child: Container(
                                                     height: 30,
                                                     width: 30,
                                                     child: Image.asset(
                                                       controller.getStatusImage(controller.NotificationList[index].title!),
                                                     ),
                                                   ),
                                                ),
                                                title: Text(
                                                  controller
                                                      .NotificationList[index].title!
                                                      .toString(),
                                                  style: TextStyle(
                                                      fontSize: 16,
                                                      fontWeight: FontWeight.w400),
                                                ),

                                                subtitle: /*Column(
                                                    crossAxisAlignment:
                                                    CrossAxisAlignment.start,
                                                    children: [*/
                                                Text(
                                                  controller
                                                      .NotificationList[index].body!
                                                      .toString(),
                                                  style: TextStyle(
                                                      fontSize: 16,
                                                      fontWeight: FontWeight.w400),
                                                ),
                                                /*Text( controller.ReservationList[index].desiredDate!.year.toString()+'-'+controller.ReservationList[index].desiredDate!.month.toString()+'-'+controller.ReservationList[index].desiredDate!.day.toString())*/

                                                //SizedBox(width: 8),

                                                //]
                                                //),

                                                trailing: PopupMenuButton(
                                                  itemBuilder: (context) {
                                                    return [
                                                      PopupMenuItem(
                                                        value: 'delete',
                                                        child: Row(
                                                          children: [
                                                            Icon(Icons.delete),
                                                            SizedBox(width: 8),
                                                            Text('Delete'),
                                                          ],
                                                        ),

                                                        onTap: () {},
                                                        //icon:Icons.ice_skating
                                                      ),
                                                      PopupMenuItem(
                                                          value: 'details',
                                                          child: Row(
                                                            children: [
                                                              Icon(Icons.details),
                                                              SizedBox(width: 8),
                                                              Text('Details'),
                                                            ],
                                                          ),
                                                          onTap: () {}
                                                      ),

                                                    ];
                                                  },
                                                  onSelected: (String value) {
                                                    if (value == 'details') {

                                                      print("details");
                                                      showDialog(
                                                        context: context,
                                                        builder: (context) {
                                                          return StatefulBuilder(
                                                            builder: (context,
                                                                setState) {
                                                              return AlertDialog(
                                                                title: Text(
                                                                  'Interview Details'
                                                                      .tr,
                                                                  style: TextStyle(
                                                                      fontSize: 18,
                                                                      fontWeight:
                                                                      FontWeight
                                                                          .bold),
                                                                ),
                                                                content: Column(
                                                                  mainAxisSize:
                                                                  MainAxisSize
                                                                      .min,
                                                                  children: [
                                                                    Text(
                                                                      "Date Interview : 31/07/2023" ,
                                                                      style:
                                                                      TextStyle(
                                                                        fontSize:
                                                                        16,
                                                                        fontWeight:
                                                                        FontWeight
                                                                            .w400,

                                                                      ),
                                                                    ),
                                                                    SizedBox(
                                                                        height: 10),
                                                                    Text(
                                                                      "Desired Hour: 8:00" ,
                                                                      style: TextStyle(
                                                                          fontSize:
                                                                          16,
                                                                          fontWeight:
                                                                          FontWeight
                                                                              .w400),
                                                                    ),
                                                                    //controller.ReservationList[index].serviceTypes![0].label.toString()+"
                                                                    SizedBox(
                                                                        height: 10),
                                                                    Text(
                                                                      'Agent Name : Sana Triki' ,
                                                                      style:
                                                                      TextStyle(
                                                                        fontSize:
                                                                        16,
                                                                        fontWeight:
                                                                        FontWeight
                                                                            .bold,
                                                                      ),
                                                                    ),

                                                                    SizedBox(
                                                                        height: 10),
                                                                    Text(
                                                                      "Agent phone : 98345876" ,
                                                                      style: TextStyle(
                                                                          fontSize:
                                                                          16,
                                                                          fontWeight:
                                                                          FontWeight
                                                                              .w400),
                                                                    ),


                                                                    SizedBox(
                                                                        height: 10),

                                                                  ],
                                                                ),
                                                                actions: [
                                                                  TextButton(
                                                                    onPressed: () {
                                                                      Navigator.pop(
                                                                          context);
                                                                    },
                                                                    child: Text(
                                                                        'Cancel'
                                                                            .tr),
                                                                  ),
                                                                ],
                                                              );
                                                            },
                                                          );
                                                        },
                                                      );
                                                    }
                                                  },
                                                ),
                                              ),
                                            ]));
                                  },
                                )
                              ],
                            ))
                      ],
                    ),
                  ),
                ],
              ),
            ),
          );
      }),
    );
  }
}