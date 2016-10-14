package br.com.lcv.util;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.lcv.transferencia.TransferenciaBase;

public class CriadorTransferenciaBase {

	public static TransferenciaBase criaTransferenciaBase() {
		return new TransferenciaBase(CriadorConta.criaConta(), CriadorConta.criaConta("00002-3"),
				BigDecimal.valueOf(100), LocalDateTime.now());
	}

	public static TransferenciaBase criaTransferenciaBase(double valor) {
		return new TransferenciaBase(CriadorConta.criaConta(), CriadorConta.criaConta("00002-3"),
				BigDecimal.valueOf(valor), LocalDateTime.now());
	}
	
	public static TransferenciaBase criaTransferenciaBase(LocalDateTime data) {
		return new TransferenciaBase(CriadorConta.criaConta(), CriadorConta.criaConta("00002-3"),
				BigDecimal.valueOf(100), data);
	}
	
	public static TransferenciaBase criaTransferenciaBase(double valor, LocalDateTime data) {
		return new TransferenciaBase(CriadorConta.criaConta(), CriadorConta.criaConta("00002-3"),
				BigDecimal.valueOf(valor), data);
	}

}
