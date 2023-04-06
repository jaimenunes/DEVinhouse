package com.loja.produtos.controller;

import com.loja.produtos.Service.ProdutoService;
import com.loja.produtos.controller.dto.ProdutoDTO;
import com.loja.produtos.repository.ProdutoRepository;
import com.loja.produtos.repository.model.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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
        List<Produto> produtos = produtoService.listaProdutos();

        model.addAttribute("produtos", produtos);
        return "listProduto";
    }
//    @GetMapping
//    @RequestMapping("/all")
//    public String listar(Model model){
//        List<ProdutoDTO> produtos = produtoService.listaProdutos()
//                .stream()
//                .map(produto -> new ProdutoDTO(produto.getNome(), produto.getDescricao(), produto.getPreco())).collect(
//                        Collectors.toList());
//        model.addAttribute("produtos", produtos);
//        return "produto";
//    }

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

//    @GetMapping()
//    @RequestMapping("/cadastro")
//    public String cadastro(ProdutoDTO produtoDTO, Model model){
//        return "formulario";
//    }
//
//    @PostMapping()
//    public String postFormulario(
//            @Validated ProdutoDTO produtoDTO,
//            Model model
//    ){
//       String test = this.produtoService.postCadastro(produtoDTO, model);
//       return test;
//    }
}
