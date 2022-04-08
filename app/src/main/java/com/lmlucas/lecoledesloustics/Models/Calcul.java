package com.lmlucas.lecoledesloustics.Models;

public class Calcul {
    private int Operand1, Operand2, resultat;
    private String Operation;

    public Calcul(int Operand1, int Operand2, String Operation) {
        this.Operand1 = Operand1;
        this.Operand2 = Operand2;
        this.Operation = Operation;
    }

    public int getOperand1() {
        return Operand1;
    }

    public void setOperand1(int operand1) {
        Operand1 = operand1;
    }

    public int getOperand2() {
        return Operand2;
    }

    public void setOperand2(int operand2) {
        Operand2 = operand2;
    }

    public String getOperation() {
        return Operation;
    }

    public void setOperation(String operation) {
        Operation = operation;
    }


    public static Calcul randomCalcul() {
        int Operand1 = (int) (Math.random() * 10);
        int Operand2 = (int) (Math.random() * 10);
        while (Operand1 - Operand2 < 0) {
            Operand1 = (int) (Math.random() * 10);
            Operand2 = (int) (Math.random() * 10);
        }
        String Operation = "";
        int random = (int) (Math.random() * 3);
        switch (random) {
            case 0:
                Operation = "+";
                break;
            case 1:
                Operation = "-";
                break;
            case 2:
                Operation = "*";
                break;
        }
        return new Calcul(Operand1, Operand2, Operation);
    }

    public int getResultat() {
        return resultat;
    }

    public void setResultat(int resultat) {
        this.resultat = resultat;
    }
}
