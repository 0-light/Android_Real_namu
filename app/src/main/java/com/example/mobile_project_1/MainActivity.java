package com.example.mobile_project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int click = 0; // 페트병그림 클릭 담을 변수
    int pet = 0; //pet 개수
    TextView textView;
    Button m_btn = (Button) findViewById(R.id.image1);
    //Button end = (Button) findViewById(R.id.end);
    //FrameLayout frameLayout;


    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.second);
        //frameLayout.findViewById(R.id.Petresult);

        CountDownTimer countDownTimer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long l) {
                int num = (int)(l/1000);
                textView.setText(Integer.toString(num+1));
            }
            @Override
            public void onFinish() {
                textView.setText("실패...");
            }
        }.start();

        m_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click++;
                if(click == 5){
                    m_btn.setBackgroundResource(R.drawable.p1);
                } else if (click == 10) {
                    m_btn.setBackgroundResource(R.drawable.p2);
                } else if (click == 15) {
                    m_btn.setBackgroundResource(R.drawable.p3);
                } else if (click == 20 ){
                    m_btn.setBackgroundResource(R.drawable.p4);
                    pet--;
                    countDownTimer.cancel();
                }
            }
        });
    }
}