package com.example.mpkApp.controllery;

import com.example.mpkApp.modele.TramwajeModel;
import com.example.mpkApp.serwisy.TramwajeSerwis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tramwaje")
public class TramwajeController {
    public final TramwajeSerwis tramwajeSerwis;

    @Autowired
    public TramwajeController(TramwajeSerwis tramwajeSerwis) {
        this.tramwajeSerwis = tramwajeSerwis;
    }

    @PostMapping("/dodaj")
    public String newTramwaj(@ModelAttribute TramwajeModel tramwaj) {
        tramwajeSerwis.newTramwaj(tramwaj);
        return "redirect:/tramwaje";
    }

    @PutMapping("/{id}")
    @ResponseBody
    public void updateTramwaj(@PathVariable Integer id, @RequestBody TramwajeModel tramwaj) {
        tramwajeSerwis.updateTramwaj(id, tramwaj);
    }

    @DeleteMapping("/{id}")
    public void deleteTramwaj(@PathVariable Integer id) {
        tramwajeSerwis.deleteTramwaj(id);
    }

    @GetMapping
    public List<TramwajeModel> getAllTramwaje(Model model) {
        return tramwajeSerwis.getAllTramwaje();
    }

    @GetMapping("/{id}")
    public TramwajeModel getTramwajById(@PathVariable Integer id, Model model) {
        return tramwajeSerwis.getTramwajById(id);
    }

    @GetMapping("/{numerBoczny}")
    public Optional<TramwajeModel> getTramwajByNumerBoczny(@PathVariable String numerBoczny) {
        return tramwajeSerwis.getTramwajByNumerBoczny(numerBoczny);
    }

    @GetMapping("/{rokProdukcji}")
    public List<TramwajeModel> getAllTramwajeByRokProdukcji(@PathVariable Integer rokProdukcji) {
        return tramwajeSerwis.getAllTramwajeByRokProdukcji(rokProdukcji);
    }

    @GetMapping("/uwagi")
    public List<TramwajeModel> getAllTramwajeByUwagi(String uwagi) {
        return tramwajeSerwis.getAllTramwajeByUwagi(uwagi);
    }
}