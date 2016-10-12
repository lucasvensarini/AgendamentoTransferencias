package br.com.lcv.model;

import br.com.lcv.calculadora.CalculadoraTaxaTipoA;

public class TransferenciaA implements ITransferencia {

	private Transferencia transferencia;
	private double taxa;
	private TipoTransferencia tipo;

	public TransferenciaA(Transferencia transferencia) {
		this.transferencia = transferencia;
		this.tipo = TipoTransferencia.A;
		this.taxa = calculaTaxa();
//		this.taxa.setScale(2, RoundingMode.FLOOR);
	}

	@Override
	public double calculaTaxa() {
		CalculadoraTaxaTipoA calculadora = new CalculadoraTaxaTipoA();
		return calculadora.calculaTaxa(transferencia);
//		return new BigDecimal(taxa);
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
