package com.example.wearweather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity", "onCreate");

        // 위치 가져오기 - 수빈
        Location location = new Location();
        location.getLoc();

        // 날씨 가져오기 - 현영
        Weather weather = new Weather();
        weather.getWeather();


    }
}