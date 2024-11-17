package com.bariqmbani.hcsidn.graphqldemo.api.rest.data;

import com.bariqmbani.hcsidn.graphqldemo.domain.customer.Customer;
import com.bariqmbani.hcsidn.graphqldemo.domain.customer.CustomerDto;
import com.bariqmbani.hcsidn.graphqldemo.domain.transaction.TransactionEntry;
import com.bariqmbani.hcsidn.graphqldemo.domain.transaction.TransactionEntryDto;

import java.util.List;

public class CustomerTransactionsResp {

    public CustomerDto customer;
    public List<TransactionEntryDto> transactions;

    public CustomerTransactionsResp(Customer customer, List<TransactionEntry> transactions) {
        this.customer = new CustomerDto(customer);
        this.transactions = transactions.stream().map(TransactionEntryDto::new).toList();
    }

}
