package com.lmlucas.lecoledesloustics.Mathematiques;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lmlucas.lecoledesloustics.ErreursActivity;
import com.lmlucas.lecoledesloustics.FelicitationsActivity;
import com.lmlucas.lecoledesloustics.Models.Calcul;
import com.lmlucas.lecoledesloustics.R;

import java.util.HashMap;

public class OperationsActivity extends AppCompatActivity {

    public final static int RES_REQUEST = 0;
    HashMap<Integer, Calcul> operations = new HashMap<>();
    Integer calculActuel = 0;
    int nombreErreurs;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operations);

        // On crée les calculs
        for (int i = 0; i < 10; i++) {
            operations.put(i, Calcul.randomCalcul());
        }

        // On affiche le premier calcul
        TextView textView = findViewById(R.id.operationsText);
        textView.setText(operations.get(calculActuel).getOperand1() + " " + operations.get(calculActuel).getOperation() + " " + operations.get(calculActuel).getOperand2());
    }

    @SuppressLint("SetTextI18n")
    public void onClick(View view) {
        EditText editText = findViewById(R.id.operationsEditText);
        TextView textView = findViewById(R.id.operationsText);
        Button button = findViewById(R.id.operationsButton);
        if (editText.getText().toString().equals("")) {
            // Si l'utilisateur n'a pas tapé de résultat
            Toast.makeText(this, "Veuillez entrer un résultat", Toast.LENGTH_SHORT).show();
        } else {
            // On vérifie le nombre de calculs réalisés
            if (calculActuel < 10) {
                operations.get(calculActuel).setResultat(Integer.parseInt(editText.getText().toString()));
                calculActuel++;
                if (calculActuel == 10) {
                    // Si on a fini les calculs
                    textView.setText("Vous avez fini les 10 calculs");
                    button.setText("Valider");
                    editText.setVisibility(View.INVISIBLE);
                } else {
                    // Sinon on affiche le calcul suivant
                    textView.setText(operations.get(calculActuel).getOperand1() + " " + operations.get(calculActuel).getOperation() + " " + operations.get(calculActuel).getOperand2());
                    editText.setText("");
                }
            } else {
                // Si on a fini les calculs
                valider();
            }
        }
    }

    public void valider() {
        TextView textView = findViewById(R.id.operationsText);
        Button button = findViewById(R.id.operationsButton);
        EditText editText = findViewById(R.id.operationsEditText);
        nombreErreurs = 0;
        for (int i = 0; i < 10; i++) {
            switch (operations.get(i).getOperation()) {
                case "+":
                    if (operations.get(i).getResultat() != operations.get(i).getOperand1() + operations.get(i).getOperand2()) {
                        nombreErreurs++;
                        break;
                    }
                    break;
                case "-":
                    if (operations.get(i).getResultat() != operations.get(i).getOperand1() - operations.get(i).getOperand2()) {
                        nombreErreurs++;
                        break;
                    }
                    break;
                case "*":
                    if (operations.get(i).getResultat() != operations.get(i).getOperand1() * operations.get(i).getOperand2()) {
                        nombreErreurs++;
                        break;
                    }
                    break;
                case "/":
                    if (operations.get(i).getResultat() != operations.get(i).getOperand1() / operations.get(i).getOperand2()) {
                        nombreErreurs++;
                        break;
                    }
                    break;
            }
        }

        Intent intent;
        //Si il y a eu des erreurs
        if (nombreErreurs == 0) {
            intent = new Intent(this, FelicitationsActivity.class);
            startActivityForResult(intent, RES_REQUEST);
        } else {
            intent = new Intent(this, ErreursActivity.class);
            intent.putExtra(ErreursActivity.ERROR_KEY, Integer.toString(nombreErreurs));
            startActivityForResult(intent, RES_REQUEST);
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RES_REQUEST) {
            if (resultCode == RESULT_CANCELED) {
                super.finish();
            }
        }
    }
}