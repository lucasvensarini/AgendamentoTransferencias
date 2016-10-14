package br.com.lcv.calculadora;

import java.time.Duration;

import br.com.lcv.transferencia.TransferenciaBase;

public class CalculadoraTaxaTipoB implements ICalculadoraTaxa  {

	private static final int LIMITE_DIAS = 30;
	private static final int TAXA_ANTES_LIMITE_DIAS = 10;
	private static final int TAXA_APOS_LIMITE_DIAS = 8;

	@Override
	public double calculaTaxa(TransferenciaBase transferenciaBase) {
		Duration duracao = Duration.between(transferenciaBase.getDataCadastro(), transferenciaBase.getDataAgendamento());
		if (duracao.toDays() <= LIMITE_DIAS) {
			return TAXA_ANTES_LIMITE_DIAS;
		}
		return TAXA_APOS_LIMITE_DIAS;
	}

}
