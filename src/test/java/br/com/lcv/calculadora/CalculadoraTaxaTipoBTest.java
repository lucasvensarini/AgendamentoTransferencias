package br.com.lcv.calculadora;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

import br.com.lcv.model.Conta;
import br.com.lcv.model.Usuario;
import br.com.lcv.transferencia.TransferenciaBase;

public class CalculadoraTaxaTipoBTest {

	private static final LocalDateTime DATA_MAIS_LIMITE_DIAS = LocalDateTime.now().plusDays(32);

	private ICalculadoraTaxa calculadora;
	private Conta contaOrigem;
	private Conta contaDestino;

	public CalculadoraTaxaTipoBTest() {
		calculadora = new CalculadoraTaxaTipoB();
		contaOrigem = new Conta("00001-2", new Usuario("Lucas"));
		contaDestino = new Conta("00001-2", new Usuario("Joao"));
	}

	@Test
	public void deveRetornarTaxaAntesLimiteDias() {
		TransferenciaBase tb = new TransferenciaBase(contaOrigem, contaDestino, BigDecimal.valueOf(100),
				LocalDateTime.now());
		Assert.assertEquals(10.0, calculadora.calculaTaxa(tb), 0.1);
	}

	@Test
	public void deveRetornarTaxaAposLimiteDias() {
		TransferenciaBase tb = new TransferenciaBase(contaOrigem, contaDestino, BigDecimal.valueOf(100),
				DATA_MAIS_LIMITE_DIAS);
		Assert.assertEquals(8.0, calculadora.calculaTaxa(tb), 0.1);
	}

}
