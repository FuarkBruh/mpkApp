package com.example.mpkApp.serwisy;

import com.example.mpkApp.modele.OpinieModel;
import com.example.mpkApp.repozytoria.OpinieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OpinieSerwis {
    private final OpinieRepo opinieRepo;

    @Autowired
    public OpinieSerwis(OpinieRepo opinieRepo) {
        this.opinieRepo = opinieRepo;
    }

    @Transactional
    public void updateOpinia(int id, OpinieModel updatedOpinia) {
        Optional<OpinieModel> optionalOpinia = opinieRepo.findById(id);
        if (optionalOpinia.isEmpty()) {
            throw new RuntimeException("Opinia not found");
        }
        else {
            OpinieModel opinia = optionalOpinia.get();
            opinia.setNumer_boczny(updatedOpinia.getNumer_boczny());
            opinia.setGodzina(updatedOpinia.getGodzina());
            opinia.setNumer_linii(updatedOpinia.getNumer_linii());
            opinia.setTresc_opinii(updatedOpinia.getTresc_opinii());
            opinieRepo.save(opinia);
        }
    }

    @Transactional
    public void deleteOpinia(int id) {
        if(opinieRepo.existsById(id)) {
            opinieRepo.deleteById(id);
        }
        else {
            throw new RuntimeException("Opinia not found");
        }
    }

    @Transactional
    public void newOpinia(OpinieModel opinia) {
        opinieRepo.save(opinia);
    }
}
