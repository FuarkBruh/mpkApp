package com.example.mpkApp.controllery;

import com.example.mpkApp.modele.KursyModel;
import com.example.mpkApp.serwisy.KursySerwis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kursy")
public class KursyController {
    public final KursySerwis kursySerwis;

    @Autowired
    public KursyController(KursySerwis kursySerwis) {
        this.kursySerwis = kursySerwis;
    }

    @PostMapping
    public void newKursy(@RequestBody KursyModel kursyModel) {
        kursySerwis.newKurs(kursyModel);
    }

    @PutMapping("{id}")
    public void updateKursy(@PathVariable int id, @RequestBody KursyModel kursyModel) {
        kursySerwis.updateKursy(id, kursyModel);
    }

    @DeleteMapping("{id}")
    public void deleteKursy(@PathVariable int id) {
        kursySerwis.deleteKurs(id);
    }

    @GetMapping("{linia_id}")
    public List<KursyModel> findAllKursyByLiniaID(@PathVariable int linia_id) {
        return kursySerwis.findKursyByLiniaID(linia_id);
    }
}
