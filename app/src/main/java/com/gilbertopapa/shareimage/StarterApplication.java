package com.gilbertopapa.shareimage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.parse.Parse;
import com.parse.ParseACL;

public class StarterApplication extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starter_application);



        // Habilite armazenamento local.
        Parse.enableLocalDatastore(this);

        // Codigo de configuração do App
        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId("25D6C2B74BF42AD4FEDE6CA351B1AC6EAC348AA9")
                .clientKey(null)
                .server("http://share-img.herokuapp.com/parse/")
                .build()
        );

/*
      // Teste de configuração do App
      ParseObject pontuacao = new ParseObject("Pontuacao");
      pontuacao.put("pontos", 100);
      pontuacao.saveInBackground(new SaveCallback() {
          public void done(ParseException e) {
              if (e == null) {
                  Log.i("TesteExecucao", "Salvo com sucesso!!!");
              } else {
                  Log.i("TesteExecucao", "Falha ao salvar os dados!!!");
              }
          }
      });

*/
        //ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        // Optionally enable public read access.
        // defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
    }
}
