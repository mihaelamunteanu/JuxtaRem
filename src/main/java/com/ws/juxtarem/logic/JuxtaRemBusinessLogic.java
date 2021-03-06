package com.ws.juxtarem.logic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ws.juxtarem.dao.UserDao;
import com.ws.juxtarem.dao.UserDaoImpl;
import com.ws.juxtarem.hibernate.JPAConfiguration;
import com.ws.juxtarem.obj.Task;
import com.ws.juxtarem.obj.User;

public class JuxtaRemBusinessLogic {
	private static Logger LOGGER = LoggerFactory.getLogger(JuxtaRemBusinessLogic.class);
	EntityManagerFactory entityManagerFactory = JPAConfiguration.ENTITY_MANAGER_FACTORY;
	UserDao userDao = new UserDaoImpl();
 

	public User loginUser(String mail) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        User user = userDao.findUserByMail(mail);
        session.close();
        LOGGER.debug("Successfully created " + user.toString());
        return user;
	}
	
	public long saveUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        userDao.saveUser(user);
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
        System.out.println("Successfully updated " + e.toString());
 
    }
 
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User e = findUserByID(id);
        session.delete(e);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted " + e.toString());
 
    }
 
    public User findUserByID(Long id) {
        Session session = sessionFactory.openSession();
        User e = (User)session.load(User.class, id);
        session.close();
        return e;
    }
    
    public Task getFirstTask() {
    	
        return new Task();
    }
}
