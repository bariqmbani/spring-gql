package com.bariqmbani.hcsidn.graphqldemo.domain.account;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * DTO for {@link Account}
 */
public class AccountDto implements Serializable {
    private final Long id;
    private final String name;
    private final String accountNumber;
    private final BigDecimal balance;

    public AccountDto(Long id, String name, String accountNumber, BigDecimal balance) {
        this.id = id;
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public AccountDto(Account account) {
        this(account.getId(), account.getName(), account.getAccountNumber(), account.getBalance());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountDto entity = (AccountDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.accountNumber, entity.accountNumber) &&
                Objects.equals(this.balance, entity.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, accountNumber, balance);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "accountNumber = " + accountNumber + ", " +
                "balance = " + balance + ")";
    }
}