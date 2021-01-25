package com.example.pizzera;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends PlantillaActivity {
    //Atributos Globales
    private String colors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //Enlazo las variables con sus ids del activity
        Button web = findViewById(R.id.web);
        Button pedido = findViewById(R.id.pedido);
        Button configuracion = findViewById(R.id.configuracion);
        ConstraintLayout layout=findViewById(R.id.layoutMenu);
        //pongo el color al fondo del layout
        SharedPreferences preferences1 = getSharedPreferences("colorGuardado", Context.MODE_PRIVATE);
        colors=preferences1.getString("color","#FFFFFF");
        layout.setBackgroundColor(Color.parseColor(colors));
        //hago los eventos onClick
        web.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(),WebActivity.class);
            startActivity(i);
        });
        pedido.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(),PedidoActivity.class);
            startActivity(i);
        });
        configuracion.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(),ConfiguracionActivity.class);
            startActivity(i);
            finish();
        });
    }
    //hago el evento onBackPressed
    public void onBackPressed() {
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setMessage("¿Desea salir de la aplicacion?").setCancelable(false);
        alerta.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alerta.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog titulo = alerta.create();
        titulo.setTitle("Salir");
        titulo.show();
    }
}