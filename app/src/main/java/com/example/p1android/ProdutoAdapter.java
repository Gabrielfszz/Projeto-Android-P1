package com.example.p1android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoAdapter.ViewHolder> {

    private Context context;
    private List<Produto> lista;
    private OnAdicionarListener listener;

    public interface OnAdicionarListener {
        void onAdicionar(Produto produto);
    }

    public ProdutoAdapter(Context context, List<Produto> lista, OnAdicionarListener listener) {
        this.context = context;
        this.lista = lista;
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView nome, descricao, preco;
        Button btnAdicionar;

        public ViewHolder(View v) {
            super(v);
            img = v.findViewById(R.id.imgProduto);
            nome = v.findViewById(R.id.tvNomeProduto);
            descricao = v.findViewById(R.id.tvDescricaoProduto);
            preco = v.findViewById(R.id.tvPrecoProduto);
            btnAdicionar = v.findViewById(R.id.btnAdicionar);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_produto, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Produto p = lista.get(position);
        holder.nome.setText(p.getNome());
        holder.descricao.setText(p.getDescricao());
        holder.preco.setText(p.getPreco());
        holder.img.setImageResource(p.getImagem());
        holder.btnAdicionar.setOnClickListener(v -> listener.onAdicionar(p));
    }

    @Override
    public int getItemCount() { return lista.size(); }
}
