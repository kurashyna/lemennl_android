package com.lmlucas.lecoledesloustics.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.lmlucas.lecoledesloustics.Database.DatabaseClient;
import com.lmlucas.lecoledesloustics.Models.Eleve;
import com.lmlucas.lecoledesloustics.R;

import java.util.List;

public class AddEleveActivity extends AppCompatActivity {

    private DatabaseClient dbClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_eleve);
        // On récupère la base de données
        dbClient = DatabaseClient.getInstance(getApplicationContext());
    }

    public void addEleve(View view) {
        // On récupère les données saisies
        // et on crée un nouvel élève avec ces données
        class CreateEleve extends AsyncTask<Void, Void, Eleve> {
            @Override
            protected Eleve doInBackground(Void... voids) {
                try {
                    EditText nomEleveView = (EditText) findViewById(R.id.AddEleveNomEditText);
                    EditText ageEleveView = (EditText) findViewById(R.id.AddEleveAgeEditText);
                    // On récupère les données saisies
                    if (nomEleveView.getText().toString().isEmpty() || ageEleveView.getText().toString().isEmpty()) {
                        // Si l'un des champs est vide, on renvoie null
                        return null;
                    }
                    String nomEleve = nomEleveView.getText().toString();
                    String ageEleveString = ageEleveView.getText().toString();
                    int ageEleve = Integer.parseInt(ageEleveString);
                    int id = dbClient.getAppDatabase().eleveDao().getLastId() + 1;
                    Eleve eleve = new Eleve(id, nomEleve, ageEleve);
                    // On ajoute l'élève à la base de données
                    dbClient.getAppDatabase().eleveDao().insert(eleve);
                    return eleve;
                } catch (Exception e) {
                    // Si une erreur survient, on renvoie null
                    return null;
                }

            }

            @Override
            protected void onPostExecute(Eleve eleve) {
                super.onPostExecute(eleve);
                if (eleve != null) {
                    // Si l'élève a été créé, on affiche un message de succès
                    setResult(RESULT_OK);
                    finish();
                } else {
                    // Sinon, on affiche un message d'erreur
                    Toast toast = Toast.makeText(getApplicationContext(), "Veuillez remplir tous les champs", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }

        }
        CreateEleve createEleve = new CreateEleve();
        createEleve.execute();
    }
}