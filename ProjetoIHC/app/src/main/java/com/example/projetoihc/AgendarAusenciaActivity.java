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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendar_ausencia);

        btnSalvar = findViewById(R.id.btnSalvar);
        editTextObs = findViewById(R.id.editTextObs);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //botao retornar ao menu
        getSupportActionBar().setTitle("Agendar ausência");     // troca o título

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AgendarAusenciaActivity.this, "Ausência agendada!", Toast.LENGTH_LONG).show();
                editTextObs.setText("");
                editTextObs.clearFocus();
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