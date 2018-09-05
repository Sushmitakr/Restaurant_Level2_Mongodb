package com.stackroute.restaurant.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
//import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
//import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.restaurant.domain.Restaurant;
import com.stackroute.restaurant.services.RestaurantService;
import com.stackroute.restaurant.services.RestaurantServiceMySQLImpl;


@RunWith(SpringRunner.class)
@WebMvcTest(value = RestaurantController.class, secure = false)
public class RestaurantControllerTest {
	@Autowired
	private MockMvc mockMvc;
 
	@Mock
	Restaurant restaurant;
	@MockBean
	private RestaurantServiceMySQLImpl restaurantService;
	
	Restaurant mockRestaurant = new Restaurant(4, "cuisine", "image1","bangalore");
	String restaurantJson= "{\"id\":\4,\"name\":\"Spring\",\"image\":\"image1\",\"location\":\" bangalore\"]}";

	
	/**
	 * alt+shift+j
	 * @throws Exception 
	 */
	@Test
    public void testGetAllRestaurant() throws Exception{
        List<Restaurant> restaurants=Arrays.asList(
                new Restaurant(1,"abc","img","loc"));
        
        //when(restaurantServiceImpl.list()).thenReturn(users);
        
        Mockito.when(
        		restaurantService.getAllRestaurants()).thenReturn(restaurants);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/api/v1/getall").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        
        //System.out.println(result.getResponse().toString());
        String expected = "[{id:1,name:abc,image:img,location:loc}]";
        
            
        System.out.println("incoming data is "+result.getResponse());
        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
        
    }
		//mockito.org
		//test environment
	

	@Test
	   public void testCreateNewUser() throws Exception {
	        
	        Restaurant res=new Restaurant(3,"bp","img3","loc3");
	        Mockito.when(restaurantService.addRestaurant(res)).thenReturn(res);
	    
	       mockMvc.perform(post("/api/v1/restaurant")
	               .contentType(MediaType.APPLICATION_JSON)
	               .content(asJsonString(res)))
	               .andExpect(status().isOk());
	
	}
	    @Test
	   public void testUpdateExistingRestaurant() throws Exception {
	    
	        Restaurant res=new Restaurant(1,"ajay","img","loc");
	        Mockito.when(restaurantService.updateRestaurantById(1,restaurant)).thenReturn(restaurant);
	        
	        Restaurant updatedRestaurant=new Restaurant(1,"bp","img1","loc1");
	        Mockito.when(restaurantService.updateRestaurantById(1,restaurant)).thenReturn(restaurant);
	    
	       mockMvc.perform(put("/api/v1//update/1")
	               .contentType(MediaType.APPLICATION_JSON)
	               .content(asJsonString(updatedRestaurant)))
	               .andExpect(status().isOk());
	             
	   }
	    
	   
	
	@Test
	   public void testDeleteResturant() throws Exception {

		Restaurant mockRestaurant=new Restaurant(1,"ajay","img","loc");
	     Mockito.when(restaurantService.deleteRestaurantById(mockRestaurant)).thenReturn(mockRestaurant);

	       mockMvc.perform(delete("/api/v1/delete/1")

	               .contentType(MediaType.APPLICATION_JSON)

	               .content(asJsonString(mockRestaurant)))

	               .andExpect(status().isOk());
	       verify(restaurantService, times(1)).deleteRestaurantById(Mockito.any(Restaurant.class));

	   }
		
	    
	    public static String asJsonString(final Object obj) {
	        try {
	            return new ObjectMapper().writeValueAsString(obj);
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
	    

		
	/*
	@Test
	public void testFindRestaurantbyId() {
		fail("Not yet implemented");
	}

	
*/

	
}