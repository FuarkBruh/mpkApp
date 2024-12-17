package com.example.mpkApp.modele;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.sql.Timestamp;

@Entity
@Table(name = "przystanki")
public class PrzystankiModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "przystanki_id_gen")
    @SequenceGenerator(name = "przystanki_id_gen", sequenceName = "przystanki_id_seq", allocationSize = 1)
    private Integer id;

    @Column(nullable = false, unique = true)
    @NotNull(message = "Nazwa is null!")
    private String nazwa;

    @Column(nullable = false, unique = true)
    @NotNull(message = "Lokalizacja is null!")
    private String Lokalizacja;

    @Column(nullable = false)
    @NotNull(message = "DataDodania is null!")
    private Timestamp dataDodania;

    @Column
    @NotNull(message = "DataEdycji is null!")
    private Timestamp dataEdycji;

    @Column
    @NotNull(message = "Uwagi is null!")
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
