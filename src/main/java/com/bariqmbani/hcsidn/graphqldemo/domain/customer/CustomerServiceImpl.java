package com.bariqmbani.hcsidn.graphqldemo.domain.customer;

import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Customer with id " + id + " not found")
        );
    }

}
