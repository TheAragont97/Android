package com.example.vehiculo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class TallerActivity extends AppCompatActivity {
    //Variables Globales
    ArrayList<String> listDatos;
    RecyclerView recycler;
    EditText marca,modelo,matricula;
    ConexionBDHelper conn;
    ArrayList<Vehiculo> listaVehiculos;
    Button insertar,modificar, eliminar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conn=new ConexionBDHelper(getApplicationContext());

        recycler=findViewById(R.id.listaVehiculos);
        marca=findViewById(R.id.marca);
        modelo=findViewById(R.id.modelo);
        matricula=findViewById(R.id.matricula);
        insertar= findViewById(R.id.insertar);
        modificar= findViewById(R.id.modificar);
        eliminar = findViewById(R.id.eliminar);

        listaVehiculos = new ArrayList<Vehiculo>();

        //recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recycler.setLayoutManager(new LinearLayoutManager(this));
        //listDatos= new ArrayList<String>();
        //aqui rellenamos la lista ya sea con lo que hemos
        //cogido de la BD o lo que le insertamos
        //ArrayAdapter adaptador= new ArrayAdapter(this,R.layout.item_reciclerview,listDatos);
        //AdapterDatos adapter= new AdapterDatos(listDatos);
        //recycler.setAdapter(adapter);

        limpiarRecycler();
        cargarDatos();

        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertarDatos();
            }
        });
        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { eliminarDatos(); }
        });
        modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { modificarDatos(); }
        });


    }

    private void insertarDatos() {
        SQLiteDatabase db= conn.getWritableDatabase();
        String insert="INSERT INTO "+Utilidades.tabla+"( "+Utilidades.marca+","
                +Utilidades.modelo+","+Utilidades.matricula+
                " ) VALUES ('"+marca.getText().toString()+"','"+modelo.getText().toString()+"','"
                +matricula.getText().toString()+"')";
        db.execSQL(insert);
        db.close();
        cargarDatos();
    }
    private void eliminarDatos(){
        SQLiteDatabase db= conn.getWritableDatabase();
        String[] parametros={matricula.getText().toString()};
        db.delete(Utilidades.tabla,Utilidades.matricula+"=?",parametros);

        db.close();
        eliminarLista();
        cargarDatos();
    }
    private void modificarDatos(){
        SQLiteDatabase db= conn.getWritableDatabase();
        String[] parametros={matricula.getText().toString()};
        ContentValues values= new ContentValues();
        values.put(Utilidades.modelo,modelo.getText().toString());
        values.put(Utilidades.marca,marca.getText().toString());
        db.update(Utilidades.tabla,values,Utilidades.matricula+"=?",parametros);

        db.close();
        cargarDatos();
        obtenerLista();
    }

    private void cargarDatos(){
        limpiarRecycler();
        rellenoColumnasPrimeraVez();
        SQLiteDatabase db= conn.getReadableDatabase();
        Vehiculo vehiculo = null;

        //select * from vehiculos
        Cursor cursor= db.rawQuery("SELECT * FROM "+Utilidades.tabla,null);
        while(cursor.moveToNext()){
            vehiculo= new Vehiculo();
            if(cursor.getString(0)!=null || cursor.getString(0)!=""){
                vehiculo.setMarca(cursor.getString(0));
                vehiculo.setModelo(cursor.getString(1));
                vehiculo.setMatricula(cursor.getString(2));
                listaVehiculos.add(vehiculo);
                obtenerLista();
            }
        }
        db.close();
    }

    private void obtenerLista() {
        AdapterDatos adapter= new AdapterDatos(listaVehiculos);
        recycler.setAdapter(adapter);
    }
    private void rellenoColumnasPrimeraVez(){
        listaVehiculos.add(new Vehiculo("Marca","Modelo","Matricula"));
        obtenerLista();
    }
    private void limpiarRecycler(){
        listaVehiculos.clear();
    }
    private void eliminarLista(){
        for(int i=0;i<listaVehiculos.size();i++){
            if(listaVehiculos.get(i).getMatricula().equals(matricula.getText().toString())){
                listaVehiculos.remove(i);
            }
        }
    }
}