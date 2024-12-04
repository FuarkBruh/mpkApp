package com.example.mpkApp.modele;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "rozklad")
public class RozkladModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rozklad_id_gen")
    @SequenceGenerator(name = "rozklad_id_gen", sequenceName = "rozklad_id_seq", allocationSize = 1)
    private int id;
    private int numer_linii;
    private Timestamp czas_startu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumer_linii() {
        return numer_linii;
    }

    public void setNumer_linii(int numer_linii) {
        this.numer_linii = numer_linii;
    }

    public Timestamp getCzas_startu() {
        return czas_startu;
    }

    public void setCzas_startu(Timestamp czas_startu) {
        this.czas_startu = czas_startu;
    }
}
