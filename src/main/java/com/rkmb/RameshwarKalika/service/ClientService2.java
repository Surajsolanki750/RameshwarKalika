package com.rkmb.RameshwarKalika.service;

import java.util.List;

import com.rkmb.RameshwarKalika.entity.Client2;

public interface ClientService2 {
	
	
	//Get GETMAPPING
	public Client2 findById(Integer id);
	
	public List<Client2> findByName(String name);
	
	public List<Client2> findByCaste(String caste);
	
	public List<Client2> findBySalary(Long salary);
	
	public List<Client2> findByAge(Integer age);
	
	//save  POSTMAPPING
	public String saveClient(Client2 client);
	
	public String saveList(List<Client2> list);
	
	//Update PUTMAPPING
	public String updateClient(Integer id, Client2 client);
	
	//Partial Update  PATCHMAPPING
	public String editname(Integer id, String name);
	public String editAge(Integer id, Integer age);
	public String editSalary(Integer id, Long salary);
	
	//Delete DELETEMAPPING
	public String deleteClient(Integer id);
	
	//Delete All DELETEMAPPING
	public String deleteAll();
	
}
