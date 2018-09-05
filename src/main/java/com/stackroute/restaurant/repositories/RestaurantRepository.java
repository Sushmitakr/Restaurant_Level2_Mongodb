package com.stackroute.restaurant.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.restaurant.domain.Restaurant;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {
	
	//@Query
	public Restaurant findByName(String name);
	
	
	//@Query
		public Restaurant findAllById(int id, Restaurant restaurant);
		 
	/*@Query
	public Restaurant findByNameAndByLocation(String name, String location);*/
}
