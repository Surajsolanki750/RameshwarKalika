package com.rkmb.RameshwarKalika.service;

import java.util.List;

import com.rkmb.RameshwarKalika.entity.Client;

public interface ClientService {

	
	public Client getClientById(Integer id);
	public List<Client> getClientList();
	public void saveClient(Client client);
	public void saveAll(List<Client> clientList);
	public void updateStudentDetails(Integer id, Client client);
	public void deleteClientById(Integer id);
	public void deleteAllClients();
}
