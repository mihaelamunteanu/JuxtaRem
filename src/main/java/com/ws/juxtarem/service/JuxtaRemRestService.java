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
package com.ws.juxtarem.service;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ws.juxtarem.logic.JuxtaRemBusinessLogic;
import com.ws.juxtarem.obj.Task;
import com.ws.juxtarem.obj.User;

@Path("/juxtaremservice")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class JuxtaRemRestService {
	JuxtaRemBusinessLogic logicProcessor = new JuxtaRemBusinessLogic();
	Map<String, User> users = new HashMap<String, User>(); 
	
	public void init() {}
	
	public JuxtaRemRestService() {
		init();
	}

	@GET
	@Path("/users/login/{mail}")
	public Response loginUser(@PathParam("mail") String mail) {
		//TODO add validation for request params
		
		User foundUser = logicProcessor.loginUser(mail);
		return Response.ok("{\"user\" : \""+ foundUser.getMainMail() +"\"}", MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("/users/{id}")
	public Response getUser(@PathParam("id") String id) {
		//TODO add validation for request params
		System.out.println("Did we get here");
		//TODO the id cannot be used, for example the databases are not syncronized
		User foundUser = logicProcessor.findUserByID(Long.valueOf(id));
		return Response.ok("{\"user\" : \""+ foundUser.getFirstName() +"\"}", MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("/points/{id}")
	public Response getUserPoints(@PathParam("id") String id) {
		User foundUser = logicProcessor.findUserByID(Long.valueOf(id));
		return Response.ok("{\"user\" : \"" + foundUser.getPoints() + "\", \"point\" : \"12\"}", MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("tasks/task")
	public Response getRandomTask() {
		Task foundTask = logicProcessor.getFirstTask();
		return Response.ok("{\"task\" : \"" + foundTask.getTaskText() + "\", \"point\" : \"" + 
		foundTask.getAwardedPoints() + "\"}", MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("tasks/{id}")
    private Response getTask(@PathParam("id") String id) {
        Task foundTask = logicProcessor.getFirstTask();
		return Response.ok("{\"task\" : \"" + foundTask.getTaskText() + "\", \"point\" : \"" + 
		foundTask.getAwardedPoints() + "\"}", MediaType.APPLICATION_JSON).build();
    }
}  