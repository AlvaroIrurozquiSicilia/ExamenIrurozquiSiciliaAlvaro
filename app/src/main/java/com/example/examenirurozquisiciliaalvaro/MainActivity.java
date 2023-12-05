package com.example.examenirurozquisiciliaalvaro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button botonIniciar;
    Button botonParar;
    Button botonVueltas;
    Button atras;
    TextView textoCronometro;
    VueltasRVAdapter adapter;
    Cronometro cronometro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView texto_Cronometro = findViewById(R.id.textoCronometro);
        RecyclerView rvVueltas = findViewById(R.id.vueltas);
        rvVueltas.setLayoutManager(new LinearLayoutManager(this));
        adapter = new VueltasRVAdapter();
        rvVueltas.setAdapter(adapter);
        botonIniciar = findViewById(R.id.botonIniciar);
        botonParar = findViewById(R.id.botonParar);
        botonVueltas = findViewById(R.id.botonVueltas);
        botonIniciar.setVisibility(View.VISIBLE);
        botonParar.setVisibility(View.INVISIBLE);
        botonVueltas.setVisibility(View.INVISIBLE);
        botonIniciar.setOnClickListener((view) -> {
            cronometro = new Cronometro(texto_Cronometro, MainActivity.this);
            cronometro.start();
            botonIniciar.setVisibility(View.INVISIBLE);
            botonParar.setVisibility(View.VISIBLE);
            botonVueltas.setVisibility(View.VISIBLE);
        });
        botonParar.setOnClickListener((view) -> {
            cronometro.parar();
            botonParar.setVisibility(View.INVISIBLE);
            botonVueltas.setVisibility(View.INVISIBLE);
            botonIniciar.setVisibility(View.INVISIBLE);
        });
        botonVueltas.setOnClickListener((view) -> {

            String tiempo = textoCronometro.getText().toString();
            adapter.addVuelta(tiempo);
        });


    }
}