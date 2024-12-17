package com.example.mpkApp.modele;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "mapowanie_linii")
public class MapowanieLiniiModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mapowanie_Linii_id_gen")
    @SequenceGenerator(name = "mapowanie_Linii_id_gen", sequenceName = "mapowanie_Linii_id_seq", allocationSize = 1)
    private Integer id;

    @Column(nullable = false)
    @NotNull(message = "LiniaId is null!")
    private Integer liniaId;

    @Column(nullable = false)
    @NotNull(message = "PrzystanekId is null!")
    private Integer przystanekId;

    @Column(nullable = false)
    @NotNull(message = "NumerPrzystankuLinii is null!")
    private Integer numerPrzystankuLinii;

    @Column(nullable = false)
    @NotNull(message = "RoznicaCzasu is null!")
    private Integer roznicaCzasu;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLiniaId() {
        return liniaId;
    }

    public void setLiniaId(Integer linia_id) {
        this.liniaId = linia_id;
    }

    public Integer getPrzystanekId() {
        return przystanekId;
    }

    public void setPrzystanekId(Integer przystanek_id) {
        this.przystanekId = przystanek_id;
    }

    public Integer getNumerPrzystankuLinii() {
        return numerPrzystankuLinii;
    }

    public void setNumerPrzystankuLinii(Integer numer_przystanku_linii) {
        this.numerPrzystankuLinii = numer_przystanku_linii;
    }

    public Integer getRoznicaCzasu() {
        return roznicaCzasu;
    }

    public void setRoznicaCzasu(Integer roznica_czasu) {
        this.roznicaCzasu = roznica_czasu;
    }
}
