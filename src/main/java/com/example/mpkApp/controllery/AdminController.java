package com.example.mpkApp.controllery;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/login")
    public String login() {
        return "forward:/login.html";  // Zwróć nazwę pliku statycznego
    }

    @GetMapping("/adminStrona")
    public String adminPage() {
        return "forward:/adminStrona.html";  // Zwróć nazwę pliku statycznego
    }
}

