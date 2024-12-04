package com.example.mpkApp.modele;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "mapowanieLinii")
public class MapowanieLiniiModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mapowanie_Linii_id_gen")
    @SequenceGenerator(name = "mapowanie_Linii_id_gen", sequenceName = "mapowanie_Linii_id_seq", allocationSize = 1)
    private int id;

    @NotNull
    private int linia_id;

    @NotNull
    private int przystanek_id;

    @NotNull
    private int numer_przystanku_linii;

    @NotNull
    private int roznica_czasu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLinia_id() {
        return linia_id;
    }

    public void setLinia_id(int linia_id) {
        this.linia_id = linia_id;
    }

    public int getPrzystanek_id() {
        return przystanek_id;
    }

    public void setPrzystanek_id(int przystanek_id) {
        this.przystanek_id = przystanek_id;
    }

    public int getNumer_przystanku_linii() {
        return numer_przystanku_linii;
    }

    public void setNumer_przystanku_linii(int numer_przystanku_linii) {
        this.numer_przystanku_linii = numer_przystanku_linii;
    }

    public int getRoznica_czasu() {
        return roznica_czasu;
    }

    public void setRoznica_czasu(int roznica_czasu) {
        this.roznica_czasu = roznica_czasu;
    }
}
