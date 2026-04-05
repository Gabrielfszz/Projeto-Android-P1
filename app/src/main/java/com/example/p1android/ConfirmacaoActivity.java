package com.example.p1android;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ConfirmacaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacao);

        double total = getIntent().getDoubleExtra("total", 0);
        int totalItens = getIntent().getIntExtra("totalItens", 0);

        ((TextView) findViewById(R.id.tvResumo)).setText(totalItens + " item(ns) adquirido(s)");
        ((TextView) findViewById(R.id.tvTotalConfirmacao)).setText(String.format("Total: R$ %.2f", total));

        ((Button) findViewById(R.id.btnVoltar)).setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });
    }
}