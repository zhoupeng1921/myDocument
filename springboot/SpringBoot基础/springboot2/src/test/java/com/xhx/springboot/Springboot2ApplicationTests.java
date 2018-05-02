package com.xhx.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class Springboot2ApplicationTests {


	@Autowired
	private TestRestTemplate restTemplate;//必须加webEnvironment才能注入

	@Test
	public void testGetUser(){
		ResponseEntity<String> responseStriing = restTemplate.getForEntity("http://localhost:8080" + "/getUser", String.class);
		System.out.println(responseStriing.getBody());
	}

	@Test
	public void testGetUserPrefix(){
		ResponseEntity<String> responseStriing = restTemplate.getForEntity("http://localhost:8080" + "/getUserPrefix", String.class);
		System.out.println(responseStriing.getBody());
	}
}
