package com.example.wearweather;

import android.os.AsyncTask;
import android.util.Log;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class OpenAPI extends AsyncTask<Void, Void, String> {

        private String url;

        public OpenAPI(String url) {

            this.url = url;
            url = "http://apis.data.go.kr/1360000/VilageFcstInfoService/getVilageFcst?serviceKey=BW9vw5Y4RyJwogIhYfUSTSye8SBTWdallELcz9QTMOriq0W0syfhTA7wObN%2BerBY3ghJyEEB4jIq1w9taywEyQ%3D%3D&pageNo=1";
            OpenAPI weather = new OpenAPI(url);
            weather.execute();

        }

        @Override
        protected String doInBackground(Void... params) {

            // parsing할 url 지정(API 키 포함해서)

            DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = null;
            try {
                dBuilder = dbFactoty.newDocumentBuilder();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            }
            Document doc = null;
            try {
                doc = dBuilder.parse(url);
            } catch (IOException | SAXException e) {
                e.printStackTrace();
            }

            // root tag
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName()); // Root element: result

            // 파싱할 tag
            NodeList nList = doc.getElementsByTagName("item");

            for(int temp = 0; temp < nList.getLength(); temp++){
                Node nNode = nList.item(temp);
                if(nNode.getNodeType() == Node.ELEMENT_NODE){

                    Element eElement = (Element) nNode;
                    Log.d("OPEN_API","날짜  : " + getTagValue("baseDate", eElement));
                    Log.d("OPEN_API","시간  : " + getTagValue("baseTime", eElement));
                    Log.d("OPEN_API","X 좌표  : " + getTagValue("nx", eElement));
                    Log.d("OPEN_API","Y 좌표  : " + getTagValue("ny", eElement));

                    Log.d("OPEN_API","강수확률  : " + getTagValue("POP", eElement));
                    Log.d("OPEN_API","습도  : " + getTagValue("REH", eElement));
                    Log.d("OPEN_API","하늘상태 : " + getTagValue("SKY", eElement));
                    Log.d("OPEN_API","3시간 기온  : " + getTagValue("T3H", eElement));
                }	// for end
            }	// if end
            return null;
        }

        @Override
        protected void onPostExecute(String str) {
            super.onPostExecute(str);
        }


    private String getTagValue(String tag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);
        if(nValue == null)
            return null;
        return nValue.getNodeValue();
    }

}

