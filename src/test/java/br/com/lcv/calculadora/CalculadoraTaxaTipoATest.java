package br.com.lcv.calculadora;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

import br.com.lcv.model.Conta;
import br.com.lcv.model.Usuario;
import br.com.lcv.transferencia.TransferenciaBase;

public class CalculadoraTaxaTipoATest {

	private ICalculadoraTaxa calculadora;
	private Conta contaOrigem;
	private Conta contaDestino;

	public CalculadoraTaxaTipoATest() {
		calculadora = new CalculadoraTaxaTipoA();
		contaOrigem = new Conta("00001-2", new Usuario("Lucas"));
		contaDestino = new Conta("00001-2", new Usuario("Joao"));
	}

	@Test
	public void deveRetornar5() {
		TransferenciaBase tb = new TransferenciaBase(contaOrigem, contaDestino, BigDecimal.valueOf(100),
				LocalDateTime.now());
		Assert.assertEquals(5.0, calculadora.calculaTaxa(tb), 0.1);
	}

	@Test
	public void deveRetornarValorAdicional() {
		TransferenciaBase tb = new TransferenciaBase(contaOrigem, contaDestino, BigDecimal.valueOf(0),
				LocalDateTime.now());
		Assert.assertEquals(2.0, calculadora.calculaTaxa(tb), 0.1);
	}

}
