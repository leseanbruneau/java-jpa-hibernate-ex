package com.leseanbruneau.hsqldb.hibernate1.app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import org.hibernate.classic.Session;

import com.leseanbruneau.hsqldb.hibernate1.config.HibernateConfigUtil;
import com.leseanbruneau.hsqldb.hibernate1.domain.JobCountHsqldbHibernate;

public class HibernateExampleApp {

	public static void main(String[] args) {
		Session session = HibernateConfigUtil
				.buildSessionFactory()
				.openSession();

		session.beginTransaction();
		
		JobCountHsqldbHibernate jobCount = new JobCountHsqldbHibernate();
		
		jobCount.setNode("HSQL01");
		jobCount.setJobName("HSQLDBHIB1234");
		jobCount.setMatchCount(23456);
		
		// Issue with java.time.LocalDate object into MySQL DATE column
		// Following block uses java.sql.Date Java object
		jobCount.setLogDate(Date.valueOf(LocalDate.of(2017, 3, 6)));
		
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
