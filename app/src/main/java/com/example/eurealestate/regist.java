package com.example.eurealestate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.hanks.htextview.fall.FallTextView;
import com.royrodriguez.transitionbutton.TransitionButton;

import java.util.Objects;

public class regist extends AppCompatActivity {

    LinearLayout rielt, agenst;
    TransitionButton next;
    FallTextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);

        rielt = findViewById(R.id.realtor);
        agenst = findViewById(R.id.agenst);
        next = findViewById(R.id.Next_button);
        textView = findViewById(R.id.fadetextview_sms);

        SharedPreferences tip_klienta = getSharedPreferences("tip", MODE_PRIVATE);

        if(Objects.equals(tip_klienta.getString("tip", ""), "chast")){
            rielt.setVisibility(View.VISIBLE);
            rielt.animate().alpha(1.0f);
        }else if(Objects.equals(tip_klienta.getString("tip", ""), "komp") || Objects.equals(tip_klienta.getString("tip", ""), "agenst")){
            agenst.setVisibility(View.VISIBLE);
            agenst.animate().alpha(1.0f);
        }else if(Objects.equals(tip_klienta.getString("tip", ""), "pokup")){
            Intent intent = new Intent(regist.this, MainMenu.class);
            startActivity(intent);
        }


        next.setVisibility(View.VISIBLE);
        next.animate().alpha(1.0f);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rielt.animate().alpha(0.0f);
                agenst.animate().alpha(0.0f);
                textView.animate().alpha(1.0f);
                next.animate().alpha(0.0f);
                textView.setTextSize(25);
                textView.animateText("Регистрация завершена!");
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(regist.this, MainMenu.class);
                        startActivity(intent);
                    }
                };
                Handler h = new Handler();
                h.postDelayed(r,2500);

            }
        });

    }


}