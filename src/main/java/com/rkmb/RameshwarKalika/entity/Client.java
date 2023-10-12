package com.rkmb.RameshwarKalika.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client data")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "client id")
	Integer clientId;
	@Column(name = "client name")
	String clientFullName;
	@Column(name = "client DoB")
	Date clientDOB;
	@Column(name = "client JobDetails")
	String clientJobDetails;
	@Column(name = "client MonthlyIncome")
	Long clientIncome;
	@Column(name = "client id")
	String clientCaste;
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	public String getClientFullName() {
		return clientFullName;
	}
	public void setClientFullName(String clientFullName) {
		this.clientFullName = clientFullName;
	}
	public Date getClientDOB() {
		return clientDOB;
	}
	public void setClientDOB(Date clientDOB) {
		this.clientDOB = clientDOB;
	}
	public String getClientJobDetails() {
		return clientJobDetails;
	}
	public void setClientJobDetails(String clientJobDetails) {
		this.clientJobDetails = clientJobDetails;
	}
	public Long getClientIncome() {
		return clientIncome;
	}
	public void setClientIncome(Long clientIncome) {
		this.clientIncome = clientIncome;
	}
	public String getClientCaste() {
		return clientCaste;
	}
	public void setClientCaste(String clientCaste) {
		this.clientCaste = clientCaste;
	}
	
}
