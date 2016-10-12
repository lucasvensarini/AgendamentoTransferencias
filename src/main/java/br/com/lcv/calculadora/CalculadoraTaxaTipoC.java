package br.com.lcv.calculadora;

import java.time.Duration;

import br.com.lcv.model.Transferencia;

public class CalculadoraTaxaTipoC {

	public static final double TAXA_MAIOR_30_DIAS = 0.012;
	public static final double TAXA_ATE_30_DIAS = 0.021;
	public static final double TAXA_ATE_25_DIAS = 0.043;
	public static final double TAXA_ATE_20_DIAS = 0.054;
	public static final double TAXA_ATE_15_DIAS = 0.067;
	public static final double TAXA_ATE_10_DIAS = 0.074;
	public static final double TAXA_ATE_5_DIAS = 0.083;
	
	public double calculaTaxa(Transferencia transferencia) {
		Duration duracao = Duration.between(transferencia.getDataCadastro(), transferencia.getDataAgendamento());
		if (duracao.toDays() < 5) {
			return transferencia.getValor() * TAXA_ATE_5_DIAS;
		} else if (duracao.toDays() < 10) {
			return transferencia.getValor() * TAXA_ATE_10_DIAS;
		} else if (duracao.toDays() < 15) {
			return transferencia.getValor() * TAXA_ATE_15_DIAS;
		} else if (duracao.toDays() < 20) {
			return transferencia.getValor() * TAXA_ATE_20_DIAS;
		} else if (duracao.toDays() < 25) {
			return transferencia.getValor() * TAXA_ATE_25_DIAS;
		} else if (duracao.toDays() < 30) {
			return transferencia.getValor() * TAXA_ATE_30_DIAS;
		}
		return transferencia.getValor() * TAXA_MAIOR_30_DIAS;
	}
	
}
