package br.com.lcv.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transferencia {

	private static final String FORMATACAO_DATA = "dd/MM/yyyy";

	private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(FORMATACAO_DATA);

	private Conta contaOrigem;
	private Conta contaDestino;
	private double valor;
	private LocalDateTime dataCadastro;
	private LocalDateTime dataAgendamento;

	public Transferencia(Conta contaOrigem, Conta contaDestino, double valor, LocalDateTime dataAgendamento) {
		this.contaOrigem = contaOrigem;
		this.contaDestino = contaDestino;
		this.valor = valor;
		this.dataCadastro = LocalDateTime.now();
		this.dataAgendamento = dataAgendamento;
	}

	public double getValor() {
		return valor;
	}

	public LocalDateTime getDataAgendamento() {
		return dataAgendamento;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Conta de origem: ").append(contaOrigem.getNumero());
		sb.append(System.getProperty("line.separator"));
		sb.append("Conta de destino: ").append(contaDestino.getNumero());
		sb.append(System.getProperty("line.separator"));
		sb.append("Valor: ").append(valor);
		sb.append(System.getProperty("line.separator"));
		sb.append("Data de Cadastro: ").append(dataCadastro.format(dateTimeFormatter));
		sb.append(System.getProperty("line.separator"));
		sb.append("Data de Agendamento: ").append(dataAgendamento.format(dateTimeFormatter));
		sb.append(System.getProperty("line.separator"));

		return sb.toString();
	}

}
