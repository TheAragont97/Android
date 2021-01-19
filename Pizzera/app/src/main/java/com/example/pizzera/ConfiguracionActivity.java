package com.example.pizzera;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class ConfiguracionActivity extends PlantillaActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        Switch fav= findViewById(R.id.fav);
        fav.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(fav.isChecked()){
                    //aqui vamos a activar la pizza favorita que es la anterior pedida
                }
            }
        });
    }
}