package com.SpaceFinders.Sprint_2.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = " Amenities")
public class Amenities {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int amenity_id;

    @NotNull
    @NotBlank(message = "Amenity name should not be empty")
    @Pattern(regexp = "[a-zA-Z\\s]{2,50}", message = "Amenity name must be 2-50 alphabetic characters")
    @Column(unique = true)
    private String amenityName;

    @NotNull
    @Column(nullable = false)
    private boolean amenityStatus = true;

    public Amenities() {}

    public Amenities(String amenityName) {
        this.amenityName = amenityName;
        this.amenityStatus = true;
    }

    public Amenities(String amenityName, boolean amenityStatus) {
        this.amenityName = amenityName;
        this.amenityStatus = amenityStatus;
    }

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

    public boolean isAmenityStatus() {
        return amenityStatus;
    }

    public void setAmenityStatus(boolean amenityStatus) {
        this.amenityStatus = amenityStatus;
    }
    
    

}