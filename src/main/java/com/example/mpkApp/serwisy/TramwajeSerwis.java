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
    private final TramwajeRepo tramwajeRepo;

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
            throw new RuntimeException("Tramwaj not found chosen to update");
        } else {
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
    public void deleteTramwaj(Integer id) {
        if (!tramwajeRepo.existsById(id)) {
            throw new RuntimeException("Tramwaj not found with id " + id);
        } else {
            tramwajeRepo.deleteById(id);
        }
    }

    public List<TramwajeModel> getAllTramwaje() {
        return tramwajeRepo.findAll();
    }

    public TramwajeModel getTramwajById(Integer id) {
        return tramwajeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Tramwaj not found with ID " + id));
    }

    public Optional<TramwajeModel> getTramwajByNumerBoczny(String numerBoczny) {
        return tramwajeRepo.findByNumerBoczny(numerBoczny);
    }

    public List<TramwajeModel> getAllTramwajeByRokProdukcji(Integer rokProdukcji) {
        return tramwajeRepo.findAllByRokProdukcji(rokProdukcji);
    }

    public List<TramwajeModel> getAllTramwajeByUwagi(String uwagi) {
        return tramwajeRepo.findAllByUwagi(uwagi);
    }

    @Override
    public String toString() {
        return "TramwajeSerwis{" +
                "tramwajeRepo=" + tramwajeRepo +
                '}';
    }


}