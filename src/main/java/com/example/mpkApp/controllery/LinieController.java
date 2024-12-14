package com.example.mpkApp.controllery;

import com.example.mpkApp.modele.LinieModel;
import com.example.mpkApp.serwisy.LinieSerwis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/linie")
public class LinieController {
    private final LinieSerwis linieSerwis;

    @Autowired
    public LinieController(LinieSerwis linieSerwis) {
        this.linieSerwis = linieSerwis;
    }

    @PostMapping
    public void newLinia(LinieModel linia) {
        linieSerwis.newLinia(linia);
    }

    @PutMapping("{id}")
    public void updateLinia(@PathVariable int id, LinieModel linia) {
        linieSerwis.updateLinia(id, linia);
    }

    @DeleteMapping("{id}")
    public void deleteLinia(@PathVariable int id) {
        linieSerwis.deleteLinia(id);
    }

    @GetMapping
    public List<LinieModel> getAllLinies() {
        return linieSerwis.getAllLinies();
    }

    @GetMapping("{id}")
    public LinieModel getLinie(@PathVariable int id) {
        return linieSerwis.getLinie(id);
    }

    @GetMapping("{numerLinii}")
    public List<LinieModel> findAllByNumerLinii(@PathVariable String numerLinii) {
        return linieSerwis.findAllByNumerLinii(numerLinii);
    }
}
