package com.philips.contas;

import com.philips.contas.controller.ClienteController;
import com.philips.contas.model.Cliente;
import com.philips.contas.repository.ClienteRepository;
import com.philips.contas.service.ClienteService;
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
		
		List<Cliente> listaClientes = clienteRepository.retornaLista();
		System.out.println(listaClientes);


	}

}
