package com.example.wearweather;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.DocumentBuilder;
//public class Weather {
//
//    /*public static void getWeather(String baseDate, String baseTime, String nx, String ny) {
//
//        String key = "BW9vw5Y4RyJwogIhYfUSTSye8SBTWdallELcz9QTMOriq0W0syfhTA7wObN%2BerBY3ghJyEEB4jIq1w9taywEyQ%3D%3D";
//
//        String address = "http://apis.data.go.kr/1360000/VilageFcstInfoService/getVilageFcst?serviceKey="
//                + key + "&numOfRows=5&pageNo=1" + "&base_date=" + baseDate + "&base_time=" + baseTime + "&nx=" + nx + "&ny=" + ny;
//
//
//    }*/

public class GetWeather1 {

    //USER_AGENT를 정해줘야 값을 넘겨줄 수 있어요
    private final String USER_AGENT="ROSE";
    Node seoul = null;


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

        //데이터 뽑아내기 json parser 웨안뒈? 그럼 xml 알라뷰
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            FileOutputStream output = new FileOutputStream("./GetWeather");
            output.write(response.toString().getBytes());
            output.close();

            Document doc = dBuilder.parse("./GetWeather");
            doc.getDocumentElement().normalize();

            //객체로 접근 body - items - item
            Element body = (Element) doc.getElementsByTagName("body").item(0);
            Element items = (Element) body.getElementsByTagName("items").item(0);
            Element item = (Element) items.getElementsByTagName("item").item(0);
            seoul = item.getElementsByTagName("seoul").item(0);


        } catch (Exception e) {
            e.printStackTrace();
        }





    }
}
