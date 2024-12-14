package com.example.mpkApp.modele;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "kursy")
public class KursyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kursy_id_gen")
    @SequenceGenerator(name = "kursy_id_gen", sequenceName = "kursy_id_seq", allocationSize = 1)
    private Integer id;

    private Integer tramwajId;

    @Column(name = "linia_id")
    private Integer liniaId;

    private Timestamp czasOdjazduZPetli;
    private Integer opoznienie;
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
