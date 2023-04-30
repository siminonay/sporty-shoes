package com.sportyshoes.service;

import com.sportyshoes.model.Users;
import com.sportyshoes.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    LoginRepository loginRepository;

    public String signUp(Users usersModel) {
        if(usersModel.getUserType().equalsIgnoreCase("admin")) {
            return "Admin account cannot created!";
        } else {
            Optional<Users> result = loginRepository.findById(usersModel.getEmail());
            if (result.isPresent()) {
                return "Account is already exists!";
            } else {
                loginRepository.save(usersModel);
                return "Account created successfully.";
            }

        }
    }

    public String signIn(Users usersModel) {
        Users users = loginRepository.signIn(usersModel.getEmail(), usersModel.getPassword(), usersModel.getUserType());
        if(users == null) {
            return "Email or password is invalid!";
        } else {
            if(users.getUserType().equalsIgnoreCase("admin")) {
                return "Admin login is successful.";
            } else {
                return "Customer login is successful.";
            }
        }
    }

    public Users getAdminInfo(String email) {
        return loginRepository.findByEmail(email);
    }

    public List<Users> getCustomers() {
        return loginRepository.findAll();
    }

    public void updatePassword(Users usersModel) {
        loginRepository.save(usersModel);
    }

}
