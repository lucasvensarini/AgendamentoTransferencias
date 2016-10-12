package br.com.lcv.calculadora;

import br.com.lcv.model.Transferencia;

public class CalculadoraTaxaTipoD {

	public static final int VALOR_LIMITE_CALCULO_TIPO_A = 25000;
	public static final int VALOR_LIMITE_CALCULO_TIPO_B = 120000;

	public double calculaTaxa(Transferencia transferencia) {
		if (transferencia.getValor() <= VALOR_LIMITE_CALCULO_TIPO_A) {
			CalculadoraTaxaTipoA calculadora = new CalculadoraTaxaTipoA();
			return calculadora.calculaTaxa(transferencia);
		} else if (transferencia.getValor() > VALOR_LIMITE_CALCULO_TIPO_A
				&& transferencia.getValor() <= VALOR_LIMITE_CALCULO_TIPO_B) {
			CalculadoraTaxaTipoB calculadora = new CalculadoraTaxaTipoB();
			return calculadora.calculaTaxa(transferencia);
		}
		CalculadoraTaxaTipoC calculadora = new CalculadoraTaxaTipoC();
		return calculadora.calculaTaxa(transferencia);
	}

}
