package com.example.eurealestate;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Slovakiya extends AppCompatActivity {

    ImageButton back;
    ViewPager viewPager;
    ImageButton like, diz;
    SliderAdapterSlovakiya sliderAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slovakiya);

        back = findViewById(R.id.back_but);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.back_but:
                        Intent intent = new Intent(Slovakiya.this, Lich_kab.class);
                        startActivity(intent);
                        break;
                }
            }
        });

        like = findViewById(R.id.diz);
        diz = findViewById(R.id.like);

        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Slovakiya.this, Polsh.class);
                startActivity(intent);
            }
        });

        diz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Slovakiya.this, Italy.class);
                startActivity(intent);
            }
        });

        viewPager=findViewById(R.id.vP);
        sliderAdapter = new SliderAdapterSlovakiya(this);

        viewPager.setAdapter(sliderAdapter);
    }
}