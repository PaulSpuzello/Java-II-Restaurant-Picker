package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Address;
import dmacc.beans.Restaurant;
import dmacc.beans.RestaurantDetail;

@Configuration
public class BeanConfiguration {
	@Bean
	public Restaurant restaurant() {
		Restaurant bean = new Restaurant("Fancy Inn", 55.99, 5);
		return bean;
	}
	
	@Bean
	public RestaurantDetail restaurantDetail() {
		RestaurantDetail bean = new RestaurantDetail("Classy", 16, 21, false);
		return bean;
	}
	
	@Bean
	public Address address() {
		Address bean = new Address("608 Fancy Man Dr.", "Richville", "Kentucky");
		return bean;
	}
}
