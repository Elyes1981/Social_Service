
import 'package:flutter/material.dart';
import 'package:get/get.dart';

import '../local/local.controller.dart';
import '../login/login.ui.dart';
import 'home.controller.dart';

class Home2View extends GetView<HomeController>{
  const Home2View({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      extendBodyBehindAppBar: true,
      appBar: MyAppBar(),
      body: SingleChildScrollView(
        child: Column(
          children: [
            HeaderSection(),
            Container(padding:EdgeInsets.all(5), child:Text("5".tr , style: TextStyle(fontSize: 20 ,color: Colors.black),)),
            Row(

              mainAxisAlignment:MainAxisAlignment.center,
              mainAxisSize:MainAxisSize.min,
              children: [


                Row(
                  mainAxisAlignment:MainAxisAlignment.center,
                  mainAxisSize:MainAxisSize.min,
                  children: [
                    Container( margin: EdgeInsets.fromLTRB(150, 50, 0, 0),child: InkWell(onTap: (){


                      Navigator.push(
                        context,
                        MaterialPageRoute(
                          builder: (context) => LoginView(),
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



class HeaderSection extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      height: 500,

      decoration: BoxDecoration(
        color: Colors.blueGrey,
        image: DecorationImage(
          image: AssetImage('assets/ttt.jpg'),
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
}

class PlayListSection extends StatelessWidget {
  final List playList = [
  ];
  @override
  Widget build(BuildContext context) {
    return Container(
      padding: EdgeInsets.fromLTRB(30, 70, 20, 20),
      child: Column(
        children: [
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              Text(
                'Appel à une aide-ménagère de qualité en un claquement de doigt ',
                style: TextStyle(
                  color: Colors.black,
                  fontSize: 15,

                ),
              ),
              Container(
                margin: EdgeInsets.only(right: 10),
                child: Text(
                  'Show all',
                  style: TextStyle(
                    fontSize: 13,
                    color: Colors.blue,
                  ),
                ),
              )
            ],
          ),

        ],
      ),
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


