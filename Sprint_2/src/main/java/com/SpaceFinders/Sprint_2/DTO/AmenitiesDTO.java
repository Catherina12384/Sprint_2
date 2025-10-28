package com.SpaceFinders.Sprint_2.DTO;
import jakarta.validation.constraints.*;

public class AmenitiesDTO {
    @NotBlank(message = "Amenity name should not be empty")
    @Pattern(regexp = "[a-zA-Z\\s]{2,50}", message = "Amenity name must be 2-50 alphabetic characters")
    private String amenityName;

    @NotNull(message = "Amenity status must not be null")
    private boolean amenityStatus = true;

    public AmenitiesDTO() {}

    public AmenitiesDTO(String amenityName) {
        this.amenityName = amenityName;
        this.amenityStatus = true;
    }

    public AmenitiesDTO(String amenityName, boolean amenityStatus) {
        this.amenityName = amenityName;
        this.amenityStatus = amenityStatus;
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