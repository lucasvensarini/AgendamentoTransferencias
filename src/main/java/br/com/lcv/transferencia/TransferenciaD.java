package br.com.lcv.transferencia;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.lcv.calculadora.CalculadoraTaxaTipoD;
import br.com.lcv.calculadora.ICalculadoraTaxa;

public class TransferenciaD implements ITransferencia {

	private TransferenciaBase transferencia;
	private BigDecimal taxa;
	private TipoTransferencia tipo;

	public TransferenciaD(TransferenciaBase transferencia) {
		this.transferencia = transferencia;
		this.tipo = TipoTransferencia.D;
		this.taxa = calculaTaxa();
	}

	@Override
	public BigDecimal calculaTaxa() {
		ICalculadoraTaxa calculadora = new CalculadoraTaxaTipoD();
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
