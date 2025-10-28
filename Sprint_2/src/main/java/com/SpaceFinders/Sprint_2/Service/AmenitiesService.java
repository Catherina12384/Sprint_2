package com.SpaceFinders.Sprint_2.Service;

import com.SpaceFinders.Sprint_2.DTO.AmenitiesDTO;
import com.SpaceFinders.Sprint_2.Entity.Amenities;
import com.SpaceFinders.Sprint_2.Repository.AmenitiesRepository;
import com.SpaceFinders.Sprint_2.Utility.AlreadyExistsException;
import com.SpaceFinders.Sprint_2.Utility.AmenityStatus;
import com.SpaceFinders.Sprint_2.Utility.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AmenitiesService {
//
//    @Autowired
//    private AmenitiesRepository amenitiesRepository;
//
//    private AmenitiesDTO convertToDTO(Amenities amenity) {
//        AmenitiesDTO dto = new AmenitiesDTO();
//        dto.setAmenityName(amenity.getAmenityName());
//        dto.setAmenityStatus(amenity.getAmenityStatus());
//        return dto;
//    }
//
//    private List<AmenitiesDTO> convertToDTOList(List<Amenities> amenitiesList){
//        List<AmenitiesDTO> dtos = new ArrayList<>();
//        for(Amenities amenities: amenitiesList){
//            dtos.add(convertToDTO(amenities));
//        }
//        return dtos;
//    }
//
//    public ResponseEntity<String> createAmenity(AmenitiesDTO amenitiesDTO) {
//        // Check if amenity already exists
//        if (amenitiesRepository.existsByAmenityName(amenitiesDTO.getAmenityName())) {
//            throw new AlreadyExistsException("Amenity with name " + amenitiesDTO.getAmenityName() + " already exists");
//        }
//
//        Amenities amenity = new Amenities();
//        amenity.setAmenityName(amenitiesDTO.getAmenityName());
//        amenity.setAmenityStatus(amenitiesDTO.getAmenityStatus());
//
//        Amenities savedAmenity = amenitiesRepository.save(amenity);
//        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Amenity has been added successfully");
//    }
//
//    public List<AmenitiesDTO> getAllAmenities() {
//        return convertToDTOList(amenitiesRepository.findAll());
//    }
//
//
//    public AmenitiesDTO getAmenityById(int id) {
//        Optional<Amenities> amenity = amenitiesRepository.findById(id);
//        if (amenity.isPresent()) {
//            return convertToDTO(amenity.get());
//        } else {
//            throw new DataNotFoundException("Amenity not found with id: " + id);
//        }
//    }
//
//    public List<AmenitiesDTO> getAmenitiesByStatus(AmenityStatus amenityStatus) {
//        return convertToDTOList(amenitiesRepository.findByAmenityStatus(amenityStatus));
//    }
//
//    public AmenitiesDTO updateAmenity(int id, AmenitiesDTO amenitiesDTO) {
//        Optional<Amenities> existingAmenity = amenitiesRepository.findById(id);
//
//        if (existingAmenity.isPresent()) {
//            Amenities amenity = existingAmenity.get();
//            amenity.setAmenityName(amenitiesDTO.getAmenityName());
//            amenity.setAmenityStatus(amenitiesDTO.getAmenityStatus());
//            return convertToDTO(amenitiesRepository.save(amenity));
//        } else {
//            throw new DataNotFoundException("Amenity not found with id: " + id);
//        }
//    }
//
//    // Update amenity status
//    public AmenitiesDTO updateAmenityStatus(int id, AmenityStatus amenityStatus) {
//        Optional<Amenities> existingAmenity = amenitiesRepository.findById(id);
//
//        if (existingAmenity.isPresent()) {
//            Amenities amenity = existingAmenity.get();
//            amenity.setAmenityStatus(amenityStatus);
//
//            return convertToDTO(amenitiesRepository.save(amenity));
//        } else {
//            throw new DataNotFoundException("Amenity not found with id: " + id);
//        }
//    }
}