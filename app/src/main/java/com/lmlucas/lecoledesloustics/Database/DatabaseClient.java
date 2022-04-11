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
            /*db.execSQL("INSERT INTO Eleves (nomEleve, ageEleve) VALUES(\"Nom Eleve 1\", \"8\");");
            db.execSQL("INSERT INTO Eleves (nomEleve, ageEleve) VALUES(\"Nom Eleve 2\", \"8\");");*/

            // On ajoute les questions à la base de données
            db.execSQL("INSERT INTO Questions (tag, question, numeroBonneReponse, reponse1, reponse2, reponse3) " +
                    "VALUES(\"francais\", \"De quel groupes sont les verbes en -er\", \"1\", \"1er groupe\", \"2eme groupe\", \"3eme groupe\");");
            db.execSQL("INSERT INTO Questions (tag, question, numeroBonneReponse, reponse1, reponse2, reponse3) " +
                    "VALUES(\"culture\", \"Dans quelle ville trouvons-nous la prison d'Alcatraz ?\", \"3\", \"Paris\", \"Washington\", \"San Francisco\");");
            db.execSQL("INSERT INTO Questions (tag, question, numeroBonneReponse, reponse1, reponse2, reponse3) " +
                    "VALUES(\"francais\", \"De quel groupes sont les verbes en -ir\", \"3\", \"1er groupe\", \"2eme groupe\", \"3eme groupe\");");
            db.execSQL("INSERT INTO Questions (tag, question, numeroBonneReponse, reponse1, reponse2, reponse3) " +
                    "VALUES(\"culture\", \"Dans quelle ville trouvons-nous le Pont Chaban Delmas ?\", \"2\", \"Paris\", \"Bordeaux\", \"Grenoble\");");
            db.execSQL("INSERT INTO Questions (tag, question, numeroBonneReponse, reponse1, reponse2, reponse3) " +
                    "VALUES(\"culture\", \"Dans quelle ville trouvons-nous le quartier de La Défense ?\", \"3\", \"Paris\", \"Colombes\", \"Courbevoie\");");
            db.execSQL("INSERT INTO Questions (tag, question, numeroBonneReponse, reponse1, reponse2, reponse3) " +
                    "VALUES(\"musiqueFrancaise\", \"A l'Eurovision 2017, qui chante Requiem ?\", \"2\", \"Angèle\", \"Alma\", \"Amel Bent\");");
            db.execSQL("INSERT INTO Questions (tag, question, numeroBonneReponse, reponse1, reponse2, reponse3) " +
                    "VALUES(\"musiqueFrancaise\", \"Qui chante le titre Dernière Danse de l'album Mini World ?\", \"1\", \"Indila\", \"Tal\", \"Shy'm\");");
            db.execSQL("INSERT INTO Questions (tag, question, numeroBonneReponse, reponse1, reponse2, reponse3) " +
                    "VALUES(\"culture\", \"Quand à eu lieu l'ouverture de la Tour Eiffel ?\", \"3\", \"15 Avril 1889\", \"27 Janvier 1889\", \"31 Mars 1889\");");
            db.execSQL("INSERT INTO Questions (tag, question, numeroBonneReponse, reponse1, reponse2, reponse3) " +
                    "VALUES(\"francais\", \"Quelle est la bonne ortographe du mot : chato ?\", \"1\", \"Château\", \"Châto\", \"Châteu\");");
            db.execSQL("INSERT INTO Questions (tag, question, numeroBonneReponse, reponse1, reponse2, reponse3) " +
                    "VALUES(\"francais\", \"Que signifie COD ?\", \"3\", \"Call of duty\", \"Coordination d'Objets Determinés\", \"Complement d'Objet Direct\");");

        }
    };
}
