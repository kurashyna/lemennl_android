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

        NumberPicker numberPicker = findViewById(R.id.tableMultiplicationNumberPicker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(9);
    }

    public void onClick(View view) {
        NumberPicker numberPicker = findViewById(R.id.tableMultiplicationNumberPicker);
        int tableNumber = numberPicker.getValue();

        Intent intent = new Intent(this, TableMultiplicationExerciceActivity.class);
        intent.putExtra("TABLE_NUMBER", tableNumber);
        startActivity(intent);
    }

    public void onClickMenu(View view) {
        super.finish();
    }
}