package com.example.mpkApp.serwisy;

import com.example.mpkApp.modele.MapowanieLiniiModel;
import com.example.mpkApp.repozytoria.MapowanieLiniiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MapowanieLiniiSerwis {
    private final MapowanieLiniiRepo mapowanieLiniiRepo;

    @Autowired
    public MapowanieLiniiSerwis(MapowanieLiniiRepo mapowanieLiniiRepo) {
        this.mapowanieLiniiRepo = mapowanieLiniiRepo;
    }

    public Optional<MapowanieLiniiModel> findById(Integer id) {
        return mapowanieLiniiRepo.findById(id);
    }

    @Override
    public String toString() {
        return "MapowanieLiniiSerwis{" +
                "mapowanieLiniiRepo=" + mapowanieLiniiRepo +
                '}';
    }


}
