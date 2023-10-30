package com.rkmb.RameshwarKalika.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.rkmb.RameshwarKalika.entity.Client2;

@RunWith(SpringRunner.class)
@TestPropertySource("classpath:/application-junit.properties")
@DataJpaTest
public class ClientRepositoryTest {
	
	@Autowired
	private ClientRepository2 repository;
	
	@Before
	public void init() {
		repository.deleteAll();
	}
	
	@Test
	public void testFindByName() {
		//Given
		Client2 client1 = new Client2( "Suraj", 26, "Software Engineer", 55000L, "OBC");
		Client2 client2 = new Client2( "Ganesh", 25, "Hardware Engineer", 25000L, "OBC");
		Client2 client3 = new Client2( "Ramesh", 26, "IT worker", 35000L, "SC");
		List<Client2> list = new ArrayList<>();
		list.add(client1);
		list.add(client2);
		list.add(client3);
		repository.saveAll(list);
		//When
		List<Client2> result = repository.findByName("Ganesh");
		
		//Then
		assertFalse(result.isEmpty());
		assertEquals(1, result.size());
		
	}

	@Test
	public void testFindByNameExpectError() {
		//Given
		//Nothing
		//When
		List<Client2> result = repository.findByName("Ganesh");
		
		//Then
		assertTrue(result.isEmpty());
		
	}
}
