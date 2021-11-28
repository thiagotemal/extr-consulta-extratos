package br.com.temal.pa.rest.controller;


import br.com.temal.pa.rest.model.AccountEntry;

import br.com.temal.pa.rest.model.DataPresenter;


import br.com.temal.pa.rest.presenter.DataAccountEntryPresenter;
import br.com.temal.pa.rest.repository.AccountEntryRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(path = "/v1/transactions")
@Api(value = "/v1/transactions")
public class AccountEntryController {

    @Autowired
    private AccountEntryRepository personService;



    @ApiOperation("Listar Lancamentos de conta.")
    @ApiResponses(
            @ApiResponse(
                    code = 200,
                    message = "Ok",
                    response = DataAccountEntryPresenter.class))
    @RequestMapping(method = RequestMethod.GET,path = "/accounts/{originAccount}/entries" )
    @ResponseBody
    public ResponseEntity FindAll(@ApiParam(value = "ID da conta",required=true) @PathVariable("originAccount") String accountId) {
        //     logger.info("inciando metodo listagem");
        try {
            List<AccountEntry> bills = this.personService.findByOriginAccount(accountId);
            if (bills != null && !bills.isEmpty() ) {
                return  ResponseEntity.ok().body(DataAccountEntryPresenter.builder().data(bills).build());
            } else {
                return new ResponseEntity<>(new HashMap<>().put("message", "Não encontrado"),
                        HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            //logger.info("Erro ao buscar lista de pessoas.");
            //logger.error(e.getMessage());
            return new ResponseEntity<>(new HashMap<>().put("message", "Ocorreu na requisição"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

 /*   @ApiOperation("Consultar uma pessoa pelo id")
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity personById(@PathVariable Long id) throws Exception {
        try {
            Invoice person = this.personService.findById(id);

            if (person != null) {
                return new ResponseEntity<>(new PersonPresenter(person), HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
           // logger.info("Erro ao buscar pessoa registrados.");
            //logger.error(e.getMessage());
            return new ResponseEntity<>(new HashMap<>().put("message", "Ocorreu na requisição"),
                    HttpStatus.BAD_REQUEST);
        }
    }*/





}
