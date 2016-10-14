package br.com.lcv.model;

import br.com.lcv.transferencia.ITransferencia;

public class Usuario {

	private static final String NOME_INVALIDO = "O nome do usuário não pode ser nulo.";
	
	private String nome;
	private AgendadorTransferencias agendadorTransferencias;

	public Usuario(String nome) {
		this.nome = validaNome(nome);
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

	private String validaNome(String nome) {
		if (nome == null || nome.isEmpty()) {
			throw new NullPointerException(NOME_INVALIDO);
		}
		return nome;
	}

}
