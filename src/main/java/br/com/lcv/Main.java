package br.com.lcv;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.lcv.model.Conta;
import br.com.lcv.model.Usuario;
import br.com.lcv.transferencia.ITransferencia;
import br.com.lcv.transferencia.TransferenciaA;
import br.com.lcv.transferencia.TransferenciaB;
import br.com.lcv.transferencia.TransferenciaBase;
import br.com.lcv.transferencia.TransferenciaC;
import br.com.lcv.transferencia.TransferenciaD;

public class Main {

	public static void main(String[] args) {
		Usuario lucas = new Usuario("Lucas");
		Usuario joao = new Usuario("Joao");

		Conta conta = new Conta("12345-6", lucas);

		TransferenciaBase transferencia1 = new TransferenciaBase(conta, new Conta("78901-2", joao),
				BigDecimal.valueOf(100), LocalDateTime.of(2016, 10, 25, 15, 30));
		ITransferencia transfercenciaA = new TransferenciaA(transferencia1);

		TransferenciaBase transferencia2 = new TransferenciaBase(conta, new Conta("78901-2", joao),
				BigDecimal.valueOf(100), LocalDateTime.of(2016, 11, 30, 15, 30));
		ITransferencia transfercenciaB = new TransferenciaB(transferencia2);

		TransferenciaBase transferencia3 = new TransferenciaBase(conta, new Conta("78901-2", joao),
				BigDecimal.valueOf(1000), LocalDateTime.of(2016, 11, 05, 15, 30));
		ITransferencia transfercenciaC = new TransferenciaC(transferencia3);

		TransferenciaBase transferencia4 = new TransferenciaBase(conta, new Conta("78901-2", joao),
				BigDecimal.valueOf(25000), LocalDateTime.of(2016, 11, 12, 15, 30));
		ITransferencia transfercenciaD1 = new TransferenciaD(transferencia4);

		TransferenciaBase transferencia5 = new TransferenciaBase(conta, new Conta("78901-2", joao),
				BigDecimal.valueOf(70000), LocalDateTime.of(2016, 11, 20, 15, 30));
		ITransferencia transfercenciaD2 = new TransferenciaD(transferencia5);

		TransferenciaBase transferencia6 = new TransferenciaBase(conta, new Conta("78901-2", joao),
				BigDecimal.valueOf(150000), LocalDateTime.of(2016, 11, 25, 15, 30));
		ITransferencia transfercenciaD3 = new TransferenciaD(transferencia6);

		lucas.agendaTransferencia(transfercenciaA);
		lucas.agendaTransferencia(transfercenciaB);
		lucas.agendaTransferencia(transfercenciaC);
		lucas.agendaTransferencia(transfercenciaD1);
		lucas.agendaTransferencia(transfercenciaD2);
		lucas.agendaTransferencia(transfercenciaD3);

		lucas.listaAgendamentos();
	}

}
