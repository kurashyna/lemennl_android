package com.lmlucas.lecoledesloustics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lmlucas.lecoledesloustics.Database.DatabaseClient;
import com.lmlucas.lecoledesloustics.Home.HomeActivity;
import com.lmlucas.lecoledesloustics.Models.Eleve;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

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

    public void studentChosen(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        TextView studentNameView = (TextView) view;

        intent.putExtra(HomeActivity.STUDENT_NAME, studentNameView.getText().toString());
        startActivity(intent);
    }


    private void getEleves() {
        class GetEleves extends AsyncTask<Void, Void, List<Eleve>> {
            @Override
            protected List<Eleve> doInBackground(Void... voids){
                List<Eleve> listeEleves = dbClient.getAppDatabase().eleveDao().getAll();
                return listeEleves;
            }
            @Override
            protected void onPostExecute(List<Eleve> eleves){
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

        // Mise à jour des taches
        getEleves();

    }
}