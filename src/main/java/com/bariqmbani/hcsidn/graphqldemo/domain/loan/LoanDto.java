package com.bariqmbani.hcsidn.graphqldemo.domain.loan;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * DTO for {@link Loan}
 */
public class LoanDto implements Serializable {
    private final Long id;
    private final BigDecimal amount;
    private final BigDecimal interestRate;
    private final BigDecimal outstandingAmount;
    private final String description;

    public LoanDto(Long id, BigDecimal amount, BigDecimal interestRate, BigDecimal outstandingAmount, String description) {
        this.id = id;
        this.amount = amount;
        this.interestRate = interestRate;
        this.outstandingAmount = outstandingAmount;
        this.description = description;
    }

    public LoanDto(Loan loan) {
        this(loan.getId(), loan.getAmount(), loan.getInterestRate(), loan.getOutstandingAmount(), loan.getDescription());
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public BigDecimal getOutstandingAmount() {
        return outstandingAmount;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanDto entity = (LoanDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.amount, entity.amount) &&
                Objects.equals(this.interestRate, entity.interestRate) &&
                Objects.equals(this.outstandingAmount, entity.outstandingAmount) &&
                Objects.equals(this.description, entity.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, interestRate, outstandingAmount, description);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "amount = " + amount + ", " +
                "interestRate = " + interestRate + ", " +
                "outstandingAmount = " + outstandingAmount + ", " +
                "description = " + description + ")";
    }
}