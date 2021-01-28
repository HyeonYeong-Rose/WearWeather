package com.example.wearweather;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.DocumentBuilder;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url = "http://apis.data.go.kr/1360000/VilageFcstInfoService/getVilageFcst?serviceKey=BW9vw5Y4RyJwogIhYfUSTSye8SBTWdallELcz9QTMOriq0W0syfhTA7wObN%2BerBY3ghJyEEB4jIq1w9taywEyQ%3D%3D&pageNo=1&numOfRows=10&dataType=XML&base_date=20210128&base_time=0500&nx=62&ny=128";
        OpenAPI weather = new OpenAPI(url);
        weather.execute();


    }



}

//    //@Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        Log.d("MainActivity", "onCreate");
//
//        // 위치 가져오기 - 수빈
//        Location location = new Location();
//        location.getLoc();
//
//        // 날씨 가져오기 - 현영
//        Weather weather = new Weather();
//
//            Weather.getWeather("20201225", "0230", "62", "128");
//
//        }
//
//











