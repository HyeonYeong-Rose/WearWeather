package com.example.wearweather;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Location location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위치 가져오기 - 수빈
        location = new Location(this);
        location.getLoc(); // latlong[0] 은 latitude, latlong[1]은 longitude



    }



}
