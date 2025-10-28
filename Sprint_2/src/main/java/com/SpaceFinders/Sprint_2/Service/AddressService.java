package com.SpaceFinders.Sprint_2.Service;

import com.SpaceFinders.Sprint_2.DTO.AddressDTO;
import com.SpaceFinders.Sprint_2.Entity.Address;
import com.SpaceFinders.Sprint_2.Repository.AddressRepository;
import com.SpaceFinders.Sprint_2.Utility.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    private Address convertToEntity (AddressDTO dto){
        Address address = new Address();
        address.setBuilding_no(dto.getBuilding_no());
        address.setStreet(dto.getStreet());
        address.setCity(dto.getCity());
        address.setCountry(dto.getCountry());
        address.setPostal_code(dto.getPostal_code());
        return address;
    }

    private AddressDTO convertToDTO (Address add){
        AddressDTO dto = new AddressDTO();
        dto.setBuilding_no(add.getBuilding_no());
        dto.setStreet(add.getStreet());
        dto.setCity(add.getCity());
        dto.setCountry(add.getCountry());
        dto.setPostal_code(add.getPostal_code());
        return dto;
    }

    private List<AddressDTO> convertToDTOList(List<Address> addressList){
        List<AddressDTO> dtos = new ArrayList<>();
        for(Address address : addressList){
            dtos.add(convertToDTO(address));
        }
        return dtos;
    }

    public ResponseEntity<String> addAddress(AddressDTO dto) {
        Address address = convertToEntity(dto);
        addressRepository.save(address);
        return ResponseEntity.status(HttpStatus.CREATED).body("Address has been added successfully");
    }

    public ResponseEntity<AddressDTO> updateAddress(int address_id, AddressDTO dto) {
        Optional<Address> addressDetails = addressRepository.findById(address_id);
        if (addressDetails.isPresent()) {
            Address address = addressDetails.get();
            address.setBuilding_no(dto.getBuilding_no());
            address.setStreet(dto.getStreet());
            address.setCity(dto.getCity());
            address.setCountry(dto.getCountry());
            address.setPostal_code(dto.getPostal_code());

            Address updatedAddress = addressRepository.save(address);
            return ResponseEntity.ok(convertToDTO(updatedAddress));
        } else {
            throw new DataNotFoundException("Address not found for id " + address_id + " to update");
        }
    }

    public ResponseEntity<String> deleteAddress(int address_id) {
        if (addressRepository.existsById(address_id)) {
            addressRepository.deleteById(address_id);
            return ResponseEntity.ok("The address has been deleted successfully");
        } else {
            throw new DataNotFoundException("Unable to delete address with id " + address_id);
        }
    }

    public ResponseEntity<List<AddressDTO>> viewAllAddress() {
        List<AddressDTO> addressList = convertToDTOList(addressRepository.findAll());
        if (addressList.isEmpty()) {
            throw new DataNotFoundException("No addresses found in the system");
        }
        return ResponseEntity.ok(addressList);
    }

    public ResponseEntity<AddressDTO> findAddressById(int address_id) {
        Optional<Address> address = addressRepository.findById(address_id);
        if (address.isPresent()) {
            return ResponseEntity.ok(convertToDTO(address.get()));
        } else {
            throw new DataNotFoundException("Address with id " + address_id + " not found");
        }
    }

    public ResponseEntity<List<AddressDTO>> findByStreetIgnoreCase(String street) {
        List<Address> addressList = addressRepository.findByStreetIgnoreCase(street);
        if (addressList.isEmpty()) {
            throw new DataNotFoundException("No addresses found for street: " + street);
        }
        return ResponseEntity.ok(convertToDTOList(addressList));
    }

    public ResponseEntity<List<AddressDTO>> findByCityIgnoreCase(String city) {
        List<Address> addressList = addressRepository.findByCityIgnoreCase(city);
        if (addressList.isEmpty()) {
            throw new DataNotFoundException("No addresses found for city: " + city);
        }
        return ResponseEntity.ok(convertToDTOList(addressList));
    }

    public ResponseEntity<List<AddressDTO>> findByCountryIgnoreCase(String country) {
        List<Address> addressList = addressRepository.findByCountryIgnoreCase(country);
        if (addressList.isEmpty()) {
            throw new DataNotFoundException("No addresses found for country: " + country);
        }
        return ResponseEntity.ok(convertToDTOList(addressList));
    }
}
