package com.rkmb.RameshwarKalika.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.rkmb.RameshwarKalika.entity.Client2;
import com.rkmb.RameshwarKalika.repository.ClientRepository2;

@RunWith(SpringRunner.class)
@TestPropertySource("classpath:/application-junit.properties")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ClientController2Test3 {

	private static final Logger LOG = LoggerFactory.getLogger(ClientController2Test3.class);

	@MockBean
	private ClientRepository2 repository;
	
	@Autowired
	private Client2Controller controller;

	@LocalServerPort
	private int port;

	@Test
	public void testGetByname() {
		// Given
		Client2 client1 = new Client2("Suraj", 26, "Software Engineer", 55000L, "OBC");
		List<Client2> list = new ArrayList<>();
		list.add(client1);
		Mockito.when(repository.findByName(any())).thenReturn(list);
		
		//When
		List<Client2> result = controller.getByName("Suraj");
		
		//Then
		assertEquals("Suraj", result.get(0).getClientFullName());
	}

}
