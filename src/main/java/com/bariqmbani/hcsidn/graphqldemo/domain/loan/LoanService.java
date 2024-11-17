package com.bariqmbani.hcsidn.graphqldemo.domain.loan;

import com.bariqmbani.hcsidn.graphqldemo.domain.customer.Customer;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public interface LoanService {

    List<Loan> getCustomerLoans(Customer customer);

    List<Loan> getLoansByCustomers(Collection<Customer> customers);

    Loan createLoan(Customer customer, BigDecimal amount, BigDecimal interestRate, String description);
}
