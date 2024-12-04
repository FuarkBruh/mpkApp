package com.example.mpkApp.serwisy;

import com.example.mpkApp.modele.LinieModel;
import com.example.mpkApp.repozytoria.LinieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class LinieSerwis {
    private final LinieRepo linieRepo;

    @Autowired
    public LinieSerwis(LinieRepo linieRepo) {
        this.linieRepo = linieRepo;
    }

    @Transactional
    public void updateLinia(int id, LinieModel updatedLinia) {
        Optional<LinieModel> optionalLinia = linieRepo.findById(id);
        if (optionalLinia.isEmpty()) {
            throw new RuntimeException("Linie not found");
        }
        else {
            LinieModel linia = optionalLinia.get();
            linia.setNumer(updatedLinia.getNumer());
            linia.setCalkowityCzasPrzejazdu(updatedLinia.getCalkowityCzasPrzejazdu());
            linieRepo.save(linia);
        }
    }

    @Transactional
    public void deleteLinia(int id) {
        if(linieRepo.existsById(id)) {
            linieRepo.deleteById(id);
        }
        else {
            throw new RuntimeException("Linie not found");
        }
    }

    @Transactional
    public void newLinia(LinieModel tramwaj) {
        linieRepo.save(tramwaj);
    }
}
