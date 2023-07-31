import 'package:country_state_city_pro/country_state_city_pro.dart';
import 'package:csc_picker/csc_picker.dart';
import 'package:demo/ui/signup/map.dart';

import 'package:demo/ui/signup/signup.dart';


import 'package:flutter/material.dart';
import 'package:intl_phone_field/intl_phone_field.dart';
class localisation extends StatefulWidget {
  const localisation({ Key? key }) : super(key: key);

  @override
  State<localisation> createState() => _localisationState();
}

class _localisationState extends State<localisation> {

  // the current step
  @override
  Widget build(BuildContext context) {
   return Scaffold(
      extendBodyBehindAppBar: true,
      appBar: MyAppBar(),
      body:
      SingleChildScrollView(
        child: Column(
          children: [
            HeaderSection(),
           
                
          
          
            ],

          ),
           
          
        
      ),
     
      
     
   
   
    );
  }

}



class HeaderSection extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
      TextEditingController country=TextEditingController();
TextEditingController state=TextEditingController();
TextEditingController city=TextEditingController();
  
    return Column(
      children: [
        Container(
          
          height: 250,
          decoration: BoxDecoration(
            color: Colors.blueGrey,
            image: DecorationImage(
              image: AssetImage('assets/c11.png'),
              fit: BoxFit.cover,
            ),
            borderRadius: BorderRadius.only(
              bottomLeft: Radius.circular(50),
            ),
          ),
         
        ),
        
              SizedBox(
                height: 100,
              ),
               CSCPicker(
              onCountryChanged: (value) {
      		
      					var countryValue = value;
      			
                  },
                  onStateChanged:(value) {
                     
      					var stateValue = value;
      			
                  },
                  onCityChanged:(value) {
                  
                      var cityValue = value;
      		
      		},
          ),
         
   SizedBox(
                          height: 20,

                        ),

     FlatButton(
       minWidth: 40,
                        color: Colors.blue,
                        shape: RoundedRectangleBorder(
                            borderRadius: BorderRadius.circular(16.0)),
                        onPressed: () {
                 Navigator.push(
                 context,
                 MaterialPageRoute(
                   builder: (context) => localisatioMap(),
                 ),
                );
                        },
                        child: Text(
                          "Localisation",
                          style: TextStyle(color: Colors.white, fontSize: 20),
                        )),
      ],
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
    return AppBar(
     
      
      actions: [
       
      ],
      backgroundColor: Colors.white.withOpacity(0),
    );
  }
}
  
