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

import org.hibernate.Session;

import com.ws.juxtarem.dao.api.EntityDao;
import com.ws.juxtarem.obj.Identifiable;

/**
 * Generic common DAO class to be extended by other DAOs
 * 
 * @author Mihaela Munteanu
 * @since 6th March 2018
 *
 */
public class EntityDaoImpl implements EntityDao {
	/** The active session to use */
	protected Session session;
	
	/**
	 * Constructor to set the current session. 
	 * 
	 * @param currentSession
	 */
	public EntityDaoImpl(Session currentSession) {
		this.session = currentSession;
	}
	
    public long save(Identifiable e) {
        this.session.save(e);
        return e.getId();
    }
    
    public long update(Identifiable e) {
        this.session.update(e);
        return e.getId();
    }
}
