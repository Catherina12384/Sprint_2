package com.SpaceFinders.Sprint_2.DTO;

public class AmenitiesDTO {
    private String amenityName;

	public String getAmenityName() {
		return amenityName;
	}

	public void setAmenityName(String amenityName) {
		this.amenityName = amenityName;
	}

	public AmenitiesDTO(String amenityName) {
		super();
		this.amenityName = amenityName;
	}

	public AmenitiesDTO(){}
}