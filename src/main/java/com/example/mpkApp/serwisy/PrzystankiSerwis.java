package com.example.mpkApp.serwisy;

import com.example.mpkApp.modele.PrzystankiModel;
import com.example.mpkApp.repozytoria.PrzystankiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PrzystankiSerwis {
    public final PrzystankiRepo przystanekRepo;

    @Autowired
    public PrzystankiSerwis(PrzystankiRepo przystanekRepo) {
        this.przystanekRepo = przystanekRepo;
    }

    @Transactional
    public void updatePrzystanek(Integer id, PrzystankiModel updatedPrzystanek) {
        Optional<PrzystankiModel> optionalPrzystanek = przystanekRepo.findById(id);
        if (optionalPrzystanek.isEmpty()) {
            throw new RuntimeException("Przystanek not found");
        }
        else {
            PrzystankiModel przystanek = optionalPrzystanek.get();

            przystanekRepo.save(przystanek);
        }
    }

    @Transactional
    public void deletePrzystanek(Integer id) {
        if(przystanekRepo.existsById(id)) {
            przystanekRepo.deleteById(id);
        }
        else {
            throw new RuntimeException("Przystanek not found");
        }
    }

    @Transactional
    public void newPrzystanek(PrzystankiModel przystanek) {
        przystanekRepo.save(przystanek);
    }

    @Override
    public String toString() {
        return "PrzystankiSerwis{" +
                "przystanekRepo=" + przystanekRepo +
                '}';
    }
}
