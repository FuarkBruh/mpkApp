package com.example.mpkApp.modele;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "mapowanie_linii")
public class MapowanieLiniiModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mapowanie_Linii_id_gen")
    @SequenceGenerator(name = "mapowanie_Linii_id_gen", sequenceName = "mapowanie_Linii_id_seq", allocationSize = 1)
    private int id;

    @NotNull
    private int liniaId;

    @NotNull
    private int przystanekId;

    @NotNull
    private int numerPrzystankuLinii;

    @NotNull
    private int roznicaCzasu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLiniaId() {
        return liniaId;
    }

    public void setLiniaId(int linia_id) {
        this.liniaId = linia_id;
    }

    public int getPrzystanekId() {
        return przystanekId;
    }

    public void setPrzystanekId(int przystanek_id) {
        this.przystanekId = przystanek_id;
    }

    public int getNumerPrzystankuLinii() {
        return numerPrzystankuLinii;
    }

    public void setNumerPrzystankuLinii(int numer_przystanku_linii) {
        this.numerPrzystankuLinii = numer_przystanku_linii;
    }

    public int getRoznicaCzasu() {
        return roznicaCzasu;
    }

    public void setRoznicaCzasu(int roznica_czasu) {
        this.roznicaCzasu = roznica_czasu;
    }
}
