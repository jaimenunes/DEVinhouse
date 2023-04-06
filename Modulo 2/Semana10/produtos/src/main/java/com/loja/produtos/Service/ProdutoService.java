package com.loja.produtos.Service;

import com.loja.produtos.controller.dto.ProdutoDTO;
import com.loja.produtos.repository.ProdutoRepository;
import com.loja.produtos.repository.model.Produto;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {
    ProdutoRepository produtoRepository;
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listaProdutos(){
        return produtoRepository.findAll();
    }

    public void addProduto(Produto produto) {
        produtoRepository.save(produto);
    }

    public void deleteProduto(Integer id){
        produtoRepository.deleteById(id);
    }

    public Produto findById(Integer id){
        return produtoRepository.findById(id).get();
    }
}

