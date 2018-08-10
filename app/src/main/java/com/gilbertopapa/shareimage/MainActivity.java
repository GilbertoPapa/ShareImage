package com.gilbertopapa.shareimage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Habilite armazenamento local.
        Parse.enableLocalDatastore(this);

        // Codigo de configuração do App
        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId("25D6C2B74BF42AD4FEDE6CA351B1AC6EAC348AA9")
                .clientKey(null)
                .server("http://share-img.herokuapp.com/parse/")
                .build()
        );



        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        // Optionally enable public read access.
        // defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
/*
        ParseObject parseObject = new ParseObject("Teste");
        parseObject.put("nome","João");
        parseObject.put("pontos",100);
        parseObject.saveInBackground();

*/
    }
}
