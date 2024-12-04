package com.example.mpkApp.modele;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tramwaje")
public class TramwajeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tramwaj_id_gen")
    @SequenceGenerator(name = "tramwaj_id_gen", sequenceName = "tramwaje_id_seq", allocationSize = 1)
    private Integer id;

    @NotNull(message = "model Can't be null")
    private String model;

    @NotNull(message = "numerBoczny Can't be null")
    private String numer_boczny;

    @Min(value = 1900, message = "Invalid year of production")
    @Max(value = 2100, message = "Invalid year of production")
    @NotNull(message = "Can't be null")
    private Integer rok_produkcji;

    @Min(value = 0, message = "Invalid pojemnosc")
    @NotNull(message = "pojemnosc Can't be null")
    private Integer pojemnosc;

    private String uwagi;

    public TramwajeModel() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getRok_produkcji() {
        return rok_produkcji;
    }

    public void setRok_produkcji(int rokProdukcji) {
        this.rok_produkcji = rokProdukcji;
    }

    public String getNumer_boczny() {
        return numer_boczny;
    }

    public void setNumer_boczny(String numerBoczny) {
        this.numer_boczny = numerBoczny;
    }

    public Integer getPojemnosc() {
        return pojemnosc;
    }

    public void setPojemnosc(int pojemnosc) {
        this.pojemnosc = pojemnosc;
    }

    public String getUwagi() {
        return uwagi;
    }

    public void setUwagi(String uwagi) {
        this.uwagi = uwagi;
    }
}

