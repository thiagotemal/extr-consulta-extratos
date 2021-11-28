package br.com.temal.pa.rest.webclient;

import feign.FeignException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@AllArgsConstructor
public class BillsService {


	private final BillsClient billsClient;


	public void postBill(String transactionId, BillRequest parameter)
			throws Exception {
		try {
			 var retorno = this.billsClient.postBills(transactionId, parameter);
			if (retorno.getData().getId() != null ){
				return;
			}else
			{
				throw new Exception("Erro ao bilhetar");
			}

		}  catch (Exception e) {
			throw new Exception("Erro ao bilhetar");
		}
	}

}
