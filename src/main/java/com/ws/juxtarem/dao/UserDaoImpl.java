package com.ws.juxtarem.dao;

import javax.persistence.TypedQuery;

import com.ws.juxtarem.hibernate.HibernateConfiguration;
import com.ws.juxtarem.obj.User;

public class UserDaoImpl implements UserDao {

	public long saveUser(User user) {
        HibernateConfiguration.SESSION_FACTORY.getCurrentSession().save(user);
        return user.getId();
	}
	
	public User findUserByMail(String mail) {
		String hql = "SELECT u.id, u.email FROM User u "
	                + " WHERE u.mainMail = :mail ";
	    TypedQuery<User> query = HibernateConfiguration.SESSION_FACTORY.getCurrentSession().createQuery(hql);
	    query.setParameter("mainMail", mail);
	    //TODO add password query.setParameter("password", password);
	    User loggedUser = (User)query.getSingleResult()	;
	    return loggedUser;
	}
}
