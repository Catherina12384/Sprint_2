package com.SpaceFinders.Sprint_2.DTO;

import java.util.List;

import com.SpaceFinders.Sprint_2.Entity.Address;
import com.SpaceFinders.Sprint_2.Entity.Amenities;
import com.SpaceFinders.Sprint_2.Utility.PropertyStatus;
import com.SpaceFinders.Sprint_2.Utility.PropertyType;

public class PropertyDTO {

    private String propertyName;//UE
    private String propertyDescription;//UE
    private PropertyType propertyType;//UE
	private AddressDTO address;
    private int totalCapacity;//UE
    private int noRooms;//UE
    private int noBathrooms;//UE
    private List <AmenitiesDTO> amenities;
    private PropertyStatus status;//UE
    boolean cancellation;//UE
    double pricePerDay;
    
    
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
		this.address = address;
	}
	public List<AmenitiesDTO> getAmenities() {
		return amenities;
	}
	public void setAmenities(List<AmenitiesDTO> amenities) {
		this.amenities = amenities;
	}
	public double getPricePerDay() {
		return pricePerDay;
	}
	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getPropertyDescription() {
		return propertyDescription;
	}
	public void setPropertyDescription(String propertyDescription) {
		this.propertyDescription = propertyDescription;
	}
	public PropertyType getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}
	public int getTotalCapacity() {
		return totalCapacity;
	}
	public void setTotalCapacity(int totalCapacity) {
		this.totalCapacity = totalCapacity;
	}
	public int getNoRooms() {
		return noRooms;
	}
	public void setNoRooms(int noRooms) {
		this.noRooms = noRooms;
	}
	public int getNoBathrooms() {
		return noBathrooms;
	}
	public void setNoBathrooms(int noBathrooms) {
		this.noBathrooms = noBathrooms;
	}
	public PropertyStatus getStatus() {
		return status;
	}
	public void setStatus(PropertyStatus status) {
		this.status = status;
	}
	public boolean isCancellation() {
		return cancellation;
	}
	public void setCancellation(boolean cancellation) {
		this.cancellation = cancellation;
	}
	public PropertyDTO(String propertyName, String propertyDescription, PropertyType propertyType, int totalCapacity,
			int noRooms, int noBathrooms, PropertyStatus status, boolean cancellation, double pricePerDay) {
		this.propertyName = propertyName;
		this.propertyDescription = propertyDescription;
		this.propertyType = propertyType;
		this.totalCapacity = totalCapacity;
		this.noRooms = noRooms;
		this.noBathrooms = noBathrooms;
		this.status = status;
		this.cancellation = cancellation;
		this.pricePerDay = pricePerDay;
	}
	
	
	public PropertyDTO(String propertyName, String propertyDescription, PropertyType propertyType, AddressDTO address,
			int totalCapacity, int noRooms, int noBathrooms, List<AmenitiesDTO> amenities, PropertyStatus status,
			boolean cancellation, double pricePerDay) {
		this.propertyName = propertyName;
		this.propertyDescription = propertyDescription;
		this.propertyType = propertyType;
		this.address = address;
		this.totalCapacity = totalCapacity;
		this.noRooms = noRooms;
		this.noBathrooms = noBathrooms;
		this.amenities = amenities;
		this.status = status;
		this.cancellation = cancellation;
		this.pricePerDay = pricePerDay;
	}
	public PropertyDTO() {}
}
