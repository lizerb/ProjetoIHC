package com.example.projetoihc;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.projetoihc.ui.login.LoginActivity;

import java.text.BreakIterator;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import static java.text.DateFormat.DEFAULT;
import static java.text.DateFormat.SHORT;

public class MainActivity extends AppCompatActivity {
    private Button btnMarcarPresenca;
    private Button btnVisPresencas;
    private Button btnAgendarAusencia;
    private Button btnMenu;
    private TextView txtData;
    private TextView txtHora;
    private ProgressBar progressBar;
    private TextView progressBarText;
    private int progr = 0;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMarcarPresenca = findViewById(R.id.btnMarcarpresenca);
        btnVisPresencas = findViewById(R.id.btnVisPresencas);
        btnAgendarAusencia = findViewById(R.id.btnAgendarAusencias);
        btnMenu = findViewById(R.id.btnMenu);
        txtData = findViewById(R.id.textViewData);
        txtHora = findViewById(R.id.textViewHora);
        progressBar = findViewById(R.id.progressBar);
        progressBarText = findViewById(R.id.textProgressBar);

        updateProgressBar();

        getSupportActionBar().setTitle("Menu");     // troca o título

        String currentDate = DateFormat.getDateInstance(SHORT).format(new Date());
        String currentTime = DateFormat.getTimeInstance(SHORT).format(new Date());

        // data e hora na tela de menu
        txtData.setText(currentDate);
        txtHora.setText(currentTime);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        btnMarcarPresenca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MarcarPresencaActivity.class);
                startActivity(intent);
            }
        });

        btnVisPresencas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VisPresencasActivity.class);
                startActivity(intent);
            }
        });

        btnAgendarAusencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AgendarAusenciaActivity.class);
                startActivity(intent);
            }
        });

    }

    private void updateProgressBar() {
        progressBar.setProgress(progr);
        progressBarText.setText(progr+"%");
    }
}