package br.com.lcv.model;

import javax.validation.constraints.Pattern;

public class Conta {

	private static final String PADRAO_NUMERO_CONTA = "\\d{5}-\\d{1}";
	
	@Pattern(regexp = PADRAO_NUMERO_CONTA)
	private String numero;
	
	private Usuario usuario;
	
	public Conta(String numero, Usuario usuario) {
		this.numero = numero;
		this.usuario = usuario;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
}
