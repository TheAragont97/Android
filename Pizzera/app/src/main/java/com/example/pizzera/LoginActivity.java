package com.example.pizzera;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

public class LoginActivity extends PlantillaActivity {
    //Atributos Globales
    private String colors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Enlazo las variables con sus ids del activity
        EditText usuario= findViewById(R.id.usuario);
        EditText password= findViewById(R.id.contraseña);
        Button login= findViewById(R.id.login);
        CheckBox recordar = findViewById(R.id.recordar);
        ConstraintLayout layout= findViewById(R.id.layoutLogin);
        //miro si esta guardado el login
        recordarme(recordar,usuario,password);
        //pongo el color si se ha elegido anteriormente
        SharedPreferences preferences1 = getSharedPreferences("colorGuardado", Context.MODE_PRIVATE);
        colors=preferences1.getString("color","#FFFFFF");
        layout.setBackgroundColor(Color.parseColor(colors));
        //hago los eventos Onclick
        login.setOnClickListener(v -> {
            if(!usuario.getText().toString().equals("") && !password.getText().toString().equals("")){
                Intent i = new Intent(getApplicationContext(), MenuActivity.class);
                if(recordar.isChecked()){
                    SharedPreferences preferences= getSharedPreferences("login",Context.MODE_PRIVATE);
                    String user=usuario.getText().toString();
                    String pass= password.getText().toString();
                    SharedPreferences.Editor editor= preferences.edit();
                    editor.putString("user",user);
                    editor.putString("pass",pass);
                    editor.commit();
                }
                else{
                    SharedPreferences preferences= getSharedPreferences("login",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor= preferences.edit();
                    editor.remove("user");
                    editor.remove("pass");
                    editor.commit();
                }
                startActivity(i);
                finish();
            }else{
                Toast t=Toast.makeText(getApplicationContext(),"No puede haber campos vacíos",Toast.LENGTH_LONG);
                t.show();
            }
        });
    }
    private void recordarme(CheckBox recordar, EditText usuario, EditText password){
        SharedPreferences preferences= getSharedPreferences("login",Context.MODE_PRIVATE);
        String user=preferences.getString("user","");
        String pass=preferences.getString("pass","");
        if(!user.equals("") && !pass.equals("")){
            recordar.setChecked(true);
            usuario.setText(user.toString());
            password.setText(pass.toString());
        }
    }
}