package com.example.mpkApp.serwisy;

import com.example.mpkApp.repozytoria.UzytkownikRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UzytkownikSerwis {
    private final UzytkownikRepo uzytkownikRepo;

    @Autowired
    UzytkownikSerwis(UzytkownikRepo uzytkownikRepo) {
        this.uzytkownikRepo = uzytkownikRepo;
    }
}
