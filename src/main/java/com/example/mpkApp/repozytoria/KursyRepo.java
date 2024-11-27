package com.example.mpkApp.repozytoria;

import com.example.mpkApp.modele.KursyModel;
import com.example.mpkApp.modele.TramwajeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KursyRepo extends JpaRepository<KursyModel, Integer> {
}
