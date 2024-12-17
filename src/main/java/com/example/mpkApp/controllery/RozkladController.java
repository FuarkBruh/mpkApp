package com.example.mpkApp.controllery;

import com.example.mpkApp.modele.RozkladModel;
import com.example.mpkApp.serwisy.RozkladSerwis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/rozklad")
public class RozkladController {
    private final RozkladSerwis rozkladSerwis;

    @Autowired
    public RozkladController(RozkladSerwis rozkladSerwis) {
        this.rozkladSerwis = rozkladSerwis;
    }

    @PostMapping
    public void newRozklad(RozkladModel model) {
        rozkladSerwis.newRozklad(model);
    }

    @PutMapping("/{id}")
    public void updateRozklad(@PathVariable Integer id, RozkladModel updatedRozklad) {
        rozkladSerwis.updateRozklad(id, updatedRozklad);
    }

    @DeleteMapping("/{id}")
    public void deleteRozklad(@PathVariable Integer id) {
        rozkladSerwis.deleteRozklad(id);
    }

}
