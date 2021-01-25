package com.example.pizzera;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PersonalizadaActivity extends PlantillaActivity {
    //Atributos Globales
    private String colors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalizada);
        Button confirmar = findViewById(R.id.confirmar);
        ConstraintLayout layout= findViewById(R.id.layoutPersonalizada);

        SharedPreferences preferences1 = getSharedPreferences("colorGuardado", Context.MODE_PRIVATE);
        colors=preferences1.getString("color","#FFFFFF");
        layout.setBackgroundColor(Color.parseColor(colors));

        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(getApplicationContext(),ConfirmarPedidoActivity.class);
                startActivity(i);
            }
        });
    }
}