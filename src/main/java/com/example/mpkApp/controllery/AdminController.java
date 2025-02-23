package com.example.mpkApp.controllery;

import com.example.mpkApp.modele.LinieModel;
import com.example.mpkApp.serwisy.LinieSerwis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    private final LinieSerwis linieSerwis;

    @Autowired
    public AdminController(LinieSerwis linieSerwis) {
        this.linieSerwis = linieSerwis;
    }

    @GetMapping("/adminStrona")
    public String adminStrona() {
        return "adminStrona";
    }

    @GetMapping("/zarzadzaniePojazdami")
    public String zarzadzaniePojazdami() {
        return "zarzadzaniePojazdami";
    }

    @GetMapping("/zarzadzaniePrzystankami")
    public String zarzadzaniePrzystankami() {
        return "zarzadzaniePrzystankami";
    }

    @GetMapping("/zarzadzanieLiniami")
    public String zarzadzanieLiniami(Model model) {
        model.addAttribute("linie", new LinieModel());
        model.addAttribute("linieList", linieSerwis.getAllLinies());
        return "zarzadzanieLiniami";
    }

    @GetMapping("/logoutSukces")
    public String logoutSukces() {
        return "logoutSukces";
    }
}