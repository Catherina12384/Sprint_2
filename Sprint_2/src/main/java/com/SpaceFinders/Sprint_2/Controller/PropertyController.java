package com.SpaceFinders.Sprint_2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpaceFinders.Sprint_2.DTO.PropertyDTO;
import com.SpaceFinders.Sprint_2.Entity.Property;
import com.SpaceFinders.Sprint_2.Service.PropertyServices;
import com.SpaceFinders.Sprint_2.Utility.PropertyStatus;

@RestController
@RequestMapping("/api")
public class PropertyController {
	@Autowired
	PropertyServices ps;
	@GetMapping("/{id}")
	public Property findPropertyById(@PathVariable int id) {
		return ps.getPropertyById(id);
	}
	@GetMapping("/viewAllProperties")
	public List<Property> viewAll() {
		return ps.viewAll();
	}
	@GetMapping("/country/{country}")
	public List<Property> findPropertiesByCountry(@PathVariable String country) {
		return ps.viewPropertyByCountry(country);
	}
	@GetMapping("/city/{city}")
	public List<Property> findPropertiesByCity(@PathVariable String city) {
		return ps.viewPropertyByCity(city);
	}
	@PostMapping("/addNewProperty")
	public Property addNewProperty(@RequestBody PropertyDTO p) {
		return ps.insertProperty(p);
	}
	@PutMapping("/updateProperty/{id}")
	public Property updateProperty(@PathVariable int id, @RequestBody PropertyDTO p) {
	    return ps.updateProperty(id, p);
	}
	@PatchMapping("/deleteProperty/{id}")
	public Property deleteProperty(@PathVariable int id, @RequestBody PropertyStatus status) {
	    return ps.updatePropertyStatus(id, status);
	}
}