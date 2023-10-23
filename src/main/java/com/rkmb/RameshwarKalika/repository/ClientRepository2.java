package com.rkmb.RameshwarKalika.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rkmb.RameshwarKalika.entity.Client2;

@Repository
public interface ClientRepository2 extends JpaRepository<Client2, Integer> {

	@Query(value = "select * from client_data2 where client_name = :name", nativeQuery = true)
	public List<Client2> findByName(@Param("name") String name);

	@Query(value = "select * from client_data2 where client_salary <= :salary", nativeQuery = true)
	public List<Client2> findBySalary(@Param("salary") Long salary);

	@Query(value = "select * from client_data2 where client_caste = :caste", nativeQuery = true)
	public List<Client2> findByCaste(@Param("caste") String caste);

	@Query(value = "select * from client_data2 where client_age = :age", nativeQuery = true)
	public List<Client2> findByAge(@Param("age") Integer age);

}
