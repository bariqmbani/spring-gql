package com.bariqmbani.hcsidn.graphqldemo.api.rest.data;

import com.bariqmbani.hcsidn.graphqldemo.domain.customer.Customer;
import com.bariqmbani.hcsidn.graphqldemo.domain.customer.CustomerDto;
import com.bariqmbani.hcsidn.graphqldemo.domain.loan.Loan;
import com.bariqmbani.hcsidn.graphqldemo.domain.loan.LoanDto;

import java.util.List;

public class CustomerLoansResp {

    public CustomerDto customer;
    public List<LoanDto> loans;

    public CustomerLoansResp(Customer customer, List<Loan> loans) {
        this.customer = new CustomerDto(customer);
        this.loans = loans.stream().map(LoanDto::new).toList();
    }

}
