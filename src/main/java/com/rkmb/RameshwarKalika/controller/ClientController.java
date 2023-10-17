package com.rkmb.RameshwarKalika.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rkmb.RameshwarKalika.entity.Client;
import com.rkmb.RameshwarKalika.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientService service;

	@GetMapping("getById/{id}")
	public Client getById(@PathVariable Integer id) {
		return service.getClientById(id);
	}

	@GetMapping("/getAll")
	public List<Client> getAllClients() {
		return service.getClientList();
	}

	@PostMapping("/save")
	public String saveClient(@RequestBody Client client) {
		service.saveClient(client);
		return "Client data stored in the database";
	}

	@PostMapping("/saveAll")
	public String saveAllClients(@RequestBody List<Client> list) {
		service.saveAll(list);
		return "All the Data Stored Successfully";
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<String> updateClientDetails(@PathVariable Integer id, @RequestBody Client client){
		if(id!=null) {
			service.updateClientDetails(id, client);
			return ResponseEntity.ok("Record updated");
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The entered id "+ id +" is not in the database please check once again");
		}
	}

}
