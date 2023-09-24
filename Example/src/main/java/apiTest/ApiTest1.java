package apiTest;
/* Java 1.8 샘플 코드 */

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class ApiTest1 {
	public static void main(String[] args) throws IOException {
		String key =""; //my key
			for(int i=1;i<366;i++) {
				try {
				
			
			
			StringBuilder urlBuilder = new StringBuilder(
					"http://apis.data.go.kr/1390804/NihhsTodayFlowerInfo01/selectTodayFlowerView01"); /* URL */
			urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "="+key); /* Service Key */
			urlBuilder.append(
					"&" + URLEncoder.encode("dataNo", "UTF-8") + "=" + URLEncoder.encode(""+i, "UTF-8")); /* 오늘의 꽃 인덱스 */
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			System.out.println("Response code: " + conn.getResponseCode());
			BufferedReader rd;
			
			if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			rd.close();
			conn.disconnect();
			System.out.println(sb.toString());
	//		System.out.println(sb.getTagValue("dataNo"));
			
			
				 
	            // 1. 파일 객체 생성
	            File file = new File("C:\\khh\\JSP\\Example\\src\\main\\webapp\\flower.txt");
	 
	            // 2. 파일 존재여부 체크 및 생성
	            if (!file.exists()) {
	                file.createNewFile();
	            }
	 
	            // 3. Writer 생성
	            FileOutputStream fos = new FileOutputStream(file);
	            BufferedOutputStream bos = new BufferedOutputStream(fos);
	            DataOutputStream dos = new DataOutputStream(bos);
	 
	            // 4. 파일에 쓰기
	            dos.writeUTF(sb.toString());
	            
	 
	            // 5. DataOutputStream close
	            dos.close();
	 
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		
//		//////////////////////////////////////////////////////
		
//		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//		DocumentBuilder builder;
//		try {
//			builder = factory.newDocumentBuilder();
//		} catch (ParserConfigurationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		
		// xml 파일을 document로 파싱하기
//		Document document = builder.parse(sb);
		
		
		
		
		
	}
}

