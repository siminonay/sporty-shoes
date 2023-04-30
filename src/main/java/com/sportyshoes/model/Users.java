package com.sportyshoes.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users {

    @Id
    private String email;  //PK

    private String password;

    private String userType;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "Users{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}
