package com.rkmb.RameshwarKalika.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.rkmb.RameshwarKalika.entity.Client2;
import com.rkmb.RameshwarKalika.repository.ClientRepository2;

@RunWith(SpringRunner.class)
@TestPropertySource("classpath:/application-junit.properties")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ClientController2Test {

	private static final Logger LOG = LoggerFactory.getLogger(ClientController2Test.class);

	@Autowired
	private ClientRepository2 repository;

	@Autowired
	private Client2Controller controller;

//	private resquestSpecification requestSpecification;
//
//	@LocalServerPort
//	private int port;
//
//	public void initRequestSpecification() {
//		final RequestSpecBuilder tempSpec = new RequestSpecBuilder();
//		requestSpecification.SetBaseUri("http://localhost:"+port+"/client").setContentType(ContentType.JSON).build();
//	}

	@Before
	public void init() {
		LOG.info("@before init method called");
		repository.deleteAll();
	}

	@Test
	public void testGetById() {
		// Given
		Client2 client = new Client2();
		client.setClientFullName("Suraj");
		client.setclientAge(26);
		client.setClientCaste("OBC");
		client.setClientJobDetails("IT ENGINEER");
		client.setClientSalary(56000l);
		Client2 repoClient = repository.save(client);

		// When
		ResponseEntity<Client2> entity = controller.getById(repoClient.getClientId());
		// Then
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	}

	@Test
	public void testGetByName() {
		// Given
		Client2 client = new Client2();
		client.setClientFullName("Suraj");
		client.setclientAge(26);
		client.setClientCaste("OBC");
		client.setClientJobDetails("IT ENGINEER");
		client.setClientSalary(56000l);
		Client2 repoClient = repository.save(client);
		// When
		List<Client2> list = controller.getByName("Suraj");
		// Then
		assertFalse(list.isEmpty());
		assertEquals(repoClient.getClientFullName(), "Suraj");

	}

	@Test
	public void testGetByNameExpectError() {
		//Given
		Client2 client = new Client2();
		client.setClientFullName("Suraj");
		client.setclientAge(26);
		client.setClientCaste("OBC");
		client.setClientJobDetails("IT ENGINEER");
		client.setClientSalary(56000l);
		repository.save(client);
		//When
		List<Client2> list = controller.getByName("Ganesh");
		//Then
		assertTrue(list.isEmpty());
		
	}
}
