package com.uniessa.colmeIA.entity;

import java.util.ArrayList;
import java.util.List;

public class Estoque {

    private List<Produto> produtos;

    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    public void cadastrarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void atualizarQuantidade(int id, int quantidade) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produto.setQuantidade(quantidade);
                break;
            }
        }
    }

    public Produto consultarProduto(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }

    public List<Produto> listarProdutos() {
        return new ArrayList<>(produtos);
    }

    public List<Produto> listarAbaixoDoMinimo() {
        List<Produto> abaixo = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.estaAbaixoDoMinimo()) {
                abaixo.add(produto);
            }
        }
        return abaixo;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
