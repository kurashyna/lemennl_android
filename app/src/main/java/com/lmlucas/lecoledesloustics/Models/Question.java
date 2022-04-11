package com.lmlucas.lecoledesloustics.Models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "Questions")
public class Question implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    // le tag correspond a la categorie de la question
    // numeroBonneResponse correspond au numero de la bonne reponse
    private String tag;
    private String question;
    private int numeroBonneReponse;
    private String reponse1;
    private String reponse2;
    private String reponse3;

    public Question() {
    }

    public Question(String tag, String question, int numeroBonneReponse, String reponse1, String reponse2, String reponse3) {
        this.tag = tag;
        this.question = question;
        this.numeroBonneReponse = numeroBonneReponse;
        this.reponse1 = reponse1;
        this.reponse2 = reponse2;
        this.reponse3 = reponse3;
    }


    protected Question(Parcel in) {
        id = in.readInt();
        tag = in.readString();
        question = in.readString();
        numeroBonneReponse = in.readInt();
        reponse1 = in.readString();
        reponse2 = in.readString();
        reponse3 = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(tag);
        dest.writeString(question);
        dest.writeInt(numeroBonneReponse);
        dest.writeString(reponse1);
        dest.writeString(reponse2);
        dest.writeString(reponse3);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    public String getBonneReponse(){
    // renvoie la bonne reponse en fonction du numero de la bonne reponse
        switch (numeroBonneReponse){
            case 1:
                return reponse1;
            case 2:
                return reponse2;
            case 3:
                return reponse3;
            default:
                return null;
        }
    }
    public List<String> getReponses(){
        // renvoie les reponses dans une liste
        List<String> reponses = new java.util.ArrayList<>();
        reponses.add(reponse1);
        reponses.add(reponse2);
        reponses.add(reponse3);
        return reponses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getNumeroBonneReponse() {
        return numeroBonneReponse;
    }

    public void setNumeroBonneReponse(int numeroBonneReponse) {
        this.numeroBonneReponse = numeroBonneReponse;
    }

    public String getReponse1() {
        return reponse1;
    }

    public void setReponse1(String reponse1) {
        this.reponse1 = reponse1;
    }

    public String getReponse2() {
        return reponse2;
    }

    public void setReponse2(String reponse2) {
        this.reponse2 = reponse2;
    }

    public String getReponse3() {
        return reponse3;
    }

    public void setReponse3(String reponse3) {
        this.reponse3 = reponse3;
    }
}
