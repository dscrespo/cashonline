package com.example.cashonline.pojo.mapper;

import com.example.cashonline.persistence.entity.Loan;
import com.example.cashonline.persistence.entity.User;
import com.example.cashonline.pojo.api.loan.LoanTO;
import com.example.cashonline.pojo.api.user.UserTO;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Stream;

@Mapper(componentModel = "spring")
public interface Mappers {

    UserTO userToUserTO(User user);
    User userTOToUser(UserTO userTO);
    LoanTO loanTOLoanTO(Loan loan);
    Stream<LoanTO> loansToLoansTO(List<Loan> loans);

}
