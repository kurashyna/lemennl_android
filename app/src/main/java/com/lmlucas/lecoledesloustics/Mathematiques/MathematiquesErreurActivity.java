package com.lmlucas.lecoledesloustics.Mathematiques;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lmlucas.lecoledesloustics.R;

public class MathematiquesErreurActivity extends AppCompatActivity {

    public static final String ERRORS_KEY = "1";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathematiques_erreur);
        String nbErreurs = getIntent().getStringExtra(ERRORS_KEY);
        TextView nbErreursView = findViewById(R.id.multiplicationErreursText);
        // Affichage du nombre d'erreurs
        nbErreursView.setText(nbErreursView.getText() + nbErreurs);
    }

    public void corriger(View view) {
        // Retour aux valeurs saisies
        setResult(RESULT_CANCELED);
        super.finish();
    }

    public void changerTable(View view) {
        // Retour au choix de la table
        Intent intent = new Intent(this, TableMultiplicationActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}