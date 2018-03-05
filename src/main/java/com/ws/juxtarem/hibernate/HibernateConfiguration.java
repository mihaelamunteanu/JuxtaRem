package com.ws.juxtarem.hibernate;

import javax.persistence.EntityManagerFactory;

import org.hibernate.cfg.Configuration;

/**
 * Singleton class to load hibernate configuration properties from hibenate.cfg.xml.
 * 
 * @author Mihaela Munteanu
 * @since 28th Feb 2018
 *
 */
public class HibernateConfiguration {
	private static Configuration configuration;
	public static EntityManagerFactory ENTITY_MANAGER_FACTORY;
	
	/**
	 * Private default empty constructor for granting singleton.
	 */
	private HibernateConfiguration() {
		configuration = new Configuration().configure("/hibernate.cfg.xml");
		ENTITY_MANAGER_FACTORY = configuration.buildSessionFactory();
	}
}
