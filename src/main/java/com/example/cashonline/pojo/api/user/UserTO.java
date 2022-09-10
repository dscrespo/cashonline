package com.example.cashonline.pojo.api.user;

import com.example.cashonline.pojo.api.loan.LoanTO;

import java.util.List;

public class UserTO {
    private Long id;
    private String firstName;
    private String lastName;
    private List<LoanTO> loans;

    public List<LoanTO> getLoans() {
        return loans;
    }

    public void setLoans(List<LoanTO> loans) {
        this.loans = loans;
    }

    public String getFirstName() {
        return firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
