package io.github.tambonbon.musicappspring.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Value("${app.version}")
    private String appVersion;

//    @GetMapping
    @RequestMapping("/")
    public String index() {
        return  "Greetings";
    }
}
