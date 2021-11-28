package br.com.temal.pa.rest.webclient;


import br.com.temal.pa.rest.model.TransactionType;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BillsResponse {

    private ResponseData data;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ResponseData {


        private Long  id;

        @ApiModelProperty( example = "ce4d0520-75c0-48e6-8484-674cfb56f79f")
        private String nsuTransaction;

        @ApiModelProperty( example = "65147475")
        private String originAccount;


        @ApiModelProperty( example = "2021-12-31", hidden = true)
        private LocalDateTime creationDate = LocalDateTime.now();

        @ApiModelProperty( example = "2021-12-31")
        private LocalDate transactionDate ;

        @ApiModelProperty( example = "RECEBIDO", hidden = true)
        @Enumerated(EnumType.STRING)
        private SituationInvoiceType status = SituationInvoiceType.RECEBIDO;

        @ApiModelProperty(
                value = "Tipo da transação ",
                example = "TED",
                required = true,
                position = 1)
        @Enumerated(EnumType.STRING)
        private TransactionType transactionType;

    }

}
