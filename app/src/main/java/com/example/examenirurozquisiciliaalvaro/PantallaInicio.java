package com.example.examenirurozquisiciliaalvaro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class PantallaInicio extends AppCompatActivity {
    Intent intent;
    Button jugar;
    Button salir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        jugar.setOnClickListener((view) -> {
            intent = new Intent(PantallaInicio.this, MainActivity.class);
            startActivity(intent);
        });
        salir.setOnClickListener((view) ->
                finish()
        );
    }
}