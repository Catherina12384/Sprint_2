package com.SpaceFinders.Sprint_2.Controller;

import com.SpaceFinders.Sprint_2.DTO.UserDTO;
import com.SpaceFinders.Sprint_2.Entity.Users;
import com.SpaceFinders.Sprint_2.Utility.GenerateOtp;
import com.SpaceFinders.Sprint_2.Utility.Hashing;
import com.SpaceFinders.Sprint_2.Utility.IpUtility;
import com.SpaceFinders.Sprint_2.Service.UserServices;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

@RestController
@RequestMapping("/v1/api/user")
public class UserController {

    @Autowired
    UserServices userServices;


    @GetMapping("/hi")
    String sayHi(){
        return "hi";
    }

    @PostMapping("/login")
    boolean userLogin(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password){
        return userServices.UserLoginServices(username, password);
    }

    @PostMapping("/signup")
    ResponseEntity<Users>  userSignup(@RequestBody UserDTO user){
        return new ResponseEntity<>(userServices.UserSignupServices(user), HttpStatus.OK);
    }

    @DeleteMapping("/deleteAccount")
    String deleteUser(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password){
        return userServices.UserDeleteServices(username, password);
    }

    @PutMapping("/updateUserDetails")
    String userDetailsUpdate(@RequestParam("username") String username, @RequestBody UserDTO userDto){
        return userServices.UserDetailsUpdate(username, userDto);
    }


    @GetMapping("/getOtp")
    String getOtp(HttpServletRequest request) throws IOException {
        String msg = "Your otp is: 4352";
        int port = 8089;
        String ipAddress = IpUtility.extractIp(request);
        System.out.println("Request form IP: " + ipAddress);
        if(IpUtility.sendOtp(ipAddress, port, msg, true) == 200) {
            return "OTP send successfully";
        }
        return "OTP send Failed";
    }

    @PostMapping("/forgetPassword")
    String forgetPassword(@RequestParam("username") String username, @RequestParam("newPassword") String newPassword){
        return userServices.UserForgetPasswordService(username, newPassword);
    }
}
