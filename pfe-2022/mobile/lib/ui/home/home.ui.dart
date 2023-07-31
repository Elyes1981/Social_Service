import 'package:demo/ui/LOCAL/local.controller.dart';
import 'package:demo/ui/home/home.controller.dart';
import 'package:demo/ui/home/home2.ui.dart';
import 'package:demo/ui/login/login.ui.dart';
import 'package:demo/ui/signup/signup.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:google_fonts/google_fonts.dart';


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
            Container(padding:EdgeInsets.all(15), child:Text("2".tr, style: TextStyle(fontSize: 20 ,color: Colors.black),)),
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

void _onTap(int index)
  {
    
  }

class HeaderSection extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      height: 500,
      decoration: BoxDecoration(
        color: Colors.blueGrey,
        image: DecorationImage(
          image: AssetImage('assets/image2.jpg'),
          fit: BoxFit.cover,
        ),
        borderRadius: BorderRadius.only(
          bottomLeft: Radius.circular(50),
        ),
      ),
      child: Stack(
        children: [
         Positioned(
            left: 20,
            bottom: 30,
            child: Text(
                "3".tr,
                style: GoogleFonts.pacifico(
                    fontWeight: FontWeight.bold,
                    fontSize: 50,
                    color: Colors.black),
              ),
          ),
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
}

class PlayListSection extends StatelessWidget {
  final List playList = [
  ];
  @override
  Widget build(BuildContext context) {
    return Container(
 
      padding: EdgeInsets.fromLTRB(30, 100, 20, 20),
      child: Column(
        children: [
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              Text("2".tr),
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
  
