package com.example.examenirurozquisiciliaalvaro;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.widget.TextView;

public class Cronometro extends Thread {
    private final TextView textoCronometro;
    private final Activity activity;
    private boolean arrancado = true;
    private int milisegundos = 0;
    private int segundos = 0;
    private int minutos = 0;
    private int horas = 0;


    public Cronometro(TextView texto_Cronometro, Activity activity) {
        this.textoCronometro = texto_Cronometro;
        this.activity = activity;
    }

    public Cronometro(TextView texto_Cronometro, Activity activity, int milisegundosAux, int segundosAux, int minutosAux, int horasAux) {
        this.textoCronometro = texto_Cronometro;
        this.activity = activity;
        this.milisegundos = milisegundosAux;
        this.minutos = minutosAux;
        this.segundos = segundosAux;
        this.horas = horasAux;

    }

    public void parar() {
        this.arrancado = false;
    }

    @Override
    public void run() {
        try {
            while (arrancado) {
                //noinspection BusyWait
                sleep(1);
                milisegundos++;
                if (milisegundos == 1000) {
                    segundos = segundos + 1;
                    milisegundos = 0;
                    if (segundos == 60) {
                        minutos = minutos + 1;
                        segundos = 0;
                        if (minutos == 60) {
                            horas = horas + 1;
                            minutos = 0;
                        }
                    }
                }
                actualizar(milisegundos, segundos, minutos, horas);
            }
        } catch (InterruptedException ex) {
            // Vacio a proposito
        }
    }

    private void actualizar(int milisegundos, int segundos, int minutos, int horas) {
        //noinspection Convert2Lambda
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                @SuppressLint("DefaultLocale") String cadena = String.format("%02d:%02d:%02d:%03d", horas, minutos, segundos, milisegundos);
                textoCronometro.setText(cadena);
            }
        });
    }

    public int getMilisegundos() {
        return milisegundos;
    }

    public int getSegundos() {
        return segundos;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getHoras() {
        return horas;
    }

}
