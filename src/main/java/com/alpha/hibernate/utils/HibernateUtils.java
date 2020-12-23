package com.alpha.hibernate.utils;

import com.alpha.hibernate.entity.Laptop;
import com.alpha.hibernate.entity.Person;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
    private static SessionFactory sessionFactory;

    private static void buildSessionFactory(){
        Configuration configuration = new org.hibernate.cfg.Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Person.class);
        configuration.addAnnotatedClass(Laptop.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static SessionFactory getSessionFactory(){
        if( null == sessionFactory ){
            synchronized (HibernateUtils.class){
                if( null == sessionFactory ){
                    buildSessionFactory();
                }
            }
        }
        return sessionFactory;
    }
}
