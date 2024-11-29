package com.example.mpkApp.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "kursy")
public class KursyModel {
    @Id
    private int id;
    private int tramwaj_id;
    private int linia_id;
    private Timestamp czas_odjazdu;
    private int opoznienie;

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

    public Timestamp getCzas_odjazdu() {
        return czas_odjazdu;
    }

    public void setCzas_odjazdu(Timestamp czas_odjazdu) {
        this.czas_odjazdu = czas_odjazdu;
    }

    public int getOpoznienie() {
        return opoznienie;
    }

    public void setOpoznienie(int opoznienie) {
        this.opoznienie = opoznienie;
    }
}
