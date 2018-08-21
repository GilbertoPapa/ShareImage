package com.gilbertopapa.shareimage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gilbertopapa.shareimage.util.ParseError;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class RegisterActivity extends AppCompatActivity {

    private EditText edtName, edtEmail, edtPassword;
    private Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtName = (EditText) findViewById(R.id.edt_nameRegister);
        edtEmail = (EditText) findViewById(R.id.edt_emailRegister);
        edtPassword = (EditText) findViewById(R.id.edt_passwordRegister);
        btnRegister = (Button) findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });
    }


    private void registerUser(){
        ParseUser parseUser = new ParseUser();
        parseUser.setUsername(edtName.getText().toString());
        parseUser.setEmail(edtEmail.getText().toString());
        parseUser.setPassword(edtPassword.getText().toString());

        parseUser.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if(e == null){
                    Toast.makeText(RegisterActivity.this,"Sucesso ao cadastrar usuário!",Toast.LENGTH_LONG).show();
                    goUserLogin();
                }else{
                    ParseError parseError = new ParseError();
                    String error = parseError.getError(e.getCode());
                    Toast.makeText(RegisterActivity.this,error,Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void goUserLogin(){
        Intent intentLogin = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intentLogin);
        finish();
    }
}
