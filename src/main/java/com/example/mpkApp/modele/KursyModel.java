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
    private int tramwaj_id;
    private int linia_id;
    private Timestamp czas_odjazdu_z_petli;
    private int opoznienie;
    private int nastepny_przystanek;

    public KursyModel() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTramwaj_id() {
        return tramwaj_id;
    }

    public void setTramwaj_id(int tramwaj_id) {
        this.tramwaj_id = tramwaj_id;
    }

    public int getLinia_id() {
        return linia_id;
    }

    public void setLinia_id(int linia_id) {
        this.linia_id = linia_id;
    }

    public Timestamp getCzas_odjazdu_z_petli() {
        return czas_odjazdu_z_petli;
    }

    public void setCzas_odjazdu_z_petli(Timestamp czas_odjazdu) {
        this.czas_odjazdu_z_petli = czas_odjazdu;
    }

    public int getOpoznienie() {
        return opoznienie;
    }

    public void setOpoznienie(int opoznienie) {
        this.opoznienie = opoznienie;
    }

    public int getNastepny_przystanek() {
        return nastepny_przystanek;
    }

    public void setNastepny_przystanek(int nastepny_przystanek) {
        this.nastepny_przystanek = nastepny_przystanek;
    }
}
