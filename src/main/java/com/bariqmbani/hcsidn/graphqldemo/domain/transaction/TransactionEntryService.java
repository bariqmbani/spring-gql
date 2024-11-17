package com.bariqmbani.hcsidn.graphqldemo.domain.transaction;

import com.bariqmbani.hcsidn.graphqldemo.domain.account.Account;
import com.bariqmbani.hcsidn.graphqldemo.domain.customer.Customer;

import java.util.Collection;
import java.util.List;

public interface TransactionEntryService {
    List<TransactionEntry> getCustomerTransactions(Customer customer);

    List<TransactionEntry> getAccountTransactions(Account account);

    List<TransactionEntry> getTransactionsByAccounts(Collection<Account> accounts);

    List<TransactionEntry> getTransactionsByCustomers(Collection<Customer> accounts);

}
