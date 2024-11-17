package com.bariqmbani.hcsidn.graphqldemo.api.rest;

import com.bariqmbani.hcsidn.graphqldemo.api.rest.data.*;
import com.bariqmbani.hcsidn.graphqldemo.domain.account.AccountService;
import com.bariqmbani.hcsidn.graphqldemo.domain.customer.Customer;
import com.bariqmbani.hcsidn.graphqldemo.domain.customer.CustomerService;
import com.bariqmbani.hcsidn.graphqldemo.domain.loan.LoanService;
import com.bariqmbani.hcsidn.graphqldemo.domain.transaction.TransactionEntryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/v1")
public class RestController {

    private final CustomerService customerService;
    private final AccountService accountService;
    private final LoanService loanService;
    private final TransactionEntryService transactionEntryService;

    public RestController(CustomerService customerService,
                          AccountService accountService,
                          LoanService loanService,
                          TransactionEntryService transactionEntryService) {
        this.customerService = customerService;
        this.accountService = accountService;
        this.loanService = loanService;
        this.transactionEntryService = transactionEntryService;
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<CustomerResp> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getById(id);
        var resp = new CustomerResp(customer);
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/customers/{id}/accounts")
    public ResponseEntity<CustomerAccountsResp> getCustomerAccounts(@PathVariable Long id) {
        var customer = customerService.getById(id);
        var accounts = accountService.getCustomerAccounts(customer);
        var resp = new CustomerAccountsResp(customer, accounts);
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/accounts/{id}/transactions")
    public ResponseEntity<AccountTransactionsResp> getAccountTransactions(@PathVariable Long id) {
        var account = accountService.getAccountById(id);
        var transactions = transactionEntryService.getAccountTransactions(account);
        var resp = new AccountTransactionsResp(account, transactions);
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/customers/{id}/loans")
    public ResponseEntity<CustomerLoansResp> getCustomerLoans(@PathVariable Long id) {
        var customer = customerService.getById(id);
        var loans = loanService.getCustomerLoans(customer);
        var resp = new CustomerLoansResp(customer, loans);
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/customers/{id}/transactions")
    public ResponseEntity<CustomerTransactionsResp> getCustomerTransactions(@PathVariable Long id) {
        var customer = customerService.getById(id);
        var transactions = transactionEntryService.getCustomerTransactions(customer);
        var resp = new CustomerTransactionsResp(customer, transactions);
        return ResponseEntity.ok(resp);
    }

}
