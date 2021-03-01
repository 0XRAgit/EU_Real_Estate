package com.example.eurealestate;


import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.hanks.htextview.fall.FallTextView;


public class Sms_kod extends AppCompatActivity {

    FallTextView textView;
    int schet=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_kod);

        textView = findViewById(R.id.fadetextview);
        textView.animateText("Добро пожаловать!");
        textView.setOnClickListener(onClickListener);

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
                            textView.animateText(" ");
                            Runnable r = new Runnable() {
                                @Override
                                public void run() {
                                    textView.setVisibility(View.INVISIBLE);

                                }
                            };
                            Handler h = new Handler();
                            h.postDelayed(r,1000);
                            break;
                    }
                break;


            }
        }
    };
}