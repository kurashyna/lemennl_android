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
        dbClient = DatabaseClient.getInstance(getApplicationContext());
    }

    public void addEleve(View view) {

        class CreateEleve extends AsyncTask<Void, Void, Eleve> {
            @Override
            protected Eleve doInBackground(Void... voids){
                try {
                    EditText nomEleveView = (EditText) findViewById(R.id.AddEleveNomEditText);
                    EditText ageEleveView = (EditText) findViewById(R.id.AddEleveAgeEditText);
                    if (nomEleveView.getText().toString().isEmpty() || ageEleveView.getText().toString().isEmpty()) {
                        return null;
                    }
                    String nomEleve = nomEleveView.getText().toString();
                    String ageEleveString = ageEleveView.getText().toString();
                    int ageEleve = Integer.parseInt(ageEleveString);
                    int id = dbClient.getAppDatabase().eleveDao().getLastId() + 1;
                    Eleve eleve = new Eleve(id, nomEleve, ageEleve);
                    dbClient.getAppDatabase().eleveDao().insert(eleve);
                    return eleve;
                } catch (Exception e) {
                    return null;
                }

            }
            @Override
            protected void onPostExecute(Eleve eleve){
                super.onPostExecute(eleve);
                if (eleve != null) {
                    setResult(RESULT_OK);
                    finish();
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Veuillez remplir tous les champs", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }

        }
        CreateEleve createEleve = new CreateEleve();
        createEleve.execute();
    }
}