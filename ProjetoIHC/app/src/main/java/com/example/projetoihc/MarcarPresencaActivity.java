package com.example.projetoihc;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MarcarPresencaActivity extends AppCompatActivity {

    Button btnScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marcar_presenca);
        btnScan = (Button) findViewById(R.id.btnScan);
        final Activity activity = this;

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
    }


      @Override
      protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
          IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
         if (result != null){
            if (result.getContents() != null){
                alert("Presença marcada!");
                //alert(result.getContents());
             }else{
                 alert("Scan cancelado");
             }
         }else{
             super.onActivityResult(requestCode, resultCode, data);
          }

     }

      private void alert(String msg){
          Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
      }

}