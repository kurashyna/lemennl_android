package com.lmlucas.lecoledesloustics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.lmlucas.lecoledesloustics.Home.HomeActivity;
import com.lmlucas.lecoledesloustics.Models.Eleve;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String nomEleves[] = {"Eleve 1", "Eleve 2", "Eleve 3", "Eleve 4", "Eleve"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // On récupère le RecyclerView du layout.
        RecyclerView rvEleves = (RecyclerView) findViewById(R.id.listeElevesView);

        // On créer nos élèves
        List<Eleve> listeEleves = new ArrayList<>();
        for (String nom : nomEleves) {
            listeEleves.add(new Eleve(nom, 8));
        }

        //
        EleveAdapter adapter = new EleveAdapter(listeEleves);
        rvEleves.setAdapter(adapter);
        rvEleves.setLayoutManager(new LinearLayoutManager(this));
    }

    public void studentChosen(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        TextView studentNameView = (TextView) view;

        intent.putExtra(HomeActivity.STUDENT_NAME, studentNameView.getText().toString());
        startActivity(intent);
    }
}