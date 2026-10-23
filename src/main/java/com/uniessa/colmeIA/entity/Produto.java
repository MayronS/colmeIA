package com.uniessa.colmeIA.entity;

public class Produto {

    private Integer id;
    private String nome;
    private String categoria;
    private double preco;
    private int quantidade;
    private int quantidadeMinima;

    public Produto() {
    }

    public Produto(Integer id, String nome, String categoria, double preco, int quantidade, int quantidadeMinima) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidade = quantidade;
        this.quantidadeMinima = quantidadeMinima;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(int quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    public boolean estaAbaixoDoMinimo() {
        return quantidade < quantidadeMinima;
    }
}