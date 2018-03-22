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
 * Exception class for this JuxtaRem application. 
 * 
 * @author Mihaela Munteanu
 * @since 19th March 2018
 *
 */
public class JuxtaRemException extends Exception {

	/**
	 * Default serial number.
	 */
	private static final long serialVersionUID = 1L;
	private ExceptionCode juxtaRemCode;
	
	public JuxtaRemException(ExceptionCode exceptionCode) {
		super();
		juxtaRemCode = exceptionCode;
	}

	public ExceptionCode getJuxtaRemCode() {
		return juxtaRemCode;
	}

	public void setJuxtaRemCode(ExceptionCode juxtaRemCode) {
		this.juxtaRemCode = juxtaRemCode;
	}
	
}
