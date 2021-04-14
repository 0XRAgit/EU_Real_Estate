package com.example.eurealestate;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class chat_pod extends AppCompatActivity {

    BottomNavigationView bnm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_pod);
        bnm=findViewById(R.id.bnm);
        bnm.setSelectedItemId(R.id.chat_sel);

        String[] users = { "Ваша проблема", "Как сменить номер телефона", "Не прогружается VR-шоурум", "Не подключатся VR-очки"};
        Spinner spin = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, users);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);

        bnm.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Intent intent;
                switch (menuItem.getItemId()){
                    case R.id.map_sel:
                        intent = new Intent(chat_pod.this, googleMap.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        break;
                    case R.id.menu_sel:
                        intent = new Intent(chat_pod.this, MainMenu.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        break;
                    case R.id.izb_sel:
                        intent = new Intent(chat_pod.this, Izb.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        break;
                }

                return false;
            }
        });
    }
}