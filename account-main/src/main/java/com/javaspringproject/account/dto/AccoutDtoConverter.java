package com.javaspringproject.account.dto;

import com.javaspringproject.account.model.Account;
import org.springframework.stereotype.Component;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AccoutDtoConverter {
    private final CustomerDtoConverter customerDtoConverter;
    private final TransactionDtoConverter transactionDtoConverter;


    public AccoutDtoConverter(CustomerDtoConverter customerDtoConverter, TransactionDtoConverter transactionDtoConverter) {
        this.customerDtoConverter = customerDtoConverter;
        this.transactionDtoConverter = transactionDtoConverter;
    }

    public AccountDto convert(Account from) {
        return new AccountDto(from.getId(),
                from.getBalance(),
                from.getCreationDate(),
                customerDtoConverter.convertToAccountCustomer(Optional.ofNullable(from.getCustomer())),
                Objects.requireNonNull(from.getTransaction())
                        .stream()
                        .map(transactionDtoConverter::convert)
                        .collect(Collectors.toSet()));
    }
}
