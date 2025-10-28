package com.SpaceFinders.Sprint_2.Entity;

import java.util.List;

import com.SpaceFinders.Sprint_2.Utility.PropertyStatus;
import com.SpaceFinders.Sprint_2.Utility.PropertyType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "property")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int propertyId;

    private int hostId;//get from JSON
    
    @Column(nullable=false)
    private String propertyName;//UE
    @Column(nullable=false)
    private String propertyDescription;//UE

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private PropertyType propertyType;//UE
    
    @OneToOne(cascade = CascadeType.ALL) // saves automatically if not already saved
    @JoinColumn(name = "address_id", referencedColumnName = "address_id") // FK column 
    private Address address;//get from address after adding

    @PositiveOrZero(message="No of people the house can accomodate cannot be negative")
    @Column(nullable=false)
    private int totalCapacity;//UE
    @PositiveOrZero(message="No of rooms cannot be negative")
    @Column(nullable=false)
    private int noRooms;//UE
    @Positive(message="No of bathrooms cannot be negative")
    @Column(nullable=false)
    private int noBathrooms;//UE
    
    @ManyToMany(cascade = CascadeType.ALL) // saves automatically if not already saved
    @JoinTable(name = "propertyId", joinColumns = @JoinColumn(name="propertyId"), inverseJoinColumns = @JoinColumn(name="amenity_id")) // FK column 
    private List<Amenities> amenities;

    @Enumerated(EnumType.STRING)
    private PropertyStatus status;//UE

    private double rating;//default 0
    boolean cancellation;//UE
    @Positive(message="Price cannot be less than or equal to 0")
    @Column(nullable=false)
    double pricePerDay;
    
	public double getPricePerDay() {
		return pricePerDay;
	}
	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
	public int getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}
	public int getHostId() {
		return hostId;
	}
	public void setHostId(int hostId) {
		this.hostId = hostId;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
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
	
	public List<Amenities> getAmenities() {
		return amenities;
	}
	public void setAmenities(List<Amenities> amenities) {
		this.amenities = amenities;
	}
	public PropertyStatus getStatus() {
		return status;
	}
	public void setStatus(PropertyStatus status) {
		this.status = status;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public boolean isCancellation() {
		return cancellation;
	}
	public void setCancellation(boolean cancellation) {
		this.cancellation = cancellation;
	}
	public Property() {}
	public Property(int hostId, Address address, String propertyName, String propertyDescription,
			PropertyType propertyType, int totalCapacity, int noRooms, int noBathrooms, List<Amenities> amenities,
			PropertyStatus status, double rating, boolean cancellation, double pricePerDay) {
		this.hostId = hostId;
		this.address = address;
		this.propertyName = propertyName;
		this.propertyDescription = propertyDescription;
		this.propertyType = propertyType;
		this.totalCapacity = totalCapacity;
		this.noRooms = noRooms;
		this.noBathrooms = noBathrooms;
		this.amenities = amenities;
		this.status = status;
		this.rating = rating;
		this.cancellation = cancellation;
		this.pricePerDay = pricePerDay;
	}
}
