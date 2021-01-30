package com.example.wearweather;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static String now_rain;
    public static int now_temp = 100;
    public static String now_dong;
    Location location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위치 가져오기 - 수빈
        location = new Location(this);
        location.getLoc(); // latlong[0] 은 latitude, latlong[1]은 longitude

        // UI
        TextView tv_dong = (TextView) findViewById(R.id.tv_dong);
        TextView tv_rain = (TextView) findViewById(R.id.tv_rain);
        TextView tv_temp = (TextView) findViewById(R.id.tv_temp);
        View top_layout = (View) findViewById(R.id.top_layout);
        ImageView img_1 = (ImageView) findViewById(R.id.img_1);
        ImageView img_2 = (ImageView) findViewById(R.id.img_2);
        ImageView img_3 = (ImageView) findViewById(R.id.img_3);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (now_temp!=100) {
                    tv_dong.setText(now_dong);
                    tv_rain.setText(now_rain);
                    tv_temp.setText("" + now_temp);
                    // 이미지 설정 알고리즘~!
                    if (now_temp >= 8) {
                        img_1.setImageResource(R.drawable.sneakers);
                        img_2.setImageResource(R.drawable.hoodies);
                        img_3.setImageResource(R.drawable.mtm);
                    }
                    else if (now_temp >= 5) {
                        img_1.setImageResource(R.drawable.onepiece);
                        img_2.setImageResource(R.drawable.vest);
                        img_3.setImageResource(R.drawable.short_coat);
                    }
                    else if (now_temp >= 2) {
                        img_1.setImageResource(R.drawable.tuttle_neck_black);
                        img_2.setImageResource(R.drawable.cardigan);
                        img_3.setImageResource(R.drawable.long_coat);
                    }
                    else if (now_temp >= -1) {
                        img_1.setImageResource(R.drawable.round_knit);
                        img_2.setImageResource(R.drawable.tuttle_knit_navy);
                        img_3.setImageResource(R.drawable.fleece);
                    }
                    else if (now_temp >= -4) {
                        img_1.setImageResource(R.drawable.boots);
                        img_2.setImageResource(R.drawable.tuttle_neck_pink);
                        img_3.setImageResource(R.drawable.mustang);
                    }
                    else if (now_temp >= -7) {
                        img_1.setImageResource(R.drawable.fur_boots);
                        img_2.setImageResource(R.drawable.muffler);
                        img_3.setImageResource(R.drawable.short_padding);
                    }
                    else {
                        img_1.setImageResource(R.drawable.ear_warmer);
                        img_2.setImageResource(R.drawable.gloaves);
                        img_3.setImageResource(R.drawable.long_padding);
                    }
                    // 비 올 경우
                    if (Integer.parseInt(now_rain) > 60) {
                        img_1.setImageResource(R.drawable.unbllera);
                    }

                   top_layout.setVisibility(View.VISIBLE); // 제일 마지막에
                }
            }
        }, 1000);
    }



}
