package com.payroll.br;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FuncionarioController {
	
	private final FuncionarioRepositorio funrepo;
	
	public FuncionarioController(FuncionarioRepositorio repo) {
		this.funrepo = repo;
	}
	
	@GetMapping("/funcionarios")
	List<Funcionario> pegartodos(){
		return funrepo.findAll();
	}
	
	@PostMapping("/funcionarios")
	Funcionario novoFuncionario(@RequestBody Funcionario funcionario) {
		return funrepo.save(funcionario);
	}
	
	@GetMapping("/funcionarios/{Id}")
	Funcionario pegarporid(@PathVariable Long Id) {
		return funrepo.findById(Id)
				.orElseThrow(() -> new FuncionarioNotFoundException(Id));
	}
	
	@PutMapping("/funcionarios/{Id}")
	Funcionario EditarFuncionario(@RequestBody Funcionario NovoFuncionario, @PathVariable Long Id) {
		
		return funrepo.findById(Id)
				.map(funcionario -> {
					funcionario.setNome(NovoFuncionario.getNome());
					funcionario.setRole(NovoFuncionario.getRole());
					return funrepo.save(funcionario);
				}).orElseGet(()-> {
					NovoFuncionario.setID(Id);
					return funrepo.save(NovoFuncionario);
				});
	}
	
	@DeleteMapping("/funcionarios/{Id}")
	void apagarfuncionario(@PathVariable Long Id) {
		funrepo.deleteById(Id);
	}
	
}
