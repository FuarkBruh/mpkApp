package com.example.mpkApp.serwisy;

import com.example.mpkApp.modele.TramwajeModel;
import com.example.mpkApp.repozytoria.TramwajeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TramwajeSerwis {
    public final TramwajeRepo tramwajeRepo;

    @Autowired
    public TramwajeSerwis(TramwajeRepo tramwajeRepo) {
        this.tramwajeRepo = tramwajeRepo;
    }

    @Transactional
    public void updateTramwaj(int id, TramwajeModel updatedTramwaj) {
        Optional<TramwajeModel> optionalTramwaj = tramwajeRepo.findById(id);
        if (optionalTramwaj.isEmpty()) {
            throw new RuntimeException("Tramwaj not found");
        }
        else {
            TramwajeModel tramwaj = optionalTramwaj.get();
            tramwaj.setModel(updatedTramwaj.getModel());
            tramwaj.setPojemnosc(updatedTramwaj.getPojemnosc());
            tramwaj.setRok_produkcji(updatedTramwaj.getRok_produkcji());
            tramwaj.setUwagi(updatedTramwaj.getUwagi());
            tramwajeRepo.save(tramwaj);
        }
    }

    @Transactional
    public void deleteTramwaj(int id) {
        if(tramwajeRepo.existsById(id)) {
            tramwajeRepo.deleteById(id);
        }
        else {
            throw new RuntimeException("Tramwaj not found");
        }
    }

    @Transactional
    public void newTramwaj(TramwajeModel tramwaj) {
        tramwajeRepo.save(tramwaj);
    }
}
