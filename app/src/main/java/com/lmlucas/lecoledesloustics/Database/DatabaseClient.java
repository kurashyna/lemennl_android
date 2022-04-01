package com.lmlucas.lecoledesloustics.Database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

public class DatabaseClient {

    private static DatabaseClient instance;

    private AppDatabase appDatabase;

    private DatabaseClient(final Context context){
        // Créer l'objet représentant la base de données de votre application à l'aide du "Room database builder"
        // LousticDatabase est le nom de la base de données
        //appDatabase = Room.databaseBuilder(context, AppDatabase.class, "LousticDatabase").build();

        ////////// REMPLIR LA BD à la première création à l'aide de l'objet roomDatabaseCallback
        // Ajout de la méthode addCallback permettant de populate (remplir) la base de données à sa création
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, "LousticDatabase").addCallback(roomDatabaseCallback).build();
    }

    // Méthode statique
    // Retourne l'instance de l'objet DatabaseClient
    public static synchronized DatabaseClient getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseClient(context);
        }
        return instance;
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }

    RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback() {

        // Called when the database is created for the first time.
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // Permets de remplir la base de données à la première création
            db.execSQL("INSERT INTO Eleves (nomEleve, ageEleve) VALUES(\"Nom Eleve 1\", \"8\");");
            db.execSQL("INSERT INTO Eleves (nomEleve, ageEleve) VALUES(\"Nom Eleve 2\", \"8\");");

        }
    };
}
