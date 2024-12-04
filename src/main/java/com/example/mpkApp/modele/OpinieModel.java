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
    private int id_uzytkownika;
    private String numer_linii;
    private String numer_boczny;
    private Timestamp godzina;
    private String tresc_opinii;

    public OpinieModel() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_uzytkownika() {
        return id_uzytkownika;
    }

    public void setId_uzytkownika(int id_uzytkownika) {
        this.id_uzytkownika = id_uzytkownika;
    }

    public String getNumer_linii() {
        return numer_linii;
    }

    public void setNumer_linii(String numer_linii) {
        this.numer_linii = numer_linii;
    }

    public String getNumer_boczny() {
        return numer_boczny;
    }

    public void setNumer_boczny(String numer_boczny) {
        this.numer_boczny = numer_boczny;
    }

    public Timestamp getGodzina() {
        return godzina;
    }

    public void setGodzina(Timestamp godzina) {
        this.godzina = godzina;
    }

    public String getTresc_opinii() {
        return tresc_opinii;
    }

    public void setTresc_opinii(String tresc_opinii) {
        this.tresc_opinii = tresc_opinii;
    }
}
