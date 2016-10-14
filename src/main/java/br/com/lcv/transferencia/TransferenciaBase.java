package br.com.lcv.transferencia;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.lcv.model.Conta;

public class TransferenciaBase {

	private static final String CONTA_INVALIDA = "A conta não pode ser nula.";
	private static final String VALOR_INVALIDO = "O valor não pode ser nulo.";
	private static final String VALOR_NEGATIVO = "O valor não pode ser negativo.";
	private static final String DATA_INVALIDA = "A data de agendamento não pode ser nula.";

	private static final String FORMATACAO_DATA = "dd/MM/yyyy";
	private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(FORMATACAO_DATA);

	private Conta contaOrigem;
	private Conta contaDestino;
	private BigDecimal valor;
	private LocalDateTime dataCadastro;
	private LocalDateTime dataAgendamento;

	public TransferenciaBase(Conta contaOrigem, Conta contaDestino, BigDecimal valor, LocalDateTime dataAgendamento) {
		this.contaOrigem = validaConta(contaOrigem);
		this.contaDestino = validaConta(contaDestino);
		this.valor = validaValor(valor);
		this.dataCadastro = LocalDateTime.now();
		this.dataAgendamento = validaData(dataAgendamento);
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

	private Conta validaConta(Conta conta) {
		if (conta == null) {
			throw new NullPointerException(CONTA_INVALIDA);
		}
		return conta;
	}

	private BigDecimal validaValor(BigDecimal valor) {
		if (valor == null) {
			throw new NullPointerException(VALOR_INVALIDO);
		}

		if (valor.doubleValue() < 0) {
			throw new IllegalArgumentException(VALOR_NEGATIVO);
		}

		return valor.setScale(2, RoundingMode.FLOOR);
	}

	private LocalDateTime validaData(LocalDateTime data) {
		if (data == null) {
			throw new NullPointerException(DATA_INVALIDA);
		}
		return data;
	}

}
