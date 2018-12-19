package com.example.easynotes.controller;

import com.example.easynotes.model.Login;
import com.example.easynotes.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


/*
[BindingResult] is Spring’s object that holds the result of the validation and binding and contains errors that may
have occurred. The  BindingResult must come right after the model object that is validated or else Spring will fail
to validate the object and throw an exception.

When Spring sees @Valid, it tries to find the validator for the object being validated. Spring automatically picks
 up validation annotations if you have “annotation-driven” enabled. Spring then invokes the validator and puts any
 errors in the BindingResult and adds the BindingResult to the view model.
 */

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showForm(Login login) {
        return "login";
    }

    @Autowired
    public LoginRepository loginRepository;

    @PostMapping("/login")
    public String validateLoginInfo(Model model, @Valid Login login, BindingResult bindingResult) {

        System.out.println("Inside Login Controller");

        Login validLogin = loginRepository.findByUserNameAndPassword(login.getUserName(), login.getPassword());

        if ( validLogin != null ) {
            System.out.println("result found");
        }

        if (bindingResult.hasErrors()) {
            return "login";
        }
        model.addAttribute("user", login.getUserName());
        return "home";
    }

}
