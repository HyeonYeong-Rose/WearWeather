package com.example.wearweather;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetWeather1 {

    //USER_AGENT를 정해줘야 값을 넘겨줄 수 있어요
    private final String USER_AGENT="ROSE";



    //HTTP GET request
    private void sendGet() throws Exception {

        //api url
        String url = "http://apis.data.go.kr/1360000/VilageFcstInfoService/getVilageFcst ?serviceKey=인증키&numOfRows=10&pageNo=1 &base_date=20151021&base_time=0230&nx=55&ny=127";


        //url 객체 생성
        URL obj = new URL(url);
        //http 연결
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //url 객체 method 이름 get
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        //응답 코드 요청-error 404 또는 엉뚱한거가 나오지 않길..
        con.getResponseCode();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        //라인 끝날때까지(while)스티링 buffer에 저장
        while ((inputLine = in.readLine())!= null){
            System.out.println(inputLine);
            response.append(inputLine);
        }
        in.close();





    }
}
