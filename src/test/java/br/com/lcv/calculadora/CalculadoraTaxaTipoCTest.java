package br.com.lcv.calculadora;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

import br.com.lcv.transferencia.TransferenciaBase;
import br.com.lcv.util.CriadorTransferenciaBase;

public class CalculadoraTaxaTipoCTest {

	private static final LocalDateTime MAIS_5_DIAS = LocalDateTime.now().plusDays(5);
	private static final LocalDateTime MAIS_10_DIAS = LocalDateTime.now().plusDays(10);
	private static final LocalDateTime MAIS_15_DIAS = LocalDateTime.now().plusDays(15);
	private static final LocalDateTime MAIS_20_DIAS = LocalDateTime.now().plusDays(20);
	private static final LocalDateTime MAIS_25_DIAS = LocalDateTime.now().plusDays(25);
	private static final LocalDateTime MAIS_30_DIAS = LocalDateTime.now().plusDays(30);
	private static final LocalDateTime MAIS_40_DIAS = LocalDateTime.now().plusDays(40);
	
	private ICalculadoraTaxa calculadora;

	public CalculadoraTaxaTipoCTest() {
		calculadora = new CalculadoraTaxaTipoC();
	}

	@Test
	public void deveUsarTaxaAte5Dias() {
		TransferenciaBase tb = CriadorTransferenciaBase.criaTransferenciaBase(MAIS_5_DIAS);
		Assert.assertEquals(8.3, calculadora.calculaTaxa(tb), 0.1);
	}
	
	@Test
	public void deveUsarTaxaAte10Dias() {
		TransferenciaBase tb = CriadorTransferenciaBase.criaTransferenciaBase(MAIS_10_DIAS);
		Assert.assertEquals(7.4, calculadora.calculaTaxa(tb), 0.1);
	}
	
	@Test
	public void deveUsarTaxaAte15Dias() {
		TransferenciaBase tb = CriadorTransferenciaBase.criaTransferenciaBase(MAIS_15_DIAS);
		Assert.assertEquals(6.7, calculadora.calculaTaxa(tb), 0.1);
	}
	
	@Test
	public void deveUsarTaxaAte20Dias() {
		TransferenciaBase tb = CriadorTransferenciaBase.criaTransferenciaBase(MAIS_20_DIAS);
		Assert.assertEquals(5.4, calculadora.calculaTaxa(tb), 0.1);
	}
	
	@Test
	public void deveUsarTaxaAte25Dias() {
		TransferenciaBase tb = CriadorTransferenciaBase.criaTransferenciaBase(MAIS_25_DIAS);
		Assert.assertEquals(4.3, calculadora.calculaTaxa(tb), 0.1);
	}
	
	@Test
	public void deveUsarTaxaAte30Dias() {
		TransferenciaBase tb = CriadorTransferenciaBase.criaTransferenciaBase(MAIS_30_DIAS);
		Assert.assertEquals(2.1, calculadora.calculaTaxa(tb), 0.1);
	}
	
	@Test
	public void deveUsarTaxaMaior30Dias() {
		TransferenciaBase tb = CriadorTransferenciaBase.criaTransferenciaBase(MAIS_40_DIAS);
		Assert.assertEquals(1.2, calculadora.calculaTaxa(tb), 0.1);
	}
	
}
