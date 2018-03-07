/**
 * Copyright 2018 Mihaela Munteanu 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0 
 *  
 *  Unless required by applicable law or agreed to in writing, software 
 *  distributed under the License is distributed on an "AS IS" BASIS, 
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 *  See the License for the specific language governing permissions and 
 *  limitations under the License. 
 *  
 */
package com.ws.juxtarem.util;

import com.ws.juxtarem.obj.JSONInterface;

/** 
 * Util class. 
 * 
 * @since 7th Feb 2018
 * @author Mihaela Munteanu
 *
 */
public class ObjectUtils {
	
	public static boolean isNullOrEmpty(Object object) {
		boolean result = false; 
		if (object != null) {
			if (object instanceof String) {
				String stringObject = (String) object;
				if ("".equals(stringObject)) {
					result = true;
				}
			}
		} else {
			result = true; 
		}
		
		return result; 
	}
	
	@Deprecated
	/**
	 * Use JSONUtils methods
	 * 
	 * @param key
	 * @param value
	 * @return JSON string with given key and value
	 */
	public static String buildJSONObject(String key, String value) {
		StringBuffer jsonObjectStringBuffer = new StringBuffer();
		//{"key":"value"}
		jsonObjectStringBuffer.append("{").append(JSONInterface.STRING_QUOTE).append(key).append(JSONInterface.STRING_QUOTE).append(":");
		jsonObjectStringBuffer.append(JSONInterface.STRING_QUOTE).append(value).append(JSONInterface.STRING_QUOTE).append("}").append(",");
		
		return jsonObjectStringBuffer.toString();
	}
	
	@Deprecated
	/**
	 * Use JSONUtils methods
	 * 
	 * @param key
	 * @param value
	 * @param addComma
	 * @return JSON string with given key and value
	 */
	public static String buildJSONObject(String key, String value, boolean addComma) {
		StringBuffer jsonObjectStringBuffer = new StringBuffer();
		//{"key":"value"}
		jsonObjectStringBuffer.append("{").append(JSONInterface.STRING_QUOTE).append(key).append(JSONInterface.STRING_QUOTE).append(":");
		jsonObjectStringBuffer.append(JSONInterface.STRING_QUOTE).append(value).append(JSONInterface.STRING_QUOTE).append("}").append(",");
		
		if (addComma) {
			jsonObjectStringBuffer.append(",");
		}
		return jsonObjectStringBuffer.toString();
	}

}
