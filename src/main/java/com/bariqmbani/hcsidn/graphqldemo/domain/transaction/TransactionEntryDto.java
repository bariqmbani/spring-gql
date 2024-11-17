package com.bariqmbani.hcsidn.graphqldemo.domain.transaction;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * DTO for {@link TransactionEntry}
 */
public class TransactionEntryDto implements Serializable {
    private final Long id;
    private final String description;
    private final BigDecimal amount;
    private final String rrn;
    private final OffsetDateTime timestamp;

    public TransactionEntryDto(Long id, String description, BigDecimal amount, String rrn, OffsetDateTime timestamp) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.rrn = rrn;
        this.timestamp = timestamp;
    }

    public TransactionEntryDto(TransactionEntry transactionEntry) {
        this(transactionEntry.getId(), transactionEntry.getDescription(), transactionEntry.getAmount(), transactionEntry.getRrn(), transactionEntry.getTimestamp());
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getRrn() {
        return rrn;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionEntryDto entity = (TransactionEntryDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.amount, entity.amount) &&
                Objects.equals(this.rrn, entity.rrn) &&
                Objects.equals(this.timestamp, entity.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, amount, rrn, timestamp);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "description = " + description + ", " +
                "amount = " + amount + ", " +
                "rrn = " + rrn + ", " +
                "timestamp = " + timestamp + ")";
    }
}