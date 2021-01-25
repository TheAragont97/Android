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

public class PedidoActivity extends PlantillaActivity {
    //Atributos Globales
    private String colors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);
        Button favoritas = findViewById(R.id.favoritas);
        Button personalizadas = findViewById(R.id.personalizadas);
        Button predeterminadas = findViewById(R.id.predeterminadas);
        ConstraintLayout layout= findViewById(R.id.layoutPedido);

        SharedPreferences preferences1 = getSharedPreferences("colorGuardado", Context.MODE_PRIVATE);
        colors=preferences1.getString("color","#FFFFFF");
        layout.setBackgroundColor(Color.parseColor(colors));

        favoritas.setOnClickListener(v -> {
            Intent i=new Intent(getApplicationContext(),FavoritaActivity.class);
            startActivity(i);
        });
        personalizadas.setOnClickListener(v -> {
            Intent i=new Intent(getApplicationContext(),PersonalizadaActivity.class);
            startActivity(i);
        });
        predeterminadas.setOnClickListener(v -> {
            Intent i=new Intent(getApplicationContext(),PredeterminadaActivity.class);
            startActivity(i);
        });
    }
}