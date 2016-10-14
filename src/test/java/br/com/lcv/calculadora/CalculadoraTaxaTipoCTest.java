package br.com.lcv.calculadora;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

import br.com.lcv.model.Conta;
import br.com.lcv.model.Usuario;
import br.com.lcv.transferencia.TransferenciaBase;

public class CalculadoraTaxaTipoCTest {

	private static final LocalDateTime DATA_MAIS_5_DIAS = LocalDateTime.now().plusDays(5);
	private static final LocalDateTime DATA_MAIS_10_DIAS = LocalDateTime.now().plusDays(10);
	private static final LocalDateTime DATA_MAIS_15_DIAS = LocalDateTime.now().plusDays(15);
	private static final LocalDateTime DATA_MAIS_20_DIAS = LocalDateTime.now().plusDays(20);
	private static final LocalDateTime DATA_MAIS_25_DIAS = LocalDateTime.now().plusDays(25);
	private static final LocalDateTime DATA_MAIS_30_DIAS = LocalDateTime.now().plusDays(30);
	private static final LocalDateTime DATA_MAIS_40_DIAS = LocalDateTime.now().plusDays(40);

	private ICalculadoraTaxa calculadora;
	private Conta contaOrigem;
	private Conta contaDestino;

	public CalculadoraTaxaTipoCTest() {
		calculadora = new CalculadoraTaxaTipoC();
		contaOrigem = new Conta("00001-2", new Usuario("Lucas"));
		contaDestino = new Conta("00001-2", new Usuario("Joao"));
	}

	@Test
	public void deveUsarTaxaAte5Dias() {
		TransferenciaBase tb = new TransferenciaBase(contaOrigem, contaDestino, BigDecimal.valueOf(100),
				DATA_MAIS_5_DIAS);
		Assert.assertEquals(8.3, calculadora.calculaTaxa(tb), 0.1);
	}

	@Test
	public void deveUsarTaxaAte10Dias() {
		TransferenciaBase tb = new TransferenciaBase(contaOrigem, contaDestino, BigDecimal.valueOf(100),
				DATA_MAIS_10_DIAS);
		Assert.assertEquals(7.4, calculadora.calculaTaxa(tb), 0.1);
	}

	@Test
	public void deveUsarTaxaAte15Dias() {
		TransferenciaBase tb = new TransferenciaBase(contaOrigem, contaDestino, BigDecimal.valueOf(100),
				DATA_MAIS_15_DIAS);
		Assert.assertEquals(6.7, calculadora.calculaTaxa(tb), 0.1);
	}

	@Test
	public void deveUsarTaxaAte20Dias() {
		TransferenciaBase tb = new TransferenciaBase(contaOrigem, contaDestino, BigDecimal.valueOf(100),
				DATA_MAIS_20_DIAS);
		Assert.assertEquals(5.4, calculadora.calculaTaxa(tb), 0.1);
	}

	@Test
	public void deveUsarTaxaAte25Dias() {
		TransferenciaBase tb = new TransferenciaBase(contaOrigem, contaDestino, BigDecimal.valueOf(100),
				DATA_MAIS_25_DIAS);
		Assert.assertEquals(4.3, calculadora.calculaTaxa(tb), 0.1);
	}

	@Test
	public void deveUsarTaxaAte30Dias() {
		TransferenciaBase tb = new TransferenciaBase(contaOrigem, contaDestino, BigDecimal.valueOf(100),
				DATA_MAIS_30_DIAS);
		Assert.assertEquals(2.1, calculadora.calculaTaxa(tb), 0.1);
	}

	@Test
	public void deveUsarTaxaMaior30Dias() {
		TransferenciaBase tb = new TransferenciaBase(contaOrigem, contaDestino, BigDecimal.valueOf(100),
				DATA_MAIS_40_DIAS);
		Assert.assertEquals(1.2, calculadora.calculaTaxa(tb), 0.1);
	}

}
