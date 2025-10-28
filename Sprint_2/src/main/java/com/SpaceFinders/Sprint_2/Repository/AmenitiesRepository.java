package com.SpaceFinders.Sprint_2.Repository;

import com.SpaceFinders.Sprint_2.Entity.Amenities;
import com.SpaceFinders.Sprint_2.Utility.AmenityStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AmenitiesRepository extends JpaRepository<Amenities, Integer> {
    List<Amenities> findByAmenityStatus(AmenityStatus amenityStatus);
    //    AmenitiesDTO findAmenityName(String amenityName);
    boolean existsByAmenityName(String amenityName);
}
