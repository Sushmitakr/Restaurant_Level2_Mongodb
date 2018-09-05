/*package com.stackroute.restaurant.services;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.stackroute.restaurant.controller.RestaurantController;
import com.stackroute.restaurant.domain.Restaurant;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RestaurantServiceTest {
	
	@Mock
	private MockMvc RestaurantMockMvc;
	
	@Mock
	private RestaurantService restaurantService;
	
	@InjectMocks
	private RestaurantController restaurantController = new RestaurantController();
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		RestaurantMockMvc = MockMvcBuilders.standaloneSetup(restaurantController).build();
	}
	
	@Test
	public void testAddRestaurant() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllRestaurants() {
		
		List<RestaurantService> restaurants = Arrays.asList(
				new Restaurant(1,"name1","image1","location1"),
				new Restaurant(2,"name2","image2","location2"));
	
	when(RestaurantService.restaurantList()).thenReturn(restaurants));
	
	RestaurantMockMvc.perform(get("/api/restaurant"))
	.andExpect(status().isOk())
	.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
	.andExpect(jsonPath("$", hasSize(2)))
	.andExpect(jsonPath("$[0].name", is("name1")))
	.andExpect(jsonPath("$[0].image", is("image1")))
	.andExpect(jsonPath("$[0].location", is("location1")));
	
	verify(restaurantService, times(1)).restaurantList();
	
	}

	@Test
	public void testFindRestaurantById() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateRestaurantById() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteRestaurantById() {
		fail("Not yet implemented");
	}

}
*/