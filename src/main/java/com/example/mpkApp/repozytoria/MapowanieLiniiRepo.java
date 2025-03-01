package com.example.mpkApp.repozytoria;

import com.example.mpkApp.modele.MapowanieLiniiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapowanieLiniiRepo extends JpaRepository<MapowanieLiniiModel, Integer> {
}