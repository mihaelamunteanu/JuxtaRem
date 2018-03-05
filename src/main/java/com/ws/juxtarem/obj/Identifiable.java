package com.ws.juxtarem.obj;

/**
 * Interface for marking an Entity as having an Id (translated to primary key in DB)
 * TODO decide if indeed the id used in the app is the primary key in the db
 * 
 * @author Mihaela Munteanu
 * @since 28th Feb 2018
 *
 */
public interface Identifiable {
	public long getId();
}
