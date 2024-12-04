package com.example.mpkApp.modele;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "kursy")
public class KursyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kursy_id_gen")
    @SequenceGenerator(name = "kursy_id_gen", sequenceName = "kursy_id_seq", allocationSize = 1)
    private int id;

    private int tramwajId;

    @Column(name = "linia_id")
    private int liniaId;

    private Timestamp czasOdjazduZPetli;
    private int opoznienie;
    private int nastepnyPrzystanek;

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

    public void setTramwajId(int tramwaj_id) {
        this.tramwajId = tramwaj_id;
    }

    public int getLiniaId() {
        return liniaId;
    }

    public void setLiniaId(int linia_id) {
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

    public void setOpoznienie(int opoznienie) {
        this.opoznienie = opoznienie;
    }

    public int getNastepnyPrzystanek() {
        return nastepnyPrzystanek;
    }

    public void setNastepnyPrzystanek(int nastepny_przystanek) {
        this.nastepnyPrzystanek = nastepny_przystanek;
    }
}
