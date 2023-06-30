import 'package:customermobile/ui/servicesType/servicestype.controller.dart';


import 'package:flutter/material.dart';
import 'package:get/get.dart';

class Servicestype extends GetView<ServicestypeController> {
  //const Servicestype({Key? key}) : super(key: key);

 
 int currentIndex = 0;
  void onTap(int index) {
    
      currentIndex = index;
    }
  

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Obx((){
  return controller.isloading.isFalse?
            
      Padding(
        padding: const EdgeInsets.fromLTRB(20, 60, 20, 20),
        child: Column(
            
            children: <Widget>[
              /*Align(
                alignment: Alignment.topLeft,
                child: GestureDetector(
                  onTap: () => Navigator.pop(context),
                  child: Icon(
                    Icons.arrow_back,
                    size: 40,
                    color: Colors.black54,
                  ),
                ),
              ),*/
              Row(
                children: [
                  Container(
                    height:200,
                    width: 160,
                    child: InkWell(
                        onTap: () {
                          Navigator.of(context).pushNamed("homepage");
                        },
                        child: Card(
                          clipBehavior: Clip.antiAlias,
                          shape: RoundedRectangleBorder(
                            borderRadius: BorderRadius.circular(24),
                          ),
                          child: Column(
                            children: [
                              Stack(
                                children: [
                                  Image.asset(
                                    "assets/images/c4.jpg",
                                    width: 340,
                                    height: 140,
                                  ),
                                ],
                              ),
                              Positioned(
                                bottom: 16,
                                right: 16,
                                left: 16,
                                child: Text(
                                  controller.ServiceList[0],
                                  style: TextStyle(
                                    fontWeight: FontWeight.bold,
                                    color: Color.fromARGB(255, 7, 35, 83),
                                    fontSize: 14,
                                  ),
                                ),
                              ),
                            ],
                          ),
                        )),
                  ),
              
              Container(
                 height:200,
                    width: 160,
                  child: InkWell(
                onTap: () {
                  Navigator.of(context).pushNamed("homepage");
                },
                child: Card(
                  clipBehavior: Clip.antiAlias,
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(24),
                  ),
                  child: Column(
                    children: [
                      Stack(
                        children: [
                          Image.asset(
                            "assets/images/c5.jpg",
                            width: 340,
                            height: 140,
                          ),
                        ],
                      ),
                      Padding(
                        padding: EdgeInsets.all(16).copyWith(bottom: 0),
                      ),
                      Positioned(
                        bottom: 16,
                        right: 16,
                        left: 16,
                        child: Text(
                          controller.ServiceList[1],
                          style: TextStyle(
                            fontWeight: FontWeight.bold,
                            color: Color.fromARGB(255, 7, 35, 83),
                            fontSize: 14,
                          ),
                        ),
                      ),
                    ],
                  ),
                ),
              )),
                ],
              ),
               Row(
                children: [
              Container(
                 height:200,
                    width: 160,
                child: InkWell(
                    onTap: () {
                      Navigator.of(context).pushNamed("homepage");
                    },
                    child: Card(
                      clipBehavior: Clip.antiAlias,
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(24),
                      ),
                      child: Column(
                        children: [
                          Stack(
                            children: [
                              Image.asset(
                                "assets/images/c6.jpg",
                                width: 340,
                                height: 140,
                              ),
                            ],
                          ),
                          Padding(
                            padding: EdgeInsets.all(16).copyWith(bottom: 0),
                          ),
                          Positioned(
                            bottom: 16,
                            right: 16,
                            left: 16,
                            child: Text(
                              controller.ServiceList[2],
                              style: TextStyle(
                                fontWeight: FontWeight.bold,
                                color: Color.fromARGB(255, 7, 35, 83),
                                fontSize: 14,
                              ),
                            ),
                          ),
                        ],
                      ),
                    )),
              ),
              Container(
                 height:200,
                    width: 160,
                child: InkWell(
                    onTap: () {
                      Navigator.of(context).pushNamed("homepage");
                    },
                    child: Card(
                      clipBehavior: Clip.antiAlias,
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(24),
                      ),
                      child: Column(
                        children: [
                          Stack(
                            children: [
                              Image.asset(
                                "assets/images/c7.jpg",
                                width: 340,
                                height: 140,
                              ),
                            ],
                          ),
                          Padding(
                            padding: EdgeInsets.all(16).copyWith(bottom: 0),
                          ),
                          Positioned(
                            child: Text(
                              controller.ServiceList[3],
                              style: TextStyle(
                                fontWeight: FontWeight.bold,
                                color: Color.fromARGB(255, 7, 35, 83),
                                fontSize: 14,
                              ),
                            ),
                          ),
                        ],
                      ),
                    )),
              ),]),
              Container(
                 height:200,
                    width: 160,
                child: InkWell(
                    onTap: () {
                      Navigator.of(context).pushNamed("home_adress");
                    },
                    child: Card(
                      clipBehavior: Clip.antiAlias,
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(24),
                      ),
                      child: Column(
                        children: [
                          Stack(
                            children: [
                              Image.asset(
                                "assets/images/c8.jpg",
                                width: 340,
                                height: 140,
                              ),
                            ],
                          ),
                          Padding(
                            padding: EdgeInsets.all(16).copyWith(bottom: 0),
                          ),
                          Positioned(
                            bottom: 16,
                            right: 16,
                            left: 16,
                            child: Text(
                              controller.ServiceList[4],
                              style: TextStyle(
                                fontWeight: FontWeight.bold,
                                color: Color.fromARGB(255, 7, 35, 83),
                                fontSize: 14,
                              ),
                            ),
                          ),
                        ],
                      ),
                    )),
              ),
              ],
              ),
      )
             :Container(child: Center(child: CircularProgressIndicator()),
            )
            ;
            
           
         
      }
      ),
        
     bottomNavigationBar: BottomNavigationBar(
        onTap: onTap,
        currentIndex: currentIndex,
        selectedItemColor: Colors.black54,
        unselectedItemColor: Colors.grey.withOpacity(0.5),
        showSelectedLabels: true,
        showUnselectedLabels: false,
        elevation: 0,
        items: const <BottomNavigationBarItem>[
          BottomNavigationBarItem(
            icon: Icon(Icons.home_rounded),
            label: 'Home',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.add_alert),
            label: 'Order',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.chat_rounded),
            label: 'Message',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.calendar_month),
            label: 'Schedule',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.menu),
            label: 'Menu',
          ),
        ],
      )  );
    
  }
}
