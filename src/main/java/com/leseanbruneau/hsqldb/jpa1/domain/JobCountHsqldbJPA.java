package com.leseanbruneau.hsqldb.jpa1.domain;

import java.sql.Date;
//import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="JOB_COUNT")
public class JobCountHsqldbJPA {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="JOB_ID")
	private Long jobId;
	
	@Column(name="NODE")
	private String node;
	
	@Column(name="JOB_NAME")
	private String jobName;
	
	@Column(name="LOG_DATE")
	private Date logDate;
	
	//@Column(name="LOG_DATE", columnDefinition = "DATE") 
	//private LocalDate logDate;
	 
	@Column(name="MATCH_COUNT")
	private int matchCount;
	

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public Date getLogDate() {
		return logDate;
	}

	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}

	public int getMatchCount() {
		return matchCount;
	}

	public void setMatchCount(int matchCount) {
		this.matchCount = matchCount;
	}

}
