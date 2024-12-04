package com.example.mpkApp.serwisy;

import com.example.mpkApp.repozytoria.MapowanieLiniiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapowanieLiniiSerwis {
    private final MapowanieLiniiRepo mapowanieLiniiRepo;

    @Autowired
    public MapowanieLiniiSerwis(MapowanieLiniiRepo mapowanieLiniiRepo) {
        this.mapowanieLiniiRepo = mapowanieLiniiRepo;
    }
}
