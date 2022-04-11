package com.lmlucas.lecoledesloustics.Models;

import java.util.ArrayList;

public class TableMultiplication {
    private int table;
    ArrayList<Multiplication> multiplications;

    public TableMultiplication(int table){
        this.table = table;
        multiplications = new ArrayList<>();
        // On crée les multiplications de la table demandée
        for (int i=1;i<=10;i++)
        {
            multiplications.add(new Multiplication(i,this.table));
        }
    }

    public ArrayList<Multiplication> getMultiplications()
    {
        return this.multiplications;
    }
}
