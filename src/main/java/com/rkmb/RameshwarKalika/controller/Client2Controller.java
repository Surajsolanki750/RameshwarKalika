package com.rkmb.RameshwarKalika.controller;

import java.util.List;

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
	
	@Autowired
	private ClientService2 service;
	
	//Retrieve data----------------------------------------------------------------------------------------------------------//
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
	public List<Client2> getBySalary(@RequestParam("salary") Long salary){
		return service.findBySalary(salary);
	}
	
	@GetMapping("/getByAge")
	public List<Client2> getByAge(@RequestParam("age") Integer age) {
		return service.findByAge(age);
	}
	
	@GetMapping("/getAll")
	public List<Client2> getAll(){
		return service.getAll();
	}
	//Save Data---------------------------------------------------------------------------------------------------------------//	
	@PostMapping("/save")
	public String saveClient(@RequestBody Client2 client) {
		service.saveClient(client);
		return "data saved for client "+client.toString();
	}
	
	@PostMapping("/saveAll")
	public String saveList(@RequestBody List<Client2> list) {
		service.saveList(list);
		return "Client list saved";
	}
	//update data------------------------------------------------------------------------------------------------------------//
	@PutMapping("updateClient/{id}")
	public String updateClient(@PathVariable Integer id, @RequestBody Client2 client) {
		service.updateClient(id, client);
		return "updated the data of id "+id;
	}
	
	//Partially update data------------------------------------------------------------------------------------------------------------//
	@PatchMapping("/editName/{id}")
	public String editname(@PathVariable Integer id, @RequestParam String name) {
		service.editName(id, name);
		return "edited the name of id "+id;
	}
	
	@PatchMapping("/editAge/{id}")
	public String editAge(@PathVariable Integer id, @RequestParam Integer age) {
		service.editAge(id, age);
		return "edited the age of id "+id;
	}
	
	@PatchMapping("/editSalary/{id}")
	public ResponseEntity<String> editSalary(@PathVariable Integer id, @RequestParam Long salary) {
		if(id!=null) {
			service.editSalary(id, salary);
			return ResponseEntity.status(HttpStatus.OK).body("Salary of client with id = "+id+" is updated to "+salary);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There is no client with id = "+id);
		}
	}
	
	//Delete data--------------------------------------------------------------------------------------------------------------------//
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id) {
		if(id!=null) {
			service.deleteClient(id);
			return ResponseEntity.status(HttpStatus.OK).body("Deleted the client with id = "+id);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There is no client with id = "+id);
		}
	}
	
	@DeleteMapping("/deleteAll")
	public String deleteAll() {
		service.deleteAll();
		return "All client data is deleted";
	}
}
