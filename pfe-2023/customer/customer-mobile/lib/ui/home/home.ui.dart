
import 'package:flutter/material.dart';
import 'package:get/get.dart';


import '../Reservation/Reservation.ui.dart';
import '../local/local.controller.dart';
import '../login/login.ui.dart';
import '../register/register.ui.dart';
import 'home.controller.dart';
import 'home2.ui.dart';


class HomeView extends GetView<HomeController>{
  const HomeView({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    MyLocaleController controllerLang =Get.find();
    int _currentIndex=0;
    // TODO: implement build
    return Scaffold(
      extendBodyBehindAppBar: true,
      appBar: MyAppBar(),
      body:
      SingleChildScrollView(
        child: Column(
          children: [
            HeaderSection(),
            //Container(padding:EdgeInsets.all(15), child:Text("2".tr, style: TextStyle(fontSize: 20 ,color: Colors.black),)),
            Row(

              mainAxisAlignment:MainAxisAlignment.center,
              mainAxisSize:MainAxisSize.min,
              children: [


                Row(
                  mainAxisAlignment:MainAxisAlignment.center,
                  mainAxisSize:MainAxisSize.min,
                  children: [
                    Container( margin: EdgeInsets.fromLTRB(150, 10, 0, 0),child: InkWell(onTap: (){


                      Navigator.push(
                        context,
                        MaterialPageRoute(
                          builder: (context) => Register(),
                        ),
                      );

                    },child:Text("4".tr,style:TextStyle(color: Colors.blue,fontSize:16, fontWeight:FontWeight.w700 ,decoration: TextDecoration.underline,decorationStyle: TextDecorationStyle.solid,)),)),
                  ],
                ) ,




              ],

            ),

          ],
        ),
      ),





    );
  }

}

void _onTap(int index)
{

}


@override
Widget build(BuildContext context) {
  return Container(
    height: 500,
    decoration: BoxDecoration(
      color: Colors.blueGrey,
      image: DecorationImage(
        image: AssetImage('assets/images/c6.jpg'),
        fit: BoxFit.cover,
      ),
      borderRadius: BorderRadius.only(
        bottomLeft: Radius.circular(50),
      ),
    ),
    child: Stack(
      children: [


        Positioned(
          right: 0,
          bottom: 20,
          child: MaterialButton(
            onPressed: () {
              Navigator.push(
                context,
                MaterialPageRoute(
                  builder: (context) => Home2View(),
                ),
              );
            },
            color: Colors.blue,
            shape: CircleBorder(),
            child: Padding(
              padding: EdgeInsets.all(17),
              child: Icon(
                Icons.play_arrow_rounded,
                color: Colors.white,
                size: 30,
              ),
            ),
          ),
        ),

      ],
    ),
  );
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
  
