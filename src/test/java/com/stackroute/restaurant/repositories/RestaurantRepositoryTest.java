package com.stackroute.restaurant.repositories;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.restaurant.domain.Restaurant;

@RunWith(SpringRunner.class)
@DataMongoTest
public class RestaurantRepositoryTest {

	@Autowired
	transient RestaurantRepository restaurantRepository;
	
	@Test
	public void testGetRestaurant() {
		restaurantRepository.save(new Restaurant(4, "Spring", "image", "location"));
		Restaurant res = restaurantRepository.findByName("Spring");
		assertEquals(res.getName(), "Spring");
			
		
	}
	@Test
	public void testSave() {
	restaurantRepository.save(new Restaurant(4, "Spring", "image", "location"));
	assertTrue(restaurantRepository.existsById(4));
		
	}

	@Test
	public void testFindById() {
		restaurantRepository.save(new Restaurant(4, "Spring", "image", "location"));
		assertTrue(restaurantRepository.existsById(4));
			
	}

	@Test
	public void testFindAll() {
		
		Restaurant mockRestaurant = new Restaurant(4, "cuisine", "image","bangalore");
		Restaurant mockRestaurant2 = new Restaurant(3, "cuisine3", "image3","bangalore3");

		Restaurant mockRestaurant3 = new Restaurant(1, "cuisine1", "image1","bangalore1");

        Optional<Restaurant> result = restaurantRepository.findById(4);
        assertEquals(result, mockRestaurant);
	}
	
	@Test
	public void testUpdateById() {
		Restaurant mockRestaurant = new Restaurant(4, "cuisine", "image","bangalore");
		
		Optional<Restaurant> result = restaurantRepository.findById(4);
		
		assertEquals(4, result.get().getId());
		
		
	}

	@Test
	public void testDeleteById() {
		
		 List<Restaurant> actualList=(List<Restaurant>) restaurantRepository.findAll();
	       assertThat(actualList.size(),is(5));
	       restaurantRepository.deleteById(1);
	       actualList=(List<Restaurant>) restaurantRepository.findAll();
	       assertThat(actualList.size(),is(4));
	       
	       assertFalse(restaurantRepository.existsById(1));
	        
		
		
		
	}

}
