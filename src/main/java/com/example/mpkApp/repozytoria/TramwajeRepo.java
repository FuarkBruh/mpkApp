package com.example.mpkApp.repozytoria;

import com.example.mpkApp.modele.TramwajeModel;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TramwajeRepo extends JpaRepository<TramwajeModel, Integer> {
    Optional<TramwajeModel> findByNumerBoczny(String numerBoczny);
    List<TramwajeModel> findAllByRokProdukcji(Integer rokProdukcji);
    List<TramwajeModel> findAllByUwagi(String uwagi);
}