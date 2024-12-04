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
    private int numerLinii;
    private Timestamp czasStartu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumerLinii() {
        return numerLinii;
    }

    public void setNumerLinii(int numer_linii) {
        this.numerLinii = numer_linii;
    }

    public Timestamp getCzasStartu() {
        return czasStartu;
    }

    public void setCzasStartu(Timestamp czas_startu) {
        this.czasStartu = czas_startu;
    }
}
