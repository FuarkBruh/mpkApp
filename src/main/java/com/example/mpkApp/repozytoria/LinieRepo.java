package com.example.mpkApp.repozytoria;

import com.example.mpkApp.modele.LinieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinieRepo extends JpaRepository<LinieModel, Integer> {
     List<LinieModel> findAllByNumerLinii(String numerLinii);
}
