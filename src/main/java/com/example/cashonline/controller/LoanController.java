package com.example.cashonline.controller;

import com.example.cashonline.pojo.api.loan.LoanTO;
import com.example.cashonline.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/loans", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoanController {

    @Autowired
    LoanService loanService;

    @GetMapping
    public List<LoanTO> getLoans() {
        return loanService.findAll();
    }
}