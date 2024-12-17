package com.example.mpkApp.modele;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "linie")
public class LinieModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "linie_id_gen")
    @SequenceGenerator(name = "linie_id_gen", sequenceName = "linie_id_seq", allocationSize = 1)
    private Integer id;

    @Column(nullable = false)
    @NotNull(message = "NumerLinii is null!")
    private String numerLinii;

    @Column(nullable = false)
    @NotNull(message = "CalkowityCzasPrzejazdu is null!")
    private Integer calkowityCzasPrzejazdu;

    public LinieModel() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumer() {
        return numerLinii;
    }

    public void setNumer(String numer) {
        this.numerLinii = numer;
    }

    public int getCalkowityCzasPrzejazdu() {
        return calkowityCzasPrzejazdu;
    }

    public void setCalkowityCzasPrzejazdu(int calkowity_czas_przejazdu) {
        this.calkowityCzasPrzejazdu = calkowity_czas_przejazdu;
    }
}
