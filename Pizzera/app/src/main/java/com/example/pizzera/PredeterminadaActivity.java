package com.example.pizzera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PredeterminadaActivity extends PlantillaActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_predeterminada);
        Button realizar = findViewById(R.id.realizarP);
        realizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),ConfirmarPedidoActivity.class);
                startActivity(i);
            }
        });
        //https://programacionymas.com/blog/listas-dinamicas-android-usando-recycler-view-card-view
    }
}