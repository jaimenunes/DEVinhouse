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
	}

}
