import 'package:flutter/material.dart';

class ButtonExample extends StatefulWidget {
  @override
  _ButtonExampleState createState() => _ButtonExampleState();
}

class _ButtonExampleState extends State<ButtonExample> {
  bool isButtonEnabled = false;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Button Example'),
      ),
      body: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          ElevatedButton(
            onPressed: () {
              setState(() {
                isButtonEnabled = !isButtonEnabled;
              });
            },
            child: Text('Toggle Button'),
          ),
          SizedBox(height: 16),
          ElevatedButton(
            onPressed: isButtonEnabled ? () {} : null,
            child: Text('Grayed Out Button'),
          ),
        ],
      ),
    );
  }
}


