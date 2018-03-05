package com.ws.juxtarem.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Singleton class to load EntityManagerFactory and EntityManager.
 * 
 * @author Mihaela Munteanu
 * @since 28th Feb 2018
 *
 */
public class JPAConfiguration {
	public static EntityManagerFactory ENTITY_MANAGER_FACTORY;
	public static EntityManager ENTITY_MANAGER;
	
	/**
	 * Private default empty constructor for granting singleton.
	 */
	private JPAConfiguration() {
		ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("JuxtaRemPersistence");
		ENTITY_MANAGER = ENTITY_MANAGER_FACTORY.createEntityManager();
	}
}
