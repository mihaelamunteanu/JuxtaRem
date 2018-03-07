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

/**
 * Utils class for manipulating JSON Data. e.g Building a JSON Response etc. 
 * 
 * @author Mihaela Munteanu
 * @since 7th of March 2018 
 *
 */
public class JSONUtils {
	
	/** 
	 * Method that builds a JSON string with a given code an already built values.
	 * e.g. code = Exception
	 * values:
	 *        value[0] = "code" : "001" 
	 *        value[1] = "text" : "The ids are expected to be long values"
	 *        
	 * The returned String will be: 
	 * "Exception" : {"code" : "001","text" : "The ids are expected to be long values"} 
	 * 
	 * if the code is null then no root element is added
	 * e.g. code = null 
	 *      values[0] = "type" : "user"
	 *      values[1] = "mail" : "john@gmail.com"
	 * Result {"type" : "user", "mail": "john@gmail.com"}
	 *      
	 * @param code - the value from the left side of the JSON
	 * @param values - the complex values from the right side 
	 * @return the String containing the JSON built from the given input
	 */
	public static String buildJSONParent(String code, String...values) {
		
		StringBuffer jsonStringBuffer = new StringBuffer();
		//add something like "Exception" : 
		if (code != null) {
			jsonStringBuffer.append("\"" + code + "\"");
			jsonStringBuffer.append(" : " );
		} 
		
		if (values != null && values.length > 0) {
			//add something like { "code" : "001", "text" : "Unexpected id" }
			jsonStringBuffer.append("{");
			
			int numberOfValues = values.length;
			for (int i = 0; i < numberOfValues; i++) {
				jsonStringBuffer.append(values[i]);
				if (i < numberOfValues - 1) {
					//this is not the last value in the list
					jsonStringBuffer.append(",");
				}
			}
			jsonStringBuffer.append("}");
		} else {
			//result would be "Exception" : null
			jsonStringBuffer.append("null");
		}

		return jsonStringBuffer.toString();
	}
	
	/** 
	 * Method to build JSON leaves: 
	 * e.g. code = text 
	 *      pairValues[1] = Id unexpected
	 * Result: "code" : "Id unexpected"
	 * 
	 * or 
	 * 
	 *      code = books
	 *      pairValues[1] = JungleBook
	 *      pairValues[2] = Leila
	 * Result: "books" : ["JungleBook", "Leila"]
	 * 
	 * if no value is in pairValues then the reuslt is "value_of_code" : null. 
	 * 
	 * @param code
	 * @param pairValues
	 * @return
	 */
	public static String buildJSONPair(String code, String...pairValues) {
		StringBuffer jsonStringBuffer = new StringBuffer();
		//add something like "code" :
		if (code != null) {
			jsonStringBuffer.append("\"" + code + "\"");
			jsonStringBuffer.append(" : " );
		} 
		
		if (pairValues != null && pairValues.length > 0) {
			int numberOfValues = pairValues.length;
			if (numberOfValues == 1) {
				jsonStringBuffer.append("\"" + pairValues[0] + "\"");
			} else {
				jsonStringBuffer.append("[");
				for (int i = 0; i < numberOfValues; i++) {
					jsonStringBuffer.append("\"" + pairValues[i] + "\"");
					if (i < numberOfValues - 1) {
						//this is not the last value in the list
						jsonStringBuffer.append(",");
					}
				}
				jsonStringBuffer.append("]");
			}
		} else {
			//result would be "code" : null
			jsonStringBuffer.append("null");
		}
		
		return jsonStringBuffer.toString();
	}

	
	/** 
	 * Method to build JSON list - a parent that has a complex list: 
	 * e.g. code = email 
	 *      listValues[0] = {"type" : "home","name" : "john.doe@gmail.com"} - this can be obtained with JSONUtils.buildJSONParent(null, typePair1, namePair1)
	 *      listValues[1] = {"type" : "work","name" : "johnd@gmail.com"}    - this can be obtained with JSONUtils.buildJSONParent(null, typePair2, namePair2)
	 * Result: "email":[{"type" : "home","name":"john.doe@gmail.com"},{"type":"work","name":"jdoe@gmail.com"}]
	 * 
	 * the typePair1 can be obtained like this: String typePair1 = JSONUtils.buildJSONPair("type", "home");
	 * 
	 * if no value is in pairValues then the result is "value_of_code" : null. 
	 * 
	 * @param code
	 * @param pairValues
	 * @return
	 */
	public static String buildJSONList(String code, String...listValues) {
		StringBuffer jsonStringBuffer = new StringBuffer();
		//add something like "code" :
		if (code != null) {
			jsonStringBuffer.append("\"" + code + "\"");
			jsonStringBuffer.append(" : " );
		} 
		
		if (listValues != null && listValues.length > 0) {
			int numberOfValues = listValues.length;
			if (numberOfValues == 1) {
				jsonStringBuffer.append("\"" + listValues[0] + "\"");
			} else {
				jsonStringBuffer.append("[");
				for (int i = 0; i < numberOfValues; i++) {
					jsonStringBuffer.append(listValues[i]);
					if (i < numberOfValues - 1) {
						//this is not the last value in the list
						jsonStringBuffer.append(",");
					}
				}
				jsonStringBuffer.append("]");
			}
		} else {
			//result would be "code" : null
			jsonStringBuffer.append("null");
		}
		
		return jsonStringBuffer.toString();
	}
}
