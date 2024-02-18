package com.payroll.br;

public class FuncionarioNotFoundException extends RuntimeException{
	
	public FuncionarioNotFoundException(Long Id) {
		super("Cound Not find Funcionario "+Id);
	}
}
