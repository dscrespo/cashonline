package com.example.cashonline.persistence.store;

import com.example.cashonline.persistence.repository.LoanRepository;
import com.example.cashonline.pojo.api.loan.LoanTO;
import com.example.cashonline.pojo.mapper.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class LoanStore {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private Mappers mappers;

    public List<LoanTO> getAllLoans(){
        return mappers.loansToLoansTO(loanRepository.findAll())
                .collect(Collectors.toList());
    }
}
