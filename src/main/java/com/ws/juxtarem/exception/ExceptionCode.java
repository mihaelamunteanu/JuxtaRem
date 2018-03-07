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
package com.ws.juxtarem.exception;

/**
 * Enum class to organize possible web service exceptions
 *  
 * @author Mihaela Munteanu
 * @since 7th of March 2018
 *
 */
public enum ExceptionCode {
	ID_NOT_A_NUMBER("001", "The ids are expected to be long values"),
	ID_DOES_NOT_EXIST("002", "An object with this id does not exist");
	
	private String code;
	private String description; 
	
	private ExceptionCode(String code, String description) {
		this.code = code; 
		this.description = description;
	}
	
	public String getCode( ) {
		return code;
	}
	
	public String getDescription( ) {
		return description;
	}

}
