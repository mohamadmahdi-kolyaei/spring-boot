package com.example.demo.customer;

import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class CustomerDTOMapper implements Function<Customer , CustomerDTO> {
    @Override
    public CustomerDTO apply(Customer customer) {
        return new CustomerDTO(customer.getName() , customer.getEmail());
    }
}
