package br.com.lcv.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Conta {

	private static final String NUMERO_INVALIDO = "O número da conta não pode ser nulo.";
	private static final String PADRAO_NUMERO_INVALIDO = "Número de formato inválido (XXXXX-X).";
	private static final String USUARIO_INVALIDO = "O usuário não pode ser nulo.";

	private static final String PADRAO_NUMERO_CONTA = "\\d{5}-\\d{1}";

	private String numero;
	private Usuario usuario;

	public Conta(String numero, Usuario usuario) {
		this.numero = validaNumero(numero);
		this.usuario = validaUsuario(usuario);
	}

	public String getNumero() {
		return numero;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	private String validaNumero(String numero) {
		if (numero == null || numero.isEmpty()) {
			throw new NullPointerException(NUMERO_INVALIDO);
		}

		Pattern pattern = Pattern.compile(PADRAO_NUMERO_CONTA);
		Matcher matcher = pattern.matcher(numero);

		if (!matcher.matches()) {
			throw new IllegalArgumentException(PADRAO_NUMERO_INVALIDO);
		}

		return numero;
	}
	
	private Usuario validaUsuario(Usuario usuario) {
		if (usuario == null) {
			throw new NullPointerException(USUARIO_INVALIDO);
		}
		return usuario;
	}

}
