package com.bariqmbani.hcsidn.graphqldemo.api.gql;

import com.bariqmbani.hcsidn.graphqldemo.api.gql.data.LoanInput;
import com.bariqmbani.hcsidn.graphqldemo.domain.account.Account;
import com.bariqmbani.hcsidn.graphqldemo.domain.account.AccountService;
import com.bariqmbani.hcsidn.graphqldemo.domain.customer.Customer;
import com.bariqmbani.hcsidn.graphqldemo.domain.customer.CustomerService;
import com.bariqmbani.hcsidn.graphqldemo.domain.loan.Loan;
import com.bariqmbani.hcsidn.graphqldemo.domain.loan.LoanService;
import com.bariqmbani.hcsidn.graphqldemo.domain.transaction.TransactionEntry;
import com.bariqmbani.hcsidn.graphqldemo.domain.transaction.TransactionEntryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.execution.BatchLoaderRegistry;
import org.springframework.stereotype.Controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class GraphqlController {

    private final Logger log = LoggerFactory.getLogger(GraphqlController.class);

    private final BatchLoaderRegistry batchLoaderRegistry;
    private final CustomerService customerService;
    private final AccountService accountService;
    private final TransactionEntryService transactionEntryService;
    private final LoanService loanService;

    public GraphqlController(BatchLoaderRegistry batchLoaderRegistry,
                             CustomerService customerService,
                             AccountService accountService,
                             TransactionEntryService transactionEntryService,
                             LoanService loanService) {
        this.batchLoaderRegistry = batchLoaderRegistry;
        this.customerService = customerService;
        this.accountService = accountService;
        this.transactionEntryService = transactionEntryService;
        this.loanService = loanService;
    }

    @QueryMapping
    public Customer customer(@Argument Long id) {
        return customerService.getById(id);
    }

    @MutationMapping
    public Loan createLoan(@Argument LoanInput loan) {
        Customer customer = customerService.getById(loan.customerId);
        return loanService.createLoan(customer, loan.amount, loan.interestRate, loan.description);
    }

    @BatchMapping("accounts")
    public Map<Customer, Set<Account>> customerAccounts(Collection<Customer> customers) {
        log.info("fetch customer accounts");
        List<Account> customerAccounts = accountService.getAccountsByCustomers(customers);
        return customerAccounts.stream()
                .collect(Collectors.groupingBy(Account::getCustomer, Collectors.toSet()));
    }

    @BatchMapping("loans")
    public Map<Customer, Set<Loan>> customerLoans(Collection<Customer> customers) {
        log.info("fetch customer loans");
        List<Loan> customerLoans = loanService.getLoansByCustomers(customers);
        return customerLoans.stream()
                .collect(Collectors.groupingBy(Loan::getCustomer, Collectors.toSet()));
    }

    @BatchMapping("transactions")
    public Map<Customer, Set<TransactionEntry>> customerTransactions(Collection<Customer> customers) {
        log.info("fetch customer transactions");
        List<TransactionEntry> customerTransactions = transactionEntryService.getTransactionsByCustomers(customers);
        return customerTransactions.stream()
                .collect(Collectors.groupingBy(TransactionEntry::getCustomer, Collectors.toSet()));
    }
}
