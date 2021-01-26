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
import android.widget.CompoundButton;
import android.widget.Switch;

import java.lang.reflect.Array;

public class ConfiguracionActivity extends PlantillaActivity {
    //Atributos Globales
    private boolean favoritas=false;
    private String colors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        SharedPreferences preferences= getSharedPreferences("pizza_favorita", Context.MODE_PRIVATE);
        favoritas=preferences.getBoolean("favoritaGuardada",false);
        Switch fav= findViewById(R.id.fav);
        Button color= findViewById(R.id.color);
        ConstraintLayout layout = findViewById(R.id.layoutConfig);
        SharedPreferences preferences1 = getSharedPreferences("colorGuardado", Context.MODE_PRIVATE);
        colors=preferences1.getString("color","#FFFFFF");
        layout.setBackgroundColor(Color.parseColor(colors));
        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colors = generateRandomColor();
                layout.setBackgroundColor(Color.parseColor(colors));
                SharedPreferences preferences1 = getSharedPreferences("colorGuardado", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor= preferences1.edit();
                editor.putString("color",colors);
                editor.commit();
            }
        });
        fav.setChecked(favoritas);
        fav.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(fav.isChecked()){
                favoritas=true;
            }
            else{
                favoritas=false;
            }
            SharedPreferences preferences2 = getSharedPreferences("pizza_favorita", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor= preferences2.edit();
            editor.putBoolean("favoritaGuardada",favoritas);
            editor.commit();
        });
    }
    public void onBackPressed() {
        Intent i = new Intent(getApplicationContext(), MenuActivity.class);
        startActivity(i);
        finish();
    }
    private static String generateRandomColor(){
        String[] letters = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
        String color = "#";
        for (int i = 0; i < 6; i++ ) {
            color += letters[(int) Math.round(Math.random() * 15)];
        }
        return color;
    }
}