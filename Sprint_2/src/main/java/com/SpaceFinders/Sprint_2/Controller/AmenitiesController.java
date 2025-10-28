package com.SpaceFinders.Sprint_2.Controller;

import com.SpaceFinders.Sprint_2.DTO.AmenitiesDTO;
import com.SpaceFinders.Sprint_2.Service.AmenitiesService;
import com.SpaceFinders.Sprint_2.Utility.AmenityStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/amenities")
public class AmenitiesController {
//
//    @Autowired
//    private AmenitiesService amenitiesService;
//
//
//    @PostMapping
//    public ResponseEntity<String> createAmenity(@RequestBody AmenitiesDTO amenitiesDTO) {
//        return amenitiesService.createAmenity(amenitiesDTO);
//    }
//
//
//    @GetMapping
//    public List<AmenitiesDTO> getAllAmenities() {
//        return amenitiesService.getAllAmenities();
//    }
//
//
//    @GetMapping("/{id}")
//    public AmenitiesDTO getAmenityById(@PathVariable int id) {
//        return amenitiesService.getAmenityById(id);
//    }
//
//    @GetMapping("/status/{status}")
//    public List<AmenitiesDTO> getAmenitiesByStatus(@PathVariable AmenityStatus amenityStatus) {
//        return amenitiesService.getAmenitiesByStatus(amenityStatus);
//    }
//
//    @PutMapping("/{id}")
//    public AmenitiesDTO updateAmenity(@PathVariable int id, @RequestBody AmenitiesDTO amenitiesDTO) {
//        return amenitiesService.updateAmenity(id, amenitiesDTO);
//    }
//
//    // Update amenity status only
//    @PatchMapping("/{id}/status")
//    public AmenitiesDTO updateAmenityStatus(@PathVariable int id,
//                                            @RequestParam AmenityStatus amenityStatus) {
//        return amenitiesService.updateAmenityStatus(id, amenityStatus);
//    }
}