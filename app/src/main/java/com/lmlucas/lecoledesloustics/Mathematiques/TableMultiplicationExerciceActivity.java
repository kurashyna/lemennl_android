package com.lmlucas.lecoledesloustics.Mathematiques;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lmlucas.lecoledesloustics.Models.Multiplication;
import com.lmlucas.lecoledesloustics.Models.TableMultiplication;
import com.lmlucas.lecoledesloustics.R;

import java.util.HashMap;
import java.util.Map;

public class TableMultiplicationExerciceActivity extends AppCompatActivity {

    public static final String TABLE_NUMBER = "TABLE_NUMBER";
    public HashMap<Multiplication, EditText> calculs = new HashMap<>();
    public final static int RES_REQUEST = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_multiplication_exercice);

        int nombre = getIntent().getIntExtra(TABLE_NUMBER, 0);
        TableMultiplication tableMultiplication = new TableMultiplication(nombre);
        LinearLayout layout = findViewById(R.id.layoutTableMultiplication);
        for (Multiplication multiplication : tableMultiplication.getMultiplications()) {
            LinearLayout layoutTMP = (LinearLayout) getLayoutInflater().inflate(R.layout.template_multiplication, null);
            TextView calcul = layoutTMP.findViewById(R.id.template_calcul);
            EditText resultat = layoutTMP.findViewById(R.id.template_resultat);

            calcul.setText(multiplication.getOperande1() + " x " + multiplication.getOperande2() + "=");
            calculs.put(multiplication,resultat);
            resultat.setInputType(InputType.TYPE_CLASS_NUMBER);

            layout.addView(layoutTMP);
        }

    }

    public void valider(View view) {
        int nbErreurs = 0;

        for (Map.Entry<Multiplication,EditText> entry : calculs.entrySet())
        {
            try{
                if (Integer.parseInt(entry.getValue().getText().toString()) != entry.getKey().getOperande1() * entry.getKey().getOperande2())
                {
                    nbErreurs ++;
                }
            }catch (Exception e){
                Toast.makeText(this, "Veuillez remplir tout les champs", Toast.LENGTH_SHORT).show();
            }

        }
        Intent intent;
        //TODO : Gérer les différents cas
        if (nbErreurs > 0)

        {
            intent = new Intent(this, MathematiquesErreurActivity.class);
            intent.putExtra(MathematiquesErreurActivity.ERRORS_KEY ,Integer.toString(nbErreurs));
            startActivityForResult(intent, RES_REQUEST);
        }else{
            intent = new Intent(this, FelicitationActivity.class);
            startActivityForResult(intent, RES_REQUEST);
        }
    }
}