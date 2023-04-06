package com.minimarket.miniMarket.service;

import com.minimarket.miniMarket.model.Produto;
import com.minimarket.miniMarket.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {
    ProdutoRepository produtoRepository;
    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public void salvar(Produto produto){
        produtoRepository.save(produto);
    }

    public Produto findByID(Integer id){
        Optional<Produto> produtoOptional = produtoRepository.findById(id);

        if (produtoOptional.isPresent()) {
            return produtoOptional.get();
        } else {
            // Você pode optar por retornar null ou lançar uma exceção
            return null;
        }
    }

}

