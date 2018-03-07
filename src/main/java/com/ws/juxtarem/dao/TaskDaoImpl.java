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

import com.ws.juxtarem.dao.api.TaskDao;

/**
 * DAO class for Task entity. 
 * 
 * @author Mihaela Munteanu
 * @since 6th of March 2018
 *
 */
public class TaskDaoImpl extends EntityDaoImpl implements TaskDao {

	public TaskDaoImpl(Session currentSession) {
		super(currentSession);
	}

}