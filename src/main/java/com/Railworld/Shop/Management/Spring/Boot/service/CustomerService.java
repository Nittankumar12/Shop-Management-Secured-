package com.Railworld.Shop.Management.Spring.Boot.service;

import com.Railworld.Shop.Management.Spring.Boot.Dto.CustomerDto;
import com.Railworld.Shop.Management.Spring.Boot.model.Customer;
import com.Railworld.Shop.Management.Spring.Boot.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public void register(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setCContact(customerDto.getCustomerContact());
        customer.setCName(customerDto.getCustomerName());
        customer.setCSpend(customerDto.getCustomerSpend());
        customerRepository.save(customer);
    }
    public Customer getCustomer(int id) {
         Optional<Customer> customer = customerRepository.findById(id);
         return customer.get();
    }
}
