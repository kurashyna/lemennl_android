package com.lmlucas.lecoledesloustics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.lmlucas.lecoledesloustics.Database.DatabaseClient;
import com.lmlucas.lecoledesloustics.Models.Eleve;

public class AddEleveActivity extends AppCompatActivity {

    private DatabaseClient dbClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_eleve);
        dbClient = DatabaseClient.getInstance(getApplicationContext());
    }

    public void addEleve(View view) {

       EditText nomEleveView = (EditText) findViewById(R.id.AddEleveNomEditText);
       EditText ageEleveView = (EditText) findViewById(R.id.AddEleveAgeEditText);

       String nomEleve = nomEleveView.getText().toString();
       String ageEleveString = ageEleveView.getText().toString();
       if (ageEleveString.isEmpty()) {
           //TODO : Faire un toast -> "Veuillez entrer un age"
       } else {
           // TODO : Réparer le code pour qu'il fonctionne
           int ageEleve = Integer.parseInt(ageEleveString);
           dbClient.getAppDatabase().eleveDao().insert(new Eleve(nomEleve, ageEleve));
           setResult(RESULT_OK);
           finish();
       }
    }
}