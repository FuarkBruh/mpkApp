package com.example.mpkApp.modele;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;

@Entity
@Table(name = "rozklad")
public class RozkladModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rozklad_id_gen")
    @SequenceGenerator(name = "rozklad_id_gen", sequenceName = "rozklad_id_seq", allocationSize = 1)
    private Integer id;

    @Column(nullable = false)
    @NotNull(message = "NumerLinii is null!")
    private Integer numerLinii;

    @Column(nullable = false)
    @NotNull(message = "CzasStartu is null!")
    private Timestamp czasStartu;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumerLinii() {
        return numerLinii;
    }

    public void setNumerLinii(Integer numer_linii) {
        this.numerLinii = numer_linii;
    }

    public Timestamp getCzasStartu() {
        return czasStartu;
    }

    public void setCzasStartu(Timestamp czas_startu) {
        this.czasStartu = czas_startu;
    }
}
