package com.paneladev.meuprimeiromicroservico.controller;

import com.paneladev.meuprimeiromicroservico.service.ProdutoService;
import com.paneladev.meuprimeiromicroservico.domain.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<Produto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById(@PathVariable Long id) {
        Produto produto = service.findById(id);

        if(produto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(produto);
    }

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody Produto produto) {
        return new ResponseEntity<>(service.save(produto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Produto> update(@RequestBody Produto produto) {
        return ResponseEntity.ok(service.save(produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}