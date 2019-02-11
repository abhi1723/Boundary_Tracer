package com.recstudentportal.www.googlemapsa;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    boolean MAP_READY=false;
    GoogleMap map;
    MarkerOptions hospital_1,station,gas_station;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MapFragment mapFragment=(MapFragment)getFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MAP_READY=true;
        map=googleMap;
        LatLng place=new LatLng(23.5761874,85.6662259);
        CameraPosition cameraPosition= CameraPosition.builder().target(place).zoom(15).bearing(112.5f).tilt(45).build();
        map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        CircleOptions circleOptions=new CircleOptions();
        circleOptions.center(new LatLng(23.5761874,85.6662259))
                .clickable(true)
                .strokeColor(Color.GREEN)
                .fillColor(Color.argb(64,0,255,0))
                .radius(300);
        map.addCircle(circleOptions);
        map.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }
}
