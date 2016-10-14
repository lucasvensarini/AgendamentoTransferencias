package br.com.lcv.transferencia;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.lcv.calculadora.CalculadoraTaxaTipoB;
import br.com.lcv.calculadora.ICalculadoraTaxa;

public class TransferenciaB implements ITransferencia {

	private TransferenciaBase transferencia;
	private BigDecimal taxa;
	private TipoTransferencia tipo;

	public TransferenciaB(TransferenciaBase transferencia) {
		this.transferencia = transferencia;
		this.tipo = TipoTransferencia.B;
		this.taxa = calculaTaxa();
	}

	@Override
	public BigDecimal calculaTaxa() {
		ICalculadoraTaxa calculadora = new CalculadoraTaxaTipoB();
		double taxa = calculadora.calculaTaxa(transferencia);
		BigDecimal bd = BigDecimal.valueOf(taxa);
		return bd.setScale(2, RoundingMode.FLOOR);
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
