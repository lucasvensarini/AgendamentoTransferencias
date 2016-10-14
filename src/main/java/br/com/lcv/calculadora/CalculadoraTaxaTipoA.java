package br.com.lcv.calculadora;

import br.com.lcv.transferencia.TransferenciaBase;

public class CalculadoraTaxaTipoA implements ICalculadoraTaxa {

	private static final double ACRESCIMO  = 0.03;
	private static final int VALOR_ADICIONAL = 2;
	
	@Override
	public double calculaTaxa(TransferenciaBase transferenciaBase) {
		return (transferenciaBase.getValor().doubleValue() * ACRESCIMO) + VALOR_ADICIONAL;		
	}
	
}
