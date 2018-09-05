package com.stackroute.restaurant.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.restaurant.domain.Restaurant;
import com.stackroute.restaurant.exceptions.DataBaseNotAvailableException;
import com.stackroute.restaurant.services.RestaurantService;

@RequestMapping("api/v1")
@RestController
@SuppressWarnings("rawtypes")
public class RestaurantController {
	
	@Autowired
	RestaurantService restaurantService;
	
	 private final Logger logger = LoggerFactory.getLogger(this.getClass());
	    @RequestMapping("/")
	    String index(){
	        logger.debug("This is a debug message");
	        logger.info("This is an info message");
	        logger.warn("This is a warn message");
	        logger.error("This is an error message");
	        return "index";
	    }
	    @CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/restaurant", method = RequestMethod.POST)
	public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) throws DataBaseNotAvailableException{
		Restaurant newRestaurant = restaurantService.addRestaurant(restaurant);
		return new ResponseEntity<Restaurant>(newRestaurant, HttpStatus.OK);
	}
	
	    @CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public ResponseEntity showAllRestaurant() {
		
		return new ResponseEntity<>(restaurantService.getAllRestaurants(),HttpStatus.OK);
	}
	    @CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/getall/{id}", method = RequestMethod.GET)
	public ResponseEntity findRestaurantbyId(@PathVariable(value = "id") String id) {
		int  id1=Integer.parseInt(id);
		System.out.println(id1);
	/*	ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("foundRestaurant", restaurantService.findRestaurantById(id));
		modelAndView.setViewName("restaurantDetails");
		return modelAndView;*/
		return new ResponseEntity<>(restaurantService.findRestaurantById(id1),HttpStatus.OK);
	}
	    @CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity updateRestaurantbyId(@PathVariable(value = "id") String id, @RequestBody Restaurant restaurant) {
		int id1=Integer.parseInt(id);
		/*Restaurant restaurant = (Restaurant) restaurantService.findRestaurantById(id1);
		restaurant.setId(restaurant.getId());
		restaurant.setName(restaurant.getName());
		restaurant.setImage(restaurant.getImage());
		restaurant.setLocation(restaurant.getLocation());
*/		
		/*ModelAndView modelAndView = new ModelAndView();
		//modelAndView.addObject("foundRestaurant", restaurantService.updateRestaurantById(id, restaurant));
		modelAndView.setViewName("restaurantForm");*/
		
		System.out.println(id1);
		return new ResponseEntity<>(restaurantService.updateRestaurantById(id1, restaurant),HttpStatus.OK);
	}	
	
	/*@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public void deleteRestaurant(@PathVariable(value = "id") String id) {
		int id1=Integer.parseInt(id);
		restaurantService.deleteRestaurantById(id1);
		
		
	}*/
	    @CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteRestaurant(@PathVariable(value = "id") String id,Restaurant res) {
        int id1=Integer.parseInt(id);
        res.setId(id1);
        
        //return new ResponseEntity<>(restaurantService.deleteRestaurantById(res),HttpStatus.OK);
        
        return new ResponseEntity<>(restaurantService.deleteRestaurantById(res),HttpStatus.OK);
    }
}
