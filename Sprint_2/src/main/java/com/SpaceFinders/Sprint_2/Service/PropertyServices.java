package com.SpaceFinders.Sprint_2.Service;

import java.util.ArrayList;
import java.util.List;

import com.SpaceFinders.Sprint_2.Repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpaceFinders.Sprint_2.DTO.AmenitiesDTO;
import com.SpaceFinders.Sprint_2.DTO.PropertyDTO;
import com.SpaceFinders.Sprint_2.Entity.Address;
import com.SpaceFinders.Sprint_2.Entity.Amenities;
import com.SpaceFinders.Sprint_2.Entity.Property;
import com.SpaceFinders.Sprint_2.Utility.PropertyStatus;

@Service
public class PropertyServices {
	@Autowired
    PropertyRepository pr;

	public Property insertProperty(PropertyDTO p) {
		int hostId = 0;
		int rating = 0;
		Address address = new Address(
				p.getAddress().getBuilding_no(),
				p.getAddress().getStreet(),
				p.getAddress().getCity(),
				p.getAddress().getPostal_code(),
				p.getAddress().getCountry()
				);
		List<AmenitiesDTO> amenities = p.getAmenities();
		List<Amenities> amenities_list = new ArrayList<>();
		for (AmenitiesDTO i:amenities) {
			//amenities_list.add(new Amenities(i.getAmenityName(),i.getAmenityStatus()));
		}
				
		return pr.save(new Property(hostId,address,p.getPropertyName(),p.getPropertyDescription(),p.getPropertyType(),p.getTotalCapacity(),p.getNoRooms(),p.getNoBathrooms(),amenities_list,p.getStatus(),rating,p.isCancellation(),p.getPricePerDay()));
	}
    public Property getPropertyById(int id) {
        return pr.findById(id).orElse(null);
    }
    public Property updateProperty(int id, PropertyDTO p) {
        Property existing = pr.findById(id).orElse(null);
		Address address = new Address(
				p.getAddress().getBuilding_no(),
				p.getAddress().getStreet(),
				p.getAddress().getCity(),
				p.getAddress().getPostal_code(),
				p.getAddress().getCountry()
				);
        if (existing != null) {
            existing.setPropertyName(p.getPropertyName());
            existing.setPropertyDescription(p.getPropertyDescription());
            existing.setPropertyType(p.getPropertyType());
            existing.setAddress(address);
            existing.setTotalCapacity(p.getTotalCapacity());
            existing.setNoRooms(p.getNoRooms());
            existing.setNoBathrooms(p.getNoBathrooms());
            existing.setStatus(p.getStatus());
            existing.setCancellation(p.isCancellation());
            return pr.save(existing);
        }
        return null;
    }
    public Property updatePropertyStatus(int id, PropertyStatus status) {
        Property existing = pr.findById(id).orElse(null);
        if (existing != null) {
            existing.setStatus(status);
            return pr.save(existing);
        }
        return null;
    }
    
    public List<Property> viewPropertyByCountry(String country){
    	List<Property> properties = pr.findByStatusAvailableAndAddress_countryIgnoreCase(country);
    	return properties;
    }
    
    public List<Property> viewPropertyByCity(String city){
    	List<Property> properties = pr.findByAddress_cityIgnoreCase(city);
    	return properties;
    }
    
    public List<Property> viewAll(){
    	List<Property> properties = pr.findAll();
    	return properties;
    }
}
