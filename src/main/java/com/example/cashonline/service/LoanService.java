package com.example.cashonline.service;

import com.example.cashonline.persistence.store.LoanStore;
import com.example.cashonline.pojo.api.loan.LoanTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    LoanStore loanStore;

    public List<LoanTO> genericFind(Integer page, Integer size, Optional<Long> userId) {

        if(userId.isPresent()) {
            return findAllByUserId(page, size, userId.get());
        } else {
           return findAll(page, size);
        }
    }

    public List<LoanTO> findAll(Integer page, Integer size) {
        return loanStore.getAllLoans(page, size);
    }

    public List<LoanTO> findAllByUserId(Integer page, Integer size, Long userId) {
        return loanStore.getAllLoansByUserId(page, size, userId);
    }
}
