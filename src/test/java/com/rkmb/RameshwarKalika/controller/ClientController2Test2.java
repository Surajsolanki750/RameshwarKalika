package com.rkmb.RameshwarKalika.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.rkmb.RameshwarKalika.entity.Client2;
import com.rkmb.RameshwarKalika.repository.ClientRepository2;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

@RunWith(SpringRunner.class)
@TestPropertySource("classpath:/application-junit.properties")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ClientController2Test2 {

	private static final Logger LOG = LoggerFactory.getLogger(ClientController2Test2.class);

	@Autowired
	private ClientRepository2 repository;

	private RequestSpecification requestSpecification;

	@LocalServerPort
	private int port;

	public void initRequestSpecification() {
		final RequestSpecBuilder tempSpec = new RequestSpecBuilder();
		requestSpecification = tempSpec.setBaseUri("http://localhost:" + port + "/client")
				.setContentType(ContentType.JSON).build();
	}

	@Before
	public void init() {
		LOG.info("@before init method called");
		repository.deleteAll();
	}

	@Test
	public void TestGetClientById() {
		// Given
		Client2 client = new Client2();
		client.setClientFullName("Suraj");
		client.setclientAge(26);
		client.setClientCaste("OBC");
		client.setClientJobDetails("IT ENGINEER");
		client.setClientSalary(56000l);
		Client2 repoClient = repository.save(client);
		// When
		final ValidatableResponse restResponse = RestAssured.given(requestSpecification).basePath("/getById/{id}")
				.pathParam("id", repoClient.getClientId()).when().get().then();
		// Then
		assertEquals(HttpStatus.OK.value(), restResponse.extract().statusCode());
	}

	@Test
	public void TestGetClientByIdExpectError() {
		// Given

		// When
		final ValidatableResponse restResponse = RestAssured.given(requestSpecification).basePath("/getById/{id}")
				.pathParam("id", 12).when().get().then();
		// Then
		assertEquals(HttpStatus.NOT_FOUND, restResponse.extract().statusCode());
	}
}
