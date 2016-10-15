package br.com.lcv.transferencia;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Test;

import br.com.lcv.model.Conta;
import br.com.lcv.model.Usuario;

public class TransferenciaBaseTest {

	private Conta conta;
	private Usuario usuario;

	public TransferenciaBaseTest() {
		usuario = new Usuario("Lucas");
		conta = new Conta("12345-6", usuario);
	}

	@Test(expected = NullPointerException.class)
	public void deveLancarNullPointerExceptionQuandoContaOrigemForNula() {
		TransferenciaBase tb = new TransferenciaBase(null, conta, BigDecimal.valueOf(1000), LocalDateTime.now());
	}

	@Test(expected = NullPointerException.class)
	public void deveLancarNullPointerExceptionQuandoContaDestinoForNula() {
		TransferenciaBase tb = new TransferenciaBase(conta, null, BigDecimal.valueOf(1000), LocalDateTime.now());
	}
	
	@Test(expected = NullPointerException.class)
	public void deveLancarNullPointerExceptionQuandoValorForNulo() {
		TransferenciaBase tb = new TransferenciaBase(conta, conta, null, LocalDateTime.now());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deveLancarNullPointerExceptionQuandoValorForNegativo() {
		TransferenciaBase tb = new TransferenciaBase(conta, conta, BigDecimal.valueOf(-1000), LocalDateTime.now());
	}
	
	@Test(expected = NullPointerException.class)
	public void deveLancarNullPointerExceptionQuandoDataAgendamentoForNula() {
		TransferenciaBase tb = new TransferenciaBase(conta, conta, BigDecimal.valueOf(1000), null);
	}

}
