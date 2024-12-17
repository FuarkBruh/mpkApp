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
    public void newMapowanieLinii (MapowanieLiniiModel model) {
        mapowanieLiniiRepo.save(model);
    }

    @Transactional
    public void updateMapowanieLinii (Integer id, MapowanieLiniiModel updatedMap) {
        Optional<MapowanieLiniiModel> opt = mapowanieLiniiRepo.findById(id);
        if (opt.isEmpty()) {
            throw new RuntimeException("MapowanieLinii not found");
        }
        else {
            MapowanieLiniiModel mapa = opt.get();
            mapa.setId(updatedMap.getId());
            mapa.setNumerPrzystankuLinii(updatedMap.getNumerPrzystankuLinii());
            mapa.setRoznicaCzasu(updatedMap.getRoznicaCzasu());
            mapa.setLinia(updatedMap.getLinia());
            mapa.setPrzystanek(updatedMap.getPrzystanek());
            mapowanieLiniiRepo.save(mapa);
        }
    }

    @Transactional
    public void deleteMapowanieLinii (Integer id) {
        if(mapowanieLiniiRepo.existsById(id)) {
            mapowanieLiniiRepo.deleteById(id);
        }
        else {
            throw new RuntimeException("MapowanieLinii not found");
        }
    }

    public List<MapowanieLiniiModel> getAllMapowanieLinii() {
        return mapowanieLiniiRepo.findAll();
    }

    public MapowanieLiniiModel getMapowanieLiniiById(Integer id) {
        return mapowanieLiniiRepo.findById(id).get();
    }

    @Override
    public String toString() {
        return "MapowanieLiniiSerwis{" +
                "mapowanieLiniiRepo=" + mapowanieLiniiRepo +
                '}';
    }


}
