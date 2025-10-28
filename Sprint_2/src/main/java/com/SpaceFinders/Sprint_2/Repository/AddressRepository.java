package com.SpaceFinders.Sprint_2.Repository;

import com.SpaceFinders.Sprint_2.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> findByStreetIgnoreCase(String street);
    List<Address> findByCityIgnoreCase(String city);
    List<Address> findByCountryIgnoreCase(String country);
}
