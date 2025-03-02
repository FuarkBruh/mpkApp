package com.example.mpkApp.controllery;

import com.example.mpkApp.modele.LinieModel;
import com.example.mpkApp.modele.MapowanieLiniiModel;
import com.example.mpkApp.modele.PrzystankiModel;
import com.example.mpkApp.serwisy.LinieSerwis;
import com.example.mpkApp.serwisy.MapowanieLiniiSerwis;
import com.example.mpkApp.serwisy.PrzystankiSerwis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    private final LinieSerwis linieSerwis;
    private final PrzystankiSerwis przystankiSerwis;
    private final MapowanieLiniiSerwis mapowanieLiniiSerwis;

    @Autowired
    public AdminController(LinieSerwis linieSerwis, PrzystankiSerwis przystankiSerwis, MapowanieLiniiSerwis mapowanieLiniiSerwis) {
        this.linieSerwis = linieSerwis;
        this.przystankiSerwis = przystankiSerwis;
        this.mapowanieLiniiSerwis = mapowanieLiniiSerwis;
    }

    @GetMapping("/dodajPojazd")
    public String dodajPojazd() {
        return "dodajPojazd";
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

    @GetMapping("/mapowanie")
    public String mapowanie(Model model) {
        model.addAttribute("mapowanie", new MapowanieLiniiModel());
        model.addAttribute("linieList", linieSerwis.getAllLinies());
        model.addAttribute("przystankiList", przystankiSerwis.findAllPrzystanek());
        model.addAttribute("mapowanieList", mapowanieLiniiSerwis.getAllMapowanieLinii());
        return "mapowanie";
    }

    @GetMapping("/logoutSukces")
    public String logoutSukces() {
        return "logoutSukces";
    }
}