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
package com.ws.juxtarem.dao;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.ws.juxtarem.dao.api.UserDao;
import com.ws.juxtarem.hibernate.HibernateConfiguration;
import com.ws.juxtarem.obj.User;

/**
 * DAO class for User entity.
 * 
 * @author Mihaela Munteanu
 * @since 6th of March 2018
 *
 */
public class UserDaoImpl extends EntityDaoImpl implements UserDao {

	public UserDaoImpl(Session currentSession) {
		super(currentSession);
	}

	public long saveUser(User user, Session session) {
        session.save(user);
        return user.getId();
	}
	
	public User findUserByMail(String mail) {
		String hql = "SELECT u.id, u.email FROM User u "
	                + " WHERE u.mainMail = :mail ";
	    TypedQuery<User> query = HibernateConfiguration.getSessionFactory().getCurrentSession().createQuery(hql);
	    query.setParameter("mainMail", mail);
	    //TODO add password query.setParameter("password", password);
	    User loggedUser = (User)query.getSingleResult()	;
	    return loggedUser;
	}
}
