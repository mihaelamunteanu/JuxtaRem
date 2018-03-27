package com.ws.juxtarem.json;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RequestReader {
	
	public static HashMap<String, String> readDataFromJsonRequest(String jsonData) throws IOException {
		HashMap<String, String> hashedJsonData = new HashMap<String, String>();
		
		
		//converting json to Map
		byte[] mapData = jsonData.getBytes();
		Map<String,String> myMap = new HashMap<String, String>();

		ObjectMapper objectMapper = new ObjectMapper();
		myMap = objectMapper.readValue(mapData, HashMap.class);
		System.out.println("Map is: "+myMap);
		
		return hashedJsonData;
	}
	

}
