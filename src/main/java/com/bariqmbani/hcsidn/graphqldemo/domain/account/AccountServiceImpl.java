package com.bariqmbani.hcsidn.graphqldemo.domain.account;

import com.bariqmbani.hcsidn.graphqldemo.domain.customer.Customer;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> getCustomerAccounts(Customer customer) {
        return accountRepository.findByCustomerId(customer.getId());
    }

    @Override
    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Account with id " + id + " not found")
        );
    }

    @Override
    public List<Account> getAccountsByCustomers(Collection<Customer> customers) {
        return accountRepository.findByCustomerIdIn(customers.stream().map(Customer::getId).toList());
    }
}
