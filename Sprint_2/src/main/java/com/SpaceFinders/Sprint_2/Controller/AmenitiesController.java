package com.SpaceFinders.Sprint_2.Controller;

import com.SpaceFinders.Sprint_2.DTO.AmenitiesDTO;
import com.SpaceFinders.Sprint_2.Service.AmenitiesService;
import com.SpaceFinders.Sprint_2.Utility.AmenityStatus;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/amenities")
public class AmenitiesController {
    @Autowired
    private AmenitiesService amenitiesService;

    @PostMapping
    public ResponseEntity<String> createAmenity(@Valid @RequestBody AmenitiesDTO amenitiesDTO) {
        return amenitiesService.createAmenity(amenitiesDTO);
    }

    @GetMapping
    public ResponseEntity<List<AmenitiesDTO>> getAllAmenities() {
        return amenitiesService.getAllAmenities();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AmenitiesDTO> getAmenityById(@PathVariable int id) {
        return amenitiesService.getAmenityById(id);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<AmenitiesDTO> getAmenityByName(@PathVariable String name) {
        return amenitiesService.getAmenityByName(name);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<AmenitiesDTO>> getAmenitiesByStatus(@PathVariable boolean status) {
        return amenitiesService.getAmenitiesByStatus(status);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AmenitiesDTO> updateAmenity(@PathVariable int id, @Valid @RequestBody AmenitiesDTO amenitiesDTO) {
        return amenitiesService.updateAmenity(id, amenitiesDTO);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<AmenitiesDTO> updateAmenityStatus(@PathVariable int id, @RequestParam boolean status) {
        return amenitiesService.updateAmenityStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAmenity(@PathVariable int id) {
        return amenitiesService.deleteAmenity(id);
    }
}