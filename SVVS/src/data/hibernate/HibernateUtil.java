/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.hibernate;

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Michael
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private static Session cur;

    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getCurrentSession() {
        //return sessionFactory.getCurrentSession();
        if (cur == null || !cur.isOpen()) {
            cur = sessionFactory.openSession();
            System.out.println("OPEN");
        }
        return cur;
    }

    public static Session getNewSession() {
        if (cur != null) {
            cur.flush();
            cur.close();
            sessionFactory.close();
        }
        cur = sessionFactory.openSession();
        return cur;

    }
}
