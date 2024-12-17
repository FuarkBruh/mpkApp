package com.example.mpkApp.serwisy;

import com.example.mpkApp.modele.UzytkownikModel;
import com.example.mpkApp.repozytoria.UzytkownikRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UzytkownikSerwis {
    private final UzytkownikRepo uzytkownikRepo;

    @Autowired
    UzytkownikSerwis(UzytkownikRepo uzytkownikRepo) {
        this.uzytkownikRepo = uzytkownikRepo;
    }

    @Transactional
    public void newUzytkownik(UzytkownikModel uzytkownik) {
        uzytkownikRepo.save(uzytkownik);
    }

    @Transactional
    public void updateUzytkownik(Integer id, UzytkownikModel UpdatedUzytkownik) {
        Optional<UzytkownikModel> optionalUzytkowik = uzytkownikRepo.findById(id);
        if (optionalUzytkowik.isEmpty()) {
            throw new RuntimeException("Uzytkownik id " + id + " not found");
        }
        UzytkownikModel uzytkownik = optionalUzytkowik.get();
        uzytkownik.setEmail(UpdatedUzytkownik.getEmail());
        uzytkownik.setHaslo(UpdatedUzytkownik.getHaslo());
        uzytkownik.setRola(UpdatedUzytkownik.getRola());
        uzytkownikRepo.save(uzytkownik);
    }

    @Transactional
    public void deleteUzytkownik(Integer id) {
        uzytkownikRepo.deleteById(id);
    }

    @Override
    public String toString() {
        return "UzytkownikSerwis{" +
                "uzytkownikRepo=" + uzytkownikRepo +
                '}';
    }
}
