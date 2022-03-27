package com.lmlucas.lecoledesloustics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    public static final String STUDENT_NAME = "student_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        String studentName = getIntent().getStringExtra(STUDENT_NAME);
        TextView studentWelcome = findViewById(R.id.homeStudentWelcome);
        studentWelcome.setText(studentWelcome.getText().toString() + studentName);
    }
}