package com.SpaceFinders.Sprint_2.Repository;

import com.SpaceFinders.Sprint_2.Entity.Amenities;
import com.SpaceFinders.Sprint_2.Utility.AmenityStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AmenitiesRepository extends JpaRepository<Amenities, Integer> {
    boolean existsByAmenityNameIgnoreCase(String amenityName);
    Optional<Amenities> findByAmenityNameIgnoreCase(String amenityName);
    List<Amenities> findByAmenityStatus(boolean amenityStatus);
}
