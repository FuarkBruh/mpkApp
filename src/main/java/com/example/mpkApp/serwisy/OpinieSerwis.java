package com.example.mpkApp.serwisy;

import com.example.mpkApp.modele.OpinieModel;
import com.example.mpkApp.repozytoria.OpinieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OpinieSerwis {
    private final OpinieRepo opinieRepo;

    @Autowired
    public OpinieSerwis(OpinieRepo opinieRepo) {
        this.opinieRepo = opinieRepo;
    }

    @Transactional
    public void newOpinia(OpinieModel opinia) {
        opinieRepo.save(opinia);
    }

    @Transactional
    public void updateOpinia(Integer id, OpinieModel updatedOpinia) {
        Optional<OpinieModel> optionalOpinia = opinieRepo.findById(id);
        if (optionalOpinia.isEmpty()) {
            throw new RuntimeException("Opinia not found");
        }
        else {
            OpinieModel opinia = optionalOpinia.get();
            opinia.setNumerBoczny(updatedOpinia.getNumerBoczny());
            opinia.setGodzina(updatedOpinia.getGodzina());
            opinia.setNumerLinii(updatedOpinia.getNumerLinii());
            opinia.setTrescOpinii(updatedOpinia.getTrescOpinii());
            opinieRepo.save(opinia);
        }
    }

    @Transactional
    public void deleteOpinia(Integer id) {
        if(opinieRepo.existsById(id)) {
            opinieRepo.deleteById(id);
        }
        else {
            throw new RuntimeException("Opinia not found");
        }
    }

    public List<OpinieModel> getAllOpinies() {
        if(opinieRepo.existsById(0)) {
            return opinieRepo.findAll();
        }
        else {
            throw new RuntimeException("Opinie not found");
        }
    }

    public OpinieModel getOpiniaById(Integer id) {
        if(opinieRepo.existsById(id)) {
            return opinieRepo.findById(id).get();
        }
        else {
            throw new RuntimeException("Opinia not found");
        }
    }

    @Override
    public String toString() {
        return "OpinieSerwis{" +
                "opinieRepo=" + opinieRepo +
                '}';
    }
}
