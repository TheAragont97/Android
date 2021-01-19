package com.example.pizzera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WebActivity extends PlantillaActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        Button pagWeb = findViewById(R.id.pagWeb);
        //https://codea.app/android/lanzar-un-link#:~:text=Para%20abrir%20un%20enlace%20o,Android%20para%20acceder%20a%20internet.
        pagWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.dominospizza.es/");
                Intent i = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(i);
            }
        });
    }
}