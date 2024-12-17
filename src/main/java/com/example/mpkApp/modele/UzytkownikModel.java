package com.example.mpkApp.modele;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table (name = "uzytkownik")
public class UzytkownikModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "uzytkownik_id_gen")
    @SequenceGenerator(name = "uzytkownik_id_gen", sequenceName = "uzytkownik_id_seq", allocationSize = 1)
    Integer id;

    @Column(nullable = false, unique = true)
    @NotNull(message = "Email can't be null")
    private String email;

    @Column(nullable = false)
    @NotNull(message = "Haslo can't be null")
    private String haslo;

    @Column(nullable = false)
    @NotNull(message = "Rola can't be null")
    private String rola;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String password) {
        this.haslo = password;
    }

    public String getRola() {
        return rola;
    }

    public void setRola(String rola) {
        this.rola = rola;
    }
}
