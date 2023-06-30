import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:select_form_field/select_form_field.dart';

import 'complain.controller.dart';

class Complain extends GetView<ComplainController> {

   final _formKey = GlobalKey<FormState>();
  @override
  Widget build(BuildContext context) {
    controller.findcomptype();
  
    controller.findsoustypes();
  //  print(controller.ReservationList.length.toString());
    //print(controller.isloading.value);
    return Scaffold(
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
        
      body: SingleChildScrollView(
         
              child: Padding(
                  padding: EdgeInsets.only(left: 10, right: 10, top: 30),
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.center,
                    children: [
                      Container(
                        height: 630,
                        width: 400,
                        child: InkWell(
                            onTap: () {
                              //Navigator.of(context).pushNamed("homepage");
                            },
                            
                            child: Card(
                              clipBehavior: Clip.antiAlias,
                              shape: RoundedRectangleBorder(
                                borderRadius: BorderRadius.circular(24),
                              ),
                              child: Column(
                                children: [
                                  SizedBox(height: 10,),
                                  Center(
                                      child: Container(
                                        child: Text("Complaint Box",
                                        style:TextStyle(
                                color: Colors.purple,
                                fontWeight: FontWeight.w500,
                                fontSize: 20,
                                
                            )))),
                                Stack(
                                      children: [
                                        Image.asset(
                                          "assets/images/cmp.jpg",
                                          height:200 ,
                                          width:400 ,
                                          
                                        ),
                                      ],
                                    ),
                                    Center(
                                      child: Container(
                                        child: Text("Your Feedback is so important to ",
                                        style:TextStyle(
                                color: Colors.black,
                                fontWeight: FontWeight.w400,
                                fontSize: 15,
                                
                            )
                                        ),
                                      ),
                                    ),
                                     Center(
                                      child: Container(
                                        child: Text(" help us improve our services",
                                        style:TextStyle(
                                color: Colors.black,
                                fontWeight: FontWeight.w400,
                                fontSize: 15,
                                
                            )))),
                            Obx(() {
      return controller.isloading.isFalse
          ? 
                            Form(
                  key: _formKey,
                               child:   Column(
                                    children: [
                                       Padding(
                        padding: const EdgeInsets.fromLTRB(20, 40,20, 0),
                        child: SelectFormField(
                          hintText: "Choose Complains",
                          type:
                              SelectFormFieldType.dropdown, // or can be dialog
                          initialValue: "Complains",

                          items: controller.complainList,
                          onChanged: (String val) =>
                              {//controller.selectComplain( ),
                              controller.compSelected= val ,
                               print(val)
                               //heeeerrreee uuu 
                              },
                              
                          onSaved: (val) => {},
                          
                        ),
                      ),
                     
                      SizedBox(height: 10,),
                      Padding(
                        padding: const EdgeInsets.fromLTRB(20, 0, 20, 0),
                        child: SelectFormField(
                       hintText: "Choose Sub Complains",

                          type:
                              SelectFormFieldType.dropdown, // or can be dialog
                          //initialValue: "Complains",

                          items: controller.sousTypesList,
                          onChanged: (String val) =>
                              {controller.sousSelected = val},
                          onSaved: (val) => {},
                        ),
                      ),
                          SizedBox(height: 5,),
                      
                         Padding(
                        padding: const EdgeInsets.fromLTRB(20, 0, 20, 0),
                           child: TextFormField(
                            controller: controller.autre,
                            decoration: InputDecoration(
                            labelText: 'Add Another Complains',
                             
                          ),
                          maxLines: 3,

                            //controller: controller.a,
                           
                          // maxLines: 4,
                        ),
                         ),
                      
                                  
                                  SizedBox(height: 20,
                                  ),
                                  Row(
                                    children: [
                                        Padding(
                                          padding: const EdgeInsets.fromLTRB(25, 0, 0, 0),
                                          child: ElevatedButton(
                    onPressed: () {
                      Navigator.of(context).pushNamed("rating");
                    },
                    child: Text( "Cancel"),
                    style: ElevatedButton.styleFrom(
                      primary: Colors.purple
                    ),
                  ),
                                        ),
                  SizedBox(width: 180,),
                                      ElevatedButton(
                    onPressed: () { controller.createCustComplain();
                            controller.addcuscomplain(_formKey.currentState!.validate());
                            Navigator.of(context).pushNamed("complainlist");
                          },
                    child: Text( "Submit"),
                    style: ElevatedButton.styleFrom(
                      primary: Colors.purple
                    ),
                  ),
                
                  
                                    ],
                                  )   ],
                                  ), ) : Container(
              child: Center(child: CircularProgressIndicator()),
            );
    })
    ,

                                  
                                  
                                ],
                              ),
                            )),
                      ),
                    ],
                  ))),
        
     bottomNavigationBar: BottomNavigationBar(
          
          //currentIndex: currentIndex,
          selectedItemColor: Colors.black54,
          unselectedItemColor: Colors.black54,
          showSelectedLabels: true,
          showUnselectedLabels: true,
          elevation: 0,
          items: const <BottomNavigationBarItem>[
            BottomNavigationBarItem(
              icon: Icon(Icons.home_rounded,color:Colors.blueAccent),
              label: 'Home',
             
              
              
            ),
            BottomNavigationBarItem(
              
              icon: Icon(Icons.list_alt,color:Colors.blueAccent),
              label: 'Orders',

            ),
            BottomNavigationBarItem(
              icon: Icon(Icons.favorite,color: Colors.redAccent,),
              label: 'Preferences',
            ),
            BottomNavigationBarItem(
              icon: Icon(Icons.heart_broken,color:Colors.black),
              label: 'Blacklist',
            ),
            BottomNavigationBarItem(
              icon: Icon(Icons.menu),
              label: 'Menu',
            ),
          ],
        )
    );
  }
}
