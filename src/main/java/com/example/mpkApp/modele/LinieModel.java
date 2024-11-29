package com.example.mpkApp.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "linie")
public class LinieModel {
    @Id
    private int id;
    private String numer;
    private int calkowity_czas_przejazdu;
    private int dystans;

    public LinieModel() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumer() {
        return numer;
    }

    public void setNumer(String numer) {
        this.numer = numer;
    }

    public int getCalkowity_czas_przejazdu() {
        return calkowity_czas_przejazdu;
    }

    public void setCalkowity_czas_przejazdu(int calkowity_czas_przejazdu) {
        this.calkowity_czas_przejazdu = calkowity_czas_przejazdu;
    }

    public int getDystans() {
        return dystans;
    }

    public void setDystans(int dystans) {
        this.dystans = dystans;
    }
}
