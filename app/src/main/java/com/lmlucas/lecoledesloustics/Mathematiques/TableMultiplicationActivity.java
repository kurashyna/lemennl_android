package com.lmlucas.lecoledesloustics.Mathematiques;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;

import com.lmlucas.lecoledesloustics.R;

public class TableMultiplicationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_multiplication);

        // On crée un NumberPicker pour choisir le nombre de table à afficher
        NumberPicker numberPicker = findViewById(R.id.tableMultiplicationNumberPicker);
        // On définit le minimum du NumberPicker
        numberPicker.setMinValue(1);
        // On définit le maximum du NumberPicker
        numberPicker.setMaxValue(9);
    }

    public void onClick(View view) {
        // On récupère le nombre de table à afficher
        NumberPicker numberPicker = findViewById(R.id.tableMultiplicationNumberPicker);
        int tableNumber = numberPicker.getValue();

        // On crée l'intent pour lancer l'activité
        Intent intent = new Intent(this, TableMultiplicationExerciceActivity.class);
        intent.putExtra("TABLE_NUMBER", tableNumber);
        startActivity(intent);
    }

    // On crée une méthode pour quitter l'activité
    public void onClickMenu(View view) {
        super.finish();
    }
}