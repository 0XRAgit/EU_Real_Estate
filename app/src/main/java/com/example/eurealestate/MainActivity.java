package com.example.eurealestate;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.royrodriguez.transitionbutton.TransitionButton;

public class MainActivity extends AppCompatActivity {

    private TransitionButton vhod,reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reg=findViewById(R.id.reg_button);
        vhod = findViewById(R.id.vhod_button);
        vhod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vhod.startAnimation();
                reg.setVisibility(View.INVISIBLE);
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        vhod.stopAnimation(TransitionButton.StopAnimationStyle.EXPAND, new TransitionButton.OnAnimationStopEndListener() {
                            @Override
                            public void onAnimationStopEnd() {
                                Intent intent = new Intent(getBaseContext(), Sms_kod.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                startActivity(intent);
                            }
                        });
                    }
                }, 2000);

        }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reg.startAnimation();
                vhod.setVisibility(View.INVISIBLE);
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        reg.stopAnimation(TransitionButton.StopAnimationStyle.EXPAND, new TransitionButton.OnAnimationStopEndListener() {
                            @Override
                            public void onAnimationStopEnd() {
                                Intent intent = new Intent(getBaseContext(), Sms_kod.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                startActivity(intent);
                            }
                        });
                    }
                }, 2000);
            }
        });
    }
}