package com.gteam.planner.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;





public class JeJuVisitAPI {

	public String JejuAPI() throws Exception {
		
			//API KEY 세팅 (cid 값으로 콘텐츠 내용 컨트롤)
	        URL url = new URL("http://api.visitjeju.net/vsjApi/contents/searchList?apiKey=4f626rjpctc56j26&locale=kr&page=1&cid=CONT_000000000500349");
	        
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
            /*System.out.println(sb.toString());*/
	        /*System.out.println("GetClass :" + sb.getClass());*/
	        /*String data = sb.toString();
	        JSONParser parser = new JSONParser();
	        Object obj = parser.parse(data);
	        JSONObject jsonObj = (JSONObject) obj;
	        
	        
	        System.out.println(jsonObj.get("items").toString());
	        String picData = (String) jsonObj.get("items[3]");*/
	        
	        return sb.toString();

	}

}
