package com.leseanbruneau.mysql.hibernate1.app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import org.hibernate.classic.Session;

import com.leseanbruneau.mysql.hibernate1.config.HibernateConfigUtil;
import com.leseanbruneau.mysql.hibernate1.domain.JobCountMysqlHibernate;

public class HibernateExampleApp {
																																																																																																																																																			
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Session session = HibernateConfigUtil
				.buildSessionFactory()
				.openSession();

		session.beginTransaction();
		
		JobCountMysqlHibernate jobCount = new JobCountMysqlHibernate();
		
		jobCount.setNode("BBY01");
		jobCount.setJobName("TEST62");
		jobCount.setMatchCount(84201);
		
		// Issue with java.time.LocalDate object into MySQL DATE column
		// Following block uses java.sql.Date Java object
		jobCount.setLogDate(Date.valueOf(LocalDate.of(2015, 6, 1)));
		
		// Issue with java.time.LocalDate object into MySQL DATE column
		// Following block uses java.time.LocalDate Java object
		// Future to-do -> fix java.time.LocalDate Java object with MySQL DATE column
		//jobCount.setLogDate(LocalDate.of(2015, 6, 2));
		
		System.out.println("logdate: |" + jobCount.getLogDate());
		
		System.out.println("LocalDate.now(): |" + LocalDate.now());
		
		session.save(jobCount);
		
		session.getTransaction().commit();
		
		session.close();
		
		System.out.println("End of program");

	}

}
