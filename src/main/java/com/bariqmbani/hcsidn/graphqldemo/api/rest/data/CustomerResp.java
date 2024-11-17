package com.bariqmbani.hcsidn.graphqldemo.api.rest.data;

import com.bariqmbani.hcsidn.graphqldemo.domain.customer.Customer;
import com.bariqmbani.hcsidn.graphqldemo.domain.customer.CustomerDto;

public class CustomerResp {

    public CustomerDto customer;

    public CustomerResp(CustomerDto customer) {
        this.customer = customer;
    }

    public CustomerResp(Customer customer) {
        this(new CustomerDto(customer));
    }

}
