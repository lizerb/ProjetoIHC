package com.example.projetoihc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MarcarPresencaActivity extends AppCompatActivity {

    Button btnScan;
    private Button btnMarcarPresenca;
    private Button btnVisPresencas;
    private Button btnAgendarAusencia;
    private Button btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marcar_presenca);
        btnScan = (Button) findViewById(R.id.btnScan);
        final Activity activity = this;
        btnMarcarPresenca = findViewById(R.id.btnMarcarpresenca);
        btnVisPresencas = findViewById(R.id.btnVisPresencas);
        btnAgendarAusencia = findViewById(R.id.btnAgendarAusencias);
        btnMenu = findViewById(R.id.btnMenu);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //botao retornar ao menu
        getSupportActionBar().setTitle("Marcar presença");     // troca o título

        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Aponte a câmera para o QR Code");
                integrator.setCameraId(0);
                integrator.initiateScan();
            }
        });

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

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {       //para retornar ao menu
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                finish();
//                return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//
//    public boolean onCreateOptionsMenu(Menu menu) {
//        return true;
//    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null){
            if (result.getContents() != null){
                alert("Presença marcada!");

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
                LocalDateTime now = LocalDateTime.now();
                String clockedMoment = dtf.format(now);

                SharedPreferences mySharedPreferences = this.getSharedPreferences("MYPREFERENCENAME", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = ((SharedPreferences) mySharedPreferences).edit();
                editor.putString("NAME", clockedMoment);
                editor.apply();

                SharedPreferences myFourthSharedPreferences = this.getSharedPreferences("MYPREFERENCEPROGRESS", Context.MODE_PRIVATE);
                SharedPreferences.Editor editorProgress = ((SharedPreferences) myFourthSharedPreferences).edit();
                editorProgress.putString("PROGRESS", "25");
                editorProgress.apply();
            }else{
              alert("Scan cancelado");
              //  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
              //  LocalDateTime now = LocalDateTime.now();
              //  String clockedMoment = dtf.format(now);
              //  TextView clockedToXML = new TextView(this);
              //  clockedToXML.setText(clockedMoment);
              //  @SuppressLint("ResourceType") ConstraintLayout layout = findViewById(R.layout.activity_vis_presencas);
              //  ConstraintSet set = new ConstraintSet();
              //  set.clone(layout);
              //  layout.addView(clockedToXML);
              //  set.applyTo(layout);
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data);
        }

    }

    private void alert(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

}