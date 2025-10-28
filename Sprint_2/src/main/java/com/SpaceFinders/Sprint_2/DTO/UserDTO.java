package com.SpaceFinders.Sprint_2.DTO;

import com.SpaceFinders.Sprint_2.Entity.UserTypeEnum;
import com.SpaceFinders.Sprint_2.Entity.UserStatusEnum;


public class UserDTO {
    String userName;
    String email;
    String passwordHash;
    String first_name;
    String last_name;
    String mobileNumber;
    UserTypeEnum userType;
    UserStatusEnum status;
    float rating;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public UserTypeEnum getUserType() {
        return userType;
    }

    public void setUserType(UserTypeEnum userType) {
        this.userType = userType;
    }

    public UserStatusEnum getStatus() {
        return status;
    }

    public void setStatus(UserStatusEnum status) {
        this.status = status;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public UserDTO(String userName, String email, String passwordHash, String first_name, String last_name, String mobileNumber, UserTypeEnum userType, UserStatusEnum status, float rating) {
        this.userName = userName;
        this.email = email;
        this.passwordHash = passwordHash;
        this.first_name = first_name;
        this.last_name = last_name;
        this.mobileNumber = mobileNumber;
        this.userType = userType;
        this.status = status;
        this.rating = rating;
    }

    public UserDTO(){
    }
}
