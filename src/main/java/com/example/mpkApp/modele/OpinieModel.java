package com.example.mpkApp.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "opinie")
public class OpinieModel {
    @Id
    private int id;
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
