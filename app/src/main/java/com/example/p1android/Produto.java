package com.example.p1android;

import java.io.Serializable;

public class Produto implements Serializable {
    private String nome, descricao, preco;
    private int imagem;
    private int quantidade;

    public Produto(String nome, String descricao, String preco, int imagem) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imagem = imagem;
        this.quantidade = 1;
    }

    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public String getPreco() { return preco; }
    public int getImagem() { return imagem; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public double getPrecoDouble() {
        return Double.parseDouble(
                preco.replace("R$ ", "")
                        .replace(".", "")
                        .replace(",", ".")
        );
    }
}