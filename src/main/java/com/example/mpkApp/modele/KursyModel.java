package com.example.mpkApp.modele;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.UniqueElements;

import java.sql.Timestamp;

@Entity
@Table(name = "kursy")
public class KursyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kursy_id_gen")
    @SequenceGenerator(name = "kursy_id_gen", sequenceName = "kursy_id_seq", allocationSize = 1)
    private Integer id;

    @Column(nullable = false)
    @NotNull(message = "TramwajId is null!")
    private Integer tramwajId;

    @Column(nullable = false)
    @NotNull(message = "LiniaId is null!")
    private Integer liniaId;

    @Column(nullable = false)
    @NotNull(message = "CzasOdjazduZPetli is null!")
    private Timestamp czasOdjazduZPetli;

    @Column(nullable = false)
    @NotNull(message = "Opoznienie is null!")
    private Integer opoznienie;

    @Column(nullable = false)
    @NotNull(message = "NastepnyPrzystanek is null!")
    private Integer nastepnyPrzystanek;


    public KursyModel() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTramwajId() {
        return tramwajId;
    }

    public void setTramwajId(Integer tramwaj_id) {
        this.tramwajId = tramwaj_id;
    }

    public int getLiniaId() {
        return liniaId;
    }

    public void setLiniaId(Integer linia_id) {
        this.liniaId = linia_id;
    }

    public Timestamp getCzasOdjazduZPetli() {
        return czasOdjazduZPetli;
    }

    public void setCzasOdjazduZPetli(Timestamp czas_odjazdu) {
        this.czasOdjazduZPetli = czas_odjazdu;
    }

    public int getOpoznienie() {
        return opoznienie;
    }

    public void setOpoznienie(Integer opoznienie) {
        this.opoznienie = opoznienie;
    }

    public int getNastepnyPrzystanek() {
        return nastepnyPrzystanek;
    }

    public void setNastepnyPrzystanek(Integer nastepny_przystanek) {
        this.nastepnyPrzystanek = nastepny_przystanek;
    }
}
