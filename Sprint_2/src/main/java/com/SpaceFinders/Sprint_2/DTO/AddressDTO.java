package com.SpaceFinders.Sprint_2.DTO;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
public class AddressDTO {

    @NotBlank(message = "Building number is required.")
    @Size(min = 2, max = 10, message = "Building number should be between 2 and 10 characters long")
    private String building_no;

    @NotBlank(message = "Street name is required")
    @Size(min = 2, max = 100, message = "Street name must be between 2 and 100 characters")
    private String street;

    @NotBlank(message = "City name is required")
    @Size(min = 2, max = 100, message = "City name must be between 2 and 100 characters")
    private String city;

    @NotBlank(message = "Postal Code is required")
    @Size(min = 5, max = 6, message = "Postal Code must be between 5 and 6 characters")
    private String postal_code;

    @NotBlank(message = "Country name is required")
    @Size(min = 2, max = 100, message = "Country name must be between 2 and 100 characters")
    private String country;

    public AddressDTO(String building_no, String street, String city, String postal_code, String country) {
        this.building_no = building_no;
        this.street = street;
        this.city = city;
        this.postal_code = postal_code;
        this.country = country;
    }

    public AddressDTO(){}

    public String getBuilding_no() {
        return building_no;
    }

    public void setBuilding_no(String building_no) {
        this.building_no = building_no;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

