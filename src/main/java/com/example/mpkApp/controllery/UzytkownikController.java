package com.example.mpkApp.controllery;

import com.example.mpkApp.modele.UzytkownikModel;
import com.example.mpkApp.serwisy.UzytkownikSerwis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/uzytkownik")
public class UzytkownikController {
    private final UzytkownikSerwis uzytkownikSerwis;

    @Autowired
    UzytkownikController(UzytkownikSerwis uzytkownikSerwis) {
        this.uzytkownikSerwis = uzytkownikSerwis;
    }

    @PostMapping
    public void newUzytkownik(UzytkownikModel uzytkownik) {
        uzytkownikSerwis.newUzytkownik(uzytkownik);
    }

    @PutMapping("/{id}")
    public void updatedUzytkownik(@PathVariable int id, UzytkownikModel uzytkownik) {
        uzytkownikSerwis.updateUzytkownik(id, uzytkownik);
    }

    @DeleteMapping("/{id}")
    public void deleteUzytkownik(@PathVariable int id) {
        uzytkownikSerwis.deleteUzytkownik(id);
    }
}
