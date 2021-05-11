package com.example.projetoihc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class AgendarAusenciaActivity extends AppCompatActivity {

    private Button btnSalvar;
    private EditText editTextObs;
    private CalendarView calendar;
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
        calendar = findViewById(R.id.calendarView);

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

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                String curDate = String.valueOf(dayOfMonth);
                callShared(curDate);
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AgendarAusenciaActivity.this, "Ausência agendada!", Toast.LENGTH_LONG).show();
                //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                //String dataSelecionada = sdf.format(new Date(calendar.));
                calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                    @Override
                    public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                        String selectedDay = String.valueOf(dayOfMonth);
                        String selectedMonth = String.valueOf(month+1);
                        String selectedYear = String.valueOf(year);
                        String curDate = selectedDay + '/' + selectedMonth + '/' + selectedYear;
                        callShared(curDate);
                    }
                });
                String obs = String.valueOf(editTextObs.getText());
                editTextObs.setText("");
                editTextObs.clearFocus();

                callSharedObs(obs);
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

    public void callShared(String informacao){
        SharedPreferences mySecondSharedPreferences = this.getSharedPreferences("MYPREFERENCEDATA", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = ((SharedPreferences) mySecondSharedPreferences).edit();
        editor.putString("DATA", informacao);
        editor.apply();
    }

    public void callSharedObs(String informacao){
        SharedPreferences myThirdSharedPreferences = this.getSharedPreferences("MYPREFERENCEOBS", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = ((SharedPreferences) myThirdSharedPreferences).edit();
        editor.putString("OBS", informacao);
        editor.apply();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

}