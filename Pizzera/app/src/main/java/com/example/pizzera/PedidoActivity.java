package com.example.pizzera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PedidoActivity extends PlantillaActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);
        Button favoritas = findViewById(R.id.favoritas);
        Button personalizadas = findViewById(R.id.personalizadas);
        Button predeterminadas = findViewById(R.id.predeterminadas);
        favoritas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),FavoritaActivity.class);
                startActivity(i);
            }
        });
        personalizadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),PersonalizadaActivity.class);
                startActivity(i);
            }
        });
        predeterminadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),PredeterminadaActivity.class);
                startActivity(i);
            }
        });
    }
}