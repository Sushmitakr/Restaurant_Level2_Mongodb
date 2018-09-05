package com.stackroute.restaurant.services;

import com.stackroute.restaurant.domain.Restaurant;

public interface RestaurantService {
	
	public Restaurant addRestaurant(Restaurant restaurant);
	public Iterable<Restaurant> getAllRestaurants();
	public Restaurant findRestaurantById(int id);
	public Restaurant updateRestaurantById(int id, Restaurant restaurant);
	public Restaurant deleteRestaurantById(Restaurant restaurant);

}
