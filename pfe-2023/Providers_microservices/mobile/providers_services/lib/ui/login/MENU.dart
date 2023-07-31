
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:google_sign_in/google_sign_in.dart';
import 'package:providers_services/ui/Calendar/calendar.dart';
import 'package:providers_services/ui/Notification/NotificationListPage.ui.dart';
import 'package:providers_services/ui/Notification/notification.ui.dart';
import 'package:providers_services/ui/Reclamation/reclamation.dart';
import 'package:providers_services/ui/login/login.ui.dart';
import 'package:providers_services/ui/ordres/Ordres.dart';
import 'package:providers_services/ui/profil/profil.dart';
import 'package:providers_services/ui/profil/profilController.dart';
import 'package:providers_services/ui/reservationHistory/ReservationHistory.ui.dart';


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
  Widget ordre = ReservationHistory();
  Widget reclamation = Reclamation();
  Widget notifications = NotificationListPage();
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
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.notifications),
            label: "Notifications",
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
    } else if(this.selectedIndex==3) {
      return this.reclamation;
    } else {
      return this.notifications;
    }
  }

  void onTapHandler(int index)  {
    this.setState(() {
      this.selectedIndex = index;
    });
  }
}

   

  



 




 