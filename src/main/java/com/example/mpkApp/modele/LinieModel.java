package com.example.mpkApp.modele;

import jakarta.persistence.*;

@Entity
@Table(name = "linie")
public class LinieModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "linie_id_gen")
    @SequenceGenerator(name = "linie_id_gen", sequenceName = "linie_id_seq", allocationSize = 1)
    private int id;
    private String numer_linii;
    private int calkowity_czas_przejazdu;

    public LinieModel() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumer() {
        return numer_linii;
    }

    public void setNumer(String numer) {
        this.numer_linii = numer;
    }

    public int getCalkowity_czas_przejazdu() {
        return calkowity_czas_przejazdu;
    }

    public void setCalkowity_czas_przejazdu(int calkowity_czas_przejazdu) {
        this.calkowity_czas_przejazdu = calkowity_czas_przejazdu;
    }
}
