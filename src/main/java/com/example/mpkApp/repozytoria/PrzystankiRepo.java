package com.example.mpkApp.repozytoria;

import com.example.mpkApp.modele.PrzystankiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrzystankiRepo extends JpaRepository<PrzystankiModel, Integer> {
    PrzystankiModel findByNazwa(String nazwa);
}
