package com.example.mpkApp.serwisy;

import com.example.mpkApp.modele.KursyModel;
import com.example.mpkApp.repozytoria.KursyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class KursySerwis {
    private final KursyRepo kursyRepo;

    @Autowired
    public KursySerwis(KursyRepo kursyRepo) {
        this.kursyRepo = kursyRepo;
    }

    @Transactional
    public void updateKursy(int id, KursyModel updatedKurs) {
        Optional<KursyModel> optionalKurs = kursyRepo.findById(id);
        if (optionalKurs.isEmpty()) {
            throw new RuntimeException("Kurs not found");
        }
        else {
            KursyModel kurs = optionalKurs.get();
            kurs.setCzas_odjazdu(updatedKurs.getCzas_odjazdu());
            kurs.setOpoznienie(updatedKurs.getOpoznienie());
            kurs.setLinia_id(updatedKurs.getLinia_id());
            kurs.setTramwaj_id(updatedKurs.getTramwaj_id());
            kursyRepo.save(kurs);
        }
    }

    @Transactional
    public void deleteKurs(int id) {
        if(kursyRepo.existsById(id)) {
            kursyRepo.deleteById(id);
        }
        else {
            throw new RuntimeException("Kurs not found");
        }
    }

    @Transactional
    public void newKurs(KursyModel kurs) {
        kursyRepo.save(kurs);
    }
}
