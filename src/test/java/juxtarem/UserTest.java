package juxtarem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.ws.juxtarem.obj.User;

public class UserTest {
	private SessionFactory sessionFactory;
	private Session session = null;
	
	@Before
	public void before() {
        sessionFactory = HibernateConfigurationTest.getHibernateConfiguration()
                .buildSessionFactory();
        session = sessionFactory.openSession();
	}
	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setFirstName("Mihaela");
		user.setLastName("Munteanu");
		user.setMiddleName("M");
		user.setPoints(0);
		user.setMainMail("mihaela@yahoo.com");
		
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created " + user.toString());
	}

}
