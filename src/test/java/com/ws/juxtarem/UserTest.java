package com.ws.juxtarem;

import org.junit.Before;
import org.junit.Test;

import com.ws.juxtarem.logic.JuxtaRemBusinessLogic;
import com.ws.juxtarem.obj.User;

/**
 * Integration test - Tomcat server with appropriate war deploy is expected as well as the DB.
 * 
 * @author Mihaela Munteanu
 *
 */
public class UserTest {
	JuxtaRemBusinessLogic businessLogic;
	
	@Before
	public void before() {
        businessLogic = new JuxtaRemBusinessLogic();
	}
	
	@Test
	public void testCreateUsers() {
		createUser("Agnes", "Munteanu", "M", 0, "mihaela@yahoo.com");
		createUser("Bogdan", "Munteanu", "M", 0, "bogdan@yahoo.com");
	}
	
//	@Test
//	public void loginUser() {
//		businessLogic.loginUser("mihaela@yahoo.com");
//	}
	
	private User createUser(String firstName, String lastname, String middleName, int points, String mail) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastname);
		user.setMiddleName(middleName);
		user.setPoints(points);
		user.setMainMail(mail);
		
		businessLogic.saveUser(user);
        
        System.out.println("Successfully created " + user.toString());
        
        return user;
	}

}
