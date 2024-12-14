package com.example.mpkApp.modele;

import jakarta.persistence.*;

@Entity
@Table(name = "przystanki")
public class PrzystankiModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "przystanki_id_gen")
    @SequenceGenerator(name = "przystanki_id_gen", sequenceName = "przystanki_id_seq", allocationSize = 1)
    private Integer id;
    private String nazwa;
    private String wspolrzedneLokalizacji;

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

    public String getWspolrzedneLokalizacji() {
        return wspolrzedneLokalizacji;
    }

    public void setWspolrzedneLokalizacji(String wspolrzedne_lokalizacji) {
        this.wspolrzedneLokalizacji = wspolrzedne_lokalizacji;
    }



}
