package com.example.projetoihc;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class VisAgendamentosActivity extends AppCompatActivity {

    public TextView mensagemDaOutraTela;
    public TextView obsDaOutraTela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vis_agendamentos);

        SharedPreferences mySecondSharedPreferences = this.getSharedPreferences("MYPREFERENCEDATA", Context.MODE_PRIVATE);
        String data = mySecondSharedPreferences.getString("DATA", "");

        mensagemDaOutraTela = findViewById(R.id.textViewAgendada);
        mensagemDaOutraTela.setText(data);

        SharedPreferences myThirdSharedPreferences = this.getSharedPreferences("MYPREFERENCEOBS", Context.MODE_PRIVATE);
        String obsContent = myThirdSharedPreferences.getString("OBS", "");

        obsDaOutraTela = findViewById(R.id.textViewObs);
        obsDaOutraTela.setText(obsContent);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //botao retornar ao menu
        getSupportActionBar().setTitle("Ausências agendadas");     // troca o título

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