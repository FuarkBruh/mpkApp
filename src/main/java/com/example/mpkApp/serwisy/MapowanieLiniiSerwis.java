package com.example.mpkApp.serwisy;

import com.example.mpkApp.modele.MapowanieLiniiModel;
import com.example.mpkApp.repozytoria.MapowanieLiniiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MapowanieLiniiSerwis {
    private final MapowanieLiniiRepo mapowanieLiniiRepo;

    @Autowired
    public MapowanieLiniiSerwis(MapowanieLiniiRepo mapowanieLiniiRepo) {
        this.mapowanieLiniiRepo = mapowanieLiniiRepo;
    }

    @Transactional
    public void newMapowanieLinii(MapowanieLiniiModel model) {
        mapowanieLiniiRepo.save(model);
    }

    @Transactional
    public void updateMapowanieLinii(Integer id, MapowanieLiniiModel updatedModel) {
        Optional<MapowanieLiniiModel> optionalMapowanie = mapowanieLiniiRepo.findById(id);
        if (optionalMapowanie.isEmpty()) {
            throw new RuntimeException("Mapowanie not found");
        } else {
            MapowanieLiniiModel mapowanie = optionalMapowanie.get();
            mapowanie.setNumerPrzystankuLinii(updatedModel.getNumerPrzystankuLinii());
            mapowanie.setRoznicaCzasu(updatedModel.getRoznicaCzasu());
            mapowanie.setLinia(updatedModel.getLinia());
            mapowanie.setPrzystanek(updatedModel.getPrzystanek());
            mapowanieLiniiRepo.save(mapowanie);
        }
    }

    @Transactional
    public void deleteMapowanieLinii(Integer id) {
        if(mapowanieLiniiRepo.existsById(id)) {
            mapowanieLiniiRepo.deleteById(id);
        } else {
            throw new RuntimeException("Mapowanie not found");
        }
    }

    public List<MapowanieLiniiModel> getAllMapowanieLinii() {
        return mapowanieLiniiRepo.findAll();
    }

    public MapowanieLiniiModel getMapowanieLiniiById(Integer id) {
        return mapowanieLiniiRepo.findById(id).orElseThrow(() -> new RuntimeException("Mapowanie not found"));
    }
}