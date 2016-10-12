package br.com.lcv.model;

import java.util.ArrayList;
import java.util.List;

public class AgendadorTransferencias {
	
	private List<ITransferencia> transferencias;

	public AgendadorTransferencias() {
		transferencias = new ArrayList<>();
	}
	
	public void agendaTransferencia(ITransferencia transfercencia) {
		transferencias.add(transfercencia);
	}
	
	public void listaAgendamentos() {
		for (ITransferencia transferencia : transferencias) {
			System.out.println(transferencia.listaInformacoes());
			System.out.println();
		}
	}
	
}
