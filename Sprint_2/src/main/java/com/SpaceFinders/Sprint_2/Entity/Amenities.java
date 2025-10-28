package com.SpaceFinders.Sprint_2.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = " Amenities")
public class Amenities {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int amenity_id;

    @NotNull
    @NotBlank(message = "Amenity name should not be empty")
    @Pattern(regexp = "[a-zA-z]{2,10}")
    String amenityName;

	public int getAmenity_id() {
		return amenity_id;
	}

	public void setAmenity_id(int amenity_id) {
		this.amenity_id = amenity_id;
	}

	public String getAmenityName() {
		return amenityName;
	}

	public void setAmenityName(String amenityName) {
		this.amenityName = amenityName;
	}

	public Amenities(
			@NotNull @NotBlank(message = "Amenity name should not be empty") @Pattern(regexp = "[a-zA-z]{2,10}") String amenityName) {
		this.amenityName = amenityName;
	}
    
    

}