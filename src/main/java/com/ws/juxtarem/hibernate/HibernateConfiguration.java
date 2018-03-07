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
package com.ws.juxtarem.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ws.juxtarem.util.Constants;

/**
 * Singleton class to load hibernate configuration properties from hibenate.cfg.xml.
 * 
 * @author Mihaela Munteanu
 * @since 28th Feb 2018
 *
 */
public class HibernateConfiguration {
	private static Configuration configuration;
	private static SessionFactory sessionFactory;
	
	/**
	 * Private default empty constructor for granting singleton.
	 */
	private HibernateConfiguration() {
	
	}
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			configuration = new Configuration().configure(Constants.HIBERNATE_CONFIGURATION);
			sessionFactory = configuration.buildSessionFactory();
		} 
		return sessionFactory;
	}
}
