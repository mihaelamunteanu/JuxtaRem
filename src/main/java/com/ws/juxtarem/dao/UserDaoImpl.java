package com.ws.juxtarem.dao;

import javax.persistence.Query;

import com.ws.juxtarem.hibernate.JPAConfiguration;
import com.ws.juxtarem.obj.User;

public class UserDaoImpl implements UserDao {

	public long saveUser(User user) {
		JPAConfiguration.ENTITY_MANAGER_FACTORY.createEntityManager().persist(user);
        return user.getId();
	}
	
	public User findUserByMail(String mail) {
		String hql = "SELECT u.id, u.email FROM User u "
	                + " WHERE u.mainMail = :mail ";
	    Query query = JPAConfiguration.ENTITY_MANAGER_FACTORY.createEntityManager().createQuery(hql);
	    query.setParameter("mainMail", mail);
	    //TODO add password query.setParameter("password", password);
	    User loggedUser = (User)query.getSingleResult()	;
	    return loggedUser;
	}
}
