package com.example.pizzera;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WebActivity extends PlantillaActivity {
    //Atributos Globales
    private String colors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        Button pagWeb = findViewById(R.id.pagWeb);
        ConstraintLayout layout= findViewById(R.id.layoutWeb);

        SharedPreferences preferences1 = getSharedPreferences("colorGuardado", Context.MODE_PRIVATE);
        colors=preferences1.getString("color","#FFFFFF");
        layout.setBackgroundColor(Color.parseColor(colors));

        //https://codea.app/android/lanzar-un-link#:~:text=Para%20abrir%20un%20enlace%20o,Android%20para%20acceder%20a%20internet.
        pagWeb.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://www.dominospizza.es/");
            Intent i = new Intent(Intent.ACTION_VIEW,uri);
            startActivity(i);
        });
    }
}