package com.example.mpkApp.repozytoria;

import com.example.mpkApp.modele.RozkladModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RozkladRepo extends JpaRepository<RozkladModel, Integer> {
}
