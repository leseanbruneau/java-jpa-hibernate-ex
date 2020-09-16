package com.leseanbruneau.mysql.jpa1.app;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.leseanbruneau.mysql.jpa1.domain.JobCountMysqlJPA;

public class JpaExampleApp {

	public static void main(String[] args) {
		
		// JPA persistent unit name in persistence.xml config file
		String jpa_pu = "jpa-mysqldb-ex";
		
		JobCountMysqlJPA jobCount = new JobCountMysqlJPA();
		
		jobCount.setNode("JPA01");
		jobCount.setJobName("EMF1234");
		jobCount.setMatchCount(54637);
		jobCount.setLogDate(Date.valueOf(LocalDate.of(2018, 5, 21)));

		EntityManagerFactory emFactory = null;		
		
		emFactory = Persistence.createEntityManagerFactory(jpa_pu);
		
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(jobCount);

		em.getTransaction().commit();
		em.close();
		emFactory.close();
		
	}

}
