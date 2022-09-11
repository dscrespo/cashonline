package com.example.cashonline.controller;

import com.example.cashonline.pojo.api.loan.LoanTO;
import com.example.cashonline.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/loans", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoanController {

    @Autowired
    LoanService loanService;

    @GetMapping()
    public List<LoanTO> getLoans(@RequestParam final int page,
                                 @RequestParam final int size,
                                 @RequestParam(required = false) final Optional<Long> userId) {
        return loanService.genericFind(page, size, userId);
    }
   /*
   Nota: Particularmente me parece mas prolijo que cada endpoint
         tenga su set de parametros definidos, para no tomar decisiones
         de que accion tomar.
         Igual entiendo el punto del ejercicio.
         Dejo abajo como lo habia hecho originalmente.
   */

   /*
   @GetMapping()
   public List<LoanTO> getLoans(@RequestParam final int page,
                                 @RequestParam final int size) {
        return loanService.findAll(page, size);

    @GetMapping()
    public List<LoanTO> getLoansByUserId(@RequestParam final int page,
                                         @RequestParam final int size,
                                         @RequestParam final long userId) {
        return loanService.findAllByUserId(page, size, userId);
    }
    */
}
