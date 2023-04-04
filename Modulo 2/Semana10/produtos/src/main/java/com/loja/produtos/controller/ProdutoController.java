package com.loja.produtos.controller;

import com.loja.produtos.repository.ProdutoRepository;
import com.loja.produtos.repository.model.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("produto")
public class ProdutoController {
    private final ProdutoRepository produtoRepository;
    public ProdutoController(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }
    @GetMapping
    public String produto(Model model){
        produtoRepository.save(
                Produto.builder()
                        .nome("Samsung")
                        .descricao("I7")
                        .preco(200.00)
                        .build()
        );
        Produto produto = produtoRepository.findById(1).orElse(null);
        model.addAttribute("produto", produto);
        return "produto";
    }
}
