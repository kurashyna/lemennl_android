package com.lmlucas.lecoledesloustics;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.lmlucas.lecoledesloustics.Database.DatabaseClient;
import com.lmlucas.lecoledesloustics.Home.AddEleveActivity;
import com.lmlucas.lecoledesloustics.Home.HomeActivity;
import com.lmlucas.lecoledesloustics.Models.Eleve;
import com.lmlucas.lecoledesloustics.Models.EleveAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public final static int ADD_ELEVE_REQUEST = 1;

    // Base de données
    private DatabaseClient dbClient;
    private List<Eleve> ListeEleves;

    private EleveAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // On récupère l'instance de la BDD
        dbClient = DatabaseClient.getInstance(getApplicationContext());

        // On récupère le RecyclerView du layout.
        RecyclerView rvEleves = (RecyclerView) findViewById(R.id.listeElevesView);
        adapter = new EleveAdapter(new ArrayList<Eleve>());
        rvEleves.setAdapter(adapter);
        rvEleves.setLayoutManager(new LinearLayoutManager(this));

    }

    // Récupération des élèves depuis la BDD
    private void getEleves() {
        class GetEleves extends AsyncTask<Void, Void, List<Eleve>> {
            @Override
            protected List<Eleve> doInBackground(Void... voids) {
                // On récupère les élèves depuis la BDD
                List<Eleve> listeEleves = dbClient.getAppDatabase().eleveDao().getAll();
                return listeEleves;
            }

            @Override
            protected void onPostExecute(List<Eleve> eleves) {
                // On affiche les élèves dans le RecyclerView
                super.onPostExecute(eleves);
                adapter.swap(eleves);
            }

        }
        GetEleves getEleves = new GetEleves();
        getEleves.execute();
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Mise à jour des élèves
        getEleves();

    }

    public void onAnonymous(View view) {
        // Si on clique sur "Continuer en tant qu'anonyme"
        Intent intent = new Intent(this, HomeActivity.class);
        Eleve eleve = new Eleve();
        eleve.setNomEleve("Anonyme");
        eleve.setAgeEleve(0);
        eleve.setId(-1);
        intent.putExtra("eleve", eleve);
        startActivity(intent);
    }

    public void addEleve(View view) {
        // Si on clique sur "Ajouter un élève"
        Intent intent = new Intent(this, AddEleveActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivityForResult(intent, ADD_ELEVE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_ELEVE_REQUEST && resultCode == RESULT_OK) {
            Toast.makeText(this, "Eleve ajouté", Toast.LENGTH_LONG).show();
            getEleves();
        }
    }
}