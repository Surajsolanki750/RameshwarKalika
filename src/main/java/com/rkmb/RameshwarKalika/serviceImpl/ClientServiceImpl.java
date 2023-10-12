package com.rkmb.RameshwarKalika.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rkmb.RameshwarKalika.entity.Client;
import com.rkmb.RameshwarKalika.repository.ClientRepository;
import com.rkmb.RameshwarKalika.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	private ClientRepository repository;

	@Autowired
	public ClientServiceImpl(ClientRepository repository) {
		this.repository = repository;
	}

	// Get
	@Override
	public Client getClientById(Integer id) {
		Client client = repository.findById(id).get();
		return client;
	}

	// GetAll
	@Override
	public List<Client> getClientList() {
		List<Client> list = new ArrayList<>();
		repository.findAll().forEach(x -> list.add(x));
		return list;
	}

	// Save
	@Override
	public void saveClient(Client client) {
		repository.save(client);
	}

	// SaveAll
	@Override
	public void saveAll(List<Client> clientList) {
		repository.saveAll(clientList);
	}

	// Update
	@Override
	public void updateStudentDetails(Integer id, Client client) {
		Client update = repository.findById(id).get();
		update.setClientFullName(client.getClientFullName());
		update.setClientDOB(client.getClientDOB());
		update.setClientCaste(client.getClientCaste());
		update.setClientIncome(client.getClientIncome());
		update.setClientJobDetails(client.getClientCaste());
		repository.save(update);
	}

	// Delete
	@Override
	public void deleteClientById(Integer id) {
		repository.deleteById(id);
	}

	// DeleteAll
	@Override
	public void deleteAllClients() {
		repository.deleteAll();
	}
}
