package com.javaspringproject.account;

import com.javaspringproject.account.model.Customer;
import com.javaspringproject.account.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;


@SpringBootApplication
public class AccountApplication implements CommandLineRunner {
    private final CustomerRepository customerRepository;

    public AccountApplication(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Customer customer = customerRepository.save(new Customer("", "Merve", "Yorulmaz", new HashSet<>()));
        System.out.println(customer);
    }
}
