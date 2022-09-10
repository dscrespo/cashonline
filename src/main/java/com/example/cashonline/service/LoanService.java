package com.example.cashonline.service;

import com.example.cashonline.persistence.store.LoanStore;
import com.example.cashonline.pojo.api.loan.LoanTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    @Autowired
    LoanStore loanStore;

    public List<LoanTO> findAll(Integer page, Integer size) {
        return loanStore.getAllLoans(page, size);
    }

    public List<LoanTO> findAllByUserId(Integer page, Integer size, Long userId) {
        return loanStore.getAllLoansByUserId(page, size, userId);
    }
}
