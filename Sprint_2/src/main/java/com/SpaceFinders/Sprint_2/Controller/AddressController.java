package com.SpaceFinders.Sprint_2.Controller;

import com.SpaceFinders.Sprint_2.DTO.AddressDTO;
import com.SpaceFinders.Sprint_2.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/property/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping("/addAddress")
    public ResponseEntity<String> addAddress(@RequestBody AddressDTO dto) {
        return addressService.addAddress(dto);
    }

    @PutMapping("/updateAddress/{address_id}")
    public ResponseEntity<AddressDTO> updateAddress(@PathVariable int address_id, @RequestBody AddressDTO addressDTO) {
        return addressService.updateAddress(address_id, addressDTO);
    }

    @DeleteMapping("/deleteAddress/{address_id}")
    public ResponseEntity<String> deleteAddress(@PathVariable int address_id) {
        return addressService.deleteAddress(address_id);
    }

    @GetMapping("/findAddressById/{address_id}")
    public ResponseEntity<AddressDTO> findAddressById(@PathVariable int address_id) {
        return addressService.findAddressById(address_id);
    }

    @GetMapping("/findAllAddressByStreet/{street}")
    public ResponseEntity<List<AddressDTO>> findAllAddressByStreet(@PathVariable String street) {
        return addressService.findByStreetIgnoreCase(street);
    }

    @GetMapping("/findAllAddressByCity/{city}")
    public ResponseEntity<List<AddressDTO>> findAllAddressByCity(@PathVariable String city) {
        return addressService.findByCityIgnoreCase(city);
    }

    @GetMapping("/findAllAddressByCountry/{country}")
    public ResponseEntity<List<AddressDTO>> findAllAddressByCountry(@PathVariable String country) {
        return addressService.findByCountryIgnoreCase(country);
    }

    @GetMapping("/viewAllAddress")
    public ResponseEntity<List<AddressDTO>> viewAllAddress() {
        return addressService.viewAllAddress();
    }
}

