package com.example.cashonline.persistence.repository;

import com.example.cashonline.persistence.entity.Loan;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LoanRepository extends PagingAndSortingRepository<Loan, Long> {


}
