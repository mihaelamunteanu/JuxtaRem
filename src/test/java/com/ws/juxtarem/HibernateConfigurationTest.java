package com.ws.juxtarem;

import org.hibernate.cfg.Configuration;

/**
 * Singleton class to load hibernate configuration properties from hibenate.cfg.xml.
 * 
 * @author Mihaela Munteanu
 * @since 28th Feb 2018
 *
 */
public class HibernateConfigurationTest {
	private static final Configuration configuration = new Configuration().configure("/hibernate.cfg.xml");
	
	/**
	 * Private default empty constructor for granting singleton.
	 */
	private HibernateConfigurationTest() {}
	
	public static Configuration getHibernateConfiguration() {
		return configuration;
	}
}
