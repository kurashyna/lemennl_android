package com.lmlucas.lecoledesloustics.Mathematiques;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.lmlucas.lecoledesloustics.R;

public class FelicitationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_felicitations);
    }

    public void onClick(View view) {
       setResult(RESULT_OK);
       super.finish();
    }
}