package com.stackroute.restaurant.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.stackroute.restaurant.domain.Restaurant;
import com.stackroute.restaurant.repositories.RestaurantRepository;

public class RestaurantServiceMySQLImplTest {

	/*@Test
	public void testRestaurantServiceMySQLImpl() {
		fail("Not yet implemented");
	}*/
	@Autowired
	MockMvc mockMvc;
	@Mock
	Restaurant restaurant;
	
	@Mock
	RestaurantRepository restaurantRepository;
	
	@InjectMocks
	private RestaurantServiceMySQLImpl restaurantService;
	
	transient Optional<Restaurant> options;
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		Restaurant mockRestaurant = new Restaurant(4, "cuisine", "image1","bangalore");
		
	}
	
	
	
	@Test
    public void testGetAllRestaurants() throws Exception {
		//Restaurant mockRestaurant = new Restaurant(4, "cuisine", "image1","bangalore");
         List<Restaurant> restaurants = new ArrayList<Restaurant>();
         restaurants.add(restaurant);
         //restaurants.add(mockRestaurant);
         Mockito.when(restaurantRepository.findAll()).thenReturn(restaurants);
         List<Restaurant> mock = (List<Restaurant>) restaurantService.getAllRestaurants();
         assertEquals(restaurants, mock);
          

    }

	//
	
	/**
     * testing the save method
     * 
     * @throws MovieAlreadyExistsException
     */
    @Test
    public void testSaveRestaurantSuccess()  {
    	Restaurant mockRestaurant = new Restaurant(4, "cuisine", "image1","bangalore");
        Mockito.when(restaurantRepository.save(mockRestaurant)).thenReturn(mockRestaurant);
        Restaurant mock= restaurantService.addRestaurant(mockRestaurant);
        assertEquals(mockRestaurant, mock);
        
    }
    
    /*@Test
	public void testFindRestaurantById() {
    	Restaurant mockRestaurant = new Restaurant(4, "cuisine", "image1","bangalore");
    	Optional optional = Optional.of(mockRestaurant);
    	Mockito.when(restaurantRepository.findById(4)).thenReturn(optional);
    	Restaurant mock = restaurantService.findRestaurantById(optional);
    	
	}*/
    
    @Test
    public void testGetRestaurantByID() throws Exception {
    	Restaurant mockRestaurant = new Restaurant(4, "cuisine", "image1","bangalore");
        options = Optional.of(mockRestaurant);
        Mockito.when(restaurantRepository.findById(4)).thenReturn(options);
        Optional<Restaurant> result = restaurantRepository.findById(4);
        assertEquals(result, options);
      
    }
    
    @Test
	public void testUpdateRestaurantById() {
    	Restaurant mockRestaurant = new Restaurant(4, "cuisine", "image1","bangalore");
        Mockito.when(restaurantRepository.save(mockRestaurant)).thenReturn(mockRestaurant);
        Optional optional = Optional.of(mockRestaurant);
        Restaurant updatedMockRestaurant = restaurantRepository.save(mockRestaurant);
       assertNotNull(updatedMockRestaurant);
        assertEquals(updatedMockRestaurant, restaurantRepository.save(mockRestaurant));
	}

    @Test
	public void testDeleteRestaurantById() {
    	
    Restaurant mockRestaurant = new Restaurant(4,"echos", "img","chennai");
    Mockito.when(restaurantRepository.save(mockRestaurant)).thenReturn(mockRestaurant);
   
    RestaurantRepository rest1=mock(RestaurantRepository.class);
    doNothing().when(rest1).deleteById(4);
//     Restaurant rest = restaurantServiceImpl.updateRestaurantById(4,mockRestaurant);
//     assertEquals(mockRestaurant, rest);    
    rest1.deleteById(restaurant.getId());
    verify(rest1,times(1)).deleteById(restaurant.getId());
	
    }
	
}
