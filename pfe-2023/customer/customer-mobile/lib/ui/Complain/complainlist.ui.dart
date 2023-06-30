import 'package:flutter/material.dart';
import 'package:get/get.dart';

import 'complain.controller.dart';

class Complainlist extends GetView<ComplainController> {
  final navigatorKey = GlobalKey<NavigatorState>();

  @override
  Widget build(BuildContext context) {
    controller.findComplains();
    print(controller.cus_cmpList.length.toString());

    return Scaffold(
        backgroundColor: Colors.white,
        appBar: AppBar(
          backgroundColor: Colors.white,
          elevation: 0.0,
          leading: Icon(
            Icons.arrow_back,
            color: Colors.black,
          ),
          actions: <Widget>[
            Padding(
              padding: const EdgeInsets.all(8.0),
              child: Icon(
                Icons.favorite_border,
                color: Colors.black,
              ),
            ),
            Padding(
              padding: const EdgeInsets.fromLTRB(0.0, 8.0, 12.0, 8.0),
              child: Icon(
                Icons.more_vert,
                color: Colors.black,
              ),
            ),
          ],
        ),
        body:
        Obx(() { 
      return controller.isloading.isFalse
          ?  SingleChildScrollView(
          scrollDirection: Axis.vertical,
          child: Container(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                // SizedBox(height: 30,),
                Container(
                  padding: EdgeInsets.symmetric(horizontal: 10),
                  child: Column(
                    children: [
                      Center(
                          child: Container(
                              child: Text(" Check Your Complaint Box",
                                  style: TextStyle(
                                    color: Color.fromARGB(255, 44, 25, 135),
                                    fontWeight: FontWeight.w500,
                                    fontSize: 20,
                                  )))),
                      SizedBox(
                        height: 5,
                      ),
                      Stack(
                        children: [
                          Image.asset(
                            "assets/images/cmp.jpg",
                            height: 200,
                            width: 400,
                          ),
                        ],
                      ),
                      Padding(
                          padding: EdgeInsets.only(left: 10, right: 10, top: 2),
                          child: Column(
                            crossAxisAlignment: CrossAxisAlignment.center,
                            children: [
                              ListView.builder(
                                  shrinkWrap: true,
                                  itemCount: controller.cus_cmpList.length,
                                  itemBuilder: (context, index) {
                                    SizedBox(
                                      height: 10,
                                    );
                                    return Card(
                                        child: Column(
                                            mainAxisSize: MainAxisSize.min,
                                            children: <Widget>[
                                          ListTile(
                                            leading: GestureDetector(
                                                behavior:
                                                    HitTestBehavior.translucent,
                                                child: Container(
                                                  height: 60,
                                                  width: 60,
                                                  decoration: BoxDecoration(
                                                      image: DecorationImage(
                                                          image: AssetImage(
                                                              "assets/images/dislike.png"))),
                                                )),
                                            title: controller.cus_cmpList[index]
                                                        .complainType !=
                                                    null
                                                ? Text(controller
                                                    .cus_cmpList[index]
                                                    .complainType!
                                                    .label
                                                    .toString())
                                                : Text(controller
                                                    .cus_cmpList[index].autre
                                                    .toString()),
                                            subtitle: controller
                                                        .cus_cmpList[index]
                                                        .sousTypes !=
                                                    null
                                                ? Text(controller
                                                    .cus_cmpList[index]
                                                    .sousTypes!
                                                    .label
                                                    .toString())
                                                : Text(''),
                                            trailing: Text(
                                              controller.cus_cmpList[index]
                                                      .complainDate!.year
                                                      .toString() +
                                                  '/' +
                                                  controller.cus_cmpList[index]
                                                      .complainDate!.month
                                                      .toString() +
                                                  '/' +
                                                  controller.cus_cmpList[index]
                                                      .complainDate!.day
                                                      .toString(),
                                            ),
                                          ),
                                          /*ButtonTheme.bar( // make buttons use the appropriate styles for cards
                child: new ButtonBar(
                  children: <Widget>[
                    new FlatButton(
                      child: const Text('Thumb up'),
                      onPressed: () { /* ... */ },
                    ),
                    new FlatButton(
                      child: const Text('Thumb down'),
                      onPressed: () { /* ... */ },
                    )]
                    )
                    )*/
                                        ]));
                                  })
                            ],
                          ))
                    ],
                  ),
                ),
              ],
            ),
          ),
        ): Container(
              child: Center(child: CircularProgressIndicator()),
            );
             }
            ),
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
        ));
  }
}
