package com.bariqmbani.hcsidn.graphqldemo.domain.loan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByCustomerId(Long customerId);

    @Query("""
                        SELECT l
                        FROM Loan l
                        JOIN FETCH l.customer
                        JOIN FETCH l.customer.transactions
                        WHERE l.customer.id IN :customerIds
            """)
    List<Loan> findByCustomerIdIn(Collection<Long> customerIds);
}