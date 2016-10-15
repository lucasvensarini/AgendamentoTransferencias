package br.com.lcv.model;

import org.junit.Test;

public class ContaTest {

	@Test(expected = NullPointerException.class)
	public void deveLancarNullPointerExceptionQuandoNumeroForNulo() {
		Usuario usuario = new Usuario("Lucas");
		Conta conta = new Conta(null, usuario);
	}
	
	@Test(expected = NullPointerException.class)
	public void deveLancarNullPointerExceptionQuandoNumeroForVazio() {
		Usuario usuario = new Usuario("Lucas");
		Conta conta = new Conta("", usuario);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deveLancarNullPointerExceptionQuandoNumeroTiverFormatoInvalido() {
		Usuario usuario = new Usuario("Lucas");
		Conta conta = new Conta("123456789", usuario);
	}
	
	@Test(expected = NullPointerException.class)
	public void deveLancarNullPointerExceptionQuandoUsuarioForNulo() {
		Conta conta = new Conta("12345-6", null);
	}
	
}
