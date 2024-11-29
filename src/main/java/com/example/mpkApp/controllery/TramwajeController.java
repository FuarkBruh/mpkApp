package com.example.mpkApp.controllery;

import com.example.mpkApp.modele.TramwajeModel;
import com.example.mpkApp.serwisy.TramwajeSerwis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tramwaje")
public class TramwajeController {
    public final TramwajeSerwis tramwajeSerwis;

    @Autowired
    public TramwajeController(TramwajeSerwis tramwajeSerwis) {
        this.tramwajeSerwis = tramwajeSerwis;
    }

    @GetMapping
    public List<TramwajeModel> getAllTramwaje() {
        return tramwajeSerwis.findAllTramwaje();
    }

    @GetMapping("/{id}")
    public TramwajeModel getTramwajeById(@PathVariable Integer id) {
        return tramwajeSerwis.findTramwajById(id);
    }

    @PostMapping
    public void newTramwaj (@RequestBody TramwajeModel tramwaj) {
        tramwajeSerwis.newTramwaj(tramwaj);
    }

    @PutMapping("/{id}")
    public void updateTramwaje(@PathVariable Integer id,@RequestBody TramwajeModel tramwaj) {
        tramwajeSerwis.updateTramwaj(id, tramwaj);
    }

    @DeleteMapping("/{id}")
    public void deleteTramwaje(@PathVariable Integer id) {
        tramwajeSerwis.deleteTramwaj(id);
    }
}
