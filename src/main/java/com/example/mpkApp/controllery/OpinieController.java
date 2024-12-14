package com.example.mpkApp.controllery;

import com.example.mpkApp.modele.OpinieModel;
import com.example.mpkApp.serwisy.OpinieSerwis;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/opinie")
public class OpinieController {
    private final OpinieSerwis opinieSerwis;

    public OpinieController(OpinieSerwis opinieSerwis) {
        this.opinieSerwis = opinieSerwis;
    }

    @PostMapping
    public void newOpinia(OpinieModel model) {
        opinieSerwis.newOpinia(model);
    }

    @PutMapping("{id}")
    public void updateOpinia(@PathVariable Integer id, OpinieModel model) {
        opinieSerwis.updateOpinia(id, model);
    }

    @DeleteMapping("{id]")
    public void deleteOpinia(@PathVariable Integer id) {
        opinieSerwis.deleteOpinia(id);
    }

    @GetMapping
    public List<OpinieModel> getAllOpinies() {
        return opinieSerwis.getAllOpinies();
    }

    @GetMapping("{id}")
    public OpinieModel getOpinia(@PathVariable Integer id) {
        return opinieSerwis.getOpiniaById(id);
    }
}
