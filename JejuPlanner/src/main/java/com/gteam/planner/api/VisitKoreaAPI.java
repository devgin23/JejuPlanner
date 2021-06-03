package com.gteam.planner.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;


public class VisitKoreaAPI {

	public String JejuAPI() throws Exception {
		
			
			//인증키2 (Encoding되어있음)
			String serviceKey = "O04vU1%2FBaFzYfPxBOYalRBg4ol8tZGeSgRc1SDG6HnIBdhw0XE6GHIcpyCrLSFpb8x%2BRe3mVF8SWqz0nIFj7RA%3D%3D";
		
			
			//API 요청변수 세팅
			 StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/PhotoGalleryService/gallerySearchList"); /*URL*/
		        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + serviceKey); //Service Key
		        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
		        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*한 페이지 결과 수*/
		        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS(아이폰), AND(안드로이드), WIN(윈도우폰),ETC(WEB이나 기타 등등)*/
		        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
		        urlBuilder.append("&" + URLEncoder.encode("arrange","UTF-8") + "=" + URLEncoder.encode("B", "UTF-8")); /* 정렬 구분 : A=촬영일, B=제목, C=수정일, D=조회수*/
		        urlBuilder.append("&" + URLEncoder.encode("keyword","UTF-8") + "=" + URLEncoder.encode("제주", "UTF-8")); /*검색 키워드*/
		        urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /* 데이터 타입 */
		        System.out.println(urlBuilder);
		        URL url = new URL(urlBuilder.toString());
	        
	        //URL 연결
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        
	        //URL 연결 TYPE 지정
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        
	        //연결 상태 확인
	        System.out.println("Response code: " + conn.getResponseCode());
	        
	        //출력정보 읽어올 변수
	        BufferedReader rd;
	        
	        //출력된 값 rd에 담기
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        
	        //rd에 담은 데이터 출력 위한 sb변수 선언
	        StringBuilder sb = new StringBuilder();
	        
	        //1줄씩 읽어서 sb에 append
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();
	        System.out.println("toString"+sb.toString());
	        return sb.toString();
	}

}
