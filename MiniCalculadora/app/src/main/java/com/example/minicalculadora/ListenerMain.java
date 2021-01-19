package com.example.minicalculadora;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ListenerMain implements View.OnClickListener {
    private MainActivity activity;
    public ListenerMain(MainActivity activity){
        this.activity=activity;
    }
    @Override
    public void onClick(View v) {
        Log.w("Boton","Entra");
        double opA=0;
        double opB=0;
        double res=0;
        EditText operandoA = activity.findViewById(R.id.operandoA);
        EditText operandoB = activity.findViewById(R.id.operandoB);
        TextView resultado = activity.findViewById(R.id.resultado);
        switch (v.getId()){
            case R.id.btnSumar:
                opA=Double.parseDouble(operandoA.getText().toString());
                opB=Double.parseDouble(operandoB.getText().toString());
                res=opA+opB;
                resultado.setText(Double.toString(res));
                break;
            case R.id.btnRestar:
                opA=Double.parseDouble(operandoA.getText().toString());
                opB=Double.parseDouble(operandoB.getText().toString());
                res=opA-opB;
                resultado.setText(Double.toString(res));
                break;
            default:
                Log.e("Error","El valor añadido en alguno de los operandos no es válido");
                break;
        }
    }
}
