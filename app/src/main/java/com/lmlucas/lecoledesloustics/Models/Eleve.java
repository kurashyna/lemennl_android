package com.lmlucas.lecoledesloustics.Models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Eleves")
public class Eleve {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String nomEleve;
    private int ageEleve;
//
//    public Eleve(String nom, int age){
//        nomEleve = nom;
//        ageEleve = age;
//    }
public long getId() {
    return id;
}

    public void setId(long id) {
        this.id = id;
    }
    public void setNomEleve(String nomEleve){
    this.nomEleve = nomEleve;
    }

    public void setAgeEleve(int ageEleve){
        this.ageEleve = ageEleve;
    }

    public int getAgeEleve() {
        return ageEleve;
    }

    public String getNomEleve() {
        return nomEleve;
    }
}
