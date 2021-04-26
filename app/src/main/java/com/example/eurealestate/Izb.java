package com.example.eurealestate;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Izb extends AppCompatActivity {
    BottomNavigationView bnm;
    ListView listView;
    String[] Titel={"Azzurro"};
    String[] Loc ={"Италия, берег озера Комо"};
    String[] Price ={"2.500.407,00 $"};
    int[] Image ={R.drawable.fomain};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_izb);
        listView = findViewById(R.id.list_men);
        bnm=findViewById(R.id.bnm);
        bnm.setSelectedItemId(R.id.izb_sel);

        Izb.MyAdapter adapter = new Izb.MyAdapter(this, Titel, Loc, Price, Image);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                Intent intent;
                switch (position){
                    case 0:
                        intent = new Intent(Izb.this, Italy.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        break;
                }
            }
        });

        bnm.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Intent intent;
                switch (menuItem.getItemId()){
                    case R.id.map_sel:
                        intent = new Intent(Izb.this, googleMap.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        break;
                    case R.id.chat_sel:
                        intent = new Intent(Izb.this, chat_pod.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        break;
                    case R.id.menu_sel:
                        intent = new Intent(Izb.this, MainMenu.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        break;
                    case R.id.lk_sel:
                        intent = new Intent(Izb.this, Lich_kab.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        break;
                }

                return false;
            }
        });
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context fcontext;
        String[] ftitel;
        String[] floc;
        String[] fprice;
        int[] fimage;

        MyAdapter (Context c, String[] titel, String[] loc, String[] price, int[] image){
            super(c,R.layout.lib,R.id.text_titel,titel);
            this.fcontext =c;
            this.fimage = image;
            this.floc = loc;
            this.fprice = price;
            this.ftitel = titel;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View lib = layoutInflater.inflate(R.layout.lib,parent,false);
            ImageView imageView = lib.findViewById(R.id.image);
            TextView titel_v = lib.findViewById(R.id.text_titel);
            TextView loc_v = lib.findViewById(R.id.text_loc);
            TextView price_v = lib.findViewById(R.id.text_price);

            imageView.setBackgroundResource(fimage[position]);
            titel_v.setText(ftitel[position]);
            loc_v.setText(floc[position]);
            price_v.setText(fprice[position]);


            return lib;
        }
    }

}