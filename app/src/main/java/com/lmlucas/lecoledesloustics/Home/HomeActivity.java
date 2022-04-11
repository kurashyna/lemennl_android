package com.lmlucas.lecoledesloustics.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lmlucas.lecoledesloustics.CultureGénérale.CultureHomeActivity;
import com.lmlucas.lecoledesloustics.Mathematiques.MathematiquesHomeActivity;
import com.lmlucas.lecoledesloustics.Models.Eleve;
import com.lmlucas.lecoledesloustics.R;

public class HomeActivity extends AppCompatActivity {

    public static final String eleveKey = "eleve";
    Intent intent;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Récupération de l'élève
        Eleve student = getIntent().getParcelableExtra(eleveKey);
        TextView studentWelcome = findViewById(R.id.homeStudentWelcome);
        // Affichage du nom de l'élève
        studentWelcome.setText(studentWelcome.getText().toString() + " " + student.getNomEleve());
    }

    // Méthode qui permet de rediriger vers l'activité choisie
    public void onActivityClick(View view) {
        switch (view.getId()) {
            case R.id.imageMaths:
                // Redirection vers l'activité des maths
                intent = new Intent(this, MathematiquesHomeActivity.class);
                startActivity(intent);
                break;
            case R.id.imageCulture:
                // Redirection vers l'activité sur la culture générale
                intent = new Intent(this, CultureHomeActivity.class);
                startActivity(intent);
                break;
            case R.id.homeBoutonRetour:
                // Redirection vers l'activité de connexion
                super.finish();
                break;
        }
    }
}