package com.example.mpkApp.modele;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;

@Entity
@Table(name = "opinie")
public class OpinieModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opinie_id_gen")
    @SequenceGenerator(name = "opinie_id_gen", sequenceName = "opinie_id_seq", allocationSize = 1)
    private Integer id;

    @Column
    @NotNull(message = "IdUzytkownika is null!")
    private Integer idUzytkownika;

    @Column
    @NotNull(message = "NumerLinii is null!")
    private String numerLinii;

    @Column
    @NotNull(message = "NumerBoczny is null!")
    private String numerBoczny;

    @Column(nullable = false)
    @NotNull(message = "Godzina is null!")
    private Timestamp godzina;

    @Column(nullable = false)
    @NotNull(message = "TrescOpinii is null!")
    private String trescOpinii;


    public OpinieModel() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUzytkownika() {
        return idUzytkownika;
    }

    public void setIdUzytkownika(Integer id_uzytkownika) {
        this.idUzytkownika = id_uzytkownika;
    }

    public String getNumerLinii() {
        return numerLinii;
    }

    public void setNumerLinii(String numer_linii) {
        this.numerLinii = numer_linii;
    }

    public String getNumerBoczny() {
        return numerBoczny;
    }

    public void setNumerBoczny(String numer_boczny) {
        this.numerBoczny = numer_boczny;
    }

    public Timestamp getGodzina() {
        return godzina;
    }

    public void setGodzina(Timestamp godzina) {
        this.godzina = godzina;
    }

    public String getTrescOpinii() {
        return trescOpinii;
    }

    public void setTrescOpinii(String tresc_opinii) {
        this.trescOpinii = tresc_opinii;
    }
}
