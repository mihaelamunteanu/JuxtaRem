package com.ws.juxtarem.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.ws.juxtarem.obj.User;

public class AccessEntity {

    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration
                .buildSessionFactory(builder.build());
        return sessionFactory;
    }
 
    public static long create(User e) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(e);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created " + e.toString());
        return e.getId();
    }
 
    public static List<User> read() {
        Session session = getSessionFactory().openSession();
        @SuppressWarnings("unchecked")
        java.util.List<User> employees = session.createQuery("FROM users").list();
        session.close();
        System.out.println("Found " + employees.size() + " Employees");
        return employees;
    }
 
    public static void update(User e) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        User em = (User) session.load(User.class, e.getId());
        em.setFirstName(e.getFirstName());
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated " + e.toString());
 
    }
 
    public static void delete(Integer id) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        User e = findByID(id);
        session.delete(e);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted " + e.toString());
 
    }
 
    public static User findByID(Integer id) {
        Session session = getSessionFactory().openSession();
        User e = (User) session.load(User.class, id);
        session.close();
        return e;
    }
     
    public static void deleteAll() {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Employee ");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all employees.");
 
    }
}
