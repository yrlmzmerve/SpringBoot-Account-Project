package com.javaspringproject.account.service;

import com.javaspringproject.account.dto.CustomerDto;
import com.javaspringproject.account.dto.CustomerDtoConverter;
import com.javaspringproject.account.exception.CustomerNotFoundException;
import com.javaspringproject.account.model.Customer;
import com.javaspringproject.account.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter converter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter converter) {
        this.customerRepository = customerRepository;
        this.converter = converter;
    }

    protected Customer findCustomerById(String id) {
        return customerRepository.findById(id)
                .orElseThrow(
                        () -> new CustomerNotFoundException("Customer could not find by id: " + id));

    }

    public CustomerDto getCustomerById(String customerId) {
        return converter.convertToCustomerDto(findCustomerById(customerId));
    }

    public List<CustomerDto> getAllCustomer() {

        return customerRepository.findAll()
                .stream()
                .map(converter::convertToCustomerDto)
                .collect(Collectors.toList());
    }
}
