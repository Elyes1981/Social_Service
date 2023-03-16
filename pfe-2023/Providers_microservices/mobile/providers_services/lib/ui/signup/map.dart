
import 'package:flutter/material.dart';
import 'package:flutter_map/flutter_map.dart';
import 'package:flutter_map_marker_popup/flutter_map_marker_popup.dart';
import 'package:geolocator/geolocator.dart';
import 'package:get/get.dart';
import 'package:latlong2/latlong.dart';
import "package:latlong/latlong.dart" as latLng;
import 'package:providers_services/ui/signup/SignUp3.dart';
import 'package:providers_services/ui/signup/signupController.dart';
class localisatioMap extends GetView<ServiceTypeController> {


 
double currentZoom = 3.0;
Position? _position ;
double?_lat;
double? _long;
 MapController mapController = MapController();
void getCurrentLocation() async{
Position position = await _determinePosition();
_position= position;
_lat = position.latitude ;
_long= position.longitude;


controller.x=_lat;
controller.y=_long;
print(controller.x);
print(controller.y);
}
Future<Position> _determinePosition() async {
    LocationPermission permission;

    permission = await Geolocator.checkPermission();

    if (permission == LocationPermission.denied) {
      permission = await Geolocator.requestPermission();
      if (permission == LocationPermission.denied) {
        return Future.error('Location Permissions are denied');
      }
    }

    return await Geolocator.getCurrentPosition();
  }

   void _zoom_out() {
    currentZoom = currentZoom - 1;
    mapController.move(LatLng(36.80, 10.18), currentZoom);
  }

  void _zoom_in() {
    currentZoom = currentZoom + 1;
    mapController.move(LatLng(36.80, 10.18), currentZoom);
  }


  @override
Widget build(BuildContext context) {
  return Scaffold(
   body:Stack(children:[
      FlutterMap(
    options: MapOptions(
      center: LatLng(36.8, 10.2),
      zoom: 13.0,
    ),
    children: [
      TileLayer(
        urlTemplate: 'http://{s}.google.com/vt/lyrs=m&x={x}&y={y}&z={z}',
                    subdomains: ['mt0', 'mt1', 'mt2', 'mt3'],
       
      ),
      MarkerLayer(
        
        markers: [
            Marker(
                        width: 80.0,
                        height: 80.0,
                        // draggable: true,
                        point: LatLng(36.8315634, 10.2330663),
                        builder: (context) => Container(
                              child: IconButton(
                                  icon: Icon(Icons.pin_drop, color: Colors.red),
                                  onPressed: () {
                                    print('Marker Tapped');
                                  }),
                            )),
         Marker(
                        width: 80.0,
                        height: 80.0,
                        point: LatLng(_lat ?? 0, _long ?? 0),
                        builder: (context) => Container(
                              child: IconButton(
                                  icon: Icon(Icons.pin_drop, color: Colors.red),
                                  onPressed: () {
                                    print('Current Location');
                                  }),
                            )),
        ],
      ),
    ],
  ),

            Padding(
              padding: EdgeInsets.symmetric(horizontal: 16.0, vertical: 34.0),
              child: Column(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Card(
                    child: TextField(
                      decoration: InputDecoration(
                        contentPadding: EdgeInsets.all(20.0),
                        hintText: "My Location",
                        prefixIcon: Icon(Icons.location_on_outlined),
                      ),
                    ),
                  ),
                  Card(
                    child: Padding(
                      padding: const EdgeInsets.all(8.0),
                      child: Column(
                        children: [
                          Text("${controller.x ?? 0},${controller.y ?? 0}"),
                        ],
                      ),
                    ),
                  ),
                ],
              ),
            ),

          ],
        ),
  floatingActionButton:
            Column(mainAxisAlignment: MainAxisAlignment.end, children: [
       
        
          FloatingActionButton(
            onPressed: (){
              getCurrentLocation();
             },
                  child: const Icon(Icons.location_on),
          
            
          ),
           SizedBox(
            height: 10,
          ),
           FloatingActionButton(
            onPressed: _zoom_in,
            child: const Icon(Icons.add_circle),
          ),
          SizedBox(
            height: 10,
          ),
          FloatingActionButton(
            
            onPressed: _zoom_out,
            child: const Icon(Icons.remove_circle),
          ),
        
          SizedBox(
            height: 10,
          )
          ,
          FloatingActionButton(
            onPressed: (){   Navigator.push(
                  context,
                  MaterialPageRoute(
                    builder: (context) => SignUp3(),
                  ),
                );},
           child: const Icon(Icons.arrow_forward),
          )
        
            
        
        ]
        
        )
        
        );
  }
}

