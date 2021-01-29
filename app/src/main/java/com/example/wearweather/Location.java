package com.example.wearweather;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.LocationManager;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class Location{

    double[] latlong;
    Activity activity;
    String dong;
    private String gu = "";

    public Location(@NonNull Activity activity) {
        this.activity = activity;

    }

    public String getGu() {
        return gu;
    }

    public void getLoc() {
        Log.d("Location", "getLoc");

        // 사용자로부터 권한 얻기
        LocationManager lm = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            String[] PERMISSIONS = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
            ActivityCompat.requestPermissions(activity, PERMISSIONS, 100);
        }

        // 위치 받아 오기
        Log.d("Location", "permitted");
        FusedLocationProviderClient fusedLocationClient = LocationServices.getFusedLocationProviderClient(activity);
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(activity, location -> {
                    if (location != null) {
                        Log.d("Location", "Success to get location");
                        Log.d("Location", location.toString());
                        Log.d("Location", "latitude: " + location.getLatitude());
                        Log.d("Location", "longitude: " + location.getLongitude());
                        latlong = new double[] {location.getLatitude(), location.getLongitude()};
                        // 주소 변환
                        Geocoder geocoder = new Geocoder(activity);
                        try {
                            List<Address> addr = geocoder.getFromLocation(latlong[0], latlong[1], 1);
                            Log.d("Location", "Success to get address");
                            dong = addr.get(0).getThoroughfare();
                            Log.d("Location", "동: " + dong); // 보여주기 위한 동
                            gu = addr.get(0).getAddressLine(0).split(" ")[2];
                            Log.d("Location", "구: " + gu);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    else {
                        Log.d("Location", "location is null"); // null인 경우 지도 어플 들어가서 위치 잡아주기
                    }

                    Log.d("Location", "global 구: " + gu);

                    HashMap<String, String> guToXY = new HashMap<String, String>();
                    guToXY.put("종로구", "60,127");
                    guToXY.put("중구", "60,127");
                    guToXY.put("용산구", "60,126");
                    guToXY.put("성동구", "61,127");
                    guToXY.put("광진구", "62,126");
                    guToXY.put("동대문구", "61,127");
                    guToXY.put("중랑구", "62,128");
                    guToXY.put("성북구", "61,127");
                    guToXY.put("강북구", "61,128");
                    guToXY.put("도봉구", "61,129");
                    guToXY.put("노원구", "61,129");
                    guToXY.put("은평구", "59,127");
                    guToXY.put("서대문구", "59,127");
                    guToXY.put("마포구", "59,127");
                    guToXY.put("양천구", "58,126");
                    guToXY.put("강서구", "58,126");
                    guToXY.put("구로구", "58,125");
                    guToXY.put("금천구", "59,124");
                    guToXY.put("영등포구", "58,126");
                    guToXY.put("동작구", "59,125");
                    guToXY.put("관악구", "59,125");
                    guToXY.put("서초구", "61,125");
                    guToXY.put("강남구", "61,126");
                    guToXY.put("송파구", "62,126");
                    guToXY.put("강동구", "62,126");


                    Log.d("Location", guToXY.get(gu)); // xy 좌표. 현영이에게 넘겨줄 것.
                    String nxny = guToXY.get(gu);


                    Calendar cal = Calendar.getInstance();
                    SimpleDateFormat dataformat = new SimpleDateFormat("yyyyMMdd");
                    String toDay = dataformat.format(cal.getTime());
                    SimpleDateFormat timeformat = new SimpleDateFormat("hhdd");
                    String currenttime = timeformat.format(cal.getTime());
                    Log.d("currenttime", currenttime);

                    //TimeMaking 클래스 기능을 currenttime에 적용시켜서 아래 url에 대입하기
                    String hh= currenttime.substring(0,2);
                    String mm=currenttime.substring(2,4);

                    int hour=Integer.valueOf(hh);
                    int minute=Integer.valueOf(mm);

                    //원래 시간 출력
                    Log.d("Location" , "current time : "+ String.format("%02d", hour)+String.format("%02d", minute));

                    //시간 base time 형식에 맞게 변환
                    //hour
                    switch(hour) {

                        case 3:
                        case 4:
                            hour = 2;
                            Log.d("Location","Hour : " + String.format("%02d", hour));
                            break;

                        case 6:
                        case 7:
                            hour = 5;
                            Log.d("Location","Hour : " + String.format("%02d", hour));
                            break;

                        case 9:
                        case 10:
                            hour = 8;
                            Log.d("Location","Hour : " + String.format("%02d", hour));
                            break;

                        case 12:
                        case 13:
                            hour = 11;
                            Log.d("Location","Hour : " + String.format("%02d", hour));
                            break;

                        case 15:
                        case 16:
                            hour = 14;
                            Log.d("Location","Hour : " + String.format("%02d", hour));
                            break;

                        case 18:
                        case 19:
                            hour = 17;
                            Log.d("Location","Hour : " + String.format("%02d", hour));
                            break;

                        case 21:
                        case 22:
                            hour = 20;
                            Log.d("Location","Hour : " + String.format("%02d", hour));
                            break;

                        case 24:
                        case 1:
                            hour = 23;
                            Log.d("Location","Hour : " + String.format("%02d", hour));
                            break;
                    }

                        //minute
                    minute=0;

                    String basetime = String.format("%02d", hour) + String.format("%02d", minute);;

                    String url = "http://apis.data.go.kr/1360000/VilageFcstInfoService/getVilageFcst?serviceKey=BW9vw5Y4RyJwogIhYfUSTSye8SBTWdallELcz9QTMOriq0W0syfhTA7wObN%2BerBY3ghJyEEB4jIq1w9taywEyQ%3D%3D&pageNo=1&numOfRows=10&dataType=XML&base_date="+toDay+"&base_time="+basetime+"&nx="+nxny.split(",")[0]+"&ny="+nxny.split(",")[1];
                    OpenAPI weather = new OpenAPI(url);
                    weather.execute();

                });
    }
}