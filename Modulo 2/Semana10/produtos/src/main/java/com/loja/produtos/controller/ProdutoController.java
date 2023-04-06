package com.loja.produtos.controller;

import com.loja.produtos.Service.ProdutoService;
import com.loja.produtos.controller.dto.ProdutoAtualizarDTO;
import com.loja.produtos.controller.dto.ProdutoDTO;
import com.loja.produtos.repository.ProdutoRepository;
import com.loja.produtos.repository.model.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
    private final ProdutoService produtoService;
    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @GetMapping
    @RequestMapping("/new")
    public String newProdutoPage(Model model, Produto produto) {
        return "formulario";
    }
    @GetMapping
    @RequestMapping("/all")
    public String showAllProducts(Model model) {
        List<ProdutoDTO> produtos = produtoService.listaProdutos()
                .stream().map(produto -> new ProdutoDTO(produto.getNome(), produto.getDescricao(), produto.getPreco()))
                .collect(Collectors.toList());

        model.addAttribute("produtos", produtos);
        return "listProduto";
    }

    @GetMapping
    public String showProduto(Model model) {
        Produto produto = Produto
                .builder()
                .nome("Teste")
                .descricao("Descrição Teste")
                .preco(10D)
                .build();
        produtoService.addProduto(produto);

        model.addAttribute("produto", produto);

        return "produto";
    }

    @PostMapping
    public String createProduto(Model model, @Validated Produto produto){
        produtoService.addProduto(produto);

        return "redirect:produto/all";
    }

    @GetMapping
    @RequestMapping("/delete/{id}")
    public String deleteProduto(@PathVariable("id") Integer id, Model model){
        produtoService.deleteProduto(id);
        List<ProdutoDTO> produtos = produtoService.listaProdutos()
                .stream().map(produto -> new ProdutoDTO(produto.getNome(), produto.getDescricao(), produto.getPreco()))
                .collect(Collectors.toList());

        model.addAttribute("produtos", produtos);
        return "listProduto";
    }

    @GetMapping
    @RequestMapping("/atualizar/{id}")
    public  String atualizarID(@PathVariable("id") Integer id, ProdutoAtualizarDTO produtoAtualizarDTO, Model model){
        model.addAttribute("id", id);
        return "formulario_atualizar";
    }

    @PostMapping
    @RequestMapping("/atualizar")
    public String atualizaProduto(ProdutoAtualizarDTO produtoAtualizarDTO, Model model){
        Produto produto = produtoService.findById(produtoAtualizarDTO.getId());
        produto.setNome(produtoAtualizarDTO.getNome());
        produto.setDescricao((produtoAtualizarDTO.getDescricao()));
        produto.setPreco(produtoAtualizarDTO.getPreco());
        produtoService.addProduto(produto);
        return "redirect:/produto/all";
    }

}
