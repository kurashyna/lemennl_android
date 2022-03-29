package com.lmlucas.lecoledesloustics.Models;

public class Eleve {
    private long id;
    private String nomEleve;
    private int ageEleve;

    public Eleve(String nom, int age){
        nomEleve = nom;
        ageEleve = age;
    }

    public long getAgeEleve() {
        return ageEleve;
    }

    public String getNomEleve() {
        return nomEleve;
    }
}
