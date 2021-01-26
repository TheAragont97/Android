package com.example.pizzera;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class PredeterminadaActivity extends PlantillaActivity {
    //Atributos Globales
    private String colors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_predeterminada);
        String[] datosLst= new String[]{"Barbacoa","Jamon York y Queso","Kebab","Atun","Jerezana","Tropical","Mediterranea","4 Quesos"};
        ArrayAdapter<String> adaptadorLst= new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,datosLst);
        ListView lst=findViewById(R.id.lista);
        lst.setAdapter(adaptadorLst);
        Button realizar = findViewById(R.id.realizarP);
        ConstraintLayout layout= findViewById(R.id.layoutPredeterminada);

        SharedPreferences preferences1 = getSharedPreferences("colorGuardado", Context.MODE_PRIVATE);
        colors=preferences1.getString("color","#FFFFFF");
        layout.setBackgroundColor(Color.parseColor(colors));

        realizar.setOnClickListener(v -> {
            Intent i= new Intent(getApplicationContext(),ConfirmarPedidoActivity.class);
            startActivity(i);
        });

        lst.setOnItemClickListener((parent, view, position, id) -> {
            String eleccion=parent.getItemAtPosition(position).toString();
            SharedPreferences preferences= getSharedPreferences("pizza_elegida",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor= preferences.edit();
            editor.remove("pizza");
            editor.putString("pizza",eleccion);
            editor.commit();
        });
        //https://programacionymas.com/blog/listas-dinamicas-android-usando-recycler-view-card-view
    }
}