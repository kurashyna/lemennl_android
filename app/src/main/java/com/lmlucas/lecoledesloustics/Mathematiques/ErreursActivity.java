package com.lmlucas.lecoledesloustics.Mathematiques;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lmlucas.lecoledesloustics.R;

public class ErreursActivity extends AppCompatActivity {

    public static final String ERROR_KEY = "1";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erreurs);
        String nbErreurs = getIntent().getStringExtra(ERROR_KEY);
        TextView nbErreursView = findViewById(R.id.erreursTextView);
        nbErreursView.setText(nbErreursView.getText() + " : " + nbErreurs + " erreurs");
    }

    public void onClick(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }
}