package br.com.lcv.model;

import br.com.lcv.transferencia.ITransferencia;

public class Usuario {

	private String nome;
	private AgendadorTransferencias agendadorTransferencias;
	
	public Usuario(String nome) {
		this.nome = nome;
		agendadorTransferencias = new AgendadorTransferencias();
	}
	
	public String getNome() {
		return nome;
	}
	
	public void agendaTransferencia(ITransferencia transfercencia) {
		agendadorTransferencias.agendaTransferencia(transfercencia);
	}
	
	public void listaAgendamentos() {
		agendadorTransferencias.listaAgendamentos();
	}
	
}
