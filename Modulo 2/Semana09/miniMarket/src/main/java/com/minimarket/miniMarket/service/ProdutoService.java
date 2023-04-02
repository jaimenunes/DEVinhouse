package com.minimarket.miniMarket.service;

import com.minimarket.miniMarket.model.Produto;
import com.minimarket.miniMarket.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    ProdutoRepository produtoRepository;
    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public void salvar(Produto produto){
        produtoRepository.save(produto);
    }
}

