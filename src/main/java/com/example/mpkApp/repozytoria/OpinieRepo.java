package com.example.mpkApp.repozytoria;

import com.example.mpkApp.modele.OpinieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpinieRepo extends JpaRepository<OpinieModel, Integer> {
}