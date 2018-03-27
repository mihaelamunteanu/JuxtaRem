
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
 */package com.ws.juxtarem.util;

/**
 * Utils class for validating web service input. 
 * 
 * @author Mihaela Munteanu
 * @since 7th of March 2018
 *
 */
public class ValidationUtils {
	/** 
	 * 
	 * @param id
	 * @return false if the value is not Long
	 */
	public static boolean validateId(String id) {
		//TODO add impl
		return true;
	}

	//Should throw exception if not valid. So boolean not expected
	public static void validateCreateNewUser(String name, String mail, byte[] pass) {
		//TODO check the name and the mail 
	}
}
