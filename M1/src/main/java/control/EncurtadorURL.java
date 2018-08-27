package control;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import entity.Url;

public class EncurtadorURL {
		

//	private final String PATH="https://is.gd/create.php?format=json&callback=myfunction&url=";  
	private final String PATH2="https://is.gd/create.php?format=simple&url=";
	
	public String sendGet(String url) throws Exception {
		URL obj = new URL(PATH2+url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		return response.toString();
	}
	 
//	+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	TESTANDO A CLASSE ENCURTADORURL()
	public static void main(String[] args) throws Exception {
		try {
			String longurl = "https://www.marvel.com";
			String shorturl = new EncurtadorURL().sendGet(longurl);

			Url u = new Url();
			u.setLongurl(longurl);
			u.setShorturl(shorturl);
			
			System.out.println(u);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
