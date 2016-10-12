package br.com.lcv.model;

import javax.validation.constraints.Pattern;

public class Conta {

	@Pattern(regexp = "\\d{5}-\\d{1}")
	private String numero;
	
	public Conta(String numero) {
		this.numero = numero;
	}
	
	public String getNumero() {
		return numero;
	}
	
}
