package com.example.projetoihc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressBarActivity extends AppCompatActivity {
    private int progr = 0;
    private Button btnIncrease;
    private Button btnDecrease;
    private ProgressBar progressBar;
    private TextView progressBarText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        btnIncrease = findViewById(R.id.button_incr);
        btnDecrease = findViewById(R.id.button_decr);
        progressBar = findViewById(R.id.progressBar);
        progressBarText = findViewById(R.id.textProgressBar);

        updateProgressBar();

        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (progr <= 75) {
                    progr += 25;
                    updateProgressBar();
                }
            }
        });

        btnDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (progr >= 25) {
                    progr -= 25;
                    updateProgressBar();
                }
            }
        });
    }

    private void updateProgressBar() {
        progressBar.setProgress(progr);
        progressBarText.setText(progr+"%");
    }
}