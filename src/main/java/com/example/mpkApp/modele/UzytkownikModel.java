package com.example.mpkApp.modele;

import jakarta.persistence.*;

@Entity
@Table (name = "uzytkownik")
public class UzytkownikModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "uzytkownik_id_gen")
    @SequenceGenerator(name = "uzytkownik_id_gen", sequenceName = "uzytkownik_id_seq", allocationSize = 1)
    int id;
    String nick;
    String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
