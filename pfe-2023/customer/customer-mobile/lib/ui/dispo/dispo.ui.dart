import 'package:flutter/material.dart';
import 'package:get/get.dart';

import 'dispo.controller.dart';

class DispoView extends GetView<DispoController>{
  const DispoView({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Scaffold(
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(
              'Centered Text',
              style: TextStyle(
                fontSize: 24.0,
                fontWeight: FontWeight.bold,
              ),
            ),
            SizedBox(height: 20.0),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                ElevatedButton(
                  onPressed: () {
                    // TODO: Implement validate button logic
                  },
                  child: Text('Validate'),
                ),
                SizedBox(width: 20.0),
                OutlinedButton(
                  onPressed: () {
                    // TODO: Implement cancel button logic
                  },
                  child: Text('Cancel'),
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }

}