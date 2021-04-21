package com.example.eurealestate;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.royrodriguez.transitionbutton.TransitionButton;

public class Lich_kab extends AppCompatActivity {

    BottomNavigationView bnm;
    ListView listView;
    String[] Titel={ "Złoty Świt", "Azzurro"};
    String[] Loc ={"Польша, Варшава", "Италия, берег озера Комо"};
    String[] Price ={"3.570.210,00 $","2.500.407,00 $"};
    String[] Comment ={"Не подходит инфраструктура.",
            "Интересный дизайн пентхауса. Круто, что рядом находится озеро Комо! Хотелось бы еще посмотреть похожие варианты."};
    int[] Image ={R.drawable.smain, R.drawable.fomain};
    TransitionButton but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lich_kab);

        listView = findViewById(R.id.list_men_lk);
        Lich_kab.MyAdapter adapter = new Lich_kab.MyAdapter(this, Titel, Loc, Price, Image,Comment);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                Intent intent;
                switch (position){
                    case 0:
                        intent = new Intent(Lich_kab.this, Polsh.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        break;
                    case 1:
                        Toast toast1=Toast.makeText(getApplicationContext(), "1",Toast.LENGTH_LONG);
                        toast1.show();
                        break;
                }
            }
        });

        but = findViewById(R.id.esche_but);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.esche_but:
                        Toast toast=Toast.makeText(getApplicationContext(), "Агент уведомлен о Вашем желании рассмотреть еще варианты объектов и свяжется с Вами в течении 12 часов",Toast.LENGTH_LONG);
                        toast.show();
                        break;
                }
            }
        });

        bnm=findViewById(R.id.bnm);
        bnm.setSelectedItemId(R.id.lk_sel);
        bnm.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Intent intent;
                switch (menuItem.getItemId()){
                    case R.id.map_sel:
                        intent = new Intent(Lich_kab.this, googleMap.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        break;
                    case R.id.chat_sel:
                        intent = new Intent(Lich_kab.this, chat_pod.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        break;
                    case R.id.izb_sel:
                        intent = new Intent(Lich_kab.this, Izb.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        break;
                    case R.id.menu_sel:
                        intent = new Intent(Lich_kab.this, MainMenu.class);
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
        String[] fcom;
        int[] fimage;

        MyAdapter (Context c, String[] titel, String[] loc, String[] price, int[] image, String[] com){
            super(c,R.layout.lib,R.id.text_titel,titel);
            this.fcontext =c;
            this.fimage = image;
            this.floc = loc;
            this.fprice = price;
            this.ftitel = titel;
            this.fcom = com;
        }

        @RequiresApi(api = Build.VERSION_CODES.M)
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View lib = layoutInflater.inflate(R.layout.lib_lkn,parent,false);
            ImageView imageView = lib.findViewById(R.id.image);
            TextView titel_v = lib.findViewById(R.id.text_titel);
            TextView loc_v = lib.findViewById(R.id.text_loc);
            TextView price_v = lib.findViewById(R.id.text_price);
            TextView com_v = lib.findViewById(R.id.com_text);
            com_v.setTextAppearance(R.style.it_font);


            imageView.setBackgroundResource(fimage[position]);
            titel_v.setText(ftitel[position]);
            loc_v.setText(floc[position]);
            price_v.setText(fprice[position]);
            com_v.setText(fcom[position]);


            return lib;
        }
    }
}