package com.stackroute.restaurant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.restaurant.domain.Restaurant;
import com.stackroute.restaurant.repositories.RestaurantRepository;

@Service
public class RestaurantServiceMySQLImpl implements RestaurantService {

	RestaurantRepository restaurantRepository;
	
	@Autowired
	public RestaurantServiceMySQLImpl(RestaurantRepository restaurantRepository) {
		super();
		this.restaurantRepository = restaurantRepository;
	}

	@Override
	public Restaurant addRestaurant(Restaurant restaurant) {
		try {
			restaurantRepository.save(restaurant);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return restaurant;
	}

	@Override
	public Iterable<Restaurant> getAllRestaurants() {
		Iterable<Restaurant> restaurantList = restaurantRepository.findAll();
				return restaurantList;
	}
	
	@Override
	public Restaurant findRestaurantById(int id) {
		Restaurant foundRestaurant = restaurantRepository.findById(id).orElse(null);
		return foundRestaurant;
	}
	
	@Override
	public Restaurant updateRestaurantById(int id, Restaurant restaurant) {
		Restaurant updateRestaurant = restaurantRepository.save(restaurant);
		return updateRestaurant;
	}

	@Override
	public Restaurant deleteRestaurantById(Restaurant restaurant) {
		restaurantRepository.deleteById(restaurant.getId());
		return restaurant;
		
	}

	
}
