package com.example.mpkApp.serwisy;

import com.example.mpkApp.modele.RozkladModel;
import com.example.mpkApp.repozytoria.RozkladRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RozkladSerwis {
    private final RozkladRepo rozkladRepo;

    @Autowired
    public RozkladSerwis(RozkladRepo rozkladRepo) {
        this.rozkladRepo = rozkladRepo;
    }

    @Transactional
    public void newRozklad(RozkladModel model) {
        rozkladRepo.save(model);
    }

    @Transactional
    public void updateRozklad(Integer id, RozkladModel updatedRozklad) {
        Optional<RozkladModel> optional = rozkladRepo.findById(id);
        if(optional.isEmpty()) {
            throw new RuntimeException("Rozklad id " + id + " not found");
        }
        else {
            RozkladModel rozklad = optional.get();
            rozklad.setNumerLinii(updatedRozklad.getNumerLinii());
            rozklad.setCzasStartu(updatedRozklad.getCzasStartu());
            rozkladRepo.save(rozklad);
        }
    }

    @Transactional
    public void deleteRozklad(Integer id) {
        if(rozkladRepo.existsById(id)) {
            rozkladRepo.deleteById(id);
        }
        else {
            throw new RuntimeException("Rozklad id " + id + " not found");
        }
    }

    @Override
    public String toString() {
        return "RozkladSerwis{" +
                "rozkladRepo=" + rozkladRepo +
                '}';
    }
}
