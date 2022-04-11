package com.lmlucas.lecoledesloustics.CultureGénérale;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lmlucas.lecoledesloustics.R;

public class CultureHomeActivity extends AppCompatActivity {

    public final static int RES_REQUEST = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culture_home);
    }

    @SuppressLint("NonConstantResourceId")
    public void onClick(View view) {
        // On récupère l'id de la vue cliquée
        switch (view.getId()) {
            case R.id.boutonCultureTousTheme:
                Intent intent = new Intent(this, CultureQuestionsActivity.class);
                intent.putExtra(CultureQuestionsActivity.QUESTIONS_THEME, "tous");
                startActivityForResult(intent, RES_REQUEST);
                break;
            case R.id.boutonCultureRetour:
                super.finish();
                break;
        }
    }
}