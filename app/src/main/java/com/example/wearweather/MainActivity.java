package com.example.wearweather;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;

import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity {

    Location location;

    private double[] latlong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity", "onCreate");

        // 위치 가져오기 - 수빈
        location = new Location(this);
        location.getLoc(); // latlong[0] 은 latitude, latlong[1]은 longitude


        // 날씨 가져오기 - 현영
        Weather weather = new Weather();
        weather.getWeather();


    }
}