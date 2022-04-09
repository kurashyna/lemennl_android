package com.lmlucas.lecoledesloustics.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.lmlucas.lecoledesloustics.Models.Eleve;
import com.lmlucas.lecoledesloustics.Models.Question;

@Database(entities = {Eleve.class, Question.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract EleveDao eleveDao();
    public abstract QuestionsDao questionsDao();
}
