package br.com.lcv;

import java.time.LocalDateTime;

import br.com.lcv.model.Conta;
import br.com.lcv.model.ITransferencia;
import br.com.lcv.model.Transferencia;
import br.com.lcv.model.TransferenciaA;
import br.com.lcv.model.TransferenciaB;
import br.com.lcv.model.TransferenciaC;
import br.com.lcv.model.TransferenciaD;
import br.com.lcv.model.Usuario;

public class Main {

	public static void main(String[] args) {
		Usuario lucas = new Usuario("Lucas");

		Conta conta = new Conta("12345-6");
		lucas.setConta(conta);
		
		Transferencia transferencia1 = new Transferencia(lucas.getConta(), new Conta("78901-2"), 1500.75,
				LocalDateTime.of(2016, 10, 25, 15, 30));
		ITransferencia transfercenciaA = new TransferenciaA(transferencia1);

		Transferencia transferencia2 = new Transferencia(lucas.getConta(), new Conta("00001-2"), 100,
				LocalDateTime.of(2016, 11, 30, 15, 30));
		ITransferencia transfercenciaB = new TransferenciaB(transferencia2);

		Transferencia transferencia3 = new Transferencia(lucas.getConta(), new Conta("00002-2"), 1000,
				LocalDateTime.of(2016, 11, 05, 15, 30));
		ITransferencia transfercenciaC = new TransferenciaC(transferencia3);

		Transferencia transferencia4 = new Transferencia(lucas.getConta(), new Conta("00003-2"), 25000,
				LocalDateTime.of(2016, 11, 12, 15, 30));
		ITransferencia transfercenciaD1 = new TransferenciaD(transferencia4);

		Transferencia transferencia5 = new Transferencia(lucas.getConta(), new Conta("00004-2"), 70000,
				LocalDateTime.of(2016, 11, 20, 15, 30));
		ITransferencia transfercenciaD2 = new TransferenciaD(transferencia5);

		Transferencia transferencia6 = new Transferencia(lucas.getConta(), new Conta("00005-2"), 150000,
				LocalDateTime.of(2016, 11, 25, 15, 30));
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
