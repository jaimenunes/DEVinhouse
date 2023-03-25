package com.philips.contas;

import com.philips.contas.model.Cliente;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContasApplication.class, args);
		Cliente cliente = new Cliente("Jaime", "1248456456");
		cliente.addCliente(cliente);
		cliente.encontrarCliente(1);
		System.out.println(cliente.encontrarCliente(1));
	}

}
