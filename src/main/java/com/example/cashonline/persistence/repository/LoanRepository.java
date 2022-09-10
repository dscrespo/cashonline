package com.example.cashonline.persistence.repository;

import com.example.cashonline.persistence.entity.Loan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LoanRepository extends PagingAndSortingRepository<Loan, Long> {

    Page<Loan> findByUserId(Long userId, Pageable page);

}
