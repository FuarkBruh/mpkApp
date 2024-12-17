package com.example.mpkApp.modele;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "przystanki")
public class PrzystankiModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "przystanki_id_gen")
    @SequenceGenerator(name = "przystanki_id_gen", sequenceName = "przystanki_id_seq", allocationSize = 1)
    private Integer id;
    private String nazwa;
    private String Lokalizacja;
    private Timestamp dataDodania;
    private Timestamp dataEdycji;
    private String uwagi;

    public PrzystankiModel() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getLokalizacja() {
        return Lokalizacja;
    }

    public void setLokalizacja(String wspolrzedne_lokalizacji) {
        this.Lokalizacja = wspolrzedne_lokalizacji;
    }

    public Timestamp getDataDodania() {
        return dataDodania;
    }

    public void setDataDodania(Timestamp dataDodania) {
        this.dataDodania = dataDodania;
    }

    public Timestamp getDataEdycji() {
        return dataEdycji;
    }

    public void setDataEdycji(Timestamp dataEdycji) {
        this.dataEdycji = dataEdycji;
    }

    public String getUwagi() {
        return uwagi;
    }

    public void setUwagi(String uwagi) {
        this.uwagi = uwagi;
    }
}
