package com.example.mpkApp.modele;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;

@Entity
@Table(name = "kursy")
public class KursyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kursy_id_gen")
    @SequenceGenerator(name = "kursy_id_gen", sequenceName = "kursy_id_seq", allocationSize = 1)
    private Integer id;

    @Column(nullable = false, name = "czas_odjazdu_z_petli")
    @NotNull(message = "CzasOdjazduZPetli is null!")
    private Timestamp czasOdjazduZPetli;

    @Column(nullable = false)
    @NotNull(message = "Opoznienie is null!")
    private Integer opoznienie;

    @Column(nullable = false)
    @NotNull(message = "NastepnyPrzystanek is null!")
    private Integer nastepnyPrzystanek;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "tramwaj_id", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_tramwaj_id"))
    private TramwajeModel tramwaje;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "linia_id", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_linia_id"))
    private LinieModel linia;

    public KursyModel() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getCzasOdjazduZPetli() {
        return czasOdjazduZPetli;
    }

    public void setCzasOdjazduZPetli(Timestamp czasOdjazduZPetli) {
        this.czasOdjazduZPetli = czasOdjazduZPetli;
    }

    public Integer getOpoznienie() {
        return opoznienie;
    }

    public void setOpoznienie(Integer opoznienie) {
        this.opoznienie = opoznienie;
    }

    public Integer getNastepnyPrzystanek() {
        return nastepnyPrzystanek;
    }

    public void setNastepnyPrzystanek(Integer nastepnyPrzystanek) {
        this.nastepnyPrzystanek = nastepnyPrzystanek;
    }

    public TramwajeModel getTramwaje() {
        return tramwaje;
    }

    public void setTramwaje(TramwajeModel tramwaje) {
        this.tramwaje = tramwaje;
    }

    public LinieModel getLinia() {
        return linia;
    }

    public void setLinia(LinieModel linia) {
        this.linia = linia;
    }
}
