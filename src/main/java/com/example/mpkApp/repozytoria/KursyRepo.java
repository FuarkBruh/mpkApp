package com.example.mpkApp.repozytoria;

import com.example.mpkApp.modele.KursyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KursyRepo extends JpaRepository<KursyModel, Integer> {
    List<KursyModel> findAllByLiniaId(Integer liniaId);
}