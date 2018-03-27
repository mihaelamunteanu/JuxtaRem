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
package com.ws.juxtarem.logic;

import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ws.juxtarem.dao.UserDaoImpl;
import com.ws.juxtarem.dao.api.UserDao;
import com.ws.juxtarem.exception.ExceptionCode;
import com.ws.juxtarem.exception.JuxtaRemException;
import com.ws.juxtarem.hibernate.HibernateConfiguration;
import com.ws.juxtarem.obj.Task;
import com.ws.juxtarem.obj.User;
import com.ws.juxtarem.util.Constants;
import com.ws.juxtarem.util.ValidationUtils;

/**
 * Class that takes care of the business logic before calling the DAOs. 
 * It parses the JSON data if needed (from a POST Request), 
 * validates the input, calls different DAOs as needed
 * 
 * @author Mihaela Munteanu
 * @since 6th of March 2018
 *
 */
public class JuxtaRemBusinessLogic {
	private static Logger LOGGER = LoggerFactory.getLogger(JuxtaRemBusinessLogic.class);
	SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();

	public User loginUser(String mail) {
        Session session = sessionFactory.openSession();
        UserDao userDao = new UserDaoImpl(session);
        User user = userDao.findUserByMail(mail);
        session.close();
        LOGGER.debug("Found logged user " + user.toString());
        return user;
	}
	
	public long saveUser(User user) {
        Session session = sessionFactory.openSession();
        UserDao userDao = new UserDaoImpl(session);
        session.beginTransaction();
        userDao.save(user);
        session.getTransaction().commit();
        session.close();
        LOGGER.debug("Successfully created " + user.toString());
        return user.getId();
	}
	 
    public void update(User e) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User em = (User) session.load(User.class, e.getId());
        em.setFirstName(e.getFirstName());
        session.getTransaction().commit();
        session.close();
        LOGGER.debug("Successfully updated " + e.toString());
 
    }
 
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User e = findUserByID(id);
        session.delete(e);
        session.getTransaction().commit();
        session.close();
        LOGGER.debug("Successfully deleted " + e.toString());
 
    }
 
    public User findUserByID(Long id) {
        Session session = sessionFactory.openSession();
        User e = (User)session.load(User.class, id);
        session.close();
        return e;
    }
    
    /** 
     * Logic to create new user account. 
     * Get the parameters from JSON request. 
     * Validate parameters. 
     * Check if the mail is already used. 
     * Save and return created user. 
     * 
     * @param name
     * @param mail
     * @param pass
     * @return
     * @throws JuxtaRemException
     */
    public User createNewUser(HashMap<String, String> jsonMappedNewUserData) throws JuxtaRemException {
		//TODO validate input
    	String name = jsonMappedNewUserData.get(Constants.NAME);
    	String mail = jsonMappedNewUserData.get(Constants.MAIL);
    	String pass = jsonMappedNewUserData.get(Constants.PASS);
    	
    	ValidationUtils.validateCreateNewUser(name, mail, pass.getBytes());
    	
        Session session = sessionFactory.openSession();
        UserDao userDao = new UserDaoImpl(session);
        User existentUser = userDao.findUserByMail(mail);
        if (existentUser != null) {
        	session.close();
        	throw new JuxtaRemException(ExceptionCode.USER_EMAIL_EXISTS);
        } 
        //check password respects criteria - can't do it as at this point it is already encrypted 
        session.beginTransaction();
        /*------ Begin Transaction ---*/
        User user = new User(name, mail, pass.getBytes());
        userDao.save(user);
        session.getTransaction().commit();
        /* Commit transaction */
        session.close();
        
        return user;
    }
    
    public Task findTaskByID(Long id) {
        Session session = sessionFactory.openSession();
        Task e = (Task)session.load(Task.class, id);
        session.close();
        return e;
    }
}
