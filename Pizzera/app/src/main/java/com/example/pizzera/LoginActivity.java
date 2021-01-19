package com.example.pizzera;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;

public class LoginActivity extends PlantillaActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText usuario= findViewById(R.id.usuario);
        EditText password= findViewById(R.id.contraseña);
        Button login= findViewById(R.id.login);
        CheckedTextView recordar = findViewById(R.id.recordar);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(usuario.getText().toString()!="" && password.getText().toString()!=""){
                    Intent i = new Intent(getApplicationContext(), MenuActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });
    }
}