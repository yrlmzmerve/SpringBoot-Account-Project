package com.javaspringproject.account.repository;

import com.javaspringproject.account.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TranscationRepository extends JpaRepository<Transaction,String> {
}
