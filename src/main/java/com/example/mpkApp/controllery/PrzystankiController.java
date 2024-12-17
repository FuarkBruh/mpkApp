package com.example.mpkApp.controllery;

import com.example.mpkApp.modele.PrzystankiModel;
import com.example.mpkApp.serwisy.PrzystankiSerwis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/przystanki")
public class PrzystankiController {
    private final PrzystankiSerwis przystankiSerwis;

    @Autowired
    public PrzystankiController(PrzystankiSerwis przystankiSerwis) {
        this.przystankiSerwis = przystankiSerwis;
    }

    @PostMapping
    public void newPrzystanek(@RequestBody PrzystankiModel model) {
        przystankiSerwis.newPrzystanek(model);
    }

    @PutMapping("/{id}")
    public void updatePrzystanek(@PathVariable int id, @RequestBody PrzystankiModel model) {
        przystankiSerwis.updatePrzystanek(id, model);
    }

    @DeleteMapping("/{id}")
    public void deletePrzystanek(@PathVariable int id) {
        przystankiSerwis.deletePrzystanek(id);
    }

    @GetMapping
    public List<PrzystankiModel> getAllPrzystanek() {
        return przystankiSerwis.findAllPrzystanek();
    }

    @GetMapping("/{id}")
    public PrzystankiModel getPrzystanek(@PathVariable Integer id) {
        return przystankiSerwis.findPrzystanekById(id);
    }

    @GetMapping("/by-nazwa/{nazwa}")
    public PrzystankiModel getPrzystanekByNazwa(@PathVariable String nazwa) {
        return przystankiSerwis.findPrzystanekByNazwa(nazwa);
    }
}
