package br.com.lcv.calculadora;

import java.time.LocalDateTime;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import br.com.lcv.transferencia.TransferenciaBase;
import br.com.lcv.util.CriadorTransferenciaBase;

public class CalculadoraTaxaTipoBTest {
	
	private static final LocalDateTime MAIS_LIMITE_DIAS = LocalDateTime.now().plusDays(32);
	
	private ICalculadoraTaxa calculadora;

	public CalculadoraTaxaTipoBTest() {
		calculadora = new CalculadoraTaxaTipoB();
	}

	@Test
	public void deveRetornarTaxaAntesLimiteDias() {
		TransferenciaBase tb = CriadorTransferenciaBase.criaTransferenciaBase();
		Assert.assertEquals(10.0, calculadora.calculaTaxa(tb), 0.1);
	}
	
	@Test
	public void deveRetornarTaxaAposLimiteDias() {
		TransferenciaBase tb = CriadorTransferenciaBase.criaTransferenciaBase(1000.0, MAIS_LIMITE_DIAS);
		Assert.assertEquals(8.0, calculadora.calculaTaxa(tb), 0.1);
	}
	
}
