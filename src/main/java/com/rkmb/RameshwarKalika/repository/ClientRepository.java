package com.rkmb.RameshwarKalika.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rkmb.RameshwarKalika.entity.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {

}
