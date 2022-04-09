package com.lmlucas.lecoledesloustics.CultureGénérale;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lmlucas.lecoledesloustics.Database.DatabaseClient;
import com.lmlucas.lecoledesloustics.ErreursActivity;
import com.lmlucas.lecoledesloustics.FelicitationsActivity;
import com.lmlucas.lecoledesloustics.Models.Question;
import com.lmlucas.lecoledesloustics.R;

import java.util.List;

public class CultureQuestionsActivity extends AppCompatActivity {


    public static final String QUESTIONS_THEME = "theme";

    public String theme = null;
    private DatabaseClient dbClient;
    private List<Question> ListeQuestions;
    Integer questionActuelle = 0;
    int nombreErreur = 0;
    TextView questionsTitle;
    TextView questionAffichee;
    Button boutonReponse1;
    Button boutonReponse2;
    Button boutonReponse3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culture_questions);
        theme = getIntent().getStringExtra(QUESTIONS_THEME);
        dbClient = DatabaseClient.getInstance(getApplicationContext());
        questionsTitle = (TextView) findViewById(R.id.cultureQuestionTitle);
        questionAffichee = (TextView) findViewById(R.id.cultureQuestion);
        boutonReponse1 = (Button) findViewById(R.id.CultureReponse1);
        boutonReponse2 = (Button) findViewById(R.id.CultureReponse2);
        boutonReponse3 = (Button) findViewById(R.id.CultureReponse3);
    }

    private void getQuestions() {
        class GetQuestions extends AsyncTask<Void, Void, List<Question>> {
            @Override
            protected List<Question> doInBackground(Void... voids) {
                if (theme.equals("tous")) {
                    return dbClient.getAppDatabase().questionsDao().getAll();
                } else {
                    //TODO : faire une requete pour récupérer les questions d'un thème était prévu
                    return dbClient.getAppDatabase().questionsDao().getAll();
                }
            }

            @SuppressLint("SetTextI18n")
            @Override
            protected void onPostExecute(List<Question> questions) {
                super.onPostExecute(questions);
                ListeQuestions = questions;
                questionsTitle.setText("Question " + (questionActuelle + 1) + "/" + ListeQuestions.size());
                questionAffichee.setText(ListeQuestions.get(questionActuelle).getQuestion());
                boutonReponse1.setText(ListeQuestions.get(questionActuelle).getReponse1());
                boutonReponse2.setText(ListeQuestions.get(questionActuelle).getReponse2());
                boutonReponse3.setText(ListeQuestions.get(questionActuelle).getReponse3());
            }

        }
        GetQuestions getQuestions = new GetQuestions();
        getQuestions.execute();
    }

    @Override
    protected void onStart() {
        super.onStart();
        int questionActuelle = 0;
        getQuestions();
    }

    @SuppressLint("SetTextI18n")
    public void onClick(View view) {
        Button bouton = (Button) view;
        if (bouton.getText().equals(ListeQuestions.get(questionActuelle).getBonneReponse())) {
            questionActuelle++;
            if (questionActuelle == ListeQuestions.size()) {
               valider();
            } else {
                questionsTitle.setText("Question " + (questionActuelle + 1) + "/" + ListeQuestions.size());
                questionAffichee.setText(ListeQuestions.get(questionActuelle).getQuestion());
                boutonReponse1.setText(ListeQuestions.get(questionActuelle).getReponse1());
                boutonReponse2.setText(ListeQuestions.get(questionActuelle).getReponse2());
                boutonReponse3.setText(ListeQuestions.get(questionActuelle).getReponse3());
            }
        } else {
            nombreErreur++;
            questionActuelle++;
            if (questionActuelle == ListeQuestions.size()) {
                valider();
            } else {
                questionsTitle.setText("Question " + (questionActuelle + 1) + "/" + ListeQuestions.size());
                questionAffichee.setText(ListeQuestions.get(questionActuelle).getQuestion());
                boutonReponse1.setText(ListeQuestions.get(questionActuelle).getReponse1());
                boutonReponse2.setText(ListeQuestions.get(questionActuelle).getReponse2());
                boutonReponse3.setText(ListeQuestions.get(questionActuelle).getReponse3());;
            }
        }
    }

    private void valider() {
        Intent intent;
        if (nombreErreur == 0) {
            intent = new Intent(this, FelicitationsActivity.class);
            startActivityForResult(intent, 1);
        } else {
            intent = new Intent(this, ErreursActivity.class);
            intent.putExtra(ErreursActivity.ERROR_KEY, Integer.toString(nombreErreur));
            startActivityForResult(intent, 1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) {
            super.finish();
        }
    }
}