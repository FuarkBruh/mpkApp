package com.example.mpkApp.controllery;

import com.example.mpkApp.modele.LinieModel;
import com.example.mpkApp.serwisy.LinieSerwis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/linie")
public class LinieController {
    private final LinieSerwis linieSerwis;

    @Autowired
    public LinieController(LinieSerwis linieSerwis) {
        this.linieSerwis = linieSerwis;
    }

    @PostMapping
    public String newLinia(@ModelAttribute LinieModel linia) {
        System.out.println(linia.getNumerLinii() + " " + linia.getCalkowityCzasPrzejazdu());
        linieSerwis.newLinia(linia);
        return "redirect:/zarzadzanieLiniami";
    }

    @PutMapping("/{id}")
    @ResponseBody
    public void updateLinia(@PathVariable int id, @RequestBody LinieModel linia) {
        linieSerwis.updateLinia(id, linia);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteLinia(@PathVariable int id) {
        linieSerwis.deleteLinia(id);
    }

    @GetMapping
    @ResponseBody
    public List<LinieModel> getAllLinies() {
        return linieSerwis.getAllLinies();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public LinieModel getLinie(@PathVariable int id) {
        return linieSerwis.getLinie(id);
    }

    @GetMapping("/numer/{numerLinii}")
    @ResponseBody
    public List<LinieModel> findAllByNumerLinii(@PathVariable String numerLinii) {
        return linieSerwis.findAllByNumerLinii(numerLinii);
    }
}