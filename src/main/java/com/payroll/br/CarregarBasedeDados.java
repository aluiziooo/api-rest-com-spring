package com.payroll.br;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;


@Configuration
public class CarregarBasedeDados {
	
	private static final Logger log = LoggerFactory.getLogger(CarregarBasedeDados.class);

	@Bean
	CommandLineRunner initDatabase(FuncionarioRepositorio repositorio) {

		return args -> {
			log.info("Preloading " + repositorio.save(new Funcionario("Bilbo Baggins", "burglar")));
			log.info("Preloading " + repositorio.save(new Funcionario("Frodo Baggins", "thief")));
			};
		}
}
