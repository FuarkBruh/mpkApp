package com.example.mpkApp.controllery;

import com.example.mpkApp.modele.OpinieModel;
import com.example.mpkApp.serwisy.OpinieSerwis;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/opinia")
public class OpinieController {
    private final OpinieSerwis opinieSerwis;

    public OpinieController(OpinieSerwis opinieSerwis) {
        this.opinieSerwis = opinieSerwis;
    }

    @GetMapping
    public String getForm(Model model) {
        model.addAttribute("newOpinia", new OpinieModel());
        return "nowaOpinia";
    }

    @GetMapping("/pasazerow")
    public String getOpiniePasazerow(Model model) {
        List<OpinieModel> opinie = opinieSerwis.getAllOpinies();
        model.addAttribute("opinie", opinie);
        return "opiniePasazerow";
    }

    @GetMapping("/{id}")
    public String getOpinia(@PathVariable Integer id, Model model) {
        OpinieModel opinia = opinieSerwis.getOpiniaById(id);
        model.addAttribute("opinia", opinia);
        return "nowaOpinia";
    }

    @PostMapping
    public String newOpinia(@Valid OpinieModel opinia, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("newOpinia", opinia);
            return "nowaOpinia";
        }
        opinieSerwis.newOpinia(opinia);
        return "redirect:/opinia";
    }
}