package com.example.mobile_project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int click = 0; // 페트병그림 클릭 담을 변수
    int pet_1=5,waste_1=0,pet=0,waste=0,r_pet; //pet,쓰레기 개수
    TextView secondtext,result,remainwaste;
    String tmp;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button m_btn = (Button) findViewById(R.id.image1);
        Button end = (Button)findViewById(R.id.end);


        secondtext = findViewById(R.id.second);
        result = (TextView) findViewById (R.id.Petresult);
        remainwaste = (TextView) findViewById(R.id.RemainWaste);

        CountDownTimer countDownTimer = new CountDownTimer(10000, 1000) {
            public void onTick(long l) {
                int num = (int)(l/1000);
               secondtext.setText(Integer.toString(num + 1));
            }
            public void onFinish() {
                // m_btn.setEnabled(false); 이건 왜안되는데,,,
                secondtext.setText("실패...");
            }
        }.start();

        m_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click++;
                    if (click == 5) {
                        m_btn.setBackgroundResource(R.drawable.p1);
                    } else if (click == 10) {
                        m_btn.setBackgroundResource(R.drawable.p2);
                    } else if (click == 15) {
                        m_btn.setBackgroundResource(R.drawable.p3);
                    } else if (click == 20) {
                        m_btn.setBackgroundResource(R.drawable.p4);
                        countDownTimer.cancel();
                        pet++;
                        waste++;
                    } else if (click == 21){
                        click = 0;
                        countDownTimer.start();
                        m_btn.setBackgroundResource(R.drawable.p0);
                    }
                    //pet = pet_1 - pet;
                    waste = waste_1 + waste;
            }
        });

        // int r_pet = (pet_1-pet); 왜안됨????????????
        remainwaste.setText(remainwaste.getText() + String.valueOf(r_pet));

        end.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                m_btn.setBackground(null);
                result.setText("페트병" + (pet_1) + "개 -> " + (pet_1-pet) + "개\n" +
                        "쓰레기" + (waste_1) + "개 -> " + (waste) + "개");
                secondtext.setText("끝");
                result.setVisibility(View.VISIBLE);
                remainwaste.setVisibility(View.INVISIBLE);
                //countDownTimer.cancel(); //왜안됨,,,
            }
        });
    }
}
