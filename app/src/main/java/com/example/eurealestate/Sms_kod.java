package com.example.eurealestate;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.hanks.htextview.fall.FallTextView;
import com.royrodriguez.transitionbutton.TransitionButton;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;


public class Sms_kod extends AppCompatActivity {

    FallTextView textView;
    int schet=0;
    TransitionButton start;
    LinearLayout ramka;
    RadioButton chast, agenst, komp,pokup;
    RadioGroup radioGroup;
    boolean flag=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_kod);

        textView = findViewById(R.id.fadetextview);
        textView.animateText("Добро пожаловать!");
        textView.setOnClickListener(onClickListener);
        start = findViewById(R.id.Start_button);
        start.setOnClickListener(onClickListener);
        ramka = findViewById(R.id.ramka);
        start.isEnabled();

        chast = findViewById(R.id.checkbox_chast);
        agenst = findViewById(R.id.checkbox_agenstvo);
        komp = findViewById(R.id.checkbox_kompaniya);
        pokup = findViewById(R.id.checkbox_pokupatel);

        radioGroup = findViewById(R.id.radiogroup);

        chast.setOnClickListener(onClickListener);
        agenst.setOnClickListener(onClickListener);
        komp.setOnClickListener(onClickListener);
        pokup.setOnClickListener(onClickListener);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                SharedPreferences tip_klienta = getSharedPreferences("tip", MODE_PRIVATE);
                SharedPreferences.Editor editor = tip_klienta.edit();
                switch (checkedId){
                    case R.id.checkbox_chast:
                        start.animate().alpha(1.0f);
                        flag=true;
                        editor.putString("tip","chast");
                        editor.apply();
                        break;
                    case R.id.checkbox_agenstvo:
                        start.animate().alpha(1.0f);
                        flag=true;
                        editor.putString("tip","agenst");
                        editor.apply();
                        break;
                    case R.id.checkbox_kompaniya:
                        start.animate().alpha(1.0f);
                        editor.putString("tip","komp");
                        editor.apply();
                        flag=true;
                        break;
                    case R.id.checkbox_pokupatel:
                        start.animate().alpha(1.0f);
                        flag=true;
                        editor.putString("tip","pokup");
                        editor.apply();
                        break;

                }
            }
        });
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.fadetextview:
                    schet++;
                    switch (schet){
                        case 1:
                            textView.animateText("Мы – EU Real Estate!");
                            break;
                        case 2:
                            textView.setTextSize(17);
                            textView.animateText("Поможем сделать правильный выбор!");
                            break;
                        case 3:
                            textView.setTextSize(40);
                            textView.animateText("Как?");
                            break;
                        case 4:
                            textView.setTextSize(30);
                            textView.animateText("С помощью VR-туров!");
                            break;
                        case 5:
                            textView.setTextSize(40);
                            textView.animateText("Enjoy");
                            break;
                        case 6:
                            textView.animate().alpha(0.0f);
                            textView.animateText(" ");
                            textView.setEnabled(false);
                            Runnable r = new Runnable() {
                                @Override
                                public void run() {

                                    start.setVisibility(VISIBLE);
                                    ramka.animate().alpha(0.0f);
                                    start.animate().alpha(1.0f);
                                }
                            };
                            Handler h = new Handler();
                            h.postDelayed(r,1000);
                            schet=0;
                            break;
                    }
                break;

                case R.id.Start_button:
                    if(flag){
                        ramka.animate().alpha(0.0f);
                        Intent intent =new Intent(Sms_kod.this,regist.class);
                        startActivity(intent);
                    }else{
                        start.animate().alpha(0.0f);
                        start.setVisibility(INVISIBLE);
                        start.setText("Готово");
                        start.setVisibility(VISIBLE);
                        start.animate().alpha(0.5f);
                        ramka.setVisibility(VISIBLE);
                        ramka.animate().alpha(1.0f);
                    }
                    break;

            }
        }
    };




}