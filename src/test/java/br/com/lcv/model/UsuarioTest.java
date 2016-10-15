package br.com.lcv.model;

import org.junit.Test;

public class UsuarioTest {

	@Test(expected = NullPointerException.class)
	public void deveLancarNullPointerExceptionQuandoNomeForNulo() {
		Usuario usuario = new Usuario(null);
	}
	
	@Test(expected = NullPointerException.class)
	public void deveLancarNullPointerExceptionQuandoNomeForVazio() {
		Usuario usuario = new Usuario("");
	}
	
}
