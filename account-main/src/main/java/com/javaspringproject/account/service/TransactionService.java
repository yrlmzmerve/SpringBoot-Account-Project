package com.javaspringproject.account.service;

import com.javaspringproject.account.model.Account;
import com.javaspringproject.account.model.Transaction;
import com.javaspringproject.account.repository.TranscationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionService {
    private Logger logger = LoggerFactory.getLogger(TransactionService.class);
    private final TranscationRepository transcationRepository;

    public TransactionService(TranscationRepository transcationRepository) {
        this.transcationRepository = transcationRepository;
    }

    protected Transaction initiateMoney(final Account account, BigDecimal amount) {
        return transcationRepository.save(
                new Transaction(amount, account)
        );
    }

}
