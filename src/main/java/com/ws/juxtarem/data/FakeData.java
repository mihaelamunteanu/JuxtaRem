package com.ws.juxtarem.data;

import java.util.ArrayList;
import java.util.List;

import com.ws.juxtarem.obj.Task;
import com.ws.juxtarem.obj.User;

public class FakeData {
	
	private List<User> users = new ArrayList<User>();
	private List<Task> tasks = new ArrayList<Task>();
	
	public FakeData() {
		User user = new User();
		user.setId(1);
		user.setFirstName("Mihaela");
		user.setLastName("Munteanu");
		user.setNickName("Misa");
		user.setPoints(0);
		
		User user2 = new User(2, "Chupa", "Bogdan", "Laiu", null, 30);
		
		users.add(user);
		users.add(user2);
		
		Task task1 = new Task(1, "Watch the first person in your proximity and notice his/her nails", 
				"Do you feel a particular sensation or it does not matter to you. "			
				+ "The aim is to observe as detailed as possible their nails without them noticing", 10,  
				"Social skills. Attention", "Easy", 30, 30, 30, null, 12, false);
		
		Task task2 = new Task(1, "Take a book you haven't read or one you haven't read in a long time and read page 15 first 5 rows", 
				"If page 15 does not have text go to the next available page that has text", 10,  
				"Remember", "Easy", 60, 30, 30, null, 12, false);
		
		tasks.add(task1);
		tasks.add(task2);
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
}
