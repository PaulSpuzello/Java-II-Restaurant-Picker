package dmacc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dmacc.beans.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
	
	public static final String FIND_NAME = "SELECT * FROM restaurant ORDER BY name ASC";
	public static final String FIND_PRICE = "SELECT * FROM restaurant ORDER BY avg_price ASC";
	
	@Query(value = FIND_NAME, nativeQuery = true)
	List<Restaurant> findByName();
	
	@Query(value = FIND_PRICE, nativeQuery = true)
	List<Restaurant> findByPrice();
}
