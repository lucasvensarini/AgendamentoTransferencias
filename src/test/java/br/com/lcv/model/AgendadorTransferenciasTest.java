package br.com.lcv.model;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.lcv.transferencia.ITransferencia;
import br.com.lcv.transferencia.TransferenciaA;
import br.com.lcv.transferencia.TransferenciaB;
import br.com.lcv.transferencia.TransferenciaBase;
import br.com.lcv.transferencia.TransferenciaC;
import br.com.lcv.transferencia.TransferenciaD;

public class AgendadorTransferenciasTest {

	private static final String FORMATACAO_DATA = "dd/MM/yyyy";
	private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(FORMATACAO_DATA);
	
	private LocalDateTime dataCadastro;

	private ByteArrayOutputStream out;

	private AgendadorTransferencias at;
	private TransferenciaBase tb;
	private Conta contaOrigem;
	private Conta contaDestino;
	private ITransferencia transferenciaA;
	private ITransferencia transferenciaB;
	private ITransferencia transferenciaC;
	private ITransferencia transferenciaD;

	public AgendadorTransferenciasTest() {
		this.dataCadastro = LocalDateTime.now();

		out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		contaOrigem = new Conta("12345-6", new Usuario("Lucas"));
		contaDestino = new Conta("78901-2", new Usuario("Joao"));
		tb = new TransferenciaBase(contaOrigem, contaDestino, BigDecimal.valueOf(1000),
				LocalDateTime.of(2016, 10, 15, 15, 00));
		transferenciaA = new TransferenciaA(tb);
		transferenciaB = new TransferenciaB(tb);
		transferenciaC = new TransferenciaC(tb);
		transferenciaD = new TransferenciaD(tb);
	}

	@Before
	public void before() {
		at = new AgendadorTransferencias();
	}

	@Test
	public void deveAgendarTransferencia() {
		at.agendaTransferencia(transferenciaA);
		at.agendaTransferencia(transferenciaB);
		at.agendaTransferencia(transferenciaC);
		at.agendaTransferencia(transferenciaD);
		
		Assert.assertEquals(4, at.getTransferencias().size());
	}

	@Test
	public void deveListarTransferencia() {
		at.agendaTransferencia(transferenciaA);
		at.agendaTransferencia(transferenciaB);
		at.agendaTransferencia(transferenciaC);
		at.agendaTransferencia(transferenciaD);
		at.listaAgendamentos();

		StringBuilder sb = new StringBuilder();
		sb.append("Conta de origem: 12345-6");
		sb.append(System.getProperty("line.separator"));
		sb.append("Conta de destino: 78901-2");
		sb.append(System.getProperty("line.separator"));
		sb.append("Valor: 1000.00");
		sb.append(System.getProperty("line.separator"));
		sb.append("Data de Cadastro: ").append(dataCadastro.format(dateTimeFormatter));
		sb.append(System.getProperty("line.separator"));
		sb.append("Data de Agendamento: 15/10/2016");
		sb.append(System.getProperty("line.separator"));
		sb.append("Taxa: 32.00");
		sb.append(System.getProperty("line.separator"));
		sb.append("Tipo: A");
		sb.append(System.getProperty("line.separator"));
		sb.append(System.getProperty("line.separator"));

		sb.append("Conta de origem: 12345-6");
		sb.append(System.getProperty("line.separator"));
		sb.append("Conta de destino: 78901-2");
		sb.append(System.getProperty("line.separator"));
		sb.append("Valor: 1000.00");
		sb.append(System.getProperty("line.separator"));
		sb.append("Data de Cadastro: ").append(dataCadastro.format(dateTimeFormatter));
		sb.append(System.getProperty("line.separator"));
		sb.append("Data de Agendamento: 15/10/2016");
		sb.append(System.getProperty("line.separator"));
		sb.append("Taxa: 10.00");
		sb.append(System.getProperty("line.separator"));
		sb.append("Tipo: B");
		sb.append(System.getProperty("line.separator"));
		sb.append(System.getProperty("line.separator"));

		sb.append("Conta de origem: 12345-6");
		sb.append(System.getProperty("line.separator"));
		sb.append("Conta de destino: 78901-2");
		sb.append(System.getProperty("line.separator"));
		sb.append("Valor: 1000.00");
		sb.append(System.getProperty("line.separator"));
		sb.append("Data de Cadastro: ").append(dataCadastro.format(dateTimeFormatter));
		sb.append(System.getProperty("line.separator"));
		sb.append("Data de Agendamento: 15/10/2016");
		sb.append(System.getProperty("line.separator"));
		sb.append("Taxa: 83.00");
		sb.append(System.getProperty("line.separator"));
		sb.append("Tipo: C");
		sb.append(System.getProperty("line.separator"));
		sb.append(System.getProperty("line.separator"));

		sb.append("Conta de origem: 12345-6");
		sb.append(System.getProperty("line.separator"));
		sb.append("Conta de destino: 78901-2");
		sb.append(System.getProperty("line.separator"));
		sb.append("Valor: 1000.00");
		sb.append(System.getProperty("line.separator"));
		sb.append("Data de Cadastro: ").append(dataCadastro.format(dateTimeFormatter));
		sb.append(System.getProperty("line.separator"));
		sb.append("Data de Agendamento: 15/10/2016");
		sb.append(System.getProperty("line.separator"));
		sb.append("Taxa: 32.00");
		sb.append(System.getProperty("line.separator"));
		sb.append("Tipo: D");
		sb.append(System.getProperty("line.separator"));
		sb.append(System.getProperty("line.separator"));

		Assert.assertEquals(sb.toString(), out.toString());
	}

}
