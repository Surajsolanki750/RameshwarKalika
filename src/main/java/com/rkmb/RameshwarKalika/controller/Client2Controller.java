package com.rkmb.RameshwarKalika.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rkmb.RameshwarKalika.entity.Client2;
import com.rkmb.RameshwarKalika.service.ClientService2;

@RestController
@RequestMapping("/client2")
public class Client2Controller {
	
	private ClientService2 service;
	
	@Autowired
	public Client2Controller(ClientService2 service) {
		this.service = service;
	}
	
	@GetMapping("/getById/{id}")
	public Client2 getById(@PathVariable Integer id) {
		return service.findById(id);
	}
	
	@GetMapping("/getByName")
	public List<Client2> getByName(@RequestParam("name") String name){
		return service.findByName(name);
	}

	@GetMapping("/getByCaste")
	public List<Client2> getByCaste(@RequestParam("caste") String caste){
		return service.findByCaste(caste);
	}
	
	@GetMapping("/getBySalary")
	public List<Client2> getBySalary(@RequestParam("caste") Long salary){
		return service.findBySalary(salary);
	}
	
	@GetMapping("/getByAge")
	public List<Client2> getByAge(Integer age) {
		return service.findByAge(age);
	}
}
