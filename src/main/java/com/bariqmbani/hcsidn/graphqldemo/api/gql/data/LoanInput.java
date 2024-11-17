package com.bariqmbani.hcsidn.graphqldemo.api.gql.data;

import java.math.BigDecimal;

public class LoanInput {
    public Long customerId;
    public String description;
    public BigDecimal amount;
    public BigDecimal interestRate;

    public LoanInput(Long customerId, String description, BigDecimal amount, BigDecimal interestRate) {
        this.customerId = customerId;
        this.description = description;
        this.amount = amount;
        this.interestRate = interestRate;
    }

}