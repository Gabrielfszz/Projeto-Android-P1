package com.example.p1android;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ProdutosFragment extends Fragment {

    private List<Produto> cesta = new ArrayList<>();
    private OnCestaAtualizada listener;

    public interface OnCestaAtualizada {
        void onCestaAtualizada(List<Produto> cesta);
    }

    public void setOnCestaAtualizada(OnCestaAtualizada listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_produtos, container, false);

        RecyclerView rv = v.findViewById(R.id.recyclerProdutos);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(new ProdutoAdapter(getContext(), getProdutos(), produto -> {
            adicionarNaCesta(produto);
        }));

        return v;
    }

    private void adicionarNaCesta(Produto produto) {
        for (Produto p : cesta) {
            if (p.getNome().equals(produto.getNome())) {
                p.setQuantidade(p.getQuantidade() + 1);
                if (listener != null) listener.onCestaAtualizada(cesta);
                return;
            }
        }
        Produto novo = new Produto(produto.getNome(), produto.getDescricao(), produto.getPreco(), produto.getImagem());
        cesta.add(novo);
        if (listener != null) listener.onCestaAtualizada(cesta);
    }

    private List<Produto> getProdutos() {
        List<Produto> lista = new ArrayList<>();
        lista.add(new Produto("Notebook Acer Nitro V15", "i7-13620h, 16GB RAM, RTX 4060, 512GB SSD ", "R$ 6.929,10", R.drawable.notebook_acer_nitro));
        lista.add(new Produto("Mouse Gamer Sem Fio Attack Shark X11", "22000 Dpi, 59g, Tri-mode Com Dock Magnético, RGB, Preto", "R$ 179,91", R.drawable.mouse_attack_shark_x11));
        lista.add(new Produto("Teclado Gamer HyperX Alloy Core", "ABNT2, RGB", "R$ 349,99", R.drawable.teclado_gamer_hyperx_alloy_core));
        lista.add(new Produto("Monitor Gamer Lg Ultragear 27\" Full HD", "144Hz, IPS, Gsync, Freesync, Preto", "R$ 1.056,52", R.drawable.monitor_lg_ultragear));
        lista.add(new Produto("Headset Gamer Havit", "Drivers 53mm, Microfone Plugável, 3.5mm, PC, PS4, XBOX ONE, Preto", "R$ 223,99", R.drawable.headset_gamer_havit));
        lista.add(new Produto("SSD Kingston A400", "480GB, SATA III, 2.5\", Leitura: 500MB/s, Gravação: 450MB/s, Preto", "R$ 589,99", R.drawable.ssd_kingston));
        lista.add(new Produto("Webcam Full HD Logitech C922 Pro Stream", "Microfone Embutido, 1080p e Tripé Incluso, Compatível Logitech Capture", "R$ 585,90", R.drawable.webcam_logitech));
        lista.add(new Produto("Roteador Acer Predator Connect W6x", "AX6000, 4804 Mbps, Wi-Fi 6, 6 Antenas, Preto", "R$ 429,90", R.drawable.roteador_acer));
        lista.add(new Produto("Console Playstation 5 Slim Digital Edition", "825GB, USB, HDMI, Branco", "R$ 3.679,91", R.drawable.playstation_5_slim));
        lista.add(new Produto("Placa de Vídeo GALAX NVIDIA GeForce RTX 5050", "1-Click OC, 8GB, GDDR6, 128-Bits, Ray Tracing, DLSS 4", "R$ 2.299,99", R.drawable.galax_rtx_5050));
        return lista;
    }
}