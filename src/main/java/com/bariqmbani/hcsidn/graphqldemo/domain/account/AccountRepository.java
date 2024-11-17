package com.bariqmbani.hcsidn.graphqldemo.domain.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findByCustomerId(Long customerId);

    @Query("""
                        SELECT a
                        FROM Account a
                        JOIN FETCH a.customer
                        JOIN FETCH a.transactions
                        WHERE a.customer.id IN :customerIds
            """)
    List<Account> findByCustomerIdIn(List<Long> customerIds);
}