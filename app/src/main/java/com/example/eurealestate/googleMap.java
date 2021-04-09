package com.example.eurealestate;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.SearchView;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class googleMap extends FragmentActivity implements OnMapReadyCallback {

    BottomNavigationView bnm;
    GoogleMap gm;
    SupportMapFragment gmFragment;
    android.support.v7.widget.SearchView sv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map);
        sv = findViewById(R.id.search_map);
        gmFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.google_map);




        bnm=findViewById(R.id.bnm);
        bnm.setSelectedItemId(R.id.map_sel);
        bnm.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.menu_sel:
                        Intent intent = new Intent( googleMap.this, MainMenu.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        break;
                    case R.id.chat_sel:
                        intent = new Intent(googleMap.this, chat_pod.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        break;
                }

                return false;
            }
        });

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                String location = sv.getQuery().toString();
                List<Address> addressList = null;
                if(location!=null || !location.equals("")){
                    try{
                        Geocoder geocoder = new Geocoder(googleMap.this);
                        addressList = geocoder.getFromLocationName(location,1);
                        if(addressList.size()>0){
                            Address address = addressList.get(0);
                            LatLng latLng = new LatLng(address.getLatitude() , address.getLongitude());
                            gm.addMarker(new MarkerOptions().position(latLng));
                            gm.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,15));
                        }
                    }catch (IOException e){
                        e.printStackTrace();;
                    }
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        gmFragment.getMapAsync(this);
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        gm=googleMap;
    }




}