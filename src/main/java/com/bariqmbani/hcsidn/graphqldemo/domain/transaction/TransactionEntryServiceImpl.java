package com.bariqmbani.hcsidn.graphqldemo.domain.transaction;

import com.bariqmbani.hcsidn.graphqldemo.domain.account.Account;
import com.bariqmbani.hcsidn.graphqldemo.domain.customer.Customer;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class TransactionEntryServiceImpl implements TransactionEntryService {

    private final TransactionEntryRepository transactionEntryRepository;

    public TransactionEntryServiceImpl(TransactionEntryRepository transactionEntryRepository) {
        this.transactionEntryRepository = transactionEntryRepository;
    }

    @Override
    public List<TransactionEntry> getCustomerTransactions(Customer customer) {
        return transactionEntryRepository.findByCustomerId(customer.getId());
    }

    @Override
    public List<TransactionEntry> getAccountTransactions(Account account) {
        return transactionEntryRepository.findByAccountId(account.getId());
    }

    @Override
    public List<TransactionEntry> getTransactionsByAccounts(Collection<Account> accounts) {
        return transactionEntryRepository.findByAccountIdIn(accounts.stream().map(Account::getId).toList());
    }

    @Override
    public List<TransactionEntry> getTransactionsByCustomers(Collection<Customer> accounts) {
        return transactionEntryRepository.findByCustomerIdIn(accounts.stream().map(Customer::getId).toList());
    }
}
