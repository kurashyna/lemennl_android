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

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Get the student name from the intent
        Eleve student= getIntent().getParcelableExtra(eleveKey);
        TextView studentWelcome = findViewById(R.id.homeStudentWelcome);
        studentWelcome.setText(studentWelcome.getText().toString() + " " + student.getNomEleve());
    }
    Intent intent;
    public void onActivityClick(View view) {
        switch (view.getId()) {
            case R.id.imageMaths:
                intent = new Intent(this, MathematiquesHomeActivity.class);
                startActivity(intent);
                break;
            case R.id.imageCulture:
                intent = new Intent(this, CultureHomeActivity.class);
                startActivity(intent);
                break;
            case R.id.homeBoutonRetour:
                super.finish();
                break;
        }
    }
}