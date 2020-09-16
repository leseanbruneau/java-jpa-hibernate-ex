package com.leseanbruneau.hsqldb.hibernate1.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.leseanbruneau.hsqldb.hibernate1.domain.JobCountHsqldbHibernate;

public class HibernateConfigUtil {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory buildSessionFactory() {
		if (sessionFactory == null) {
			try {
				
				AnnotationConfiguration configuration = new AnnotationConfiguration()
						.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect")
						.setProperty("hibernate.connection.driver_class", "org.hsqldb.jdbcDriver")
						.setProperty("hibernate.connection.url", "jdbc:hsqldb:hsql://localhost/jpasamplesdb")
						.setProperty("hibernate.connection.username", "sa")
						.setProperty("hibernate.connection.password", "")
						.setProperty("hibernate.c3p0.min_size", "5")
						.setProperty("hibernate.c3p0.max_size", "20")
						.setProperty("hibernate.c3p0.timeout", "1800")
						.setProperty("hibernate.c3p0.max_statements", "50")
						.addAnnotatedClass(JobCountHsqldbHibernate.class);
				
				sessionFactory = configuration.buildSessionFactory();
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("There is an issue with creating Hibernate SessionFactory");
			}
		}
		return sessionFactory;
	}	

}
