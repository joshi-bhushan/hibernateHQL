package com.ydel.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	private static SessionFactory buildSessionFactory()
	{
		try{
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		System.out.println("Hibernate Configuration loaded");
		 ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		 System.out.println("hibernate Service registry created");	
		 
		 SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		 return sessionFactory;
		}catch(Throwable e)
		{
	
			System.err.println("initail session factotu creation failed."+e);
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
			
		}
		 	
	}
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;

}
}