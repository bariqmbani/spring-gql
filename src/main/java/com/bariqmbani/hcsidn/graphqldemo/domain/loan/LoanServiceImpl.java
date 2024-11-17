package com.bariqmbani.hcsidn.graphqldemo.domain.loan;

import com.bariqmbani.hcsidn.graphqldemo.domain.customer.Customer;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;

    public LoanServiceImpl(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public List<Loan> getCustomerLoans(Customer customer) {
        return loanRepository.findByCustomerId(customer.getId());
    }

    @Override
    public List<Loan> getLoansByCustomers(Collection<Customer> customers) {
        return loanRepository.findByCustomerIdIn(customers.stream().map(Customer::getId).toList());
    }

    @Override
    public Loan createLoan(Customer customer, BigDecimal amount, BigDecimal interestRate, String description) {
        Loan loan = new Loan();
        loan.setAmount(amount);
        loan.setInterestRate(interestRate);
        loan.setCustomer(customer);
        loan.setDescription(description);
        loan.setOutstandingAmount(amount.add(amount.multiply(interestRate)));
        return loanRepository.save(loan);
    }
}
