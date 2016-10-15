package br.com.lcv.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.lcv.transferencia.ITransferencia;

public class AgendadorTransferencias {
	
	private List<ITransferencia> transferencias;

	public AgendadorTransferencias() {
		transferencias = new ArrayList<>();
	}
	
	public List<ITransferencia> getTransferencias() {
		return Collections.unmodifiableList(transferencias);
	}
	
	public void agendaTransferencia(ITransferencia transferencia) {
		transferencias.add(transferencia);
	}
	
	public void listaAgendamentos() {
		for (ITransferencia transferencia : transferencias) {
			System.out.println(transferencia.listaInformacoes());
			System.out.println();
		}
	}
	
}
