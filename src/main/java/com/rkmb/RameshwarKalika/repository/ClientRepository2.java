package com.rkmb.RameshwarKalika.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rkmb.RameshwarKalika.entity.Client2;

@Repository
public interface ClientRepository2 extends JpaRepository<Client2, Integer>{
	
	public List<Client2> findByName(String name);
	
	public List<Client2> findBySalary(Long salary);
	
	public List<Client2> findByCaste(String caste);
	
	public List<Client2> findByAge(Integer age);

}
