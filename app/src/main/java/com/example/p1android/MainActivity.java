package com.example.p1android;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Produto> cesta = new ArrayList<>();
    private Button btnCesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCesta = findViewById(R.id.btnCesta);

        ProdutosFragment fragment = new ProdutosFragment();
        fragment.setOnCestaAtualizada(lista -> {
            cesta = new ArrayList<>(lista);
            int total = 0;
            for (Produto p : cesta) total += p.getQuantidade();
            btnCesta.setText("🛒 Cesta (" + total + ")");
        });

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();

        btnCesta.setOnClickListener(v -> {
            Intent intent = new Intent(this, CestaActivity.class);
            intent.putExtra("cesta", (ArrayList<Produto>) cesta);
            startActivity(intent);
        });
    }
}