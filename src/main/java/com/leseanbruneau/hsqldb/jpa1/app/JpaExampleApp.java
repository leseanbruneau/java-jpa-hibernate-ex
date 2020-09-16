package com.leseanbruneau.hsqldb.jpa1.app;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.leseanbruneau.hsqldb.jpa1.domain.JobCountHsqldbJPA;

public class JpaExampleApp {

	public static void main(String[] args) {
		// JPA persistent unit name in persistence.xml config file
		String jpa_pu = "jpa-hsqldb-ex";
		
		JobCountHsqldbJPA jobCount = new JobCountHsqldbJPA();
		
		jobCount.setNode("JPA01");
		jobCount.setJobName("HSQL349");
		jobCount.setMatchCount(34901);
		jobCount.setLogDate(Date.valueOf(LocalDate.of(2016, 12, 21)));

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
