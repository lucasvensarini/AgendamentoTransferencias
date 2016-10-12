package br.com.lcv.model;

public class Usuario {

	private String nome;
	private AgendadorTransferencias agendadorTransferencias;
	private Conta conta;
	
	public Usuario(String nome) {
		this.nome = nome;
		agendadorTransferencias = new AgendadorTransferencias();
	}
	
	public String getNome() {
		return nome;
	}
	
	public Conta getConta() {
		return conta;
	}
	
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	public void agendaTransferencia(ITransferencia transfercencia) {
		agendadorTransferencias.agendaTransferencia(transfercencia);
	}
	
	public void listaAgendamentos() {
		agendadorTransferencias.listaAgendamentos();
	}
	
}
