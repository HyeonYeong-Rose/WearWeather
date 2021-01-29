package com.example.wearweather;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

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
    String rain;
    String temperature;

        private String url;

        public OpenAPI(String url) {

            this.url = url;


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
                    Log.d("OPEN_API","카테고리  : " + getTagValue("category", eElement));
                    Log.d("OPEN_API","값  : " + getTagValue("fcstValue", eElement));



                    String num = getTagValue("category",eElement).toString();


                    switch (num) {
                        case "POP":
                            Log.d("OPEN_API","강수 확률!!!!!!!!!!!!  : " + getTagValue("fcstValue", eElement));
                            rain = getTagValue("fcstValue", eElement);


                        case "T3H":
                            Log.d("OPEN_API","3시간 기온!!!!!!!!!!!  : " + getTagValue("fcstValue", eElement));
                            temperature = getTagValue("fcstValue", eElement);
                            break;
                    }



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

