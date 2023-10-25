package com.rkmb.RameshwarKalika.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rkmb.RameshwarKalika.entity.Client2;
import com.rkmb.RameshwarKalika.service.ClientService2;

@RestController
@RequestMapping("/client2")
public class Client2Controller {
	
	private static final Logger LOG = LoggerFactory.getLogger(Client2Controller.class);
	
//	LOG.info("getEmpById method is called");
	
	@Autowired
	private ClientService2 service;
	
	//Retrieve data----------------------------------------------------------------------------------------------------------//
	@GetMapping("/getById/{id}")
	public Client2 getById(@PathVariable Integer id) {
		LOG.info("getById method is called");
		return service.findById(id);
	}
	
	@GetMapping("/getByName")
	public List<Client2> getByName(@RequestParam("name") String name){
		LOG.info("getByName method is called");
		return service.findByName(name);
	}

	@GetMapping("/getByCaste")
	public List<Client2> getByCaste(@RequestParam("caste") String caste){
		LOG.info("getByCaste method is called");
		return service.findByCaste(caste);
	}
	
	@GetMapping("/getBySalary")
	public List<Client2> getBySalary(@RequestParam("salary") Long salary){
		LOG.info("getBySalary method is called");
		return service.findBySalary(salary);
	}
	
	@GetMapping("/getByAge")
	public List<Client2> getByAge(@RequestParam("age") Integer age) {
		LOG.info("getByAge method is called");
		return service.findByAge(age);
	}
	
	@GetMapping("/getAll")
	public List<Client2> getAll(){
		LOG.info("getAll method is called");
		return service.getAll();
	}
	//Save Data---------------------------------------------------------------------------------------------------------------//	
	@PostMapping("/save")
	public String saveClient(@RequestBody Client2 client) {
		LOG.info("saveClient method is called");
		service.saveClient(client);
		return "data saved for client "+client.toString();
	}
	
	@PostMapping("/saveAll")
	public String saveList(@RequestBody List<Client2> list) {
		LOG.info("saveClient method is called");
		service.saveList(list);
		return "Client list saved";
	}
	//update data------------------------------------------------------------------------------------------------------------//
	@PutMapping("updateClient/{id}")
	public String updateClient(@PathVariable Integer id, @RequestBody Client2 client) {
		LOG.info("updateClient method is called");
		service.updateClient(id, client);
		return "updated the data of id "+id;
	}
	
	//Partially update data------------------------------------------------------------------------------------------------------------//
	@PatchMapping("/editName/{id}")
	public String editname(@PathVariable Integer id, @RequestParam String name) {
		LOG.info("editName method is called");
		service.editName(id, name);
		return "edited the name of id "+id;
	}
	
	@PatchMapping("/editAge/{id}")
	public String editAge(@PathVariable Integer id, @RequestParam Integer age) {
		LOG.info("editAge method is called");
		service.editAge(id, age);
		return "edited the age of id "+id;
	}
	
	@PatchMapping("/editSalary/{id}")
	public ResponseEntity<String> editSalary(@PathVariable Integer id, @RequestParam Long salary) {
		if(id!=null) {
			LOG.info("editSalary method is called");
			service.editSalary(id, salary);
			return ResponseEntity.status(HttpStatus.OK).body("Salary of client with id = "+id+" is updated to "+salary);
		}else {
			LOG.info("client not found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There is no client with id = "+id);
		}
	}
	
	//Delete data--------------------------------------------------------------------------------------------------------------------//
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id) {
		if(id!=null) {
			LOG.info("deleteById method is called");
			service.deleteClient(id);
			return ResponseEntity.status(HttpStatus.OK).body("Deleted the client with id = "+id);
		}else {
			LOG.info("client not found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There is no client with id = "+id);
		}
	}
	
	@DeleteMapping("/deleteAll")
	public String deleteAll() {
		LOG.info("deleteAll method is called");
		service.deleteAll();
		return "All client data is deleted";
	}
}
