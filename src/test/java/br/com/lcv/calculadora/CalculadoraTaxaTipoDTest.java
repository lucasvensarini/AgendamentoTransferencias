package br.com.lcv.calculadora;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

import br.com.lcv.model.Conta;
import br.com.lcv.model.Usuario;
import br.com.lcv.transferencia.TransferenciaBase;

public class CalculadoraTaxaTipoDTest {

	private ICalculadoraTaxa calculadora;
	private Conta contaOrigem;
	private Conta contaDestino;

	public CalculadoraTaxaTipoDTest() {
		calculadora = new CalculadoraTaxaTipoD();
		contaOrigem = new Conta("00001-2", new Usuario("Lucas"));
		contaDestino = new Conta("00001-2", new Usuario("Joao"));
	}

	@Test
	public void deveUsarCalculadoraTipoA() {
		TransferenciaBase tb = new TransferenciaBase(contaOrigem, contaDestino, BigDecimal.valueOf(25000),
				LocalDateTime.now());
		Assert.assertEquals(752, calculadora.calculaTaxa(tb), 0.1);
	}

	@Test
	public void deveUsarCalculadoraTipoB() {
		TransferenciaBase tb = new TransferenciaBase(contaOrigem, contaDestino, BigDecimal.valueOf(26000),
				LocalDateTime.now());
		Assert.assertEquals(10, calculadora.calculaTaxa(tb), 0.1);
	}

	@Test
	public void deveUsarCalculadoraTipoC() {
		TransferenciaBase tb = new TransferenciaBase(contaOrigem, contaDestino, BigDecimal.valueOf(150000),
				LocalDateTime.now());
		Assert.assertEquals(12450, calculadora.calculaTaxa(tb), 0.1);
	}

}
