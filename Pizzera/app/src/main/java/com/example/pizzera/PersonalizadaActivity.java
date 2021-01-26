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
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.chip.Chip;

public class PersonalizadaActivity extends PlantillaActivity {
    //Atributos Globales
    private String colors;
    private String pedido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalizada);
        Button confirmar = findViewById(R.id.confirmar);
        ConstraintLayout layout= findViewById(R.id.layoutPersonalizada);
        RadioButton grande= findViewById(R.id.grande);
        RadioButton mediana= findViewById(R.id.mediana);
        RadioButton pequeña= findViewById(R.id.pequeña);
        RadioGroup tamaño = findViewById(R.id.radioGroup);
        //Comprueba cual se a elegido
        tamañoElegido(grande,mediana,pequeña,tamaño.getCheckedRadioButtonId());

        Chip ingrediente_queso= findViewById(R.id.ingrediente_queso);
        Chip ingrediente_tomate = findViewById(R.id.ingrediente_tomate);
        Chip ingrediente_atun = findViewById(R.id.ingrediente_atun);
        Chip ingrediente_cebolla = findViewById(R.id.ingrediente_cebolla);
        Chip ingrediente_pimiento = findViewById(R.id.ingrediente_pimiento);
        Chip ingrediente_jamon = findViewById(R.id.ingrediente_jamon);
        Chip ingrediente_salsabbq = findViewById(R.id.ingrediente_salsabbq);


        SharedPreferences preferences1 = getSharedPreferences("colorGuardado", Context.MODE_PRIVATE);
        colors=preferences1.getString("color","#FFFFFF");
        layout.setBackgroundColor(Color.parseColor(colors));

        ingrediente_queso.setOnClickListener(v -> pedido+="Queso ");
        ingrediente_tomate.setOnClickListener(v -> pedido+="Tomate ");
        ingrediente_atun.setOnClickListener(v -> pedido+="Atún ");
        ingrediente_cebolla.setOnClickListener(v -> pedido+="Cebolla ");
        ingrediente_pimiento.setOnClickListener(v -> pedido+="Pimiento ");
        ingrediente_jamon.setOnClickListener(v -> pedido+="Jamon ");
        ingrediente_salsabbq.setOnClickListener(v -> pedido+="Salsa BBQ ");
        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences= getSharedPreferences("pizza_elegida",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor= preferences.edit();
                editor.remove("pizza");
                editor.putString("pizza",pedido);
                editor.commit();
                Intent i = new Intent(getApplicationContext(),ConfirmarPedidoActivity.class);
                startActivity(i);
            }
        });
    }
    private void tamañoElegido(RadioButton grande,RadioButton mediana,RadioButton pequeña,int id){
        if(grande.getId()==id){
            pedido="Pizza Grande con: ";
        }
        else if(mediana.getId()==id){
            pedido="Pizza Mediana con: ";
        }
        else{
            pedido="Pizza Pequeña con: ";
        }

    }
}