package br.com.lcv.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.lcv.calculadora.CalculadoraTaxaTipoD;

public class TransferenciaD implements ITransferencia {

	private Transferencia transferencia;
	private double taxa;
	private TipoTransferencia tipo;

	public TransferenciaD(Transferencia transferencia) {
		this.transferencia = transferencia;
		this.tipo = TipoTransferencia.D;
		this.taxa = calculaTaxa();
//		this.taxa.setScale(2, RoundingMode.HALF_UP);
	}

	@Override
	public double calculaTaxa() {
		CalculadoraTaxaTipoD calculadora = new CalculadoraTaxaTipoD();
		return calculadora.calculaTaxa(transferencia);
	}

	@Override
	public String listaInformacoes() {
		StringBuilder sb = new StringBuilder(transferencia.toString());
		sb.append("Taxa: ").append(taxa);
		sb.append(System.getProperty("line.separator"));
		sb.append("Tipo: ").append(tipo.name());

		return sb.toString();
	}

}
