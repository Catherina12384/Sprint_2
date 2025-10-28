package com.SpaceFinders.Sprint_2.Service;

import com.SpaceFinders.Sprint_2.DTO.AddressDTO;
import com.SpaceFinders.Sprint_2.Entity.Address;
import com.SpaceFinders.Sprint_2.Repository.AddressRepository;
import com.SpaceFinders.Sprint_2.Utility.AddressNotFoundException;
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

    public ResponseEntity<String> addAddress(AddressDTO dto){
        Address address = convertToEntity(dto);
        addressRepository.save(address);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Address has been added successfully");
    }

    public AddressDTO updateAddress(int address_id, AddressDTO dto){
        Optional<Address> addressDetails = addressRepository.findById(address_id);
        if(addressDetails.isPresent()){
            Address address = addressDetails.get();
            address.setBuilding_no(dto.getBuilding_no());
            address.setStreet(dto.getStreet());
            address.setCity(dto.getCity());
            address.setCountry(dto.getCountry());
            address.setPostal_code(dto.getPostal_code());

            Address updatedAddress = addressRepository.save(address);
            return convertToDTO(updatedAddress);
        }
        else throw new AddressNotFoundException("Address Not Found for id " + address_id +" to update");
    }

    public ResponseEntity<String> deleteAddress(int address_id){
        if(addressRepository.existsById(address_id)){
            addressRepository.deleteById(address_id);
            return ResponseEntity.status(HttpStatus.FOUND).body("The address has been deleted successfully");
        }
        else throw new AddressNotFoundException("Unable to delete id " + address_id);
    }

    public List<AddressDTO> viewAllAddress(){
        return convertToDTOList(addressRepository.findAll());
    }

    public AddressDTO findAddressById(int address_id){
        Optional<Address> address= addressRepository.findById(address_id);
        if (address.isPresent()){
            return convertToDTO(address.get());
        }
        else throw new AddressNotFoundException("Address " + address_id + "not Found");
    }

    public List<AddressDTO> findByStreetIgnoreCase(String street){
        List<Address> address = addressRepository.findByStreetIgnoreCase(street);
        return convertToDTOList(address);
    }

    public List<AddressDTO> findByCityIgnoreCase(String city){
        List<Address> address = addressRepository.findByCityIgnoreCase(city);
        return convertToDTOList(address);
    }

    public List<AddressDTO> findByCountryIgnoreCase(String country){
        List<Address> address = addressRepository.findByCountryIgnoreCase(country);
        return convertToDTOList(address);
    }
}
