import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpEvent, HttpHeaders, HttpRequest,HttpParams } from '@angular/common/http';
import { CustomerResearch } from 'src/app/Model/customer-research';
import { Recurrent } from 'src/app/Model/recurrent';
import * as L from 'leaflet';

@Injectable({
  providedIn: 'root'
})

export class ResearchService {

     constructor(private http: HttpClient) {

      }
 ngAfterViewInit(): void {

       var map = L.map('map', {
        center: [ 36.8315797, 10.2330051 ],
        zoom: 3
      });

      const tiles = L.tileLayer('http://{s}.google.com/vt/lyrs=m&x={x}&y={y}&z={z}', {
        maxZoom: 24,
        minZoom: 3,
        subdomains:['mt0','mt1','mt2','mt3'],

      });


      tiles.addTo(map);
     // add marker to the current position
  if(!navigator.geolocation){
      console.log('localisation is not supported');
    }
    navigator.geolocation.getCurrentPosition((position)=>
    {  var marker = new L.Marker(new L.LatLng(position.coords.latitude, position.coords.longitude));
      map.flyTo([position.coords.latitude, position.coords.longitude],12);
      console.log(
        `latt.${position.coords.latitude}, lon:${position.coords.longitude}`
      )
      marker.addTo(map).bindPopup('Getting your Current Location details.').openPopup();
    });
    //Moving Marker


//.addTo(this.map).bindPopup("Exact Location");

 // popup on mapclick
var popup = new L.Popup();

function onMapClick(e:any) {

	popup
		.setLatLng(e.latlng)
		.setContent("You clicked the map at " + e.latlng.toString());
   /// .openOn(map);

   var marker = new L.Marker(new L.LatLng(e.latlng.lat, e.latlng.lng),{draggable:true});
   marker.addTo(map).bindPopup("Getting your New Location").openPopup();
   console.log("You clicked the map at latitude: " + e.latlng.lat + " and longitude: " + e.latlng.lng);
   window.alert('getting data successfully!');
   localStorage.setItem('home_Adress_GPS_latt',e.latlng.lat);
   localStorage.setItem('home_Adress_GPS_long',e.latlng.lng);

}

map.on('click', onMapClick);

    }

     getList(): Observable<any> {
       return this.http.get("http://localhost:8091/reseach");}
     create(CustomerResearch: CustomerResearch): Observable<any> {
        return this.http.post("http://localhost:8091/reseach/neww",CustomerResearch);}
     getlistresearchmou3ina():Observable<any>{
     return this.http.get("http://localhost:8091/reseach")
     }
      getlistresult(query:any,morning :boolean ,evening:boolean ,afternoon :boolean ,anArray: any,lat:any ,lon:any,limit:any ):Observable<any>{
      let params = new HttpParams();
      params = params.set('query', query);
      params = params.set('morning', morning);
      params = params.set('evening', evening);
      params = params.set('afternoon', afternoon);
      params = params.set('anArray',anArray);
      params = params.set('lat',lat);
      params = params.set('lon',lon);
      params = params.set('limit',limit);
          return this.http.get("http://localhost:8091/reseach/date1",{ params: params } );
          }

      get(id: number): Observable<any> {
            return this.http.get("http://localhost:8091/reseach/"+ `${id}`);
          }
}
