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

public class FavoritaActivity extends PlantillaActivity {
    //Atributos Globales
    private String colors;
    private boolean fav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorita);
        Button realizar= findViewById(R.id.realizar);
        ConstraintLayout layout= findViewById(R.id.layoutFavorita);

        SharedPreferences preferences = getSharedPreferences("pizza_favorita", Context.MODE_PRIVATE);
        fav=preferences.getBoolean("favoritaGuardada",false);

        SharedPreferences preferences1 = getSharedPreferences("colorGuardado", Context.MODE_PRIVATE);
        colors=preferences1.getString("color","#FFFFFF");
        layout.setBackgroundColor(Color.parseColor(colors));

        realizar.setOnClickListener(v -> {
            esFav(fav);
        });
    }
    private void esFav(boolean fav){
        if(fav){
            Intent i= new Intent(getApplicationContext(),ConfirmarPedidoActivity.class);
            startActivity(i);
        }
    }
}