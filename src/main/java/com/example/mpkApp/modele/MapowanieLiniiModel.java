package com.example.mpkApp.modele;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "mapowanie_linii")
public class MapowanieLiniiModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mapowanie_Linii_id_gen")
    @SequenceGenerator(name = "mapowanie_Linii_id_gen", sequenceName = "mapowanie_Linii_id_seq", allocationSize = 1)
    private Integer id;

    @Column(nullable = false)
    @NotNull(message = "NumerPrzystankuLinii is null!")
    private Integer numerPrzystankuLinii;

    @Column(nullable = false)
    @NotNull(message = "RoznicaCzasu is null!")
    private Integer roznicaCzasu;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "linia_id", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_linia_id"))
    private LinieModel linia;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "przystanek_id", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_przystanek_id"))
    private PrzystankiModel przystanek;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumerPrzystankuLinii() {
        return numerPrzystankuLinii;
    }

    public void setNumerPrzystankuLinii(Integer numer_przystanku_linii) {
        this.numerPrzystankuLinii = numer_przystanku_linii;
    }

    public Integer getRoznicaCzasu() {
        return roznicaCzasu;
    }

    public void setRoznicaCzasu(Integer roznica_czasu) {
        this.roznicaCzasu = roznica_czasu;
    }

    public @NotNull LinieModel getLinia() {
        return linia;
    }

    public void setLinia(@NotNull LinieModel linia) {
        this.linia = linia;
    }

    public @NotNull PrzystankiModel getPrzystanek() {
        return przystanek;
    }

    public void setPrzystanek(@NotNull PrzystankiModel przystanek) {
        this.przystanek = przystanek;
    }
}
