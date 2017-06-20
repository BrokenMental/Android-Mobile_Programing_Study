package com.inhatc.juha.googlemap_source;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        long minTime = 1000;
        float minDistance = 1;

        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        LocationManager locationManager = (LocationManager) this.
                getSystemService(Context.LOCATION_SERVICE);

        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                updateMap(location);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
                alertStatus(provider);
            }

            @Override
            public void onProviderEnabled(String provider) {
                alertProvider(provider);
            }

            @Override
            public void onProviderDisabled(String provider) {
                checkProvider(provider);
            }
        };

        String strLocationProvider = LocationManager.NETWORK_PROVIDER;
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
            return;
        }
        locationManager.requestLocationUpdates(strLocationProvider,
                                                minTime, minDistance, locationListener);
    }

    public void updateMap(Location location) {
        double latitude = location.getLatitude();
        double longtude = location.getLongitude();
        final LatLng objLocation = new LatLng(latitude, longtude);

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(objLocation, 15));
        Marker objMK = mMap.addMarker(new MarkerOptions()
                .position(objLocation)
                .title("Current Postion"));
        objMK.showInfoWindow();
    }

    public void checkProvider(String strProvider) {
        Toast.makeText(this, strProvider + "에 의한 turn off postion service. " +
                "Please Turn on position service...", Toast.LENGTH_SHORT).show();

        Intent objIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        startActivity(objIntent);
    }

    public void alertProvider(String strProvider) {
        Toast.makeText(this, strProvider + "Strarting position service !",
                Toast.LENGTH_LONG).show();
    }

    public void alertStatus(String strProvider) {
        Toast.makeText(this, "Changing postion service : " + strProvider,
                Toast.LENGTH_LONG).show();

        /*
        double latitude = 37.448344;
        double longitude = 126.657474;
        LatLng objLocation;

        objLocation = new LatLng(latitude, longitude);

        Marker objMK1 = mMap.addMarker(new MarkerOptions()
                                        .position(objLocation)
                                        .title("Inha Technical College")
                                        .snippet("INHATC"));

        latitude = 37.449402;
        longitude = 126.657348;
        objLocation = new LatLng(latitude, longitude);

        Marker objMK2 = mMap.addMarker(new MarkerOptions()
                .position(objLocation)
                .title("수준 원점")
                .snippet("국토 높이의 기준점"));

        objMK2.showInfoWindow();
        mMap.moveCamera(CameraUpdateFactory.newLatLng(objLocation));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(15));

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        */

        /*
        double latitude = 37.448344;
        double longitude = 126.657474;
        LatLng objLocation;

        objLocation = new LatLng(latitude, longitude);

        mMap.addMarker(new MarkerOptions().position(objLocation).title("Inha Technical College"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(objLocation));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(16));

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        */

        // Add a marker in Sydney and move the camera
        /*
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        */
    }
}
