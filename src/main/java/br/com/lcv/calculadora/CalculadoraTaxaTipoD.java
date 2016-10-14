package br.com.lcv.calculadora;

import br.com.lcv.transferencia.TransferenciaBase;

public class CalculadoraTaxaTipoD implements ICalculadoraTaxa {

	public static final int VALOR_LIMITE_CALCULO_TIPO_A = 25000;
	public static final int VALOR_LIMITE_CALCULO_TIPO_B = 120000;

	@Override
	public double calculaTaxa(TransferenciaBase transferenciaBase) {
		ICalculadoraTaxa calculadora;
		if (transferenciaBase.getValor().doubleValue() <= VALOR_LIMITE_CALCULO_TIPO_A) {
			calculadora = new CalculadoraTaxaTipoA();
		} else if (transferenciaBase.getValor().doubleValue() > VALOR_LIMITE_CALCULO_TIPO_A
				&& transferenciaBase.getValor().doubleValue() <= VALOR_LIMITE_CALCULO_TIPO_B) {
			calculadora = new CalculadoraTaxaTipoB();
		} else {
			calculadora = new CalculadoraTaxaTipoC();
		}
		return calculadora.calculaTaxa(transferenciaBase);
	}

}
