package io.github.tambonbon.musicappspring.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {
    @Value("${app.version}")
    private String appVersion;

//    @GetMapping
    @RequestMapping("/")
    @ResponseBody // it's going to return its request body directly as a string
    public String index() {
        return  "Greetings";
    }

    // Login form
//    @RequestMapping("/login.html")
//    public String login() {
//        return "login.html";
//    }
//
//    // Login form with error
//    @RequestMapping("/login-error.html")
//    public String loginError(Model model) {
//        model.addAttribute("loginError", true);
//        return "login.html";
//    }

}
