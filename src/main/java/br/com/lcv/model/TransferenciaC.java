package br.com.lcv.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.lcv.calculadora.CalculadoraTaxaTipoC;

public class TransferenciaC implements ITransferencia {

	private Transferencia transferencia;
	private double taxa;
	private TipoTransferencia tipo;

	public TransferenciaC(Transferencia transferencia) {
		this.transferencia = transferencia;
		this.tipo = TipoTransferencia.C;
		this.taxa = calculaTaxa();
//		this.taxa.setScale(2, RoundingMode.HALF_UP);
	}

	@Override
	public double calculaTaxa() {
		CalculadoraTaxaTipoC calculadora = new CalculadoraTaxaTipoC();
		return calculadora.calculaTaxa(transferencia);
	}

	@Override
	public String listaInformacoes() {
		StringBuilder sb = new StringBuilder(transferencia.toString());
		sb.append("Taxa: ").append(taxa);
		sb.append(System.getProperty("line.separator"));
		sb.append("Tipo: ").append(tipo.name());
		
		return sb.toString();	}

}
