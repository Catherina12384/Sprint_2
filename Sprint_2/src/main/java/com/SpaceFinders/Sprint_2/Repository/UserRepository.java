package com.SpaceFinders.Sprint_2.Repository;

import com.SpaceFinders.Sprint_2.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {


    Optional<Users> findByUserName(String username);
    Optional<Users> findByEmail(String email);

    Optional<Users> findByMobileNumber(String mobileNumber);
}
