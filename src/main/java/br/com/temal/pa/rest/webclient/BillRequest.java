package br.com.temal.pa.rest.webclient;

import br.com.temal.pa.rest.model.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BillRequest {

	private String nsuTransaction;
	private String originAccount;
	private LocalDate transactionDate ;
	private TransactionType transactionType;

}
