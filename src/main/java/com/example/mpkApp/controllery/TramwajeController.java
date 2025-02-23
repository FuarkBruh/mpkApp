package com.example.mpkApp.controllery;

import com.example.mpkApp.modele.TramwajeModel;
import com.example.mpkApp.serwisy.TramwajeSerwis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tramwaje")
public class TramwajeController {
    public final TramwajeSerwis tramwajeSerwis;

    @Autowired
    public TramwajeController(TramwajeSerwis tramwajeSerwis) {
        this.tramwajeSerwis = tramwajeSerwis;
    }

    @GetMapping
    public String getTramwaje(Model model) {
        List<TramwajeModel> tramwaje = tramwajeSerwis.findAllTramwaje();
        model.addAttribute("tramwaje", tramwaje);
        return "zarzadzaniePojazdami";
    }

    @PostMapping("/dodaj")
    public String newTramwaj(@ModelAttribute TramwajeModel tramwaj) {
        tramwajeSerwis.newTramwaj(tramwaj);
        return "redirect:/tramwaje";
    }

    @GetMapping("/{id}")
    public String getTramwajById(@PathVariable Integer id, Model model) {
        TramwajeModel tramwaj = tramwajeSerwis.findTramwajById(id);
        model.addAttribute("tramwaj", tramwaj);
        return "tramwajSzczegoly";
    }

    @PostMapping("/update/{id}")
    public String updateTramwaj(@PathVariable Integer id, @ModelAttribute TramwajeModel tramwaj) {
        tramwajeSerwis.updateTramwaj(id, tramwaj);
        return "redirect:/tramwaje";
    }

    @PostMapping("/delete/{id}")
    public String deleteTramwaj(@PathVariable Integer id) {
        tramwajeSerwis.deleteTramwaj(id);
        return "redirect:/tramwaje";
    }
}