package com.SpaceFinders.Sprint_2.Service;


import com.SpaceFinders.Sprint_2.DTO.UserDTO;
import com.SpaceFinders.Sprint_2.Entity.UserStatusEnum;
import com.SpaceFinders.Sprint_2.Entity.Users;
import com.SpaceFinders.Sprint_2.Repository.UserRepository;
import com.SpaceFinders.Sprint_2.Utility.GenerateOtp;
import com.SpaceFinders.Sprint_2.Utility.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Service
public class UserServices {

    @Autowired
    UserRepository userRepository;

    public boolean UserLoginServices(String username, String password){
        Optional<Users> temp = userRepository.findByUserName(username);
        if(temp.isPresent()) {
            Users user = temp.get();
            return (username).equals(user.getUserName()) && Hashing.decryptPassword(password, user.getPasswordHash());
        }
        return false;
    }

    public Users UserSignupServices(UserDTO user){
//        System.out.println("UserName: " + user.getUserName() + " Email: " + user.getEmail() + " PasswordHash: " + user.getPasswordHash() + " First_name: " + user.getFirst_name() + " Last_name: " + user.getLast_name() + " MobileNumber: " + user.getMobileNumber() + " UserType: " + user.getUserType() + " Status: " + user.getStatus() + " Rating: " + user.getRating());
        if(!isUserAlreadyExists(user)) {
            return userRepository.save(new Users(user.getUserName(), user.getEmail(), Hashing.encryptPassword(user.getPasswordHash()), user.getFirst_name(), user.getLast_name(), user.getMobileNumber(), user.getUserType(), user.getStatus(), user.getRating()));
        }
        System.out.println("User Already Exists");
        return null;
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

    public Optional<Users> findUserByUserName(UserDTO userDTO){
        return userRepository.findByUserName(userDTO.getUserName());
    }

    public Optional<Users> findUserByUserName(String username){
        return userRepository.findByUserName(username);
    }
    public String UserDeleteServices(String username, String password) {
        Optional<Users> temp = userRepository.findByUserName(username);
        if(temp.isPresent()) {
            Users user = temp.get();
            if(Hashing.decryptPassword(password, user.getPasswordHash())){
                user.setStatus(UserStatusEnum.INACTIVE);
                UserDetailsUpdate(username, new UserDTO(user.getUserName(), user.getEmail(), Hashing.encryptPassword(user.getPasswordHash()), user.getFirst_name(), user.getLast_name(), user.getMobileNumber(), user.getUserType(), user.getStatus(), user.getRating()));
                return "Deleted";
            }
        }
        return "ERROR";
    }

    public String UserDetailsUpdate(@RequestParam("username") String username, UserDTO userDto) {
        Optional<Users> user = userRepository.findByUserName(username);
        if(user.isPresent()) {
            System.out.println(user.get().getUserName());
            Users updateUser = user.get();
            updateUser.setUserName(userDto.getUserName());
            updateUser.setEmail(userDto.getEmail());
            updateUser.setPasswordHash(Hashing.encryptPassword(userDto.getPasswordHash()));
            updateUser.setFirst_name(userDto.getFirst_name());
            updateUser.setLast_name(userDto.getLast_name());
            updateUser.setMobileNumber(userDto.getMobileNumber());
            updateUser.setUserType(userDto.getUserType());
            updateUser.setStatus(userDto.getStatus());
            updateUser.setRating(userDto.getRating());


            System.out.println("UserName: " + updateUser.getUserName() + " Email: " + updateUser.getEmail() + " PasswordHash: " + updateUser.getPasswordHash() + " First_name: " + updateUser.getFirst_name() + " Last_name: " + updateUser.getLast_name() + " MobileNumber: " + updateUser.getMobileNumber() + " UserType: " + updateUser.getUserType() + " Status: " + updateUser.getStatus() + " Rating: " + updateUser.getRating());

            userRepository.save(updateUser);
            return "Updated";
        }
        return "Not Updated";
    }

    public String UserForgetPasswordService(String username, String newPassword){
        Optional<Users> user = userRepository.findByUserName(username);
        if(user.isPresent()){

            Scanner s = new Scanner(System.in);
            if((GenerateOtp.GenerateNDigitRandomNumber(4) == s.nextInt())){
                user.get().setPasswordHash(Hashing.encryptPassword(newPassword));
                userRepository.save(user.get());
                return "Password Updated";
            }
            return "Password Not Updated {Wrong OTP}";
        }
        return "Password Not Updated {No User Found}";
    }
}
