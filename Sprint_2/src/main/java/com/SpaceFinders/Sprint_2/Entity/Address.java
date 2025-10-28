package com.SpaceFinders.Sprint_2.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
@Table(name = "AddressServices")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int address_id;

    @NotNull
    @NotBlank(message = "Building number is required.")
    @Size(min = 2, max = 10, message = "Building number should be between 2 and 10 characters long")
    String building_no;

    @NotNull
    @NotBlank(message = "Street name is required")
    @Size(min = 2, max = 100, message = "Street name must be between 2 and 100 characters")
    String street;

    @NotNull
    @NotBlank(message = "City name is required")
    @Size(min = 2, max = 100, message = "City name must be between 2 and 100 characters")
    String city;

    @NotNull
    @NotBlank(message = "Postal Code is required")
    @Size(min = 5, max = 6, message = "Postal Code must be between 5 and 6 characters")
    String postal_code;

    @NotNull
    @NotBlank(message = "Country name is required")
    @Size(min = 2, max = 100, message = "Country name must be between 2 and 100 characters")
    String country;

    public Address(int address_id, String building_no, String street, String city, String postal_code, String country) {
        this.address_id = address_id;
        this.building_no = building_no;
        this.street = street;
        this.city = city;
        this.postal_code = postal_code;
        this.country = country;
    }

    public Address(String building_no, String street, String city, String postal_code, String country) {
        this.building_no = building_no;
        this.street = street;
        this.city = city;
        this.postal_code = postal_code;
        this.country = country;
    }

    public Address(){}

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

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

