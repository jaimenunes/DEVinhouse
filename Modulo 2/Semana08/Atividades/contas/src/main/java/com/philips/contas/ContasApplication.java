package com.philips.contas;

import com.philips.contas.controller.ClienteController;
import com.philips.contas.controller.ContaController;
import com.philips.contas.model.Cliente;
import com.philips.contas.model.Conta;
import com.philips.contas.repository.ClienteRepository;
import com.philips.contas.repository.ContaRepository;
import com.philips.contas.service.ClienteService;
import com.philips.contas.service.ContaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ContasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContasApplication.class, args);
		ClienteRepository clienteRepository = new ClienteRepository();
		ClienteService clienteService = new ClienteService(clienteRepository);
		ClienteController clienteController = new ClienteController(clienteService);
		Cliente novoCliente = new Cliente("João da Silva", "12345678901");
		Cliente novoCliente1 = new Cliente("Pedro da Silva", "12345678901");
		clienteController.addCliente(novoCliente);
		clienteController.addCliente(novoCliente1);
		ContaRepository contaRepository = new ContaRepository();
		ContaService contaService = new ContaService(contaRepository);
		ContaController contaController = new ContaController(contaService);
		Conta conta1 = new Conta(novoCliente);
		contaController.addConta(conta1);
		contaController.deposito(1, 100);
		contaController.saque(1, 50);
		contaController.saque(1, 70);
		List<Cliente> listaClientes = clienteRepository.retornaLista();
		System.out.println(listaClientes);
		List<Conta> listaContas = contaRepository.retornaLista();
		System.out.println(listaContas);
	}

}
