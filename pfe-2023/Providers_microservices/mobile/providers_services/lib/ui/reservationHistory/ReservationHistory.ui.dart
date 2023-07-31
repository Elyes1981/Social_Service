import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:providers_services/core/routes/app_routes.dart';
import 'package:flutter_rating_bar/flutter_rating_bar.dart';
import 'package:providers_services/ui/profil/CustomerProfil.ui.dart';
import 'package:providers_services/ui/reservationHistory/ReservationHistory.controller.dart';
import 'package:cached_network_image/cached_network_image.dart';


class ReservationHistory extends GetView<ReservationHistoryController> {

  final navigatorKey = GlobalKey<NavigatorState>();
  @override
  Widget build(BuildContext context) {
    controller.findReserv();
    print(controller.ReservationList.value);
    print("hiii" + controller.ReservationList.length.toString());


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
                              "Your List Of Orders",
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
                                  itemCount: controller.ReservationList.length,
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
                                                  height: 50,
                                                  width: 50,
                                                  child: Image.asset(
                                                    controller.getStatusImage(controller.ReservationList[index].customerReservation!.status!),
                                                  ),
                                                ),
                                            ),
                                            title: Text(
                                              controller.ReservationList[index].orderDay!.year!.toString() +
                                                  '-' +
                                                  controller.ReservationList[index].orderDay!.month!.toString() +
                                                  '-' +
                                                  controller
                                                      .ReservationList[index].orderDay!.day!.toString(),
                                              style: TextStyle(
                                                  fontSize: 16,
                                                  fontWeight: FontWeight.w400),
                                            ),
                                            /*   title:
              Text(" ",
              style: TextStyle(

                  fontSize: 16,
                  fontWeight: FontWeight.w600

              ),),*/

                                            /* title: Text("Imene Chaoua"
        /*controller.ReservationList[index].id.toString()+" "+controller.ReservationList[index].numberOfMou3ina.toString()*/)*/
                                            subtitle: Column(
                                                crossAxisAlignment:
                                                    CrossAxisAlignment.start,
                                                children: [
                                                  Text("Service Cost : " +
                                                      controller
                                                          .ReservationList[
                                                              index]
                                                          .serviceCost!
                                                          .toString() +
                                                      "TND"),
                                                  //Text( controller.ReservationList[index].desiredDate!.year.toString()+'-'+controller.ReservationList[index].desiredDate!.month.toString()+'-'+controller.ReservationList[index].desiredDate!.day.toString())*/

                                                  SizedBox(width: 8),
                                                  FlutterRatingBar(
                                                    itemSize: 18,
                                                    //if(controller.ReservationList[index].rate==null){}
                                                    initialRating: controller
                                                                .ReservationList[
                                                                    index].rank !=
                                                            null
                                                        ? controller
                                                        .ReservationList[
                                                    index].rank!
                                                            .toDouble()
                                                        : 0,
                                                    fillColor: Color.fromARGB(
                                                        255, 60, 10, 68),
                                                    borderColor: Color.fromARGB(
                                                        255, 60, 10, 68),
                                                    //allowHalfRating: true,
                                                  ),
                                                ]),

                                            trailing: PopupMenuButton(
                                              itemBuilder: (context) {
                                                return [
                                                  PopupMenuItem(
                                                    value: 'rate',
                                                    child: Row(
                                                      children: [
                                                        Icon(Icons.star),
                                                        SizedBox(width: 8),
                                                        Text('Rating'),
                                                      ],
                                                    ),

                                                    onTap: () {
                                                      // print("hhh");
                                                      // Navigator.of(context).pushNamed("rating");
                                                      //arguments: controller.CustomerList[index].id);

                                                      //Get.toNamed<dynamic>(AppRoutes.rating);
                                                    },
                                                    //icon:Icons.ice_skating
                                                  ),
                                                  PopupMenuItem(
                                                      value: 'confirm',
                                                      child: Row(
                                                        children: [
                                                          Icon(Icons.check),
                                                          SizedBox(width: 8),
                                                          Text('Confirm'),
                                                        ],
                                                      ),
                                                      onTap: () {
                                                        controller.confirmReservation(controller.ReservationList[index].customerReservation!.id);
                                                      },
                                                ),
                                                  PopupMenuItem(
                                                      value: 'reject',
                                                      child: Row(
                                                        children: [
                                                          Icon(Icons.clear),
                                                          SizedBox(width: 8),
                                                          Text('Decline'),
                                                        ],
                                                      ),
                                                      onTap: () {
                                                        controller.CancelReservation(controller.ReservationList[index].customerReservation!.id);

                                                      }
                                                    //showMyDialog,

                                                  ),
                                                  PopupMenuItem(
                                                      value: 'details',
                                                      child: Row(
                                                        children: [
                                                          Icon(Icons.info),
                                                          SizedBox(width: 8),
                                                          Text('Details'),
                                                        ],
                                                      ),
                                                      onTap: () {}
                                                      //showMyDialog,

                                                      ),
                                                  PopupMenuItem(
                                                    onTap: () {
                                                      //Get.to(() => CustomerProfil());
                                                    },
                                                    value: 'customer',
                                                    child: Row(
                                                      children: [
                                                        Icon(Icons.person),
                                                        SizedBox(width: 8),
                                                        Text('Customer details'),
                                                      ],
                                                    ),
                                                  )
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
                                                              'Orders Details'
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
                                                                  "Status:" +
                                                                      controller
                                                                          .ReservationList[
                                                                              index]
                                                                          .customerReservation!
                                                                          .paymentStatus!
                                                                          .toString(),
                                                                  style:
                                                                      TextStyle(
                                                                    fontSize:
                                                                        16,
                                                                    fontWeight:
                                                                        FontWeight
                                                                            .w400,
                                                                    color: controller.ReservationList[index].customerReservation!.paymentStatus!.toString() ==
                                                                            "Unpaid"
                                                                        ? Colors
                                                                            .red
                                                                        : Colors
                                                                            .green,
                                                                  ),
                                                                ),
                                                                SizedBox(
                                                                    height: 10),

                                                      /*          Container(
                                                                  child: ListView.builder(
                                                                    shrinkWrap: true,
                                                                    itemCount: controller.ReservationList[index].customerReservation!.serviceTypes!.length,
                                                                    itemBuilder: (context, serviceIndex) {
                                                                      return ListTile(
                                                                        title: Text(
                                                                          controller.ReservationList[index].customerReservation!.serviceTypes![serviceIndex]!.label.toString(),
                                                                          style: TextStyle(fontSize: 16, fontWeight: FontWeight.w400),
                                                                        ),
                                                                      );
                                                                    },
                                                                  ),
                                                                )*/

                                                                Row(
                                                                  children: [
                                                                    Text("Service Type: "),
                                                                    Column(
                                                                      children: controller.ReservationList[index].customerReservation!.serviceTypes!.map((serviceType) =>
                                                                          Text("- ${serviceType.label!.toString()}"),
                                                                      ).toList(),
                                                                    ),
                                                                  ],
                                                                ),
                                                                /*Column(
                                                                  children: [
                                                                    for (var serviceType in controller.ReservationList[index].customerReservation!.serviceTypes!)
                                                                      Text(
                                                                        "Service Type: ${serviceType.label.toString()} ",
                                                                      ),
                                                                  ],
                                                                ),*/
                                                                //controller.ReservationList[index].serviceTypes![0].label.toString()+"
                                                                SizedBox(
                                                                    height: 10),
                                                                Text(
                                                                  'Time Work',
                                                                  style:
                                                                      TextStyle(
                                                                    fontSize:
                                                                        16,
                                                                    fontWeight:
                                                                        FontWeight
                                                                            .bold,
                                                                  ),
                                                                ),
                                                                Row(
                                                                  children: [
                                                                    if (controller
                                                                            .ReservationList[index]
                                                                            .customerReservation!
                                                                            .morning! ==
                                                                        true)
                                                                      Expanded(
                                                                        child:
                                                                            Column(
                                                                          children: [
                                                                            Image.asset(
                                                                              'assets/morning.png',
                                                                              width: 30,
                                                                              height: 30,
                                                                              fit: BoxFit.cover,
                                                                            ),
                                                                            Text('Morning'),
                                                                          ],
                                                                        ),
                                                                      ),
                                                                    if (controller
                                                                            .ReservationList[index]
                                                                            .customerReservation!
                                                                            .afternoon! ==
                                                                        true)
                                                                      Expanded(
                                                                        child:
                                                                            Column(
                                                                          children: [
                                                                            Image.asset(
                                                                              'assets/afternoon.png',
                                                                              width: 30,
                                                                              height: 30,
                                                                              fit: BoxFit.cover,
                                                                            ),
                                                                            Text('Afternoon'),
                                                                          ],
                                                                        ),
                                                                      ),
                                                                    if (controller
                                                                            .ReservationList[index]
                                                                            .customerReservation!
                                                                            .evening! ==
                                                                        true)
                                                                      Expanded(
                                                                        child:
                                                                            Column(
                                                                          children: [
                                                                            Image.asset(
                                                                              'assets/night.png',
                                                                              width: 30,
                                                                              height: 30,
                                                                              fit: BoxFit.cover,
                                                                            ),
                                                                            Text('Evening'),
                                                                          ],
                                                                        ),
                                                                      ),
                                                                  ],
                                                                ),
                                                                SizedBox(
                                                                    height: 10),
                                                               Text(
                                                                  "Customer Name :" +
                                                                      controller
                                                                          .ReservationList[
                                                                              index]
                                                                          .customerReservation!
                                                                          .customer!
                                                                          .firstName
                                                                          .toString() +
                                                                      ' ' +
                                                                      controller
                                                                          .ReservationList[
                                                                              index]
                                                                          .customerReservation!
                                                                          .customer!
                                                                          .lastName
                                                                          .toString(),
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
                                                if (value == 'complain') {
                                                  //print(controller.CustomerList[index].id);
                                                  // CustomerItemView(id: controller.CustomerList[index].id);
                                                  // Get.toNamed<dynamic>(AppRoutes.rating);
                                                  Navigator.of(context)
                                                      .pushNamed("complain");
                                                }
                                                if (value == 'reject') {
                                                  showDialog(
                                                    context: context,
                                                    builder: (BuildContext context) {
                                                      return AlertDialog(
                                                        title: Text('Confirmation'),
                                                        content: Text('Are you sure you want to decline this reservation?'),
                                                        actions: [
                                                          TextButton(
                                                            child: Text('Cancel'),
                                                            onPressed: () {
                                                              Navigator.of(context).pop(); // Ferme la boîte de dialogue
                                                            },
                                                          ),
                                                          TextButton(
                                                            child: Text('Decline'),
                                                            onPressed: () {
                                                              // Appeler la méthode pour décliner la réservation ici
                                                              controller.CancelReservation(controller.ReservationList[index].customerReservation!.id!);

                                                              Navigator.of(context).pop(); // Ferme la boîte de dialogue
                                                            },
                                                          ),
                                                        ],
                                                      );
                                                    },
                                                  );
                                                }
                                                if (value == 'customer') {
                                                  showDialog(
                                                    context: context,
                                                    builder: (context) {
                                                      return AlertDialog(
                                                        title: Text(
                                                            'Customer Details'),
                                                        content: Column(
                                                          crossAxisAlignment:
                                                              CrossAxisAlignment
                                                                  .start,
                                                          mainAxisSize:
                                                              MainAxisSize.min,
                                                          children: [
                                                            Center(
                                                              child: CachedNetworkImage(
                                                                imageUrl: 'assets/profile.png',
                                                                imageBuilder: (context, imageProvider) => CircleAvatar(
                                                                  radius: 40,
                                                                  backgroundImage: imageProvider,
                                                                ),
                                                                placeholder: (context, url) => CircleAvatar(
                                                                  radius: 40,
                                                                  backgroundColor: Colors.grey,
                                                                ),
                                                                errorWidget: (context, url, error) => CircleAvatar(
                                                                  radius: 40,
                                                                  backgroundColor: Colors.grey,
                                                                  child: Icon(Icons.person),
                                                                ),
                                                              ),
                                                            ),
                                                            SizedBox(height: 10),
                                                            Row(
                                                              children: [
                                                                Icon(Icons
                                                                    .person),
                                                                SizedBox(
                                                                    width: 5),
                                                                Text(
                                                                    'Name: ${controller.ReservationList[index].customerReservation!.customer!.firstName} ${controller.ReservationList[index].customerReservation!.customer!.lastName}'),
                                                              ],
                                                            ),
                                                            Row(
                                                              children: [
                                                                Icon(Icons.email),
                                                                SizedBox(width: 5),
                                                                Text('Email: ${controller.ReservationList[index].customerReservation!.customer!.emailAdress}'),
                                                              ],
                                                            ),
                                                            Row(
                                                              children: [
                                                                Icon(Icons.phone),
                                                                SizedBox(width: 5),
                                                                Text('Phone: ${controller.ReservationList[index].customerReservation!.customer!.phone}'),
                                                              ],
                                                            ),
                                                         /*   Row(
                                                              children: [
                                                                Icon(Icons.location_on),
                                                                SizedBox(width: 5),
                                                                Text('Gouvernerat: ${controller.ReservationList[index].customerReservation!.customer!.gouvernerat!.name!} ,'),      //${controller.ReservationList[index].customerReservation!.customer!.delegation!.name}
                                                              ],
                                                            ),*/
                                                            Row(
                                                              children: [
                                                                SizedBox(width: 5),
                                                                Icon(Icons.home),
                                                                Text('Home address: ${controller.ReservationList[index].customerReservation!.customer!.home_Adress}'),
                                                              ],
                                                            ),
                                                           Row(
                                                              children: [
                                                                SizedBox(width: 5),
                                                                Text('Residence : ${controller.ReservationList[index].customerReservation!.customer!.residenceType!.label!} , with ${controller.ReservationList[index].customerReservation!.customer!.residenceNumberOfrooms!} rooms'),
                                                              ],
                                                            ),
                                                            Row(
                                                              children: [
                                                                Icon(Icons.people),
                                                                SizedBox(width: 5),
                                                                Text('Number of residents:  ${controller.ReservationList[index].customerReservation!.customer!.numberOfPersonInRes}'),
                                                              ],
                                                            ),

                                                            // Ajoutez d'autres détails du client ici
                                                          ],
                                                        ),
                                                        actions: [
                                                          TextButton(
                                                            onPressed: () {
                                                              Navigator.pop(
                                                                  context);
                                                            },
                                                            child:
                                                                Text('Close'),
                                                          ),
                                                        ],
                                                      );
                                                    },
                                                  );
                                                }
                                                /* if(value=='favorite'){
                                                      Get.toNamed<dynamic>(AppRoutes.preferences,arguments: controller.ReservationList[index].id);
                                                    }*/
                                              },
                                            ),

                                            //child: Text(    controller.CustomerList[index].firstName.toString().substring(0, 1).toUpperCase()+controller.CustomerList[index].lastName.toString().substring(0, 1).toUpperCase()
// style: TextStyle(color: Colors.black)),
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
          ); /*: Container(
            child: Center(child: CircularProgressIndicator()),
          );*/
        }),
/*        bottomNavigationBar: BottomNavigationBar(
          //currentIndex: currentIndex,
          selectedItemColor: Colors.black54,
          unselectedItemColor: Colors.black54,
          showSelectedLabels: true,
          showUnselectedLabels: true,
          elevation: 0,
          items: const <BottomNavigationBarItem>[
            BottomNavigationBarItem(
              icon: Icon(Icons.home_rounded, color: Colors.blueAccent),
              label: 'Home',
            ),
            BottomNavigationBarItem(
              icon: Icon(Icons.list_alt, color: Colors.blueAccent),
              label: 'Orders',
            ),
            BottomNavigationBarItem(
              icon: Icon(
                Icons.favorite,
                color: Colors.redAccent,
              ),
              label: 'Preferences',
            ),
            BottomNavigationBarItem(
              icon: Icon(Icons.heart_broken, color: Colors.black),
              label: 'Blacklist',
            ),
            BottomNavigationBarItem(
              icon: Icon(Icons.menu),
              label: 'Menu',
            ),
          ],
        )*/);
  }
}
