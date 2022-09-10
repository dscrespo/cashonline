package com.example.cashonline.persistence.repository;

import com.example.cashonline.persistence.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {


}
