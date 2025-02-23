package com.example.mpkApp.controllery;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GlownaController {

    @GetMapping("/")
    public String glowna() {
        return "glowna"; // Zwraca szablon glowna.html
    }

    @GetMapping("/rozklad")
    public String rozklad() {
        return "rozklad"; // Zwraca szablon rozklad.html
    }

    @GetMapping("/rozkladLive")
    public String rozkladLive() {
        return "rozkladLive"; // Zwraca szablon rozkladLive.html
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Zwraca szablon login.html
    }
}