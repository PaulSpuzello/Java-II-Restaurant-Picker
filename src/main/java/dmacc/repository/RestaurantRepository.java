package dmacc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dmacc.beans.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
	
	public static final String FIND_NAME = "SELECT * FROM restaurant ORDER BY name ASC";
	public static final String FIND_PRICE = "SELECT * FROM restaurant ORDER BY avg_price ASC";
	public static final String FIND_RATING = "SELECT * FROM restaurant ORDER BY rating DESC";
	public static final String FIND_TYPE = "SELECT * FROM restaurant ORDER BY type ASC";
	public static final String FIND_PARTY_SIZE = "SELECT * FROM restaurant ORDER BY party_size DESC";
	public static final String FIND_DISTANCE = "SELECT * FROM restaurant ORDER BY distance ASC";
	public static final String FIND_KIDS_MENU = "SELECT * FROM restaurant ORDER BY has_kids_menu ASC";
	public static final String FIND_STREET = "SELECT * FROM restaurant ORDER BY street ASC";
	public static final String FIND_CITY = "SELECT * FROM restaurant ORDER BY city ASC";
	public static final String FIND_STATE = "SELECT * FROM restaurant ORDER BY state ASC";
	
	@Query(value = FIND_NAME, nativeQuery = true)
	List<Restaurant> findByName();
	
	@Query(value = FIND_PRICE, nativeQuery = true)
	List<Restaurant> findByPrice();
	

	@Query(value = FIND_RATING, nativeQuery = true)
	List<Restaurant> findByRating();
	
	@Query(value = FIND_TYPE, nativeQuery = true)
	List<Restaurant> findByType();
	
	@Query(value = FIND_PARTY_SIZE, nativeQuery = true)
	List<Restaurant> findByPartySize();
	
	@Query(value = FIND_DISTANCE, nativeQuery = true)
	List<Restaurant> findByDistance();
	
	@Query(value = FIND_KIDS_MENU, nativeQuery = true)
	List<Restaurant> findByKidsMenu();
	
	@Query(value = FIND_STREET, nativeQuery = true)
	List<Restaurant> findByStreet();
	
	@Query(value = FIND_CITY, nativeQuery = true)
	List<Restaurant> findByCity();
	
	@Query(value = FIND_STATE, nativeQuery = true)
	List<Restaurant> findByState();

	@Query("select r from Restaurant r where r.avgPrice > :lowprice and r.avgPrice < :highprice order by avgPrice ASC")
	List<Restaurant> findBySpecific(@Param("lowprice") double lowprice, @Param("highprice") double highprice);

	@Query("select r from Restaurant r where r.name = :name")
	List<Restaurant> findBySpecificName(@Param("name") String name);
	
	@Query("select r from Restaurant r where r.rating = :rating")
	List<Restaurant> findBySpecificRating(@Param("rating") int rating);
	
	@Query("select r from Restaurant r where r.restDetail.partySize = :partySize")
	List<Restaurant> findBySpecificPartySize(@Param("partySize") int partySize);
	 
	@Query("select r from Restaurant r where r.restDetail.type = :type")
	List<Restaurant> findBySpecificType(@Param("type") String type);
}
