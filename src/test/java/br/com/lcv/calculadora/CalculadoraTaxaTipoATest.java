package br.com.lcv.calculadora;

import org.junit.Assert;
import org.junit.Test;

import br.com.lcv.transferencia.TransferenciaBase;
import br.com.lcv.util.CriadorTransferenciaBase;

public class CalculadoraTaxaTipoATest {

	private ICalculadoraTaxa calculadora;

	public CalculadoraTaxaTipoATest() {
		calculadora = new CalculadoraTaxaTipoA();
	}

	@Test
	public void deveRetornar5() {
		TransferenciaBase tb = CriadorTransferenciaBase.criaTransferenciaBase();
		Assert.assertEquals(5.0, calculadora.calculaTaxa(tb), 0.1);
	}
	
	@Test
	public void deveRetornarValorAdicional() {
		TransferenciaBase tb = CriadorTransferenciaBase.criaTransferenciaBase(0.0);
		Assert.assertEquals(2.0, calculadora.calculaTaxa(tb), 0.1);
	}

}
