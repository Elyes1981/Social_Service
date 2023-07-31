import 'dart:convert';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:get/get_state_manager/src/rx_flutter/rx_obx_widget.dart';
import 'package:providers_services/core/models/CustomerOrderMou3inaList.dart';
import 'package:http/http.dart' as http;
import 'package:providers_services/core/routes/app_routes.dart';
import 'package:providers_services/ui/ordres/ordresController.dart';

class ProvidersOrders extends GetView<ordresController> {
  final navigatorKey = GlobalKey<NavigatorState>();

  @override
  Widget build(BuildContext context) {
    controller.findResearch();
    print("hiii" + controller.mou3ina_orderlist.length.toString());
    // controller.findMou3inas();
    // print(controller.ReservationList[0].desiredDate.toString());

    controller.findResearch();

    print(controller.mou3ina_orderlist.length.toString());
    return Scaffold(
      body: Obx(() {
        return SingleChildScrollView(
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
                      bottomRight: Radius.circular(40),
                    ),
                  ),
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
                              fontSize: 22,
                              fontWeight: FontWeight.w700,
                            ),
                          ),
                          SizedBox(
                            width: 10,
                          ),
                        ],
                      ),
                      Padding(
                        padding: EdgeInsets.only(left: 10, right: 10, top: 10),
                        child: Column(
                          crossAxisAlignment: CrossAxisAlignment.center,
                          children: [
                            ListView.builder(
                              shrinkWrap: true,
                              itemCount: controller.mou3ina_orderlist.length,
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
                                            height: 100,
                                            width: 60,
                                            decoration: BoxDecoration(
                                              image: DecorationImage(
                                                image: AssetImage(
                                                  "assets/ttt.jpg",
                                                ),
                                              ),
                                            ),
                                          ),
                                        ),
                                        title: Text(
                                          controller.mou3ina_orderlist[index]
                                              .id!
                                              .toString(),
                                          style: TextStyle(
                                            fontSize: 16,
                                            fontWeight: FontWeight.w400,
                                          ),
                                        ),
                                        subtitle: Text(
                                          controller.mou3ina_orderlist[index]
                                              .rank!
                                              .toString(),
                                          style: TextStyle(
                                            fontSize: 16,
                                            fontWeight: FontWeight.w400,
                                          ),
                                        ),
                                        trailing: PopupMenuButton(
                                          itemBuilder: (context) {
                                            return [
                                              PopupMenuItem(
                                                value: 'rate',
                                                child: Text('Rating'),
                                                onTap: () {
                                                  // Handle rating action
                                                },
                                              ),
                                              PopupMenuItem(
                                                value: 'favorite',
                                                child: Text('Favorite'),
                                                onTap: () {
                                                  // Handle favorite action
                                                },
                                              ),
                                              PopupMenuItem(
                                                value: 'complain',
                                                child: Text('Complain'),
                                                onTap: () {
                                                  // Handle complain action
                                                },
                                              ),
                                            ];
                                          },
                                          onSelected: (String value) {
                                            if (value == 'rate') {
                                              // Handle rate action
                                            } else if (value == 'favorite') {
                                              // Handle favorite action
                                            } else if (value == 'complain') {
                                              // Handle complain action
                                            }
                                          },
                                        ),
                                      ),
                                    ],
                                  ),
                                );
                              },
                            ),
                          ],
                        ),
                      ),
                    ],
                  ),
                ),
              ],
            ),
          ),
        );
      }),
      bottomNavigationBar: BottomNavigationBar(
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
      ),
    );
  }
}