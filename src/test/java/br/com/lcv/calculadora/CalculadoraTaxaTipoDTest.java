package br.com.lcv.calculadora;

import org.junit.Assert;
import org.junit.Test;

import br.com.lcv.transferencia.TransferenciaBase;
import br.com.lcv.util.CriadorTransferenciaBase;

public class CalculadoraTaxaTipoDTest {

	private ICalculadoraTaxa calculadora;

	public CalculadoraTaxaTipoDTest() {
		calculadora = new CalculadoraTaxaTipoD();
	}
	
	@Test
	public void deveUsarCalculadoraTipoA() {
		TransferenciaBase tb = CriadorTransferenciaBase.criaTransferenciaBase(25000);
		Assert.assertEquals(752, calculadora.calculaTaxa(tb), 0.1);
	}
	
	@Test
	public void deveUsarCalculadoraTipoB() {
		TransferenciaBase tb = CriadorTransferenciaBase.criaTransferenciaBase(26000);
		Assert.assertEquals(10, calculadora.calculaTaxa(tb), 0.1);
	}
	
	@Test
	public void deveUsarCalculadoraTipoC() {
		TransferenciaBase tb = CriadorTransferenciaBase.criaTransferenciaBase(150000);
		Assert.assertEquals(12450, calculadora.calculaTaxa(tb), 0.1);
	}
	
}
