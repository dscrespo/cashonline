package com.example.cashonline.controller;

import com.example.cashonline.pojo.api.loan.LoanTO;
import com.example.cashonline.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/loans", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoanController {

    @Autowired
    LoanService loanService;

    @GetMapping("{page}/{size}")
    public List<LoanTO> getLoans(@PathVariable final int page, @PathVariable final int size ) {
        return loanService.findAll(page, size);
    }

    @GetMapping("{page}/{size}/{userId}")
    public List<LoanTO> getLoansByUserId(@PathVariable final int page,
                                         @PathVariable final int size,
                                         @PathVariable final long userId) {
        return loanService.findAllByUserId(page, size, userId);
    }
}
