package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private double avgPrice;
	private int rating;
	@Autowired
	private RestaurantDetail restDetail;
	@Autowired
	private Address address;
	
	public Restaurant() {
		
	}
	
	public Restaurant(String name, double avg, int rating) {
		this.name = name;
		this.avgPrice = avg;
		this.rating = rating;
	}
	
	public Restaurant(int id, String name, double avg, int rating) {
		this.id = id;
		this.name = name;
		this.avgPrice = avg;
		this.rating = rating;
	}
	
	public Restaurant(int id, String name, double avg, int rating, Address add) {
		this.id = id;
		this.name = name;
		this.avgPrice = avg;
		this.rating = rating;
		this.address = add;
	}
	
	public Restaurant(int id, String name, double avg, int rating, Address add, RestaurantDetail restDet) {
		this.id = id;
		this.name = name;
		this.avgPrice = avg;
		this.rating = rating;
		this.address = add;
		this.restDetail = restDet;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(double avgPrice) {
		this.avgPrice = avgPrice;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public RestaurantDetail getRestDetail() {
		return restDetail;
	}

	public void setRestDetail(RestaurantDetail restDetail) {
		this.restDetail = restDetail;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", avgPrice=" + avgPrice + ", rating=" + rating
				+ ", restDetail=" + restDetail + ", address=" + address + "]";
	}
	
}
