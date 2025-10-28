package com.SpaceFinders.Sprint_2.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpaceFinders.Sprint_2.Entity.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer>{
	List<Property> findByStatusAvailableAndAddress_countryIgnoreCase(String country);
	List<Property> findByAddress_cityIgnoreCase(String city);
}
