package com.example.wearweather;

public class Weather {

    public static void getWeather(String baseDate, String baseTime, String nx, String ny) {

        String key = "BW9vw5Y4RyJwogIhYfUSTSye8SBTWdallELcz9QTMOriq0W0syfhTA7wObN%2BerBY3ghJyEEB4jIq1w9taywEyQ%3D%3D";

        String address = "http://apis.data.go.kr/1360000/VilageFcstInfoService/getVilageFcst?serviceKey="
                + key + "&numOfRows=5&pageNo=1" + "&base_date=" + baseDate + "&base_time=" + baseTime + "&nx=" + nx + "&ny=" + ny;


    }



}
