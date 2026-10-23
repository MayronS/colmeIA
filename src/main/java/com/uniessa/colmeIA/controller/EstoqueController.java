package com.uniessa.colmeIA.controller;

import com.uniessa.colmeIA.entity.Estoque;
import com.uniessa.colmeIA.entity.Produto;
import com.uniessa.colmeIA.service.EstoqueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    private final EstoqueService estoqueService;

    public EstoqueController(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    @GetMapping
    public Estoque listarTodos() {
        return estoqueService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Produto> consultarPorId(@PathVariable int id) {
        Produto produto = estoqueService.consultarProduto(id);
        if (produto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produto);
    }

    @PostMapping("/produtos")
    public ResponseEntity<Produto> cadastrar(@RequestBody Produto produto) {
        Produto cadastrado = estoqueService.cadastrarProduto(produto);
        return ResponseEntity.ok(cadastrado);
    }
}
