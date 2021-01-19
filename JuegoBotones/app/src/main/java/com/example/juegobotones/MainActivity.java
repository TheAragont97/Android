package com.example.juegobotones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView IA = findViewById(R.id.IA);
        TextView ganador = findViewById(R.id.ganador);
        TextView nuestraEleccion = findViewById(R.id.nuestraEleccion);
        Button piedra = findViewById(R.id.piedra);
        Button papel = findViewById(R.id.papel);
        Button tijeras= findViewById(R.id.tijeras);
        Button reset = findViewById(R.id.reset);
        reset.setEnabled(false);

        //Cuando le demos a la opción veremos que ha elegido la IA

        Toast.makeText(MainActivity.this, "Bienvenido a Pi/Pa/T de Antonio Aragón", Toast.LENGTH_SHORT).show();

        piedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Eleccion de la IA random
                IA.setText(juegoIA());
                nuestraEleccion.setText("piedra");
                ganador.setText(verGanador(IA.getText().toString(),nuestraEleccion.getText().toString()));
                papel.setEnabled(false);
                tijeras.setEnabled(false);
                reset.setEnabled(true);

            }
        });

        papel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Eleccion de la IA random
                IA.setText(juegoIA());
                nuestraEleccion.setText("papel");
                ganador.setText(verGanador(IA.getText().toString(),nuestraEleccion.getText().toString()));
                piedra.setEnabled(false);
                tijeras.setEnabled(false);
                reset.setEnabled(true);

            }
        });

        tijeras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Eleccion de la IA random
                IA.setText(juegoIA());
                nuestraEleccion.setText("tijeras");
                ganador.setText(verGanador(IA.getText().toString(),nuestraEleccion.getText().toString()));
                papel.setEnabled(false);
                piedra.setEnabled(false);
                reset.setEnabled(true);

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Mostramos un mensaja para empezar de nuevo el juego
                Toast.makeText(MainActivity.this, "Comienza de nuevo", Toast.LENGTH_SHORT).show();
                //Resetamos valores
                IA.setText("");
                nuestraEleccion.setText("");
                ganador.setText("");
                papel.setEnabled(true);
                piedra.setEnabled(true);
                tijeras.setEnabled(true);
                reset.setEnabled(true);

            }
        });

    }
    private String juegoIA(){
        String eleccionIA="";
        int opIA= (int) (Math.random()*3)+1;
            if(opIA==1){
                eleccionIA="piedra";
            }
            else if(opIA==2){
                eleccionIA="papel";
            }
            else if(opIA==3){
                eleccionIA="tijeras";
            }
        return eleccionIA;
    }

    private String verGanador(String eleccionIA, String eleccionJugador){
        String ganador="";
            if(!eleccionIA.equals(eleccionJugador)){
                if(eleccionIA.equals("piedra") && eleccionJugador.equals("tijeras")){
                    ganador="Gana la IA";
                }
                else if(eleccionIA.equals("tijeras") && eleccionJugador.equals("papel")){
                    ganador="Gana la IA";
                }
                else if(eleccionIA.equals("papel") && eleccionJugador.equals("piedra")){
                    ganador="Gana la IA";
                }
                else if(eleccionJugador.equals("piedra") && eleccionIA.equals("tijeras")){
                    ganador="Gana el Jugador";
                }
                else if(eleccionJugador.equals("tijeras") && eleccionIA.equals("papel")){
                    ganador="Gana el Jugador";
                }
                else if(eleccionJugador.equals("papel") && eleccionIA.equals("piedra")){
                    ganador="Gana el Jugador";
                }
            }
            else{
                ganador="Habéis empatado";
            }

        return ganador;
    }
}