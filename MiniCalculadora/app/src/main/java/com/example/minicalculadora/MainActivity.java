package com.example.minicalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    //Atributos Globales
    public ListenerMain listener;
    /* Caso sin el ListenerMain
    public double opA=0;
    public double opB=0;
    public double res=0;
    public EditText operandoA;
    public EditText operandoB;
    public TextView resultado;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listener = new ListenerMain(this);
        Button btnSumar = findViewById(R.id.btnSumar);
        Button btnRestar = findViewById(R.id.btnRestar);
        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(view);
            }
        });
        btnRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(view);
            }
        });
        /* Funciona pero sin la clase ListenerMain
        operandoA = findViewById(R.id.operandoA);
        operandoB = findViewById(R.id.operandoB);
        resultado = findViewById(R.id.resultado);
        Button btnSumar = findViewById(R.id.btnSumar);
        Button btnRestar = findViewById(R.id.btnRestar);
        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opA=Double.parseDouble(operandoA.getText().toString());
                opB=Double.parseDouble(operandoB.getText().toString());
                res=opA+opB;
                resultado.setText(Double.toString(res));
            }
        });
        btnRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opA=Double.parseDouble(operandoA.getText().toString());
                opB=Double.parseDouble(operandoB.getText().toString());
                res=opA-opB;
                resultado.setText(Double.toString(res));
            }
        });*/
    }


}