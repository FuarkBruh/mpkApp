package com.example.mpkApp.serwisy;

import com.example.mpkApp.modele.TramwajeModel;
import com.example.mpkApp.repozytoria.TramwajeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TramwajeSerwis {
    public final TramwajeRepo tramwajeRepo;

    @Autowired
    public TramwajeSerwis(TramwajeRepo tramwajeRepo) {
        this.tramwajeRepo = tramwajeRepo;
    }


    @Transactional
    public void newTramwaj(TramwajeModel tramwaj) {
        tramwajeRepo.save(tramwaj);
    }

    @Transactional
    public void updateTramwaj(Integer id, TramwajeModel updatedTramwaj) {
        Optional<TramwajeModel> optionalTramwaj = tramwajeRepo.findById(id);
        if (optionalTramwaj.isEmpty()) {
            throw new RuntimeException("Tramwaj not found");
        }
        else {
            TramwajeModel tramwaj = optionalTramwaj.get();
            tramwaj.setModel(updatedTramwaj.getModel());
            tramwaj.setNumerBoczny(updatedTramwaj.getNumerBoczny());
            tramwaj.setPojemnosc(updatedTramwaj.getPojemnosc());
            tramwaj.setRokProdukcji(updatedTramwaj.getRokProdukcji());
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

    public List<TramwajeModel> findAllTramwaje() {
        if(tramwajeRepo.findAll().isEmpty()) {
            throw new RuntimeException("No tramwaje found");
        }
        else {
            tramwajeRepo.findAll();
            return tramwajeRepo.findAll();
        }
    }

    public TramwajeModel findTramwajById(int id) {
        return tramwajeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Tramwaj with ID " + id + " not found"));
    }

    @Override
    public String toString() {
        return "TramwajeSerwis{" +
                "tramwajeRepo=" + tramwajeRepo +
                '}';
    }
}
