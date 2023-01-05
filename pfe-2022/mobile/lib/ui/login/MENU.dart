import 'package:demo/ui/Calendar/calendar.dart';
import 'package:demo/ui/Reclamation/reclamation.dart';
import 'package:demo/ui/login/login.controller.dart';
import 'package:demo/ui/login/login.ui.dart';
import 'package:demo/ui/ordres/Ordres.dart';
import 'package:demo/ui/profil/profil.dart';
import 'package:demo/ui/profil/profilController.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:google_sign_in/google_sign_in.dart';


class  Categories  extends StatefulWidget{
  @override
  State<StatefulWidget> createState() {
    return MyHomePageState();
  }

}

class MyHomePageState extends State<Categories> {
    final GoogleSignIn _googleSignIn = GoogleSignIn();
int selectedIndex = 0;
  Widget prof = Profile();
  Widget calend = Calendar();
  Widget ordre = ordres();
  Widget reclamation = Reclamation();
  var kPrimaryColor;
  void signOutGoogle() async{
  await _googleSignIn.signOut();
  print("User Sign Out");
}


  @override
 Widget build(BuildContext context){
   return Scaffold(
     appBar: AppBar(
       title: Text("Welcome:${profilController.instance.usernName}".tr),
       //: "
       centerTitle: true,
         actions: <Widget>[
    IconButton(
      icon: Icon(
        Icons.logout,
        color: Colors.white,
      ),
      onPressed: () {
        
         signOutGoogle();
                           
                                   Navigator.push(
                  context,
                  MaterialPageRoute(
                    builder: (context) => LoginView(),
                  ),
                );
      },
    ),
         ]
     ),
   
     body:  this.getBody(),
      bottomNavigationBar: BottomNavigationBar(
        type: BottomNavigationBarType.fixed,
        currentIndex: this.selectedIndex,
        items: [
          BottomNavigationBarItem(
            icon: Icon(Icons.calendar_today),
            label:"6".tr,
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.person),
            label: "7".tr,
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.view_list),
            label: "8".tr,
          ),
            BottomNavigationBarItem(
            icon: Icon(Icons.report_problem),
            label: "10".tr,
          )
        ],
        onTap: (int index) {
          this.onTapHandler(index);
        },
      ),
    );
  }

    Widget getBody( )  {
    if(this.selectedIndex == 0) {
      return this.calend;
    } else if(this.selectedIndex==1) {
      return this.prof;
       } else if(this.selectedIndex==2) {
      return this.ordre;
    } 
    else {
      return this.reclamation;
    }
  }

  void onTapHandler(int index)  {
    this.setState(() {
      this.selectedIndex = index;
    });
  }
}

   

  



 




 