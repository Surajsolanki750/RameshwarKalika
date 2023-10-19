package com.rkmb.RameshwarKalika.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client_data2")
public class Client2 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "client_id")
	private Integer clientId;
	@Column(name = "client_name")
	private String clientFullName;
	@Column(name = "client_age")
	private Integer clientAge;
	@Column(name = "client_Job_Details")
	private String clientJobDetails;
	@Column(name = "client_salary")
	private Long clientSalary;
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

	public Integer getclientAge() {
		return clientAge;
	}

	public void setclientAge(Integer clientAge) {
		this.clientAge = clientAge;
	}

	public String getClientJobDetails() {
		return clientJobDetails;
	}

	public void setClientJobDetails(String clientJobDetails) {
		this.clientJobDetails = clientJobDetails;
	}

	public Long getClientSalary() {
		return clientSalary;
	}

	public void setClientSalary(Long clientSalary) {
		this.clientSalary = clientSalary;
	}

	public String getClientCaste() {
		return clientCaste;
	}

	public void setClientCaste(String clientCaste) {
		this.clientCaste = clientCaste;
	}

	public Client2(Integer clientId, String clientFullName, Integer clientAge, String clientJobDetails, Long clientSalary,
			String clientCaste) {
		this.clientId = clientId;
		this.clientFullName = clientFullName;
		this.clientAge = clientAge;
		this.clientJobDetails = clientJobDetails;
		this.clientSalary = clientSalary;
		this.clientCaste = clientCaste;
	}

	public Client2() {

	}

}
