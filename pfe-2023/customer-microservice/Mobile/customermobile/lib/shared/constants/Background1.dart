import 'package:flutter/material.dart';

class Background1 extends StatelessWidget {
  final Widget child;

  const Background1({
    Key? key,
    required this.child,  AppBar? appBar,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    Size size = MediaQuery.of(context).size;

    return Container(
      width: double.infinity,
      height: size.height,
      child: Stack(
        alignment: Alignment.center,
        children: <Widget>[
          
         
         
          Positioned(
            bottom: 0,
            right: 0,
            child: Image.asset(
              "assets/images/bottom1.png",
              width: size.width
            ),
          ),
          Positioned(
            bottom: 0,
            right: 0,
            child: Image.asset(
              "assets/images/bottom2.png",
              width: size.width
            ),
          ),
          child
        ],
      ),
    );
  }
}