package com.lmlucas.lecoledesloustics.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.lmlucas.lecoledesloustics.Models.Eleve;

@Database(entities = {Eleve.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract EleveDao eleveDao();

}
