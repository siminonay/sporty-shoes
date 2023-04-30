package com.sportyshoes.controller;

import com.sportyshoes.model.Users;
import com.sportyshoes.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String open(Model model, Users users) {
        model.addAttribute("users", users);
        return "index";
    }

    @RequestMapping(value = "/openSignUp", method = RequestMethod.GET)
    public String openSignUp(Model model, Users users) {
        model.addAttribute("users", users);
        return "signUp";
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String signIn(Model model, Users users, HttpSession session) {
        String result = loginService.signIn(users);
        if (result.equals("Customer login is successful.")) {
            session.setAttribute("email", users.getEmail());
            return "customerHome";
        } else if (result.equals("Admin login is successful.")) {
            session.setAttribute("email", users.getEmail());
            return "adminHome";
        } else {
            return "index";
        }
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String signUp(Model model, Users users) {
        String result = loginService.signUp(users);
        model.addAttribute("users", users);
        System.out.println(result);
        return "index";
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.GET)
    public String changePassword(HttpSession session, Model model) {
        String ea = (String) session.getAttribute("email");
        Users users = loginService.getAdminInfo(ea);
        model.addAttribute("users", users);
        return "changePassword";
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    public String updatePassword(@RequestParam(name="oldPassword") String oldPassword,@RequestParam(name="newPassword") String newPassword, HttpSession session, Model model) {
        String ea = (String) session.getAttribute("email");
        Users users = loginService.getAdminInfo(ea);
        if (oldPassword.equals(users.getPassword())) {
            users.setPassword(newPassword);
            loginService.updatePassword(users);
            model.addAttribute("action", "Password changed successfully!");
            return "adminHome";
        } else {
            model.addAttribute("action", "Old password is not matching.");
            return "changePassword";
        }
    }

    @RequestMapping(value = "/viewCustomersPage", method = RequestMethod.GET)
    public String viewCustomers(Model model, Users users) {
        List<Users> usersList = loginService.getCustomers();
        model.addAttribute("users", usersList);
        return "viewCustomers";
    }


}
