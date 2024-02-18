package com.payroll.br;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class Funcionario {
	
	private @Id @GeneratedValue Long ID;
	private String nome;
	private String role;
	
	Funcionario () {}
	
	Funcionario (String nome, String role){
		this.nome = nome;
		this.role = role;
	}

	public long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Funcionario))
			return false;
		
		Funcionario funcionario = (Funcionario) obj;
		return Objects.equals(this.ID, funcionario.ID) && Objects.equals(this.nome, funcionario.nome)
				&& Objects.equals(this.role, funcionario.role);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.ID, this.nome, this.role);
	}
	
	@Override
	public String toString() {
		return "FUNCIONÁRIO{"+" Id= "+this.ID+", Nome= "+this.nome+", Role= "+this.role+" }";
	}
}
