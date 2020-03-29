package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil{
    private static final SessionFactory sesionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
        return new Configuration().configure().buildSessionFactory();

    }

    public static SessionFactory getSessionFactory() {return sesionFactory;}
}
