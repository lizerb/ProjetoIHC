package com.example.projetoihc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class VisAgendamentosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vis_agendamentos);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //botao retornar ao menu
        getSupportActionBar().setTitle("Ausências agendadas");     // troca o título
    }
}