package com.lmlucas.lecoledesloustics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class ListViewEleves extends AppCompatActivity {

    ListView simpleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*TODO : Finir la ListView
         https://abhiandroid.com/ui/listview */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_eleves);
        simpleList = (ListView) findViewById(R.id.eleveListView);
        StudentAdapter customAdapter = new StudentAdapter(getApplicationContext());


    }
}