package com.example.p1android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CestaAdapter extends RecyclerView.Adapter<CestaAdapter.ViewHolder> {

    private Context context;
    private List<Produto> lista;

    public CestaAdapter(Context context, List<Produto> lista) {
        this.context = context;
        this.lista = lista;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nome, qtd, subtotal;
        public ViewHolder(View v) {
            super(v);
            nome = v.findViewById(R.id.tvNomeCesta);
            qtd = v.findViewById(R.id.tvQtdCesta);
            subtotal = v.findViewById(R.id.tvSubtotalCesta);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_cesta, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Produto p = lista.get(position);
        holder.nome.setText(p.getNome());
        holder.qtd.setText("Qtd: " + p.getQuantidade());
        double subtotal = p.getPrecoDouble() * p.getQuantidade();
        holder.subtotal.setText(String.format("R$ %.2f", subtotal));
    }

    @Override
    public int getItemCount() { return lista.size(); }
}