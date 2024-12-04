package com.example.mpkApp.modele;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "opinie")
public class OpinieModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opinie_id_gen")
    @SequenceGenerator(name = "opinie_id_gen", sequenceName = "opinie_id_seq", allocationSize = 1)
    private int id;
    private int idUzytkownika;
    private String numerLinii;
    private String numerBoczny;
    private Timestamp godzina;
    private String trescOpinii;

    public OpinieModel() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUzytkownika() {
        return idUzytkownika;
    }

    public void setIdUzytkownika(int id_uzytkownika) {
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
