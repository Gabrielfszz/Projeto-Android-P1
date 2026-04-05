package com.example.p1android;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class CestaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cesta);

        List<Produto> cesta = (ArrayList<Produto>) getIntent().getSerializableExtra("cesta");

        RecyclerView rv = findViewById(R.id.recyclerCesta);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new CestaAdapter(this, cesta));

        double total = 0;
        int totalItens = 0;
        for (Produto p : cesta) {
            total += p.getPrecoDouble() * p.getQuantidade();
            totalItens += p.getQuantidade();
        }

        ((TextView) findViewById(R.id.tvTotal)).setText(String.format("R$ %.2f", total));

        double finalTotal = total;
        int finalTotalItens = totalItens;
        ((Button) findViewById(R.id.btnFinalizar)).setOnClickListener(v -> {
            Intent intent = new Intent(this, ConfirmacaoActivity.class);
            intent.putExtra("total", finalTotal);
            intent.putExtra("totalItens", finalTotalItens);
            intent.putExtra("cesta", (ArrayList<Produto>) cesta);
            startActivity(intent);
        });
    }
}