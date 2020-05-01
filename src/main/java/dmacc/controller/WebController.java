package dmacc.controller;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import dmacc.beans.Restaurant;
import dmacc.repository.RestaurantRepository;

@Controller
public class WebController {
	@Autowired
	RestaurantRepository repo;
	
	@GetMapping("/viewAll")
	public String viewAllRestaurants(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewRestaurant(model);
		}
		
		model.addAttribute("restaurants", repo.findByName());
		return "results";
	}
	
	@GetMapping("/viewByPrice")
	public String viewAllByPrice(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewRestaurant(model);
		}
		
		model.addAttribute("restaurants", repo.findByPrice());
		return "results";
	}
  
  @GetMapping("/viewBySpecificPrice_{price1}_{price2}")
	public String viewSpecificPrice(@PathVariable("price1") double price1, @PathVariable("price2") double price2, Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewRestaurant(model);
		}
		
		model.addAttribute("restaurants", repo.findBySpecific(price1, price2));
		return "results";
	}
	
	@GetMapping("/viewBySpecificName_{name}")
	public String viewSpecificPrice(@PathVariable("name") String name, Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewRestaurant(model);
		}
		
		model.addAttribute("restaurants", repo.findBySpecificName(name));
		return "results";
	}
	
	@GetMapping("/viewBySpecificRating_{rating}")
	public String viewSpecificRating(@PathVariable("rating") int rating, Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewRestaurant(model);
		}
		
		model.addAttribute("restaurants", repo.findBySpecificRating(rating));
		return "results";
	}
	
	
	 @GetMapping("/viewBySpecificPartySize_{partySize}") 
	 public String viewSpecificPartySize(@PathVariable("partySize") int partySize, Model model) { 
		 if(repo.findAll().isEmpty()) { 
			 return addNewRestaurant(model); 
		}
	  
	  model.addAttribute("restaurants", repo.findBySpecificRating(partySize));
	  return "results";
	}
	 
	 @GetMapping("/viewBySpecificType_{type}") 
	 public String viewSpecificType(@PathVariable("type") String type, Model model) { 
		 if(repo.findAll().isEmpty()) { 
			 return addNewRestaurant(model); 
		}
	  
	  model.addAttribute("restaurants", repo.findBySpecificType(type));
	  return "results";
	}
	 
	
  @GetMapping("/viewByRating")
	public String viewAllByRating(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewRestaurant(model);
		}
		
		model.addAttribute("restaurants", repo.findByRating());
		return "results";
	}
	
	@GetMapping("/viewByPartySize")
	public String viewAllByPartySize(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewRestaurant(model);
		}
		
		model.addAttribute("restaurants", repo.findByPartySize());
		return "results";
	}
	
	@GetMapping("/viewByDistance")
	public String viewAllByDistance(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewRestaurant(model);
		}
		
		model.addAttribute("restaurants", repo.findByDistance());
		return "results";
	}
	
	@GetMapping("/viewByType")
	public String viewAllByType(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewRestaurant(model);
		}
		
		model.addAttribute("restaurants", repo.findByType());
		return "results";
	}
	
	@GetMapping("/viewByKidsMenu")
	public String viewAllByKidsMenu(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewRestaurant(model);
		}
		
		model.addAttribute("restaurants", repo.findByKidsMenu());
		return "results";
	}
	
	@GetMapping("/viewByStreet")
	public String viewAllByStreet(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewRestaurant(model);
		}
		
		model.addAttribute("restaurants", repo.findByStreet());
		return "results";
	}
	
	@GetMapping("/viewByCity")
	public String viewAllByCity(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewRestaurant(model);
		}
		
		model.addAttribute("restaurants", repo.findByCity());
		return "results";
	}
	
	@GetMapping("/viewByState")
	public String viewAllByState(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewRestaurant(model);
		}
		
		model.addAttribute("restaurants", repo.findByState());
		return "results";
	}
  
	@GetMapping("/inputRestaurant")
	public String addNewRestaurant(Model model) {
		Restaurant r = new Restaurant();
		model.addAttribute("newRestaurant", r);
		return "input";
	}
	
	@PostMapping("/inputRestaurant")
		public String addNewRestaurant(@ModelAttribute Restaurant r, Model model) {
			repo.save(r);
			return viewAllRestaurants(model);
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateRestaurant(@PathVariable("id") long id, Model model) {
		Restaurant c = repo.findById(id).orElse(null);
		System.out.println("ITEM TO EDIT: " + c.toString());
		model.addAttribute("newRestaurant", c);
		return "input";
	}
	
	@PostMapping("/update/{id}")
	public String reviseRestaurant(Restaurant r, Model model) {
		repo.save(r);
		return viewAllRestaurants(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteRestaurant(@PathVariable("id") long id, Model model) {
		Restaurant r = repo.findById(id).orElse(null);
	    repo.delete(r);
	    return viewAllRestaurants(model);
	}

	@GetMapping("/details/{id}")
	public String showRestaurantDetails(@PathVariable("id") long id, Model model) {
		Restaurant c = repo.findById(id).orElse(null);
		model.addAttribute("detailRestaurant", c);
		return "details";
	}
}
