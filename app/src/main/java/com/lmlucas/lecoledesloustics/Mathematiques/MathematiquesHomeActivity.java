package com.lmlucas.lecoledesloustics.Mathematiques;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lmlucas.lecoledesloustics.R;

public class MathematiquesHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathematiques_home);
    }

    public void onExerciceClick(View view) {
        switch(view.getId()) {
            case R.id.BoutonTableMultiplication:
                Intent intent = new Intent(this, TableMultiplicationActivity.class);
                startActivity(intent);
                break;
            case R.id.BoutonOperations:
                Intent intent2 = new Intent(this, OperationsActivity.class);
                startActivity(intent2);
                break;
        }
    }
}