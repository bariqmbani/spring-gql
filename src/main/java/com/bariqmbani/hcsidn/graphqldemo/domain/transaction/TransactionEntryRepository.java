package com.bariqmbani.hcsidn.graphqldemo.domain.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface TransactionEntryRepository extends JpaRepository<TransactionEntry, Long> {
    List<TransactionEntry> findByCustomerId(Long customerId);

    List<TransactionEntry> findByAccountId(Long accountId);

    @Query("""
                        SELECT te
                        FROM TransactionEntry te
                        JOIN FETCH te.account
                        JOIN FETCH te.customer
                        WHERE te.account.id IN :accountIds
            """)
    List<TransactionEntry> findByAccountIdIn(Collection<Long> accountIds);

    @Query("""
                        SELECT te
                        FROM TransactionEntry te
                        JOIN FETCH te.customer
                        JOIN FETCH te.account
                        WHERE te.customer.id IN :customerIds
            """)
    List<TransactionEntry> findByCustomerIdIn(Collection<Long> customerIds);
}