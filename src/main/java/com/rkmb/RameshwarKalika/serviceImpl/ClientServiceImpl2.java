package com.rkmb.RameshwarKalika.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rkmb.RameshwarKalika.Exception.ResourceNotFoundExcpetion;
import com.rkmb.RameshwarKalika.entity.Client2;
import com.rkmb.RameshwarKalika.repository.ClientRepository2;
import com.rkmb.RameshwarKalika.service.ClientService2;

public class ClientServiceImpl2 implements ClientService2 {

	private ClientRepository2 repository;

	@Autowired
	public ClientServiceImpl2(ClientRepository2 repository) {
		this.repository = repository;
	}

	@Override
	public Client2 findById(Integer id) {
		Client2 client = repository.findById(id).get();
		return client;
	}

	@Override
	public List<Client2> findByName(String name) {
		List<Client2> list = repository.findByName(name);
		return list;
	}

	@Override
	public List<Client2> findByCaste(String caste) {
		List<Client2> list = repository.findByCaste(caste);
		return list;
	}

	@Override
	public List<Client2> findBySalary(Long salary) {
		List<Client2> list = repository.findBySalary(salary);
		return list;
	}

	@Override
	public List<Client2> findByAge(Integer age) {
		List<Client2> list = repository.findByAge(age);
		return list;
	}

	@Override
	public String saveClient(Client2 client) {
		repository.save(client);
		return "Client data saved into database";
	}

	@Override
	public String saveList(List<Client2> list) {
		repository.saveAll(list);
		return "All the data saved successfully into database";
	}

	@Override
	public String updateClient(Integer id, Client2 client) {
		Client2 update = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundExcpetion("Client with id " + id + " not exist in the database"));
		update.setClientFullName(client.getClientFullName());
		update.setClientSalary(client.getClientSalary());
		update.setClientJobDetails(client.getClientJobDetails());
		update.setclientAge(client.getclientAge());
		update.setClientCaste(client.getClientCaste());
		repository.save(update);
		return "Client with ID " + id + " is updated";
	}

	@Override
	public String editname(Integer id, String name) {
		Client2 editName = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundExcpetion("Client with id \" + id + \" not exist in the database"));
		editName.setClientFullName(name);
		return "Name edited for id " + id;
	}

	@Override
	public String editAge(Integer id, Integer age) {
		Client2 editAge = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundExcpetion("Client with id \" + id + \" not exist in the database"));
		editAge.setclientAge(age);
		return "Age edited for id " + id;
	}

	@Override
	public String editSalary(Integer id, Long salary) {
		Client2 editSalary = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundExcpetion("Client with id \" + id + \" not exist in the database"));
		editSalary.setClientSalary(salary);
		return "Salary edited for id " + id;
	}

	@Override
	public String deleteClient(Integer id) {
		if (id != null) {
			repository.deleteById(id);
			return "Client with ID " + id + " is deleted from the database.";
		} else {
			return "The client with id " + id + " is not available in the database";
		}
	}

	@Override
	public String deleteAll() {
		repository.deleteAll();
		return "All data deleted.... :-(";
	}

}
