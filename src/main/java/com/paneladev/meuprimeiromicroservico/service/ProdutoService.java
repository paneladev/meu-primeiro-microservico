package com.paneladev.meuprimeiromicroservico.service;

import com.paneladev.meuprimeiromicroservico.domain.Produto;
import com.paneladev.meuprimeiromicroservico.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> findAll() {
        return (List<Produto>) repository.findAll();
    }

    public Produto findById(Long id) {
        return repository.findById(id).get();
    }

    public Produto save(Produto produto) {
        return repository.save(produto);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}