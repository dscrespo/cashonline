package com.example.cashonline.service;

import com.example.cashonline.persistence.entity.Loan;
import com.example.cashonline.persistence.entity.User;
import com.example.cashonline.persistence.repository.UserRepository;
import com.example.cashonline.pojo.api.loan.LoanTO;
import com.example.cashonline.pojo.api.user.UserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserTO findById(long id) {
        UserTO user = new UserTO();

        User dbUser = userRepository.findById(id).get();
        user.setId(dbUser.getId());
        user.setFirstName(dbUser.getFirstName());
        user.setLastName(dbUser.getLastName());
        List<LoanTO> loans = new ArrayList<>();
        for (Loan dbloan : dbUser.getLoans()) {
            LoanTO loan = new LoanTO();
            loan.setId(dbloan.getId());
            loan.setTotal(dbloan.getTotal());
            loan.setUserId(dbloan.getUserId());
            loans.add(loan);
        }
        user.setLoans(loans);
        return user;
    }

    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }

    public void createUSer(UserTO request) {
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        userRepository.save(user);
    }
}
