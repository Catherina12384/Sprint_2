package com.SpaceFinders.Sprint_2.Service;


import com.SpaceFinders.Sprint_2.DTO.UserDTO;
import com.SpaceFinders.Sprint_2.Entity.UserStatusEnum;
import com.SpaceFinders.Sprint_2.Entity.Users;
import com.SpaceFinders.Sprint_2.Repository.UserRepository;
import com.SpaceFinders.Sprint_2.Utility.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Service
public class UserServices {

    @Autowired
    UserRepository userRepository;

    public ResponseEntity<String> UserLoginServices(String username, String password){
        Optional<Users> temp = userRepository.findByUserName(username);

        if(temp.isEmpty()) {
            throw new UserNotFoundException("User not found with username: " + username);
        }

        Users user = temp.get();

        // Check if user is blocked
        if(user.getStatus() == UserStatusEnum.BLOCKED) {
            throw new UserBlockedException("User account is blocked. Please contact support.");
        }

        // Check if user is inactive
        if(user.getStatus() == UserStatusEnum.INACTIVE) {
            throw new UserBlockedException("User account is inactive. Please contact support.");
        }

        // Validate password
        if(!Hashing.decryptPassword(password, user.getPasswordHash())) {
            throw new InvalidCredentialsException("Invalid password");
        }

        return ResponseEntity.ok("Login successful");
    }

    public ResponseEntity<Users> UserSignupServices(UserDTO user){
        if(isUserAlreadyExists(user)) {
            throw new AlreadyExistsException("User already exists with provided username, email, or mobile number");
        }

        Users savedUser = userRepository.save(new Users(
                user.getUserName(),
                user.getEmail(),
                Hashing.encryptPassword(user.getPasswordHash()),
                user.getFirst_name(),
                user.getLast_name(),
                user.getMobileNumber(),
                user.getUserType(),
                user.getStatus(),
                user.getRating()
        ));

        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    boolean isUserAlreadyExists(UserDTO userDto){
        Users exampleUser = new Users();
        exampleUser.setUserName(userDto.getUserName());
        exampleUser.setEmail(userDto.getEmail());
        exampleUser.setMobileNumber(userDto.getMobileNumber());
        ExampleMatcher matcher = ExampleMatcher.matchingAny().withIgnoreCase();
        Example<Users> example = Example.of(exampleUser, matcher);

        return userRepository.exists(example);
    }

    public Optional<Users> findUserByUserName(String username){
        return userRepository.findByUserName(username);
    }

    public ResponseEntity<Users> findUserByEmail(String email){
        Optional<Users> user = userRepository.findByEmail(email);

        if(user.isEmpty()) {
            throw new UserNotFoundException("User not found with email: " + email);
        }

        return ResponseEntity.ok(user.get());
    }

    public ResponseEntity<Users> findUserByMobileNumber(String mobileNumber){
        Optional<Users> user = userRepository.findByMobileNumber(mobileNumber);

        if(user.isEmpty()) {
            throw new UserNotFoundException("User not found with mobile number: " + mobileNumber);
        }

        return ResponseEntity.ok(user.get());
    }

    public ResponseEntity<String> UserDeleteServices(String username, String password) {
        Optional<Users> temp = userRepository.findByUserName(username);

        if(temp.isEmpty()) {
            throw new UserNotFoundException("User not found with username: " + username);
        }

        Users user = temp.get();

        if(!Hashing.decryptPassword(password, user.getPasswordHash())){
            throw new InvalidCredentialsException("Invalid password. Cannot delete account.");
        }

        user.setStatus(UserStatusEnum.INACTIVE);
        UserDetailsUpdate(username, new UserDTO(
                user.getUserName(),
                user.getEmail(),
                user.getPasswordHash(), // Already hashed
                user.getFirst_name(),
                user.getLast_name(),
                user.getMobileNumber(),
                user.getUserType(),
                user.getStatus(),
                user.getRating()
        ));

        return ResponseEntity.ok("Account successfully deactivated");
    }

    public ResponseEntity<String> UserDetailsUpdate(@RequestParam("username") String username, UserDTO userDto) {
        Optional<Users> user = userRepository.findByUserName(username);

        if(user.isEmpty()) {
            throw new UserNotFoundException("User not found with username: " + username);
        }

        Users updateUser = user.get();
        updateUser.setUserName(userDto.getUserName());
        updateUser.setEmail(userDto.getEmail());

        // Only encrypt if it's a new password (not already hashed)
        if(userDto.getPasswordHash() != null && !userDto.getPasswordHash().startsWith("$2a$")) {
            updateUser.setPasswordHash(Hashing.encryptPassword(userDto.getPasswordHash()));
        } else {
            updateUser.setPasswordHash(userDto.getPasswordHash());
        }

        updateUser.setFirst_name(userDto.getFirst_name());
        updateUser.setLast_name(userDto.getLast_name());
        updateUser.setMobileNumber(userDto.getMobileNumber());
        updateUser.setUserType(userDto.getUserType());
        updateUser.setStatus(userDto.getStatus());
        updateUser.setRating(userDto.getRating());

        userRepository.save(updateUser);
        return ResponseEntity.ok("User details updated successfully");
    }

    public ResponseEntity<String> UserForgetPasswordService(String username, String newPassword){
        Optional<Users> user = userRepository.findByUserName(username);

        if(user.isEmpty()){
            throw new UserNotFoundException("User not found with username: " + username);
        }

        Scanner s = new Scanner(System.in);
        int enteredOtp = s.nextInt();
        int generatedOtp = GenerateOtp.GenerateNDigitRandomNumber(4);

        if(generatedOtp != enteredOtp){
            throw new InvalidOtpException("Invalid OTP. Password reset failed.");
        }

        user.get().setPasswordHash(Hashing.encryptPassword(newPassword));
        userRepository.save(user.get());
        return ResponseEntity.ok("Password updated successfully");
    }
}
