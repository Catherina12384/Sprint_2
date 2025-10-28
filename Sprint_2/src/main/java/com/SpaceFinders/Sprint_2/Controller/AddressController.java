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
    public ResponseEntity<String> addAddress(@RequestBody AddressDTO dto){
        return addressService.addAddress(dto);
    }

    @PutMapping("/updateAddress/{address_id}")
    public AddressDTO updateAddress(@PathVariable int address_id, @RequestBody AddressDTO addressDTO){
        return addressService.updateAddress(address_id, addressDTO);
    }

    @DeleteMapping("/deleteAddress/{address_id}")
    public ResponseEntity<String> deleteAddress(@PathVariable int address_id){
        return addressService.deleteAddress(address_id);
    }

    @GetMapping("/findAddressById")
    public AddressDTO findAddressById(int address_id){
        return addressService.findAddressById(address_id);
    }

    @GetMapping("/findAllAddressByStreet")
    public List<AddressDTO> findAllAddressByStreet(String street){
        return addressService.findByStreetIgnoreCase(street);
    }

    @GetMapping("/findAllAddressByCity")
    public List<AddressDTO> findAllAddressByCity(String city){
        return addressService.findByCityIgnoreCase(city);
    }

    @GetMapping("/findAllAddressByCountry")
    public List<AddressDTO> findAllAddressByCountry(String country){
        return addressService.findByCountryIgnoreCase(country);
    }

    @GetMapping("/viewAllAddress")
    public List<AddressDTO> viewAllAddress(){
        return addressService.viewAllAddress();
    }
}

