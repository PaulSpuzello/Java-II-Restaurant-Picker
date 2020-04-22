package dmacc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dmacc.beans.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
	
	public static final String FIND_REST = "SELECT * FROM restaurant ORDER BY name ASC";
	
	@Query(value = FIND_REST, nativeQuery = true)
	List<Restaurant> findBySingle(String name);
}
