package com.example.cashonline.persistence.store;

import com.example.cashonline.persistence.entity.Loan;
import com.example.cashonline.persistence.repository.LoanRepository;
import com.example.cashonline.pojo.api.loan.LoanTO;
import com.example.cashonline.pojo.mapper.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class LoanStore {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private Mappers mappers;

    public List<LoanTO> getAllLoans(Integer page, Integer size){
        Pageable paging = PageRequest.of(page, size);
        Page<Loan> result = loanRepository.findAll(paging);
        if(result.hasContent()) {
            return mappers.loansToLoansTO(result.getContent()).collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    public List<LoanTO> getAllLoansByUserId(Integer page, Integer size, Long userId){
        Pageable paging = PageRequest.of(page, size);
        Page<Loan> result = loanRepository.findByUserId(userId, paging);
        if(result.hasContent()) {
            return mappers.loansToLoansTO(result.getContent()).collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }
}
