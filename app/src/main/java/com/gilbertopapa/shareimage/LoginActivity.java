package com.gilbertopapa.shareimage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gilbertopapa.shareimage.util.ParseError;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    private TextView tvRegister;
    private Button btnLogin;
    private EditText edtUserName, edtUserPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Habilite armazenamento local.
        Parse.enableLocalDatastore(this);

        // Codigo de configuração do App
        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId("25D6C2B74BF42AD4FEDE6CA351B1AC6EAC348AA9")
                .clientKey(null)
                .server("http://share-img.herokuapp.com/parse/")
                .build()
        );


        ParseACL defaultACL = new ParseACL();
        ParseACL.setDefaultACL(defaultACL, true);

        //
        checkUser();

        tvRegister = (TextView) findViewById(R.id.tv_registerUser);
        btnLogin = (Button) findViewById(R.id.btn_login);
        edtUserName = (EditText) findViewById(R.id.edt_nameLogin);
        edtUserPassword = (EditText) findViewById(R.id.edt_passwordLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = edtUserName.getText().toString();
                String userPassword = edtUserPassword.getText().toString();
                login(userName,userPassword);
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRegister = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intentRegister);
                finish();
            }
        });

    }

    private void login (String nameUser, String userPassword){
        ParseUser.logInInBackground(nameUser, userPassword, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(e == null){
                    Toast.makeText(LoginActivity.this,"Login realizado com sucesso.",Toast.LENGTH_LONG).show();
                    goMain();

                }else{
                    //fazer tratamento dos erros
                    ParseError parseError = new ParseError();
                    String error = parseError.getError(e.getCode());
                    Toast.makeText(LoginActivity.this,error,Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void checkUser() {
        if (ParseUser.getCurrentUser() != null) {
            goMain();
        }
    }

    private void goMain() {
        Intent intentMain = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intentMain);
        finish();
    }


}
