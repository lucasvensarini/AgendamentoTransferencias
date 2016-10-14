package br.com.lcv.calculadora;

import java.time.Duration;

import br.com.lcv.transferencia.TransferenciaBase;

public class CalculadoraTaxaTipoC implements ICalculadoraTaxa {

	public static final double TAXA_MAIOR_30_DIAS = 0.012;
	public static final double TAXA_ATE_30_DIAS = 0.021;
	public static final double TAXA_ATE_25_DIAS = 0.043;
	public static final double TAXA_ATE_20_DIAS = 0.054;
	public static final double TAXA_ATE_15_DIAS = 0.067;
	public static final double TAXA_ATE_10_DIAS = 0.074;
	public static final double TAXA_ATE_5_DIAS = 0.083;

	@Override
	public double calculaTaxa(TransferenciaBase transferenciaBase) {
		double taxa;
		Duration duracao = Duration.between(transferenciaBase.getDataCadastro(),
				transferenciaBase.getDataAgendamento());
		if (duracao.toDays() <= 5) {
			taxa = TAXA_ATE_5_DIAS;
		} else if (duracao.toDays() <= 10) {
			taxa = TAXA_ATE_10_DIAS;
		} else if (duracao.toDays() <= 15) {
			taxa = TAXA_ATE_15_DIAS;
		} else if (duracao.toDays() <= 20) {
			taxa = TAXA_ATE_20_DIAS;
		} else if (duracao.toDays() <= 25) {
			taxa = TAXA_ATE_25_DIAS;
		} else if (duracao.toDays() <= 30) {
			taxa = TAXA_ATE_30_DIAS;
		} else {
			taxa = TAXA_MAIOR_30_DIAS;
		}
		return transferenciaBase.getValor().doubleValue() * taxa;
	}

}
