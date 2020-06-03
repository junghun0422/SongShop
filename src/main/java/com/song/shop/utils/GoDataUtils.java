package com.song.shop.utils;

import java.io.IOException;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class GoDataUtils
{
	public static void returnGoData() throws IOException, SAXException, ParserConfigurationException
	{
	    StringBuilder urlBuilder = new StringBuilder("http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty"); /*URL*/
	    urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=SizuZHWJZdm57%2FDKgvpl8RaFL2FQhF9JyUtJhMzkecKytQCd%2FE9jO2yPt1Ak9bV1%2Fs0XdyncShNGesrpIuwDcQ%3D%3D"); /*Service Key*/
		urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
	    urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
	    urlBuilder.append("&" + URLEncoder.encode("stationName","UTF-8") + "=" + URLEncoder.encode("종로구", "UTF-8")); /*측정소 이름*/
	    urlBuilder.append("&" + URLEncoder.encode("dataTerm","UTF-8") + "=" + URLEncoder.encode("DAILY", "UTF-8")); /*요청 데이터기간 (하루 : DAILY, 한달 : MONTH, 3달 : 3MONTH)*/
	    urlBuilder.append("&" + URLEncoder.encode("ver","UTF-8") + "=" + URLEncoder.encode("1.3", "UTF-8")); /*버전별 상세 결과 참고문서 참조*/
//	    System.out.println(urlBuilder);
//	    URL url = new URL(urlBuilder.toString());
//	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//	    conn.setRequestMethod("GET");
//	    conn.setRequestProperty("Content-type", "application/json");
//	    
//	    System.out.println("Response code: " + conn.getResponseCode());
//	    
//	    BufferedReader rd;
//	    if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//	    else rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
//	    
//	    StringBuilder sb = new StringBuilder();
//	    String line;
//	    while ((line = rd.readLine()) != null)  sb.append(line);
//	    
//	    rd.close();
//	    conn.disconnect();
//	    
//	    System.out.println(sb.toString());
	    
	    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    Document doc = dBuilder.parse(urlBuilder.toString());
	 
	    NodeList nList = doc.getElementsByTagName("item");
	    for(int i=0; i<nList.getLength(); i++)
	    {
	    	Node node = nList.item(i);
	    	if(node.getNodeType() == Node.ELEMENT_NODE)
	    	{
	    		Element ele = (Element) node;
	    		System.out.println(getTagValue("mangName", ele) + " | " + getTagValue("khaiValue", ele));
	    	}
	    }
	}
	
	private static String getTagValue(String tag, Element eElement)
	{
	    NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
	    Node nValue = (Node) nlList.item(0);
	    if(nValue == null) 
	        return null;
	    return nValue.getNodeValue();
	}
}
