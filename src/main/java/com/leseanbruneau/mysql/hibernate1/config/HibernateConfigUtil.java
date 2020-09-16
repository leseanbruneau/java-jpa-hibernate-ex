package com.leseanbruneau.mysql.hibernate1.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.leseanbruneau.mysql.hibernate1.domain.JobCountMysqlHibernate;

public class HibernateConfigUtil {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory buildSessionFactory() {
		if (sessionFactory == null) {
			try {
				
				AnnotationConfiguration configuration = new AnnotationConfiguration()
						.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
						.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
						.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/springbatchdemo?serverTimezone=UTC")
						.setProperty("hibernate.connection.username", "DEMODBOWNER")
						.setProperty("hibernate.connection.password", "")
						.setProperty("hibernate.c3p0.min_size", "5")
						.setProperty("hibernate.c3p0.max_size", "20")
						.setProperty("hibernate.c3p0.timeout", "1800")
						.setProperty("hibernate.c3p0.max_statements", "50")
						.addAnnotatedClass(JobCountMysqlHibernate.class);
				
				sessionFactory = configuration.buildSessionFactory();
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("There is an issue with creating Hibernate SessionFactory");
			}
		}
		return sessionFactory;
	}

}
