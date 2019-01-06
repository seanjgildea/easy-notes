package com.example.easynotes.controller;

import com.example.easynotes.exception.EmailExistsException;
import com.example.easynotes.model.Login;
import com.example.easynotes.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
public class IndexController {

    @Autowired
    RestTemplate restTemplate;

    Logger logger = LoggerFactory.getLogger(IndexController.class);

    @GetMapping("/login")
    public String showForm(Login login) {

        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");



        return "login";
    }


    @RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {



        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/user/register")
    public String showRegistrationForm(WebRequest request, Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    /*
    @PostMapping("/user/register")
    public ModelAndView registerUserAccount(
            @ModelAttribute("user") @Valid User accountDto,
            BindingResult result, WebRequest request, Errors errors) {

        User user = new User();
        if (!result.hasErrors()) {
            //user = createUserAccount(accountDto, result);
        }
        if (user == null) {
            result.rejectValue("email", "message.regError");
        }
    }

    /*
    private User createUserAccount(User accountDto, BindingResult result) {
        User registered = null;
        try {
            registered = service.registerNewUserAccount(accountDto);
        } catch (EmailExistsException e) {
            return null;
        }
        return registered;
    } */

}
