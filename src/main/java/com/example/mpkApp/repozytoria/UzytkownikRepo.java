package com.example.mpkApp.repozytoria;

import com.example.mpkApp.modele.UzytkownikModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UzytkownikRepo extends JpaRepository<UzytkownikModel, Integer> {
}
