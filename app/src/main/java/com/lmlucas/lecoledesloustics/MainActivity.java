package com.lmlucas.lecoledesloustics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String studentNames[] = {"Eleve 1", "Eleve 2", "Eleve 3", "Eleve 4", "Eleve", "Eleve", "Eleve", "Eleve"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView eleveListView = findViewById(R.id.studentListView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_studentlistview, R.id.studentTextView, studentNames);
        eleveListView.setAdapter(arrayAdapter);
    }

    public void studentChosen(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        TextView studentNameView = (TextView) view;

        intent.putExtra(HomeActivity.STUDENT_NAME, studentNameView.getText().toString());
        startActivity(intent);
    }
}