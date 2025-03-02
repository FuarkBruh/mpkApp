package com.example.mpkApp.controllery;

import com.example.mpkApp.modele.TramwajeModel;
import com.example.mpkApp.serwisy.TramwajeSerwis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
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

    @PostMapping()
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

    @GetMapping()
    public String getAllTramwaje(Model model) {
        List<TramwajeModel> tramwaje = tramwajeSerwis.getAllTramwaje();
        model.addAttribute("tramwaje", tramwaje);
        return "zarzadzaniePojazdami";
    }

    @GetMapping("/{id}")
    public String getTramwajById(@PathVariable Integer id, Model model) {
        TramwajeModel tramwaj = tramwajeSerwis.getTramwajById(id);
        model.addAttribute("tramwaj", tramwaj);
        return "zarzadzaniePojazdami";
    }

    @GetMapping("/numerBoczny/{numerBoczny}")
    public String getTramwajByNumerBoczny(@PathVariable String numerBoczny, Model model) {
        Optional<TramwajeModel> tramwaj = tramwajeSerwis.getTramwajByNumerBoczny(numerBoczny);
        model.addAttribute("tramwaj", tramwaj);
        return "zarzadzaniePojazdami";
    }

    @GetMapping("/rokProdukcji/{rokProdukcji}")
    public String getAllTramwajeByRokProdukcji(@PathVariable Integer rokProdukcji, Model model) {
        List<TramwajeModel> tramwaje = tramwajeSerwis.getAllTramwajeByRokProdukcji(rokProdukcji);
        model.addAttribute("tramwaje", tramwaje);
        return "zarzadzaniePojazdami";
    }

    @GetMapping("/uwagi")
    public String getAllTramwajeByUwagi(String uwagi, Model model) {
        List<TramwajeModel> tramwaje = tramwajeSerwis.getAllTramwajeByUwagi(uwagi);
        model.addAttribute("tramwaje", tramwaje);
        return "zarzadzaniePojazdami";
    }

    @GetMapping("/wyszukaj")
    public String searchTramwaje(
            @RequestParam(required = false) String numerBoczny,
            @RequestParam(required = false) Integer rokProdukcji,
            @RequestParam(required = false) String uwagi,
            Model model) {

        List<TramwajeModel> tramwaje;

        if (numerBoczny != null && !numerBoczny.isEmpty()) {
            tramwaje = tramwajeSerwis.getTramwajByNumerBoczny(numerBoczny)
                    .map(List::of)
                    .orElse(Collections.emptyList());
        } else if (rokProdukcji != null) {
            tramwaje = tramwajeSerwis.getAllTramwajeByRokProdukcji(rokProdukcji);
        } else if (uwagi != null && !uwagi.isEmpty()) {
            tramwaje = tramwajeSerwis.getAllTramwajeByUwagi(uwagi);
        } else {
            tramwaje = tramwajeSerwis.getAllTramwaje();
        }

        model.addAttribute("tramwaje", tramwaje);
        return "zarzadzaniePojazdami";
    }
}