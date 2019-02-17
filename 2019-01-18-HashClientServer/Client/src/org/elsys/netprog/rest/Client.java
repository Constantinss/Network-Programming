package org.elsys.netprog.rest;

import java.net.*;
import java.io.*;
import java.util.Base64;
import java.util.Random;
import org.json.JSONObject;
import org.json.JSONException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//RESOURCES: https://docs.oracle.com/javase/tutorial/networking/urls/readingWriting.html
//RESOURCES: https://www.codevscolor.com/java-nanotime-and-currenttimemillis/

public class Client {

	private static String Url = "http://localhost:8080/jersey-rest-homework";
	
	public static void main(String[] args) throws IOException, NoSuchAlgorithmException, JSONException {
		
			System.out.println("Client");
			JSONObject json = sendGetRequest();
			int length = json.getInt("LENGTH");
			String h1 = json.getString("HASH");			
			
			System.out.println("Length: " + length);
			System.out.println("Hash: " + h1);
			
			String h2= null;
			byte[] input = new byte[length];
			
			while(true) {
				long startTime = System.nanoTime();
				new Random().nextBytes(input);
				MessageDigest md = MessageDigest.getInstance("MD5");
				byte[] hashB = md.digest(input);
				
				h2 = Base64.getUrlEncoder().encodeToString(hashB);
				if(h1.equals(h2)) {
					long endTime = System.nanoTime();
					System.out.println("Time: "+(endTime - startTime) + " ns");
					sendPostRequest(h1, Base64.getUrlEncoder().encodeToString(input));
					break;
				}
			}
			
	}

	private static void sendPostRequest(String hash, String input) throws IOException {
		// Post method
		URL url = new URL(Url + "/post");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
		connection.setRequestMethod("POST");
		
		String urlParameters = "hash=" + hash + "&input=" + input;
		connection.setDoInput(true);
		connection.setDoOutput(true);
		DataOutputStream st = new DataOutputStream(connection.getOutputStream());
		st.writeBytes(urlParameters);
		st.flush();
		st.close();
				
		InputStreamReader inputStream = new InputStreamReader(connection.getInputStream());
		BufferedReader in = new BufferedReader(inputStream);
		String inputLine;
		StringBuffer response = new StringBuffer();
		
		while((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
	}

	private static JSONObject sendGetRequest() throws IOException, JSONException{
		// Get method
		URL url = new URL(Url + "/get");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
				
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
			response.append('\r');
			System.out.println(inputLine);
		}
		in.close();
		
		JSONObject json = new JSONObject(response.toString());
		return  json;
	}	

}