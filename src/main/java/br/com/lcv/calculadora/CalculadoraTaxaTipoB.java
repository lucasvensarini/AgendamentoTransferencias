package br.com.lcv.calculadora;

import java.time.Duration;

import br.com.lcv.model.Transferencia;

public class CalculadoraTaxaTipoB {

	private static final int LIMITE_DIAS = 30;
	private static final int TAXA_ANTES_LIMITE_DIAS = 10;
	private static final int TAXA_APOS_LIMITE_DIAS = 8;

	public double calculaTaxa(Transferencia transferencia) {
		Duration duracao = Duration.between(transferencia.getDataCadastro(), transferencia.getDataAgendamento());
		if (duracao.toDays() < LIMITE_DIAS) {
			return TAXA_ANTES_LIMITE_DIAS;
		}
		return TAXA_APOS_LIMITE_DIAS;
	}

}
