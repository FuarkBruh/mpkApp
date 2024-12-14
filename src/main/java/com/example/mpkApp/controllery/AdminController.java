package com.example.mpkApp.controllery;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/login")
    public String login() {
        return "forward:/login.html";  //
    }

    @GetMapping("/adminStrona")
    public String adminPage() {
        return "forward:/adminStrona.html";
    }

    @GetMapping("/zarzadzaniePojazdami")
    public String zarzadzaniePojazdami() {
        return "forward:/zarzadzaniePojazdami.html";
    }

    @GetMapping("/glowna")
    public String glowna() {
        return "forward:/glowna.html";
    }

    @GetMapping("/logoutSukces")
    public String logoutSukces() {
        return "forward:/logoutSukces.html";
    }
}
