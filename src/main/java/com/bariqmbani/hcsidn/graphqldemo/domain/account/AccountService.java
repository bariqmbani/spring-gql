package com.bariqmbani.hcsidn.graphqldemo.domain.account;

import com.bariqmbani.hcsidn.graphqldemo.domain.customer.Customer;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface AccountService {

    List<Account> getCustomerAccounts(Customer customer);

    Account getAccountById(Long id);

    List<Account> getAccountsByCustomers(Collection<Customer> customers);
}
