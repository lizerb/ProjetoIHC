package com.example.projetoihc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AgendarAusenciaActivity extends AppCompatActivity {

    private Button btnSalvar;
    private EditText editTextObs;
    private Button btnMarcarPresenca;
    private Button btnVisPresencas;
    private Button btnAgendarAusencia;
    private Button btnMenu;
    private Button btnAgendadas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendar_ausencia);

        btnSalvar = findViewById(R.id.btnSalvar);
        editTextObs = findViewById(R.id.editTextObs);
        btnMarcarPresenca = findViewById(R.id.btnMarcarpresenca);
        btnVisPresencas = findViewById(R.id.btnVisPresencas);
        btnAgendarAusencia = findViewById(R.id.btnAgendarAusencias);
        btnMenu = findViewById(R.id.btnMenu);
        btnAgendadas = findViewById(R.id.btnAgendados);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //botao retornar ao menu
        getSupportActionBar().setTitle("Agendar ausência");     // troca o título

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        btnAgendadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VisAgendamentosActivity.class);
                startActivity(intent);
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AgendarAusenciaActivity.this, "Ausência agendada!", Toast.LENGTH_LONG).show();
                editTextObs.setText("");
                editTextObs.clearFocus();
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {       //para retornar ao menu
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

}