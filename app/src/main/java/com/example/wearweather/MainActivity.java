package com.example.wearweather;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
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

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (now_temp!=100) {
                   tv_dong.setText(now_dong);
                   tv_rain.setText(now_rain);
                   tv_temp.setText("" + now_temp);
                    top_layout.setVisibility(View.VISIBLE); // 제일 마지막에
                }
            }
        }, 1000);
    }



}
