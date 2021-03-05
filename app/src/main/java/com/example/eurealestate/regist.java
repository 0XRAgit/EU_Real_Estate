package com.example.eurealestate;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.royrodriguez.transitionbutton.TransitionButton;

import java.util.Objects;

public class regist extends AppCompatActivity {

    LinearLayout rielt, agenst;
    TransitionButton next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);

        rielt = findViewById(R.id.realtor);
        agenst = findViewById(R.id.agenst);
        next = findViewById(R.id.Next_button);


        SharedPreferences tip_klienta = getSharedPreferences("tip", MODE_PRIVATE);

        if(Objects.equals(tip_klienta.getString("tip", ""), "chast")){
            rielt.setVisibility(View.VISIBLE);
            rielt.animate().alpha(1.0f);
        }else if(Objects.equals(tip_klienta.getString("tip", ""), "komp") || Objects.equals(tip_klienta.getString("tip", ""), "agenst")){
            agenst.setVisibility(View.VISIBLE);
            agenst.animate().alpha(1.0f);
        }

        next.setVisibility(View.VISIBLE);
        next.animate().alpha(0.5f);

    }
}