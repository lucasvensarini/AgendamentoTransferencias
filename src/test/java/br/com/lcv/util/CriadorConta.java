package br.com.lcv.util;

import br.com.lcv.model.Conta;
import br.com.lcv.model.Usuario;

public class CriadorConta {

	public static Conta criaConta() {
		return new Conta("00001-2", new Usuario("Lucas"));
	}
	
	public static Conta criaConta(String numero) {
		return new Conta(numero, new Usuario("Lucas"));
	}
	
}
