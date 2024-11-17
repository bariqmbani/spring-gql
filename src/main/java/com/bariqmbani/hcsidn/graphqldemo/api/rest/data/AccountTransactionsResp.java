package com.bariqmbani.hcsidn.graphqldemo.api.rest.data;

import com.bariqmbani.hcsidn.graphqldemo.domain.account.Account;
import com.bariqmbani.hcsidn.graphqldemo.domain.account.AccountDto;
import com.bariqmbani.hcsidn.graphqldemo.domain.transaction.TransactionEntry;
import com.bariqmbani.hcsidn.graphqldemo.domain.transaction.TransactionEntryDto;

import java.util.List;

public class AccountTransactionsResp {

    public AccountDto account;
    public List<TransactionEntryDto> transactions;

    public AccountTransactionsResp(Account account, List<TransactionEntry> transactions) {
        this.account = new AccountDto(account);
        this.transactions = transactions.stream().map(TransactionEntryDto::new).toList();
    }

}
