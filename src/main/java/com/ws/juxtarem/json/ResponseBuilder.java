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
package com.ws.juxtarem.json;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.ws.juxtarem.obj.User;
import com.ws.juxtarem.util.Constants;
import com.ws.juxtarem.util.JSONUtils;

/**
 * Class to build the REST responses as JSON
 *  
 * @author Mihaela Munteanu
 * @since 7th of March 2018
 *
 */
public class ResponseBuilder {
	
	public static Response buildGetUserPointsResponse(User user) {
		String userJson = JSONUtils.buildJSONPair(Constants.USER, user.getFirstName());
		String pointsJson = JSONUtils.buildJSONPair(Constants.POINTS, String.valueOf(user.getPoints()));
		String response = JSONUtils.buildJSONParent(Constants.RESPONSE, userJson, pointsJson);
		String rootResponse = JSONUtils.buildJSONParent(null, response);
		return Response.ok(rootResponse, MediaType.APPLICATION_JSON).build();
	}
	
	public static Response buildCreateNewUserResponse(User user) {
		String userId = JSONUtils.buildJSONPair(Constants.ID, String.valueOf(user.getId()));
		String userJson = JSONUtils.buildJSONPair(Constants.USER, user.getFirstName());
		String mailJson = JSONUtils.buildJSONPair(Constants.MAIL, String.valueOf(user.getMainMail()));
		String response = JSONUtils.buildJSONParent(Constants.RESPONSE, userId, userJson, mailJson);
		String rootResponse = JSONUtils.buildJSONParent(null, response);
		return Response.ok(rootResponse, MediaType.APPLICATION_JSON).build();
	}
	
	
	public static Response buildPostCreateNewUserExceptionResponse(Exception exception) {
		//TODO check if this is a JuxtaRem exception and build the response
		return Response.status(Status.NOT_ACCEPTABLE).build();
	}
	
//	
//	public Response buildExceptionResponse(ExceptionCode exceptionCode, Object object) {
//	return Response.ok("{\"task\" : \"" + foundTask.getTaskText() + "\", \"point\" : \"" + 
//	foundTask.getAwardedPoints() + "\"}", MediaType.APPLICATION_JSON).build();
}
