package br.com.temal.pa.rest.webclient;

import java.io.Serializable;


public enum SituationInvoiceType implements Serializable {

	RECEBIDO,
	RECUSADO,
	CANCELADO,
	PENDENTE,
	CONCLUIDO
}