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

    @Autowired
    private AmenitiesRepository amenitiesRepository;

    private AmenitiesDTO convertToDTO(Amenities amenity) {
        return new AmenitiesDTO(amenity.getAmenityName(), amenity.isAmenityStatus());
    }

    private Amenities convertToEntity(AmenitiesDTO dto) {
        return new Amenities(dto.getAmenityName(), dto.isAmenityStatus());
    }

    private List<AmenitiesDTO> convertToDTOList(List<Amenities> amenitiesList) {
        List<AmenitiesDTO> dtos = new ArrayList<>();
        for (Amenities amenities : amenitiesList) {
            dtos.add(convertToDTO(amenities));
        }
        return dtos;
    }

    public ResponseEntity<String> createAmenity(AmenitiesDTO amenitiesDTO) {
        // Check if amenity already exists
        if (amenitiesRepository.existsByAmenityNameIgnoreCase(amenitiesDTO.getAmenityName())) {
            throw new AlreadyExistsException("Amenity with name '" + amenitiesDTO.getAmenityName() + "' already exists");
        }

        Amenities amenity = convertToEntity(amenitiesDTO);
        amenitiesRepository.save(amenity);
        return ResponseEntity.status(HttpStatus.CREATED).body("Amenity has been added successfully");
    }

    public ResponseEntity<List<AmenitiesDTO>> getAllAmenities() {
        List<Amenities> amenitiesList = amenitiesRepository.findAll();
        if (amenitiesList.isEmpty()) {
            throw new DataNotFoundException("No amenities found in the system");
        }
        return ResponseEntity.ok(convertToDTOList(amenitiesList));
    }

    public ResponseEntity<AmenitiesDTO> getAmenityById(int id) {
        Optional<Amenities> amenity = amenitiesRepository.findById(id);
        if (amenity.isPresent()) {
            return ResponseEntity.ok(convertToDTO(amenity.get()));
        } else {
            throw new DataNotFoundException("Amenity not found with id: " + id);
        }
    }

    public ResponseEntity<AmenitiesDTO> getAmenityByName(String name) {
        Optional<Amenities> amenity = amenitiesRepository.findByAmenityNameIgnoreCase(name);
        if (amenity.isPresent()) {
            return ResponseEntity.ok(convertToDTO(amenity.get()));
        } else {
            throw new DataNotFoundException("Amenity not found with name: " + name);
        }
    }

    public ResponseEntity<List<AmenitiesDTO>> getAmenitiesByStatus(boolean status) {
        List<Amenities> amenitiesList = amenitiesRepository.findByAmenityStatus(status);
        if (amenitiesList.isEmpty()) {
            throw new DataNotFoundException("No amenities found with status: " + (status ? "active" : "inactive"));
        }
        return ResponseEntity.ok(convertToDTOList(amenitiesList));
    }

    public ResponseEntity<AmenitiesDTO> updateAmenity(int id, AmenitiesDTO amenitiesDTO) {
        Optional<Amenities> existingAmenity = amenitiesRepository.findById(id);

        if (existingAmenity.isPresent()) {
            Amenities amenity = existingAmenity.get();

            // Check if new name already exists (and it's not the same amenity)
            if (amenitiesRepository.existsByAmenityNameIgnoreCase(amenitiesDTO.getAmenityName())) {
                Optional<Amenities> duplicateCheck = amenitiesRepository.findByAmenityNameIgnoreCase(amenitiesDTO.getAmenityName());
                if (duplicateCheck.isPresent() && duplicateCheck.get().getAmenity_id() != id) {
                    throw new AlreadyExistsException("Amenity with name '" + amenitiesDTO.getAmenityName() + "' already exists");
                }
            }

            amenity.setAmenityName(amenitiesDTO.getAmenityName());
            amenity.setAmenityStatus(amenitiesDTO.isAmenityStatus());
            Amenities updatedAmenity = amenitiesRepository.save(amenity);
            return ResponseEntity.ok(convertToDTO(updatedAmenity));
        } else {
            throw new DataNotFoundException("Amenity not found with id: " + id);
        }
    }

    public ResponseEntity<AmenitiesDTO> updateAmenityStatus(int id, boolean status) {
        Optional<Amenities> existingAmenity = amenitiesRepository.findById(id);

        if (existingAmenity.isPresent()) {
            Amenities amenity = existingAmenity.get();
            amenity.setAmenityStatus(status);
            Amenities updatedAmenity = amenitiesRepository.save(amenity);
            return ResponseEntity.ok(convertToDTO(updatedAmenity));
        } else {
            throw new DataNotFoundException("Amenity not found with id: " + id);
        }
    }

    public ResponseEntity<String> deleteAmenity(int id) {
        if (amenitiesRepository.existsById(id)) {
            amenitiesRepository.deleteById(id);
            return ResponseEntity.ok("Amenity has been deleted successfully");
        } else {
            throw new DataNotFoundException("Amenity not found with id: " + id);
        }
    }
}