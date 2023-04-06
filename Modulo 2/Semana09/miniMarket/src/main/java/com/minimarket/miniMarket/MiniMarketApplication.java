package com.minimarket.miniMarket;

import com.minimarket.miniMarket.model.Categoria;
import com.minimarket.miniMarket.model.Produto;
import com.minimarket.miniMarket.service.CategoriaService;
import com.minimarket.miniMarket.service.ClienteService;
import com.minimarket.miniMarket.service.ProdutoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class MiniMarketApplication implements CommandLineRunner {
	private final ProdutoService produtoService;
	private final CategoriaService categoriaService;
	private final ClienteService clienteService;

	public MiniMarketApplication(ProdutoService produtoService, CategoriaService categoriaService, ClienteService clienteService){
		this.produtoService = produtoService;
		this.categoriaService = categoriaService;
		this.clienteService = clienteService;
	}
	public static void main(String[] args) {
		SpringApplication.run(MiniMarketApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
//		System.out.println("Nome produto");
//		String nomeProduto = scanner.nextLine();
//		System.out.println("Descrição do produto");
//		String descricaoProduto = scanner.nextLine();
//		Double precoProduto = scanner.nextDouble();
//		Produto produto = new Produto();
//		produto.setNome(nomeProduto);
//		produto.setDescricao(descricaoProduto);
//		System.out.println("Preço produto");
//		produto.setPreco(precoProduto);
//		produtoService.salvar(produto);
		System.out.println("Nome Categoria");
		String nomeCategoria = scanner.nextLine();
		Categoria categoria = new Categoria();
		categoria.setNome(nomeCategoria);
		categoriaService.salvar(categoria);
		Produto produto = produtoService.findByID(1);
		produto.setCategoria(categoria);
		produtoService.salvar(produto);
	}
}
