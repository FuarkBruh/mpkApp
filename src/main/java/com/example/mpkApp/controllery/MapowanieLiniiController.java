package com.example.mpkApp.controllery;

import com.example.mpkApp.modele.MapowanieLiniiModel;
import com.example.mpkApp.serwisy.MapowanieLiniiSerwis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mapowanieLinii")
public class MapowanieLiniiController {
    private final MapowanieLiniiSerwis mapowanieLiniiSerwis;

    @Autowired
    public MapowanieLiniiController(MapowanieLiniiSerwis mapowanieLinii) {
        this.mapowanieLiniiSerwis = mapowanieLinii;
    }

    @PostMapping
    public void newMapowanieLinii(@RequestBody MapowanieLiniiModel model) {
        mapowanieLiniiSerwis.newMapowanieLinii(model);
    }

    @PutMapping("/{id}")
    public void updateMapowanieLinii(@PathVariable Integer id, @RequestBody MapowanieLiniiModel model) {
        mapowanieLiniiSerwis.updateMapowanieLinii(id, model);
    }

    @DeleteMapping("/{id}")
    public void deleteMapowanieLinii(@PathVariable Integer id) {
        mapowanieLiniiSerwis.deleteMapowanieLinii(id);
    }

    @GetMapping
    public List<MapowanieLiniiModel> getAllMapowanieLinii() {
        return mapowanieLiniiSerwis.getAllMapowanieLinii();
    }

    @GetMapping("/{id}")
    public MapowanieLiniiModel getMapowanieLinii(@PathVariable Integer id) {
        return mapowanieLiniiSerwis.getMapowanieLiniiById(id);
    }
}
