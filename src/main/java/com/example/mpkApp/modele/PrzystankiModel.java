package com.example.mpkApp.modele;

import jakarta.persistence.*;

@Entity
@Table(name = "przystanki")
public class PrzystankiModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "przystanki_id_gen")
    @SequenceGenerator(name = "przystanki_id_gen", sequenceName = "przystanki_id_seq", allocationSize = 1)
    private int id;
    private String nazwa;
    private String wspolrzedne_lokalizacji;

    public PrzystankiModel() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getWspolrzedne_lokalizacji() {
        return wspolrzedne_lokalizacji;
    }

    public void setWspolrzedne_lokalizacji(String wspolrzedne_lokalizacji) {
        this.wspolrzedne_lokalizacji = wspolrzedne_lokalizacji;
    }



}
