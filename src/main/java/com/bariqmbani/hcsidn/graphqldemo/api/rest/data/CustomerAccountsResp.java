package com.bariqmbani.hcsidn.graphqldemo.api.rest.data;

import com.bariqmbani.hcsidn.graphqldemo.domain.account.Account;
import com.bariqmbani.hcsidn.graphqldemo.domain.account.AccountDto;
import com.bariqmbani.hcsidn.graphqldemo.domain.customer.Customer;
import com.bariqmbani.hcsidn.graphqldemo.domain.customer.CustomerDto;

import java.util.List;

public class CustomerAccountsResp {

    public CustomerDto customer;
    public List<AccountDto> accounts;

    public CustomerAccountsResp(Customer customer, List<Account> accounts) {
        this.customer = new CustomerDto(customer);
        this.accounts = accounts.stream().map(AccountDto::new).toList();
    }

}
