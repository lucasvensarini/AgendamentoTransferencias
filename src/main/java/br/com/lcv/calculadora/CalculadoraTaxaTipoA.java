package br.com.lcv.calculadora;

import br.com.lcv.model.Transferencia;

public class CalculadoraTaxaTipoA {

	private static final double ACRESCIMO  = 0.03;
	private static final int VALOR_ADICIONAL = 2;
	
	public double calculaTaxa(Transferencia transferencia) {
		return (transferencia.getValor() * ACRESCIMO) + VALOR_ADICIONAL;		
	}
	
}
