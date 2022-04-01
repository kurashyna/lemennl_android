package com.lmlucas.lecoledesloustics.Models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Eleves")
public class Eleve implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String nomEleve;
    private int ageEleve;

    public Eleve(){}
    public Eleve(String nomEleve, int ageEleve) {
        this.nomEleve = nomEleve;
        this.ageEleve = ageEleve;
    }
    protected Eleve(Parcel in) {
        id = in.readLong();
        nomEleve = in.readString();
        ageEleve = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(nomEleve);
        dest.writeInt(ageEleve);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Eleve> CREATOR = new Creator<Eleve>() {
        @Override
        public Eleve createFromParcel(Parcel in) {
            return new Eleve(in);
        }

        @Override
        public Eleve[] newArray(int size) {
            return new Eleve[size];
        }
    };

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
