package com.stackroute.restaurant.repoIntegration;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.restaurant.Application;
import com.stackroute.restaurant.domain.Restaurant;



@SuppressWarnings("unchecked")
@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestaurantIntegrationTest {

	  @LocalServerPort
	    private int port;
	    
	    Restaurant rest;
	    
	    private TestRestTemplate restTemplate=new TestRestTemplate();
	    
	    
	    HttpHeaders headers = new HttpHeaders();
	    
	    HttpEntity<Restaurant> entity;
	    
	    private String createURLWithPort(String uri)
	    {
	        return "http://localhost:"+port+uri;
	    }
	    
	    @Before
	    public void setUp()
	    {
	        rest=new Restaurant(1, "taj", "indian", "taj.jpeg");
	        entity=new HttpEntity(rest,headers);
	    }
	    
	    @After

	   public void tearDown() throws Exception {

	       restTemplate.exchange(createURLWithPort("/api/vi/resturant/1"), HttpMethod.DELETE, entity, String.class);

	   }


	    
	    @Test
	    public void testGetAllRestaurant() throws Exception {
	    	rest.setLocation("mumbai");
	        
	        entity=new HttpEntity(rest,headers);
	        
	        ResponseEntity<String> response = restTemplate.exchange(
	                createURLWithPort("/api/vi/resturant/1"),
	                HttpMethod.PUT, entity, String.class);

	        response = restTemplate.exchange(
	                createURLWithPort("/api/vi/resturant"),
	                HttpMethod.GET, entity, String.class);

	        String expected = "[{\"id\":1,\"name\":\"taj\",\"image\":\"indian\",\"location\":\"taj.jpeg\"}]";

	        assertNotNull(response);
	        
	        String actual=response.getBody();
	        
	        //System.out.println(actual);
	        
	         assertNotNull(actual);

	         assertEquals(200, response.getStatusCodeValue());
	        
	        assertEquals(expected, actual);
	    }
	    @Test
	    public void testAddRestaurant() throws Exception {

	        ResponseEntity<String> response = restTemplate.exchange(
	                createURLWithPort("/api/vi/resturant"),
	                HttpMethod.POST, entity, String.class);

	        assertNotNull(response);

	       String actual = response.getBody();

	       assertNotNull(actual);

	       assertEquals(200, response.getStatusCodeValue());
	    }
	    @Test
	    public void testGetRestaurantUsingId() throws Exception {

	        rest.setLocation("bangalore");
	        
	        entity=new HttpEntity(rest,headers);
	        
	        ResponseEntity<String> response = restTemplate.exchange(
	                createURLWithPort("/api/vi/resturant/1"),
	                HttpMethod.PUT, entity, String.class);

	        response = restTemplate.exchange(
	                createURLWithPort("/api/vi/resturant/1"),
	                HttpMethod.GET, entity, String.class);

	        String expected = "{\"id\":1,\"name\":\"taj\",\"image\":\"indian\",\"location\":\"taj.jpeg\"}";
	        
	        assertNotNull(response);

	       String actual = response.getBody();

	       assertNotNull(actual);

	       assertEquals(200, response.getStatusCodeValue());
	       
	        assertEquals(expected, actual);
	    }
	    
	    @Test
	    public void testUpdateRestaurantUsingId() throws Exception {

	        //HttpEntity<String> entity = new HttpEntity<String>(null, headers);

	        rest.setLocation("bangalore");
	        entity=new HttpEntity(rest,headers);
	        ResponseEntity<String> response = restTemplate.exchange(
	                createURLWithPort("/api/vi/resturant/1"),
	                HttpMethod.PUT, entity, String.class);

	        String expected = "{\"id\":1,\"name\":\"taj\",\"image\":\"indian\",\"location\":\"taj.jpeg\"}";
	        
	        assertNotNull(response);

	       String actual = response.getBody();

	       assertNotNull(actual);

	       assertEquals(200, response.getStatusCodeValue());
	       
	        assertEquals(expected, actual);
	        
	    
	    }

	    
	}
