package br.com.lcv.transferencia;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.lcv.model.Conta;

public class TransferenciaBase {

	private static final String FORMATACAO_DATA = "dd/MM/yyyy";

	private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(FORMATACAO_DATA);

	private Conta contaOrigem;
	private Conta contaDestino;
	private BigDecimal valor;
	private LocalDateTime dataCadastro;
	private LocalDateTime dataAgendamento;

	public TransferenciaBase(Conta contaOrigem, Conta contaDestino, BigDecimal valor, LocalDateTime dataAgendamento) {
		this.contaOrigem = contaOrigem;
		this.contaDestino = contaDestino;
		this.valor = valor.abs().setScale(2, RoundingMode.FLOOR);
		this.dataCadastro = LocalDateTime.now();
		this.dataAgendamento = dataAgendamento;
	}

	public BigDecimal getValor() {
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
