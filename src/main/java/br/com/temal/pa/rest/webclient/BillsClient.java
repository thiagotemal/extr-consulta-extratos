package br.com.temal.pa.rest.webclient;


import br.com.temal.pa.rest.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.io.IOException;

@FeignClient(configuration = FeignConfig.class, name = "CustomerSearchClient", url = "${bilh.bilhetagem.transacoes.java.url}")
public interface BillsClient {

    @PostMapping(value = "/v1/transactions/v1/transactions/bills", produces = MediaType.APPLICATION_JSON_VALUE)
    BillsResponse postBills(@RequestHeader(value = "x-transaction-id") String xTransactionId,
                            @RequestBody(required = true) BillRequest parameter) throws IOException;

}
