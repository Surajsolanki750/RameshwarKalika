package com.rkmb.RameshwarKalika.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client_data")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "client_id")
	private Integer clientId;
	@Column(name = "client_name")
	private String clientFullName;
	@Column(name = "client_DoB")
	private Date clientDOB;
	@Column(name = "client_JobDetails")
	private String clientJobDetails;
	@Column(name = "client_MonthlyIncome")
	private Long clientIncome;
	@Column(name = "client_caste")
	private String clientCaste;

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

	public Client(Integer clientId, String clientFullName, Date clientDOB, String clientJobDetails, Long clientIncome,
			String clientCaste) {
		this.clientId = clientId;
		this.clientFullName = clientFullName;
		this.clientDOB = clientDOB;
		this.clientJobDetails = clientJobDetails;
		this.clientIncome = clientIncome;
		this.clientCaste = clientCaste;
	}

	public Client() {

	}

}
