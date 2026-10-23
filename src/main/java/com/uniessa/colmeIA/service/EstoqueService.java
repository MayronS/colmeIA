package com.uniessa.colmeIA.service;

import com.uniessa.colmeIA.entity.Estoque;
import com.uniessa.colmeIA.entity.Produto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueService {

    private final Estoque estoque = new Estoque();
    private int nextId = 1;

    public EstoqueService() {
        seed();
    }

    public Estoque findAll() {
        return estoque;
    }

    public List<Produto> listarProdutos() {
        return estoque.listarProdutos();
    }

    public Produto consultarProduto(int id) {
        return estoque.consultarProduto(id);
    }

    public Produto cadastrarProduto(Produto produto) {
        if (produto.getId() != null && produto.getId() > 0) {
            Produto existente = estoque.consultarProduto(produto.getId());
            if (existente != null) {
                System.out.println("Atenção: ID " + produto.getId() + " já existe, sobrescrevendo...");
            }
        } else {
            produto.setId(nextId++);
        }
        estoque.cadastrarProduto(produto);
        return produto;
    }

    public void atualizarQuantidade(int id, int quantidade) {
        estoque.atualizarQuantidade(id, quantidade);
    }

    public List<Produto> listarAbaixoDoMinimo() {
        return estoque.listarAbaixoDoMinimo();
    }

    private void seed() {
        estoque.cadastrarProduto(new Produto(123231, "Arroz Tipo 1", "Mercearia", 5.49, 20, 5));
        estoque.cadastrarProduto(new Produto(2123213, "Feijão Carioca", "Mercearia", 4.29, 2, 5));
        estoque.cadastrarProduto(new Produto(3123123, "Sabão em Pó", "Limpeza", 12.90, 30, 10));
    }
}
