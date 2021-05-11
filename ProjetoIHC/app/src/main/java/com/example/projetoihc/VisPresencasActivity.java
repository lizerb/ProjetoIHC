package com.example.projetoihc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class VisPresencasActivity extends AppCompatActivity {

    public TextView mensagemDaOutraTela;
    private Button btnMarcarPresenca;
    private Button btnVisPresencas;
    private Button btnAgendarAusencia;
    private Button btnMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vis_presencas);

        btnMarcarPresenca = findViewById(R.id.btnMarcarpresenca);
        btnVisPresencas = findViewById(R.id.btnVisPresencas);
        btnAgendarAusencia = findViewById(R.id.btnAgendarAusencias);
        btnMenu = findViewById(R.id.btnMenu);


        SharedPreferences mySharedPreferences = this.getSharedPreferences("MYPREFERENCENAME", Context.MODE_PRIVATE);
        String data = mySharedPreferences.getString("NAME", "");

        mensagemDaOutraTela = findViewById(R.id.textView2);
        mensagemDaOutraTela.setText(data);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //botao retornar ao menu
        getSupportActionBar().setTitle("Visualizar presenças");     // troca o título

        //TextView clockedToXML = new TextView(this);
        //clockedToXML.setText(data);
        //@SuppressLint("ResourceType") ConstraintLayout layout = (ConstraintLayout) findViewById(R.layout.activity_vis_presencas);
        //ConstraintSet set = new ConstraintSet();
        //layout.addView(clockedToXML);
        //int id = clockedToXML.getId();
        //set.clone(layout);
        //set.connect(id, ConstraintSet.HORIZONTAL_GUIDELINE, );
        //set.applyTo(layout);

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

    //public boolean onCreateOptionsMenu(Menu menu) {
        //return true;
    //}

}